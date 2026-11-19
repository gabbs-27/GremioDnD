package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PicaroTest {
    @Test
    public void realizarAccionHaceAtaqueFurtivo() throws DatosInvalidosException {
        Picaro p = new Picaro("Sombra", 3, 21, true);
        assertEquals("El Pícaro Sombra aprovecha la ventaja táctica para asestar un Ataque Furtivo masivo y se reposiciona.",
                p.realizarAccion());
    }

    @Test
    public void guardaSiTieneHerramientasDeLadron() throws DatosInvalidosException {
        assertTrue(new Picaro("Sombra", 3, 21, true).isHerramientasLadron());
    }

    @Test
    public void dadoDeGolpeEsD8() throws DatosInvalidosException {
        assertEquals("d8", new Picaro("Sombra", 3, 21, true).getDadoGolpe());
    }

    @Test
    public void atributoEspecialDescribeLasHerramientas() throws DatosInvalidosException {
        assertEquals("Herramientas de ladrón: No", new Picaro("Sombra", 3, 21, false).getAtributoEspecial());
    }

    @Test
    public void polimorfismoDesdeReferenciaDeTipoAventurero() throws DatosInvalidosException {
        Aventurero a = new Picaro("Sombra", 3, 21, true);
        assertEquals("Pícaro", a.getNombreClase());
        assertTrue(a.realizarAccion().contains("Ataque Furtivo"));
    }
}
