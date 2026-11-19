package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AventureroTest {
    @Test
    public void constructorGuardaLosDatosBasicos() throws DatosInvalidosException {
        Aventurero a = new Guerrero("Thorgar", 7, 64, true);
        assertEquals("Thorgar", a.getNombre());
        assertEquals(7, a.getNivel());
        assertEquals(64, a.getPuntosVida());
    }

    @Test
    public void nombreSeGuardaSinEspaciosSobrantes() throws DatosInvalidosException {
        Aventurero a = new Guerrero("   Thorgar  ", 1, 10, false);
        assertEquals("Thorgar", a.getNombre());
    }

    @Test
    public void nombreVacioLanzaExcepcion() {
        assertThrows(DatosInvalidosException.class, () -> new Guerrero("   ", 1, 10, false));
    }

    @Test
    public void nivelCeroLanzaExcepcion() {
        assertThrows(DatosInvalidosException.class, () -> new Guerrero("Thorgar", 0, 10, false));
    }

    @Test
    public void nivelMayorA20LanzaExcepcion() {
        assertThrows(DatosInvalidosException.class, () -> new Guerrero("Thorgar", 21, 10, false));
    }

    @Test
    public void nivelesLimiteSonValidos() throws DatosInvalidosException {
        assertEquals(1, new Guerrero("Novato", Aventurero.NIVEL_MINIMO, 10, false).getNivel());
        assertEquals(20, new Guerrero("Leyenda", Aventurero.NIVEL_MAXIMO, 200, true).getNivel());
    }

    @Test
    public void puntosVidaEnCeroLanzaExcepcion() {
        assertThrows(DatosInvalidosException.class, () -> new Guerrero("Thorgar", 5, 0, false));
    }

    @Test
    public void setNivelInvalidoLanzaExcepcion() throws DatosInvalidosException {
        Aventurero a = new Guerrero("Thorgar", 5, 40, false);
        assertThrows(DatosInvalidosException.class, () -> a.setNivel(25));
        assertEquals(5, a.getNivel());
    }

    @Test
    public void contadorStaticAumentaConCadaAventurero() throws DatosInvalidosException {
        int antes = Aventurero.getTotalAventureros();
        new Guerrero("Uno", 1, 10, false);
        new Picaro("Dos", 1, 8, true);
        assertEquals(antes + 2, Aventurero.getTotalAventureros());
    }

    @Test
    public void toStringIncluyeLosDatosPrincipales() throws DatosInvalidosException {
        String texto = new Guerrero("Thorgar", 7, 64, true).toString();
        assertTrue(texto.contains("Guerrero"));
        assertTrue(texto.contains("Thorgar"));
        assertTrue(texto.contains("Nivel 7"));
        assertTrue(texto.contains("PV 64"));
    }
}
