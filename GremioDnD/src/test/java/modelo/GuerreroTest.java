package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GuerreroTest {
    @Test
    public void realizarAccionUsaOleadaDeAccion() throws DatosInvalidosException {
        Guerrero g = new Guerrero("Thorgar", 7, 64, true);
        assertEquals("El Guerrero Thorgar usa Oleada de Acción para realizar múltiples ataques físicos continuos.",
                g.realizarAccion());
    }

    @Test
    public void guardaSiUsaArmaduraPesada() throws DatosInvalidosException {
        assertTrue(new Guerrero("Thorgar", 7, 64, true).isArmaduraPesada());
        assertFalse(new Guerrero("Lira", 2, 18, false).isArmaduraPesada());
    }

    @Test
    public void dadoDeGolpeEsD10() throws DatosInvalidosException {
        assertEquals("d10", new Guerrero("Thorgar", 7, 64, true).getDadoGolpe());
    }

    @Test
    public void atributoEspecialDescribeLaArmadura() throws DatosInvalidosException {
        assertEquals("Armadura pesada: Sí", new Guerrero("Thorgar", 7, 64, true).getAtributoEspecial());
        assertEquals("Armadura pesada: No", new Guerrero("Lira", 2, 18, false).getAtributoEspecial());
    }

    @Test
    public void nombreDeClaseEsGuerrero() throws DatosInvalidosException {
        assertEquals("Guerrero", new Guerrero("Thorgar", 7, 64, true).getNombreClase());
    }
}
