package JUnit;

import java.util.Random;

public class BinaryString {
	private char[] bits;

	public BinaryString(int numerobits) {
		bits = new char[numerobits];
		Random random = new Random();
		for (int i = 0; i < numerobits; i++) {
			if (random.nextDouble() < 0.5) {
				bits[i] = '1';
			} else {
				bits[i] = '0';
			}
		}

	}
	
	public BinaryString(String bits){
		this.bits = bits.toCharArray();
	}
	public int length(){
		return bits.length;
	}
	public void set(int index, char value){
		/* Las siguientes líneas de código es como yo lo hubiese hecho :*/
		if((index>bits.length-1)||(index<0)){
			throw new BinaryStringException("No entra dentro de los límites del array.");
		}
		if((value!='0')&&(value!='1')){
			throw new BinaryStringException("El valor a cambiar no ha de ser distinto a 0 o 1.");
		}
		bits[index]=value;
		/* El ejemplo de código que sale en las transparencias es el siguiente:
		 * try{bits[index]=value;}catch(RuntimeException e)
		 * {throw new BinaryStringException();}*/
	}
	public char get(int index){
		/* Las siguientes líneas de código es como yo lo hubiese hecho :*/
		if((index>bits.length-1)||(index<0)){
			throw new BinaryStringException("No entra dentro de los límites del array.");
		}
		return bits[index];
		/* El ejemplo de código que sale en las transparencias es el siguiente:
		 * try{return bits[index]}catch(RuntimeException e)
		 * {throw new BinaryStringException();}*/
	}
	public String toString(){
		String res = "";
		for(int i=0;i<bits.length;i++){
			if(bits[i]=='1'){
				res = res + "1";
			}else{
				res = res + "0";
			}
		}
		return res;
	}
	

}
