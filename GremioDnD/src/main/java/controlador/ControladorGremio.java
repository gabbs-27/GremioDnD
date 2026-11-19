package controlador;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTextField;
import modelo.Aventurero;
import modelo.Clerigo;
import modelo.DatosInvalidosException;
import modelo.GestorArchivo;
import modelo.Guerrero;
import modelo.Mago;
import modelo.Picaro;
import vista.FrmGremio;

public class ControladorGremio {
    private final ArrayList<Aventurero> gremio;
    private final FrmGremio vista;

    public ControladorGremio(FrmGremio vista) {
        this.gremio = new ArrayList<>();
        this.vista = vista;
        if (vista != null) {
            inicializarEventos();
            accionCambiarClase();
            actualizarVista();
        }
    }

    private void inicializarEventos() {
        vista.getBtnRegistrar().addActionListener(e -> accionRegistrar());
        vista.getCmbClase().addActionListener(e -> accionCambiarClase());

        soloNumeros(vista.getTxtNivel(), 2);
        soloNumeros(vista.getTxtPuntosVida(), 4);
        soloNumerosSiEsMago(vista.getTxtAtributo());
    }

    public void registrarAventurero(String clase, String nombre, int nivel, int puntosVida, String atributo)
            throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del aventurero es obligatorio.");
        }
        if (existeNombre(nombre)) {
            throw new DatosInvalidosException("Ya existe un aventurero llamado \"" + nombre.trim()
                    + "\" en el gremio. Elige otro nombre.");
        }
        Aventurero nuevo = crearAventurero(clase, nombre, nivel, puntosVida, atributo);
        gremio.add(nuevo);
        guardarEnArchivo("REGISTRO -> " + nuevo);
        actualizarVista();
    }

    private Aventurero crearAventurero(String clase, String nombre, int nivel, int puntosVida, String atributo)
            throws DatosInvalidosException {
        switch (normalizar(clase)) {
            case "guerrero":
                return new Guerrero(nombre, nivel, puntosVida, interpretarSiNo(atributo));
            case "mago":
                return new Mago(nombre, nivel, puntosVida, convertirEntero(atributo, "espacios de conjuro"));
            case "clerigo":
                return new Clerigo(nombre, nivel, puntosVida, atributo);
            case "picaro":
                return new Picaro(nombre, nivel, puntosVida, interpretarSiNo(atributo));
            default:
                throw new DatosInvalidosException("La clase \"" + clase + "\" no es válida.");
        }
    }

    public List<Aventurero> getGremio() {
        return Collections.unmodifiableList(gremio);
    }

    private boolean existeNombre(String nombre) {
        for (Aventurero aventurero : gremio) {
            if (aventurero.getNombre().equalsIgnoreCase(nombre.trim())) {
                return true;
            }
        }
        return false;
    }

    private void actualizarVista() {
        if (vista != null) {
            vista.cargarTabla(gremio);
        }
    }

    private void accionRegistrar() {
        try {
            String clase = claseSeleccionada();
            String nombre = vista.getTxtNombre().getText();
            int nivel = convertirEntero(vista.getTxtNivel().getText(), "nivel");
            int puntosVida = convertirEntero(vista.getTxtPuntosVida().getText(), "puntos de vida");
            String atributo = vista.getChkAtributo().isVisible()
                    ? (vista.getChkAtributo().isSelected() ? "Sí" : "No")
                    : vista.getTxtAtributo().getText();

            registrarAventurero(clase, nombre, nivel, puntosVida, atributo);
            vista.limpiarFormulario();
            vista.mostrarMensaje("¡" + nombre.trim() + " se ha unido al gremio como " + clase + "!");
        } catch (DatosInvalidosException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void accionCambiarClase() {
        String clase = normalizar(claseSeleccionada());
        boolean esSiNo = clase.equals("guerrero") || clase.equals("picaro");

        switch (clase) {
            case "guerrero":
                vista.getLblAtributo().setText("Armadura pesada:");
                vista.getChkAtributo().setText("Usa armadura pesada");
                vista.getChkAtributo().setToolTipText("Marca la casilla si el guerrero lleva armadura pesada");
                break;
            case "mago":
                vista.getLblAtributo().setText("Espacios de conjuro:");
                vista.getTxtAtributo().setToolTipText("Número entero mayor que 0 (un mago de nivel 1 tiene 2)");
                break;
            case "clerigo":
                vista.getLblAtributo().setText("Dios venerado:");
                vista.getTxtAtributo().setToolTipText("Ej: Pelor, Tyr, Moradin");
                break;
            case "picaro":
                vista.getLblAtributo().setText("Herramientas de ladrón:");
                vista.getChkAtributo().setText("Tiene herramientas de ladrón");
                vista.getChkAtributo().setToolTipText("Marca la casilla si el pícaro tiene ganzúas y herramientas");
                break;
            default:
                vista.getLblAtributo().setText("Atributo especial:");
        }
        vista.getTxtAtributo().setVisible(!esSiNo);
        vista.getChkAtributo().setVisible(esSiNo);
        vista.getTxtAtributo().setText("");
        vista.getChkAtributo().setSelected(false);
    }

    private void guardarEnArchivo(String texto) {
        try {
            GestorArchivo.anexar(texto);
        } catch (IOException ex) {
            String aviso = "No se pudo escribir en " + GestorArchivo.RUTA_ARCHIVO + ": " + ex.getMessage();
            if (vista != null) {
                vista.mostrarError(aviso);
            } else {
                System.err.println(aviso);
            }
        }
    }

    private String claseSeleccionada() {
        Object seleccion = vista.getCmbClase().getSelectedItem();
        return seleccion == null ? "" : seleccion.toString();
    }

    private static int convertirEntero(String texto, String campo) throws DatosInvalidosException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new DatosInvalidosException("El campo \"" + campo + "\" es obligatorio.");
        }
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException ex) {
            throw new DatosInvalidosException("El campo \"" + campo + "\" debe ser un número entero.");
        }
    }

    private static boolean interpretarSiNo(String texto) {
        String valor = normalizar(texto);
        return valor.equals("si") || valor.equals("s") || valor.equals("true") || valor.equals("1");
    }

    private static String normalizar(String texto) {
        if (texto == null) {
            return "";
        }
        String sinTildes = Normalizer.normalize(texto.trim(), Normalizer.Form.NFD).replaceAll("\\p{M}", "");
        return sinTildes.toLowerCase();
    }

    private static boolean esDigitoOEdicion(char c) {
        return Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE;
    }

    private void soloNumeros(JTextField campo, int maxDigitos) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                boolean esEdicion = c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE;
                boolean excedeLargo = !esEdicion && campo.getText().length() >= maxDigitos
                        && campo.getSelectedText() == null;
                if (!esDigitoOEdicion(c) || excedeLargo) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }

    private void soloNumerosSiEsMago(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                boolean esMago = normalizar(claseSeleccionada()).equals("mago");
                if (esMago && !esDigitoOEdicion(e.getKeyChar())) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
    }
}
