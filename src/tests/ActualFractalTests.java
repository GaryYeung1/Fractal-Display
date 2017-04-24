package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Scanner;

import org.junit.Test;

import edu.buffalo.cse116.*;

public class ActualFractalTests {
	private GUI _gui;
	private Sets sets;
	private Scanner scanner; 
	private final int userInputTime, userInputDis;
	public ActualFractalTests() {
		sets = new Sets(_gui);
//		_gui = new GUI();
		scanner = new Scanner(System.in);
//		System.out.println("Hello. Please enter an integer for the escapeDistance:");
//		int dis = scanner.nextInt();
//		if(dis>0){
//			userInputDis = dis;
//		}
//		else{
//			while(dis <= 0){
//				System.out.println("I'm sorry. You can't put a number less "
//						+ "than zero. Try and enter the number again: ");
//				dis = scanner.nextInt();
//			}
//			userInputDis = dis;
//		}
//		System.out.println("Thank you. Can you enter an integer for the escapeTime? "
//				+ "Type here:");
//		int time = scanner.nextInt();
//		if(time>1 && time<255){
//			userInputTime = time;
//		}
//		else{
//			while(time < 1 || time > 255){
//				System.out.println("I'm sorry. You can't put a number less than 1 or "
//						+ "greater than 255. Try and enter the number again: ");
//				time = scanner.nextInt();
//			}
//			userInputTime = time;
//		}

	}
	
//	public mandel

	/**
	 * Tests that the Mandelbrot set properly translates to the appropriate x and y coordinates.
	 * 
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 */
	@Test
	public void mandelbrotSetTranslationTest() {
		Sets sets = new Sets(_gui);
		int[][] grid = new int[2048][2048];
		grid = sets.Mandelbrot_set(-2.15,-1.3,0.6,1.3,2,255);
		assertEquals(grid[0][0], sets.mandelbrotSet(-2.15, -1.3, 2, 255));
	}

	/**
	 * Tests that the Julia set properly translates to the appropriate x and y coordinates.
	 * 
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void juliaSetTranslationTest() {
		//		Sets sets = new Sets(_gui);
		int[][] omg = new int[512][512];
		omg = sets.Julia_set();
		assertTrue(omg[0][0] == sets.juliaSet(-1.7,-1.0));
	}

	/**
	Tests that the Burningship set properly translates to the appropriate x and y coordinates.
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void burningShipSetTranslationTest() {
		//		Sets sets = new Sets(_gui);
		int[][] omg = new int[512][512];
		omg = sets.BurningShip_set();
		assertTrue(omg[0][0]==sets.burningShipSet(-1.8,-0.08));
	}

	/**
	 * This tests if the escape time is greater than one
	 * 
	 * @author Genessy and Florebencia
	 */
	@Test 
	public void burningShipTest2() {
		//		Sets sets = new Sets(_gui);
		int escapeTime = sets.burningShipSet(-1.75, 0);
		assertTrue(escapeTime > 1);
	}

	/**
	 * This tests if the mandelbrot will return an int[512][512]
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void mandelbrotFractalReturn() {
		//		Sets sets = new Sets(_gui);
		int[][] grid = new int[512][512];
		grid = sets.Mandelbrot_set();
		assertArrayEquals(grid, sets.Mandelbrot_set());
	}
	/**
	 * This tests if the burningShip set will return an array of 512 by 512
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void burningShipFractalReturn(){
		//		Sets sets = new Sets(_gui);
		int[][] grid = new int[512][512];
		grid = sets.BurningShip_set();
		assertArrayEquals(grid, sets.BurningShip_set());

	}
	/**
	 * Tests that the Multibrot set properly translates to the appropriate x and y coordinates.
	 * @author Gary Yeung
	 */
	@Test
	public void multibrotSetTranslationTest() {
		//		Sets set = new Sets(_gui);
		int[][] omg = new int[512][512];
		omg = sets.Multibrot_set();
		assertTrue(omg[0][0]==sets.Multibrot(-1.0,-1.3));
	}
	/**
	 * This method checks if the mandelbrot set will exceed the escape distance.
	 * If it does it exceed the distance then the escape time should be 1.
	 * 
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void mandelbrotExceedsEscapeDistance() {
		//		Sets sets = new Sets(_gui);
		double x = 0.5946289062500001;
		double y = 1.2949218750000122;
		int escapeTime = sets.mandelbrotSet(x, y);
		assertEquals(2.0, escapeTime, 0.0);
	}

	/**
	 * This method checks if the mandelbrot set will never exceed the escape
	 * distance. If it doesn't the sets class method should stop the loop at 254
	 * times and the escape time should be 254.
	 * 
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void mandelbrotUnderEscapeDistance() {
		//		Sets sets = new Sets(_gui);
		double x = 0.3207031250000001;
		double y = -0.07109374999999386;
		int escapeTime = sets.mandelbrotSet(x, y);
		assertEquals(255, escapeTime, 0.0);
	}

	/**
	 * Method checks if the burning ship set stays below the escape distance. +
	 * * @author genessy 
	 */
	@Test
	public void burningShipBelowEscapeDistance() {
		//		Sets sets = new Sets(_gui);
		double x = -1.7443359374999874;
		double y = -0.017451171875000338;
		int escapeTime = sets.burningShipSet(x, y);
		assertEquals(255, escapeTime, 0);
	}
	/**
	 * This method calculates how many loops the multibrot should do while being under the 
	 * escape distance
	 * @author Florebencia and Genessy
	 */
	@Test
	public void multibrotUnderEscapeDistance(){
		//		Sets sets = new Sets(_gui);
		double x = 0.5859375;
		double y = 0.24375000000000108;
		int escapeTime = sets.Multibrot(x, y);
		assertEquals(255, escapeTime, 0);
	}

	/**
	 * This method checks if the escape time exceeds escape distance
	 * @author Florebencia 
	 */
	@Test
	public void multibrotExceedsEscapeDistance(){
		//		Sets sets = new Sets(_gui);
		double x = 0.9921875;
		double y = 1.05625;
		int escapeTime = sets.Multibrot(x, y);
		assertTrue(0 <= escapeTime);
	}
	/**
	 * Method checks if the julia set exceeds the escape distance.
	 * @author Genessy
	 */
	@Test
	public void juliaExceedsEscapeDistance(){
		//		Sets sets = new Sets(_gui);
		double x = 1.6933593749999853;
		double y = 0.9765625;
		int escapeTime = sets.juliaSet(x, y);
		assertTrue(0 <= escapeTime);
	}
	/**
	 * Method checks if the julia set stays below the escape distance.
	 */
	@Test
	public void juliaBelowEscapeDistance(){
		//		Sets sets = new Sets(_gui);
		double x = 1.0492187499999897;
		double y = -0.234375;
		int escapeTime = sets.juliaSet(x, y);
		assertEquals(255, escapeTime, 0);
	}


}