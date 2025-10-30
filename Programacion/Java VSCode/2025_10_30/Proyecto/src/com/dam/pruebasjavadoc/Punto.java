/**
* Esta clase define un punto en un espacio de dos dimensiones.
* @author Daniel Parra Segovia
* @version1.0, 30 de octubre de 2025
*/

public class Punto {
    /** @param x Coordenada x del punto */
    private float x;
    /** @param y Coordenada y del punto */
    private float y;
    /**
    * Constructor por defecto
    */
    public Punto() {
        x = 0.0f;
        y = 0.0f;
    }
    /**
    * Constructor con argumentos.
    * @param x La coordenada ’x’ del punto.
    * @param y La coordenada ’y’ del punto.
    */
    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }
    /**
    * Esta función devuelve el valor de la coordenada ’x’
    * @return El valor de la coordenada ’x’
    */
    public float getX() {
        return x;
    }
    /**
    * Esta función cambia el valor de la coordenada ’x’
    * @param x El nuevo valor de la coordenada ’x’
    */
    public void setX(float x) {
        this.x = x;
    }
    /**
     * Esta función devuelve el valor de la coordenada ’y’
     * @return El valor de la coordenada ’y’
     */
    public float getY() {
        return y;
    }
}
    
