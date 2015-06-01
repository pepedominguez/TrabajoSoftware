package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Prueba {
	private BinaryString bitset1, bitset2, bitset3, bitset4, bitset5;
	private String pruebaString2 = "1010101010", pruebaString3 = "100101",
			pruebaString4 = "0110101", pruebaString5 = "1111000";

	@Before
	// Con before leemos los datos de entrada antes de nada.
	public void antesDelTest() {
		bitset1 = new BinaryString(10);
		bitset2 = new BinaryString(pruebaString2);
		bitset3 = new BinaryString(pruebaString3);
		bitset4 = new BinaryString(pruebaString4);
		bitset5 = new BinaryString(pruebaString5);
	}

	@Test
	public void testLength() {
		assertEquals(10, bitset1.length());
		assertEquals(10, bitset2.length());
		/*
		 * Este m�todo va a ser correcto ya que al ejecutarlo el bitset1 va a
		 * corresponder al primer constructor que se le pasar� por par�metro
		 * N=10 (su longitud), y el bitset2 va a corresponder al segundo
		 * constructor cuyo valor en binario va a ser 1010101010 cuya longitud
		 * es 10. 10 = 10 en ambos casos por lo tanto el test va a ser correcto.
		 */
	}

	@Test
	public void testSetBit() {
		/*
		 * La l�nea siguiente cambia el valor de la segunda posici�n del array
		 * por un 1.
		 */
		bitset3.set(1, '1');
		/*
		 * La siguiente l�nea mira si el valor de la segunda posici�n del array
		 * es un 1.
		 */
		assertEquals('1', bitset3.get(1));

	}
	/* El siguiente test ser� correcto si y solo si
	 * al intentar conseguir el valor del puesto 56 del array
	 * esto haga que se intente acceder a una posici�n del array fuera
	 * de sus l�mites y esto provoque que se lance una excepci�n de tipo 
	 * BinaryStringException.*/
	@Test(expected = BinaryStringException.class)
	public void testGetOutOfLimitBit(){
		bitset4.get(56);
	}
	@Test(expected = BinaryStringException.class)
	public void testSetOutOfLimitBit(){
		bitset4.set(56, '0');
	}
	@Test
	public void testSetOutOfLimitBitV2(){
		try{
			bitset4.set(56, '0');
			fail("Se esperaba excepci�n BinaryStringException");
		}catch(BinaryStringException e){
			
		}
	}
	@Test (expected = BinaryStringException.class)
	public void testInvalidBitValue(){
		bitset4.set(1, 'a');
	}
	@Test
	public void testToString(){
		assertEquals(" 1111000", bitset5.toString());
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	

}
