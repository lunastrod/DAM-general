package banco;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

@RunWith(Parameterized.class)
public class CuentaBancoTest2 {

    private CuentaBanco cuenta;

    private final int cantidad;
    private final int esperado;

    private static final int SALDO_INICIAL = 500;

    public CuentaBancoTest2(int cantidad, int esperado) {
        this.cantidad = cantidad;
        this.esperado = esperado;
    }

    @Parameters(name = "depositar({0}) => {1}")
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][] {
            {  200,  700 },   // deposito valido normal
            {    1,  501 },   // minimo valido
            { 1000, 1500 },   // deposito grande
            {    0,   -1 },   // cero no valido
            { -100,   -1 },   // negativo
        });
    }

    @Before
    public void setUp() throws Exception {
        cuenta = new CuentaBanco(SALDO_INICIAL, "contra");
    }

    @Test
    public void testDepositar() {
        assertEquals(esperado, cuenta.depositar(cantidad));
    }
}