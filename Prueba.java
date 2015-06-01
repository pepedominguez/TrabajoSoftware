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
		 * Este método va a ser correcto ya que al ejecutarlo el bitset1 va a
		 * corresponder al primer constructor que se le pasará por parámetro
		 * N=10 (su longitud), y el bitset2 va a corresponder al segundo
		 * constructor cuyo valor en binario va a ser 1010101010 cuya longitud
		 * es 10. 10 = 10 en ambos casos por lo tanto el test va a ser correcto.
		 */
	}

	@Test
	public void testSetBit() {
		/*
		 * La línea siguiente cambia el valor de la segunda posición del array
		 * por un 1.
		 */
		bitset3.set(1, '1');
		/*
		 * La siguiente línea mira si el valor de la segunda posición del array
		 * es un 1.
		 */
		assertEquals('1', bitset3.get(1));

	}
	/* El siguiente test será correcto si y solo si
	 * al intentar conseguir el valor del puesto 56 del array
	 * esto haga que se intente acceder a una posición del array fuera
	 * de sus límites y esto provoque que se lance una excepción de tipo 
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
			fail("Se esperaba excepción BinaryStringException");
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
