package composicion;

public class PruebaAutomovil {
    public static void main(String[] args) {
        Automovil auto1 = new Automovil();
        System.out.println("Auto 1 - Ruedas: " + auto1.getNumRuedas() + ", Motor: " + auto1.getNumMotor());

        Automovil auto2 = new Automovil(6, 12345);
        System.out.println("Auto 2 - Ruedas: " + auto2.getNumRuedas() + ", Motor: " + auto2.getNumMotor());
    }
}
