package modelo;

public class Guerrero extends Aventurero {
    private boolean armaduraPesada;

    public Guerrero(String nombre, int nivel, int puntosVida, boolean armaduraPesada)
            throws DatosInvalidosException {
        super(nombre, nivel, puntosVida);
        this.armaduraPesada = armaduraPesada;
    }

    public boolean isArmaduraPesada() {
        return armaduraPesada;
    }

    public void setArmaduraPesada(boolean armaduraPesada) {
        this.armaduraPesada = armaduraPesada;
    }

    @Override
    public String getNombreClase() {
        return "Guerrero";
    }

    @Override
    public String getDadoGolpe() {
        return "d10";
    }

    @Override
    public String getAtributoEspecial() {
        return "Armadura pesada: " + (armaduraPesada ? "Sí" : "No");
    }

    @Override
    public String realizarAccion() {
        return "El Guerrero " + nombre
                + " usa Oleada de Acción para realizar múltiples ataques físicos continuos.";
    }
}
