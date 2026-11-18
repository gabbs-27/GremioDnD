package modelo;

public class Picaro extends Aventurero {
    private boolean herramientasLadron;

    public Picaro(String nombre, int nivel, int puntosVida, boolean herramientasLadron)
            throws DatosInvalidosException {
        super(nombre, nivel, puntosVida);
        this.herramientasLadron = herramientasLadron;
    }

    public boolean isHerramientasLadron() {
        return herramientasLadron;
    }

    public void setHerramientasLadron(boolean herramientasLadron) {
        this.herramientasLadron = herramientasLadron;
    }

    @Override
    public String getNombreClase() {
        return "Pícaro";
    }

    @Override
    public String getDadoGolpe() {
        return "d8";
    }

    @Override
    public String getAtributoEspecial() {
        return "Herramientas de ladrón: " + (herramientasLadron ? "Sí" : "No");
    }

    @Override
    public String realizarAccion() {
        return "El Pícaro " + nombre
                + " aprovecha la ventaja táctica para asestar un Ataque Furtivo masivo y se reposiciona.";
    }
}
