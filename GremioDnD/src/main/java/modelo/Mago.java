package modelo;

public class Mago extends Aventurero {
    private int espaciosConjuro;

    public Mago(String nombre, int nivel, int puntosVida, int espaciosConjuro)
            throws DatosInvalidosException {
        super(nombre, nivel, puntosVida);
        if (espaciosConjuro < 1) {
            throw new DatosInvalidosException("El mago necesita al menos 1 espacio de conjuro.");
        }
        this.espaciosConjuro = espaciosConjuro;
    }

    public int getEspaciosConjuro() {
        return espaciosConjuro;
    }

    public boolean gastarEspacioConjuro() {
        return gastarEspacioConjuro(1);
    }

    public boolean gastarEspacioConjuro(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de espacios a gastar debe ser mayor que 0.");
        }
        if (cantidad > espaciosConjuro) {
            return false;
        }
        espaciosConjuro -= cantidad;
        return true;
    }

    @Override
    public String getNombreClase() {
        return "Mago";
    }

    @Override
    public String getDadoGolpe() {
        return "d6";
    }

    @Override
    public String getAtributoEspecial() {
        return "Espacios de conjuro: " + espaciosConjuro;
    }

    @Override
    public String realizarAccion() {
        if (gastarEspacioConjuro()) {
            return "El Mago " + nombre
                    + " gasta un espacio de conjuro para lanzar una poderosa Bola de Fuego.";
        }
        return "El Mago " + nombre
                + " no tiene espacios de conjuro disponibles y ataca con su bastón.";
    }
}
