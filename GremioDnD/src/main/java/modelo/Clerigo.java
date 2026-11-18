package modelo;

public class Clerigo extends Aventurero {
    private String diosVenerado;

    public Clerigo(String nombre, int nivel, int puntosVida, String diosVenerado)
            throws DatosInvalidosException {
        super(nombre, nivel, puntosVida);
        setDiosVenerado(diosVenerado);
    }

    public String getDiosVenerado() {
        return diosVenerado;
    }

    public final void setDiosVenerado(String diosVenerado) throws DatosInvalidosException {
        if (diosVenerado == null || diosVenerado.trim().isEmpty()) {
            throw new DatosInvalidosException("Debes indicar el dios venerado por el clérigo.");
        }
        this.diosVenerado = diosVenerado.trim();
    }

    @Override
    public String getNombreClase() {
        return "Clérigo";
    }

    @Override
    public String getDadoGolpe() {
        return "d8";
    }

    @Override
    public String getAtributoEspecial() {
        return "Dios venerado: " + diosVenerado;
    }

    @Override
    public String realizarAccion() {
        return "El Clérigo " + nombre
                + " usa Canalizar Divinidad para curar a sus aliados y expulsar muertos vivientes.";
    }
}
