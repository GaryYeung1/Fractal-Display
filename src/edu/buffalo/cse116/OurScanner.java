package edu.buffalo.cse116;

import java.util.Scanner;

/**
 * This class was created to be get the user input for the escape distance.
 * @author Florebencia Fils-Aime
 *
 */
public class OurScanner {
	private int _escapeDistance;
	/**creates the scanner to get the user input
	 * @author Florebencia Fils-Aime
	 */
	public OurScanner(){
		
	}
	
	/**
	 * This method gets the _escapeDistance and turns the integer public
	 * @author Florebencia Fils-Aime
	 * @return _escapeDistance
	 */
	public int getEscapeDistance(){
		int escapeDistance;
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Hello. Please enter an integer for the escapeDistance:");
		escapeDistance = myScanner.nextInt();
		while(escapeDistance <= 0){
			System.out.println("I'm sorry. You can't put a number less than zero. Try and enter the number again: ");
			escapeDistance = myScanner.nextInt();
		}
		System.out.println("Thank you, the fractal will be here shortly");
		return escapeDistance;
	}
}
