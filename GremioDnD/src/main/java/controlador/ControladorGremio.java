package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Aventurero;
import modelo.Clerigo;
import modelo.DatosInvalidosException;
import modelo.GestorArchivo;
import modelo.Guerrero;
import modelo.Mago;
import modelo.Picaro;
import vista.FrmGremio;

public class ControladorGremio implements ActionListener {

    public static final int NIVEL_MAXIMO_GREMIO = 20;

    private ArrayList<Aventurero> gremio;
    private FrmGremio vista;

    public ControladorGremio(FrmGremio vista) {
        this.gremio = new ArrayList<>();
        this.vista = vista;
        if (vista != null) {
            vista.getBtnRegistrar().addActionListener(this);
            vista.getBtnCombate().addActionListener(this);
            vista.getBtnReportes().addActionListener(this);
            vista.getCmbClase().addActionListener(this);
            cambiarCampoAtributo();
            actualizarVista();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnRegistrar()) {
            accionRegistrar();
        } else if (e.getSource() == vista.getBtnCombate()) {
            accionCombate();
        } else if (e.getSource() == vista.getBtnReportes()) {
            accionReportes();
        } else if (e.getSource() == vista.getCmbClase()) {
            cambiarCampoAtributo();
        }
    }

    public void registrarAventurero(String clase, String nombre, int nivel, int puntosVida, String atributo)
            throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del aventurero es obligatorio.");
        }
        if (existeNombre(nombre)) {
            throw new DatosInvalidosException("Ya existe un aventurero llamado " + nombre.trim() + " en el gremio.");
        }

        Aventurero nuevo;
        if (clase.equals("Guerrero")) {
            nuevo = new Guerrero(nombre, nivel, puntosVida, atributo.equals("Sí"));
        } else if (clase.equals("Mago")) {
            nuevo = new Mago(nombre, nivel, puntosVida, convertirEntero(atributo, "espacios de conjuro"));
        } else if (clase.equals("Clérigo")) {
            nuevo = new Clerigo(nombre, nivel, puntosVida, atributo);
        } else if (clase.equals("Pícaro")) {
            nuevo = new Picaro(nombre, nivel, puntosVida, atributo.equals("Sí"));
        } else {
            throw new DatosInvalidosException("La clase " + clase + " no es válida.");
        }

        int nivelesUsados = sumarNiveles();
        if (nivelesUsados + nuevo.getNivel() > NIVEL_MAXIMO_GREMIO) {
            int nivelesDisponibles = NIVEL_MAXIMO_GREMIO - nivelesUsados;
            throw new DatosInvalidosException("El gremio ya suma " + nivelesUsados + " niveles y el máximo es "
                    + NIVEL_MAXIMO_GREMIO + ". Solo quedan " + nivelesDisponibles + " niveles disponibles.");
        }

        gremio.add(nuevo);
        guardarEnArchivo("REGISTRO -> " + nuevo.toString());
        actualizarVista();
    }

    public ArrayList<Aventurero> getGremio() {
        return gremio;
    }

    public int sumarNiveles() {
        int suma = 0;
        for (Aventurero aventurero : gremio) {
            suma = suma + aventurero.getNivel();
        }
        return suma;
    }

    public String simularCombate() {
        if (gremio.isEmpty()) {
            return "El gremio no tiene aventureros. Registra al menos uno para combatir.";
        }
        String relato = "===== INICIO DE COMBATE =====\n";
        guardarEnArchivo("===== INICIO DE COMBATE =====");

        for (Aventurero aventurero : gremio) {
            String mensaje = aventurero.realizarAccion();
            relato = relato + mensaje + "\n";
            guardarEnArchivo(mensaje);
        }

        relato = relato + "===== FIN DE COMBATE =====";
        guardarEnArchivo("===== FIN DE COMBATE =====");
        actualizarVista();
        return relato;
    }

    public String generarReporteComposicion() {
        int guerreros = 0;
        int magos = 0;
        int clerigos = 0;
        int picaros = 0;

        for (Aventurero aventurero : gremio) {
            String clase = aventurero.getNombreClase();
            if (clase.equals("Guerrero")) {
                guerreros++;
            } else if (clase.equals("Mago")) {
                magos++;
            } else if (clase.equals("Clérigo")) {
                clerigos++;
            } else if (clase.equals("Pícaro")) {
                picaros++;
            }
        }

        return "REPORTE 1 - COMPOSICIÓN DEL GREMIO\n"
                + "Guerreros: " + guerreros + "\n"
                + "Magos: " + magos + "\n"
                + "Clérigos: " + clerigos + "\n"
                + "Pícaros: " + picaros + "\n"
                + "Total del gremio: " + gremio.size();
    }

    public String generarReporteEstadisticas() {
        if (gremio.isEmpty()) {
            return "REPORTE 2 - ESTADÍSTICAS DEL GREMIO\nNo hay aventureros registrados.";
        }
        Aventurero mayorNivel = gremio.get(0);
        Aventurero mayorVida = gremio.get(0);
        int sumaNiveles = 0;
        int sumaPuntosVida = 0;

        for (Aventurero aventurero : gremio) {
            if (aventurero.getNivel() > mayorNivel.getNivel()) {
                mayorNivel = aventurero;
            }
            if (aventurero.getPuntosVida() > mayorVida.getPuntosVida()) {
                mayorVida = aventurero;
            }
            sumaNiveles = sumaNiveles + aventurero.getNivel();
            sumaPuntosVida = sumaPuntosVida + aventurero.getPuntosVida();
        }

        double promedioNivel = (double) sumaNiveles / gremio.size();
        promedioNivel = Math.round(promedioNivel * 100) / 100.0;

        return "REPORTE 2 - ESTADÍSTICAS DEL GREMIO\n"
                + "Mayor nivel: " + mayorNivel.getNombre() + " (" + mayorNivel.getNombreClase()
                + ", nivel " + mayorNivel.getNivel() + ")\n"
                + "Más puntos de vida: " + mayorVida.getNombre() + " (" + mayorVida.getPuntosVida() + " PV)\n"
                + "Nivel promedio: " + promedioNivel + "\n"
                + "Niveles usados: " + sumaNiveles + " de " + NIVEL_MAXIMO_GREMIO + "\n"
                + "Puntos de vida totales del gremio: " + sumaPuntosVida;
    }

    private void accionRegistrar() {
        try {
            String clase = (String) vista.getCmbClase().getSelectedItem();
            String nombre = vista.getTxtNombre().getText();
            int nivel = convertirEntero(vista.getTxtNivel().getText(), "nivel");
            int puntosVida = convertirEntero(vista.getTxtPuntosVida().getText(), "puntos de vida");

            String atributo;
            if (vista.getChkAtributo().isVisible()) {
                if (vista.getChkAtributo().isSelected()) {
                    atributo = "Sí";
                } else {
                    atributo = "No";
                }
            } else {
                atributo = vista.getTxtAtributo().getText();
            }

            registrarAventurero(clase, nombre, nivel, puntosVida, atributo);
            vista.limpiarFormulario();
            vista.mostrarMensaje(nombre.trim() + " se ha unido al gremio como " + clase + ".");
        } catch (DatosInvalidosException ex) {
            vista.mostrarError(ex.getMessage());
        }
    }

    private void accionCombate() {
        if (gremio.isEmpty()) {
            vista.mostrarMensaje(simularCombate());
        } else {
            vista.agregarBitacora(simularCombate() + "\n");
        }
    }

    private void accionReportes() {
        if (gremio.isEmpty()) {
            vista.mostrarMensaje("No hay aventureros para generar reportes.");
        } else {
            String reportes = generarReporteComposicion() + "\n\n" + generarReporteEstadisticas();
            vista.agregarBitacora(reportes + "\n");
            vista.mostrarMensaje(reportes);
        }
    }

    private void cambiarCampoAtributo() {
        String clase = (String) vista.getCmbClase().getSelectedItem();

        if (clase.equals("Guerrero")) {
            vista.getLblAtributo().setText("Armadura pesada:");
            vista.getChkAtributo().setText("Usa armadura pesada");
            vista.getChkAtributo().setVisible(true);
            vista.getTxtAtributo().setVisible(false);
        } else if (clase.equals("Mago")) {
            vista.getLblAtributo().setText("Espacios de conjuro:");
            vista.getTxtAtributo().setToolTipText("Número entero mayor que 0");
            vista.getChkAtributo().setVisible(false);
            vista.getTxtAtributo().setVisible(true);
        } else if (clase.equals("Clérigo")) {
            vista.getLblAtributo().setText("Dios venerado:");
            vista.getTxtAtributo().setToolTipText("Ej: Pelor, Tyr, Moradin");
            vista.getChkAtributo().setVisible(false);
            vista.getTxtAtributo().setVisible(true);
        } else if (clase.equals("Pícaro")) {
            vista.getLblAtributo().setText("Herramientas de ladrón:");
            vista.getChkAtributo().setText("Tiene herramientas de ladrón");
            vista.getChkAtributo().setVisible(true);
            vista.getTxtAtributo().setVisible(false);
        }

        vista.getTxtAtributo().setText("");
        vista.getChkAtributo().setSelected(false);
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

    private void guardarEnArchivo(String texto) {
        try {
            GestorArchivo.anexar(texto);
        } catch (IOException ex) {
            if (vista != null) {
                vista.mostrarError("No se pudo escribir en " + GestorArchivo.RUTA_ARCHIVO);
            }
        }
    }

    private int convertirEntero(String texto, String campo) throws DatosInvalidosException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new DatosInvalidosException("El campo " + campo + " es obligatorio.");
        }
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException ex) {
            throw new DatosInvalidosException("El campo " + campo + " debe ser un número entero.");
        }
    }
}
