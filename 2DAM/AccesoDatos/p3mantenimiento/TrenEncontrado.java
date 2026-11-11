package p3mantenimiento;

public class TrenEncontrado {
    private Tren tren;
    private long posicion;

    public TrenEncontrado(Tren tren, long posicion) {
        this.tren = tren;
        this.posicion = posicion;
    }

    public Tren getTren() {
        return tren;
    }

    public long getPosicion() {
        return posicion;
    }
}