package composicion;

public class Automovil {
    private int numRuedas;
    private Motor motor;

    public Automovil() {
        this.numRuedas = 4;
        this.motor = new Motor();
    }

    public Automovil(int numRuedas, int numMotor) {
        this.numRuedas = numRuedas;
        this.motor = new Motor(numMotor);
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumMotor(int numMotor) {
        this.motor.setNumMotor(numMotor);
    }

    public int getNumMotor() {
        return motor.getNumMotor();
    }



}
