package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import edu.buffalo.cse116.*;

public class ActualFractalTests {
	public ActualFractalTests() {
	}

	/**
	 * this sets the point system up for the coordinates.
	 * 
	 * @param x
	 * @param y
	 * @author Yang Cai and Florebencia Fils-Aime
	 */
	public Point original(int x, int y) {
		Point original = new Point(x, y);
		return original;
	}

	/**
	 * This is for the Mandelbrot Set.
	 * 
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 */
	@Test
	public void mandelbrotSetTranslationTest() {
		Sets set = new Sets();
		double w = (0.6 - (-2.15)) / 512;
		double h = (1.3 - (-1.3)) / 512;
		int[][] grid = new int[512][512];

		for (int i = 0; i < 512; i++) {
			for (int j = 0; j < 512; j++) {
				double x = w * j;
				double y = h * i;
				grid[i][j] = set.mandelbrotSet(x, y);
			}
		}
		assertTrue(grid[1][1] == set.mandelbrotSet(0.0043,0.0051));
	}

	/**
	 * This is for the Julia Set.
	 * 
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void juliaSetTranslationTest() {
		Sets set = new Sets();
		int[][] omg = new int[512][512];
		omg = set.Julia_set();
		assertTrue(omg[1][1] == set.juliaSet(0.0066,0.0039));
	}

	/**
	 * This is for the Burning Ship Set.
	 * 
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void burningShipSetTranslationTest() {
		Sets set = new Sets();
		int[][] omg = new int[512][512];
		omg = set.BurningShip_set();
		assertTrue(omg[1][1]==set.burningShipSet(0.0068,0.0002));
	}
	
	/**
	 * This tests if the escape time is greater than one
	 * 
	 * @author Genessy and Florebencia
	 */
	@Test 
	public void burningShipTest2() {
		Sets sets = new Sets();
		int escapeTime = sets.burningShipSet(-1.75, 0);
		assertTrue(escapeTime > 1);
	}

	/**
	 * This tests if the mandelbrot will return a int[512][512]
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void mandelbrotFractalReturn() {
		Sets sets = new Sets();
		int[][] grid = new int[512][512];
		grid = sets.Mandelbrot_set();
		assertTrue(grid==sets.Mandelbrot_set());
	}
	
	@Test
	public void burningShipFractalReturn(){
//		assertTrue(grid == sets.BurningShip_set());
//		assertTrue(grid == sets.Julia_set());
//		assertTrue(grid == sets.Multibrot_set());
	}

	@Test
	public void multibrotSetTranslationTest() {
		Sets set = new Sets();
		int[][] omg = new int[512][512];
		omg = set.Multibrot_set();
		assertTrue(omg[1][1]==set.Multibrot(0.0039,0.0051));
	}
	/**
	 * This method checks if the mandelbrot set will exceed the escape distance.
	 * If it does it exceed the distance then the escape time should be 1.
	 * 
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void mandelbrotExceedsEscapeDistance() {
		Sets sets = new Sets();
		double x = 0.5946289062500001;
		double y = 1.2949218750000122;
		int escapeTime = sets.mandelbrotSet(x, y);
		assertEquals(1, escapeTime, 0.0);
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
		Sets sets = new Sets();
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
		Sets sets = new Sets();
		double x = -1.7443359374999874;
		double y = -0.017451171875000338;
		int escapeTime = sets.burningShipSet(x, y);
		assertEquals(255, escapeTime, 0);
	}
	/**
	 * 
	 */
	@Test
	public void multibrotUnderEscapeDistance(){
		Sets sets = new Sets();
		double x = 0.5859375;
		double y = 0.24375000000000108;
		int escapeTime = sets.Multibrot(x, y);
		assertEquals(255, escapeTime, 0);
	}
	
	/**
	 * 
	 */
	@Test
	public void multibrotExceedsEscapeDistance(){
		Sets sets = new Sets();
		double x = 0.9921875;
		double y = 1.05625;
		int escapeTime = sets.Multibrot(x, y);
		assertEquals(1, escapeTime, 0.0);
	}
	/**
	 * 
	 */
	@Test
	public void juliaExceedsEscapeDistance(){
		Sets sets = new Sets();
		double x = 1.6933593749999853;
		double y = 0.9765625;
		int escapeTime = sets.juliaSet(x, y);
		assertEquals(255, escapeTime, 0);
		
				}
	/**
	 * 
	 */
	@Test
	public void juliaBelowEscapeDistance(){
		Sets sets = new Sets();
		double x = 1.0492187499999897;
				double y = -0.234375;
		int escapeTime = sets.juliaSet(x, y);
		assertEquals(255, escapeTime, 0);
	}
//	public void multibrotTest(int x, int y) {
//		double xCalc;
//		double yCalc;
//		xCalc = (0.6 - (-2.15)) / 512;
//		yCalc = (1.3 - (-1.3)) / 512;
//		double[][] grid = new double[512][512];
//		for (int i = 0; i < grid.length; i++) {
//			for (int k = 0; k < grid[i].length; i++) {
//				grid[i][k] = -2.15 + i * (xCalc) - 1.3 + (k * yCalc);
//			}
//		}
//		// Point ori = original(0, 0);
//
//		double xPrime;
//		double yPrime;
//		double dist = 0;
//		int passes = 0;
//
//		while (dist <= 2 && passes < 255) {
//			xPrime = Math.pow(x, 3) - (3 * x * Math.pow(y, 2)) + xCalc;
//			yPrime = (3 * Math.pow(x, 2) * y) - Math.pow(y, 3) + yCalc;
//			passes++;
//			dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
//
//		}
//	}
}
