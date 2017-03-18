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
	 * Tests that the Mandelbrot set properly translates to the appropriate x and y coordinates.
	 * 
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 */
	@Test
	public void mandelbrotSetTranslationTest() {
		Sets set = new Sets();
		int[][] grid = new int[512][512];
		grid = set.Mandelbrot_set();
		assertTrue(grid[0][0] == set.mandelbrotSet(-2.15, -1.3));
	}

	/**
	 * Tests that the Julia set properly translates to the appropriate x and y coordinates.
	 * 
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void juliaSetTranslationTest() {
		Sets set = new Sets();
		int[][] omg = new int[512][512];
		omg = set.Julia_set();
		assertTrue(omg[0][0] == set.juliaSet(-1.7,-1.0));
	}

	/**
	Tests that the Burningship set properly translates to the appropriate x and y coordinates.
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void burningShipSetTranslationTest() {
		Sets set = new Sets();
		int[][] omg = new int[512][512];
		omg = set.BurningShip_set();
		assertTrue(omg[0][0]==set.burningShipSet(-1.8,-0.08));
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
		assertTrue(grid.equals(sets.Mandelbrot_set()));
	}
	
	@Test
	public void burningShipFractalReturn(){
		Sets sets = new Sets();
		int[][] grid = new int[512][512];
		grid = sets.BurningShip_set();
		assertTrue(grid.equals(sets.BurningShip_set()));
//		assertTrue(grid == sets.Julia_set());
//		assertTrue(grid == sets.Multibrot_set());
	}
	/**
	 * Tests that the Multibrot set properly translates to the appropriate x and y coordinates.
	 * @author Gary Yeung
	 */
	@Test
	public void multibrotSetTranslationTest() {
		Sets set = new Sets();
		int[][] omg = new int[512][512];
		omg = set.Multibrot_set();
		assertTrue(omg[0][0]==set.Multibrot(-1.0,-1.3));
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
		assertFalse(2 <= escapeTime);
	}
	/**
	 * Method checks if the julia set exceeds the escape distance.
	 */
	@Test
	public void juliaExceedsEscapeDistance(){
		Sets sets = new Sets();
		double x = 1.6933593749999853;
		double y = 0.9765625;
		int escapeTime = sets.juliaSet(x, y);
		assertFalse(2 <= escapeTime);
		}
	/**
	 * Method checks if the julia set stays below the escape distance.
	 */
	@Test
	public void juliaBelowEscapeDistance(){
		Sets sets = new Sets();
		double x = 1.0492187499999897;
				double y = -0.234375;
		int escapeTime = sets.juliaSet(x, y);
		assertEquals(255, escapeTime, 0);
	}
	

}