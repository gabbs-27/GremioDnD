package controlador;

import modelo.DatosInvalidosException;
import vista.FrmGremio;

public class Main {

    public static void main(String[] args) {
        FrmGremio vista = new FrmGremio();
        ControladorGremio controlador = new ControladorGremio(vista);

        cargarGremioInicial(controlador);
        imprimirReportes(controlador);

        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    private static void cargarGremioInicial(ControladorGremio controlador) {
        try {
            controlador.registrarAventurero("Guerrero", "Thorgar", 1, 12, "Sí");
            controlador.registrarAventurero("Mago", "Elandra", 1, 8, "2");
        } catch (DatosInvalidosException ex) {
            System.out.println("No se pudo cargar el gremio inicial: " + ex.getMessage());
        }
    }

    private static void imprimirReportes(ControladorGremio controlador) {
        System.out.println("==============================================");
        System.out.println(controlador.generarReporteComposicion());
        System.out.println("----------------------------------------------");
        System.out.println(controlador.generarReporteEstadisticas());
        System.out.println("==============================================");
    }
}
