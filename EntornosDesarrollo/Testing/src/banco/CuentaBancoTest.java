package banco;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CuentaBancoTest {
    private CuentaBanco cuenta;
    
    private static final String PASSWD = "contra";
    private static final int SALDO_INICIAL = 500;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cuenta=new CuentaBanco(SALDO_INICIAL,PASSWD);
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	//---------------------

	@Test
	public void testDepositar() {
		assertEquals(SALDO_INICIAL+200, cuenta.depositar(200));
	}
	
	@Test
	public void testDepositar2() {
		assertEquals(-1, cuenta.depositar(0));
	}
	
	@Test
	public void testDepositar3() {
		assertEquals(-1, cuenta.depositar(-100));
	}
	
	//----------------------

	@Test
	public void testRetirar() {
		assertEquals(SALDO_INICIAL-100,cuenta.retirar(100, PASSWD));
	}
	
	@Test
	public void testRetirar2() {
		assertEquals(-1,cuenta.retirar(SALDO_INICIAL+100, PASSWD));
	}
	
	@Test
	public void testRetirar3() {
		assertEquals(0,cuenta.retirar(SALDO_INICIAL, PASSWD));
	}
	
	@Test
	public void testRetirar4() {
		assertEquals(-2,cuenta.retirar(SALDO_INICIAL, PASSWD+"patata"));
	}
	
	//----------------------

	@Test
	public void testPasswordCorrecta() {
		assertEquals(true,cuenta.passwordCorrecta(PASSWD));
	}
	
	@Test
	public void testPasswordCorrecta2() {
		assertEquals(false,cuenta.passwordCorrecta(PASSWD+"patata"));
	}
	
	@Test
	public void testPasswordCorrecta3() {
		assertEquals(false,cuenta.passwordCorrecta(""));
	}

	

}
