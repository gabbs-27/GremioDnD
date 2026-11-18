package modelo;

public abstract class Aventurero implements IAccionCombate {
    public static final int NIVEL_MINIMO = 1;
    public static final int NIVEL_MAXIMO = 20;

    private static int totalAventureros = 0;

    protected String nombre;
    protected int nivel;
    protected int puntosVida;

    public Aventurero(String nombre, int nivel, int puntosVida) throws DatosInvalidosException {
        validarDatos(nombre, nivel, puntosVida);
        this.nombre = nombre.trim();
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        totalAventureros++;
    }

    public abstract String getNombreClase();

    public abstract String getDadoGolpe();

    public abstract String getAtributoEspecial();

    @Override
    public abstract String realizarAccion();

    protected final void validarDatos(String nombre, int nivel, int puntosVida) throws DatosInvalidosException {
        validarNombre(nombre);
        validarNivel(nivel);
        validarPuntosVida(puntosVida);
    }

    private static void validarNombre(String nombre) throws DatosInvalidosException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del aventurero es obligatorio.");
        }
    }

    private static void validarNivel(int nivel) throws DatosInvalidosException {
        if (nivel < NIVEL_MINIMO || nivel > NIVEL_MAXIMO) {
            throw new DatosInvalidosException("El nivel debe estar entre " + NIVEL_MINIMO
                    + " y " + NIVEL_MAXIMO + " (reglas de D&D 5e).");
        }
    }

    private static void validarPuntosVida(int puntosVida) throws DatosInvalidosException {
        if (puntosVida <= 0) {
            throw new DatosInvalidosException(
                    "Los puntos de vida deben ser mayores que 0. Con 0 PV el personaje cae inconsciente.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatosInvalidosException {
        validarNombre(nombre);
        this.nombre = nombre.trim();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) throws DatosInvalidosException {
        validarNivel(nivel);
        this.nivel = nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) throws DatosInvalidosException {
        validarPuntosVida(puntosVida);
        this.puntosVida = puntosVida;
    }

    public static int getTotalAventureros() {
        return totalAventureros;
    }

    @Override
    public String toString() {
        return getNombreClase() + " | " + nombre
                + " | Nivel " + nivel
                + " | PV " + puntosVida
                + " | Dado de golpe " + getDadoGolpe()
                + " | " + getAtributoEspecial();
    }
}
