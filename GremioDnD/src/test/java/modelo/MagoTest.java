package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MagoTest {
    @Test
    public void realizarAccionLanzaBolaDeFuego() throws DatosInvalidosException {
        Mago m = new Mago("Elandra", 5, 28, 4);
        assertEquals("El Mago Elandra gasta un espacio de conjuro para lanzar una poderosa Bola de Fuego.",
                m.realizarAccion());
    }

    @Test
    public void realizarAccionGastaUnEspacioDeConjuro() throws DatosInvalidosException {
        Mago m = new Mago("Elandra", 5, 28, 4);
        m.realizarAccion();
        assertEquals(3, m.getEspaciosConjuro());
    }

    @Test
    public void sinEspaciosAtacaConElBaston() throws DatosInvalidosException {
        Mago m = new Mago("Elandra", 1, 8, 1);
        m.realizarAccion();
        assertEquals("El Mago Elandra no tiene espacios de conjuro disponibles y ataca con su bastón.",
                m.realizarAccion());
        assertEquals(0, m.getEspaciosConjuro());
    }

    @Test
    public void sobrecargaGastarUnEspacio() throws DatosInvalidosException {
        Mago m = new Mago("Elandra", 5, 28, 4);
        assertTrue(m.gastarEspacioConjuro());
        assertEquals(3, m.getEspaciosConjuro());
    }

    @Test
    public void sobrecargaGastarVariosEspacios() throws DatosInvalidosException {
        Mago m = new Mago("Elandra", 5, 28, 4);
        assertTrue(m.gastarEspacioConjuro(3));
        assertEquals(1, m.getEspaciosConjuro());
    }

    @Test
    public void noGastaSiNoAlcanzanLosEspacios() throws DatosInvalidosException {
        Mago m = new Mago("Elandra", 5, 28, 2);
        assertFalse(m.gastarEspacioConjuro(5));
        assertEquals(2, m.getEspaciosConjuro());
    }

    @Test
    public void cantidadInvalidaLanzaExcepcion() throws DatosInvalidosException {
        Mago m = new Mago("Elandra", 5, 28, 2);
        assertThrows(IllegalArgumentException.class, () -> m.gastarEspacioConjuro(0));
    }

    @Test
    public void menosDeUnEspacioLanzaExcepcion() {
        assertThrows(DatosInvalidosException.class, () -> new Mago("Elandra", 5, 28, 0));
    }

    @Test
    public void dadoDeGolpeEsD6() throws DatosInvalidosException {
        assertEquals("d6", new Mago("Elandra", 5, 28, 4).getDadoGolpe());
    }
}
