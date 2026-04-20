package pruebas;

public class calculadora {
    private int a,b;
    public calculadora(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int suma(){
        return a+b;
    }
    public int resta(){
        return a-b;
    }
    public int multiplicacion(){
        return a*b;
    }
    public int division(){
        return a/b;
    }
}
