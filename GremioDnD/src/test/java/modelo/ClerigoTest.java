package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ClerigoTest {
    @Test
    public void realizarAccionCanalizaDivinidad() throws DatosInvalidosException {
        Clerigo c = new Clerigo("Aldric", 4, 31, "Pelor");
        assertEquals("El Clérigo Aldric usa Canalizar Divinidad para curar a sus aliados y expulsar muertos vivientes.",
                c.realizarAccion());
    }

    @Test
    public void guardaElDiosVenerado() throws DatosInvalidosException {
        assertEquals("Pelor", new Clerigo("Aldric", 4, 31, "  Pelor ").getDiosVenerado());
    }

    @Test
    public void diosVacioLanzaExcepcion() {
        assertThrows(DatosInvalidosException.class, () -> new Clerigo("Aldric", 4, 31, ""));
    }

    @Test
    public void dadoDeGolpeEsD8() throws DatosInvalidosException {
        assertEquals("d8", new Clerigo("Aldric", 4, 31, "Tyr").getDadoGolpe());
    }

    @Test
    public void atributoEspecialMuestraElDios() throws DatosInvalidosException {
        assertEquals("Dios venerado: Tyr", new Clerigo("Aldric", 4, 31, "Tyr").getAtributoEspecial());
    }
}
