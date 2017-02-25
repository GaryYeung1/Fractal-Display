package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import edu.buffalo.cse116.*;

public class ActualFractalTests {
	public ActualFractalTests(){}
	/**
	 * this sets the point system up for the coordinates.
	 * @param x
	 * @param y
	 * @author Yang Cai and Florebencia Fils-Aime 
	 */
	public Point original(int x, int y){
		Point original = new Point(x,y);
		return original;
	}
	/**
	 * This is for the Mandelbrot Set.
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 */
	@Test
	public void mandelbrotSetTranslationTest(){
		Sets set = new Sets();
		double w = (0.6 - (-2.15)) / 512;
		double h = (1.3 - (-1.3)) / 512; 
		int[][] grid = new int[512][512];

		for(int i = 0; i < 512 ;i++){
			for(int j = 0; j < 512 ;j++){
				double x = w * j;
				double y = h * i;
				grid[i][j] = set.mandelbrotSet(x,y); 
			}
		}
		assertTrue(grid == set.Mandelbrot_set());
	}
	@Test
	public void mandelbrotTest(){
		Point ori = original(0,0);
		float escapeTime;
		int xCalc = ori.x;
		int yCalc = ori.y;
		double dist = Math.pow(Math.pow(xCalc, 2) + Math.pow(yCalc, 2),1/2);
		int passes = 0;
		int x = xCalc;
		int y = yCalc;
		while(dist<=2 && passes< 255){
			int xPrime = x * x - y * y + ori.x;
			int yPrime = 2 * x * y + ori.y;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			x = xPrime;
			y = yPrime;
		}
		escapeTime = passes;
//		sets the x boundaries.
		Sets sets = new Sets();
		sets.mandelbrotSet(-1, 1);
		assertTrue(-2.15<x);
		assertTrue(x < 0.6);
		//sets the y boundaries.
		assertTrue(-1.3 <y);
		assertTrue(y < 1.3);
	}
	/**
	 * This is for the Julia Set.
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void juliaSetTranslationTest(){
		Sets set = new Sets();
		double w = (1.7 - (-1.7)) / 512; 
		double h = (1.0 - (-1.0)) / 512; 
 		int[][] grid = new int[512][512];

  		for(int i = 0; i < 512 ;i++)
  		{
  			for(int j = 0; j < 512 ;j++)
  			{
  				double x = w * j;
  				double y = h * i;
  				grid[i][j] = set.juliaSet(x, y); 
  			}
  		}
  		assertTrue(grid==set.Julia_set());
	}
	@Test
	public void juliaTest(){
		Point ori = original(0,0);
		float escapeTime;
		int xCalc = ori.x;
		int yCalc = ori.y;
		double dist = Math.pow(Math.pow(xCalc, 2) + Math.pow(yCalc, 2),1/2);
		int passes = 0;
		double x = xCalc;
		double y = yCalc;
		while(dist <= 2 && passes < 255){
			double xPrime = x * x - y * y - 0.72689;
			double yPrime = 2 * x * y + 0.188887;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			x = xPrime;
			y = yPrime;
		}
		escapeTime = passes;
		//sets the boundary for the x value
		assertTrue(-1.7<x);
		assertTrue(x < 1.7);
		//sets the boundary for the y value
		assertTrue(-1.0 <y);
		assertTrue(y< 1.0);
	}
	/**
	 * This is for the Burning Ship Set.
	 * @author Gary Yeung, Yang Cai, Florebencia Fils-Aime
	 */
	@Test
	public void burningShipSetTranslationTest(){
		Sets set = new Sets();
		double w = (1.7 - (-1.8)) / 512;  
		double h = (0.025 - (-0.08)) / 512; 
 		int[][] grid = new int[512][512];

  		for(int i = 0; i < 512 ;i++)
  		{
  			for(int j = 0; j < 512 ;j++)
  			{
  				double x = w * j;
  				double y = h * i;
  				grid[i][j] = set.burningShipSet(x,y);  
  			}
  		}
  		assertTrue(grid == set.BurningShip_set());
	}
	@Test
	public void burningShipTest(){
		Point ori = original(0,0);
		float escapeTime;
		int xCalc = ori.x;
		int yCalc = ori.y;
		double dist = Math.pow(Math.pow(xCalc, 2) + Math.pow(yCalc, 2),1/2);
		int passes = 0;
		double x = xCalc;
		double y = yCalc;
		while(dist <= 2 && passes < 255){
			double xPrime = x * x - y * y + ori.x;
			double yPrime = Math.abs(2 * x * y) + ori.y;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			x = xPrime;
			y = yPrime;
		}
		escapeTime = passes;
		//sets the boundary for the x value
		assertTrue(-1.8<x);
		assertTrue(x < -1.7);
		//sets the boundary for the y value
		assertTrue(-0.08 <y);
		assertTrue(y < 0.025);
	}
	/**
	 * This tests if the escape time is greater than one
	 * @author Genessy and Florebencia
	 */
	public void burningShipTest2(){
		Sets sets = new Sets();
		int escapeTime = sets.burningShipSet(-1.75, 0);
		assertTrue(escapeTime < 1);
	}
	/**
	 * 
	 */
	@Test
	public void fractalReturn(){
		Sets sets = new Sets();
		int[][] grid = new int[512][512];
//		assertEquals(grid,sets.Mandelbrot_set(), 0.0);
		assertTrue(grid==sets.BurningShip_set());
		assertTrue(grid==sets.Julia_set());
		assertTrue(grid==sets.Multibrot_set());
	}
	/**
	 * This method checks if the mandelbrot set will exceed the escape distance. If it does it exceed the
	 * distance then the escape time should be 1.
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void multibrotSetTranslationTest(){
		Sets set = new Sets();
		double w = (1 - (-1)) / 512;
		double h = (1.3 - (-1.3)) / 512;
		int[][] grid = new int[512][512];

  		for(int i = 0; i < 512 ;i++)
  		{
  			for(int j = 0; j < 512 ;j++)
  			{
  				double x = w * j;
  				double y = h * i;
  				grid[i][j] = set.Multibrot(x,y);
  			}
  		}
  		assertTrue(grid[1][1] == set.Multibrot(0.00390625,0.005078125));
	}
	@Test
	public void mandelbrotExceedsEscapeDistance(){
		Sets sets = new Sets();
		double x = 0.5946289062500001;
		double y = 1.2949218750000122;
		int escapeTime = sets.mandelbrotSet(x, y);
		assertEquals(1, escapeTime, 0.0);
	}
	/**
	 * This method checks if the mandelbrot set will never exceed the escape distance. If it doesn't the sets
	 * class method should stop the loop at 254 times and the escape time should be 254.
	 * @author Florebencia Fils-Aime 
	 */
	@Test
	public void mandelbrotUnderEscapeDistance(){
		Sets sets = new Sets();
		double x = 0.3207031250000001;
		double y = -0.07109374999999386;
		int escapeTime = sets.mandelbrotSet(x, y);
		assertEquals(1, escapeTime, 0.0);
	}
	/** Method checks if the burning ship set stays below the escape distance. 
	 +	 * @author genessy 
	 +	 */
	 @Test
	 			
	 public void burningShipBelowEscapeDistance(){
	 	Sets sets = new Sets();
	 	//int escapeTime = sets.burningShipSet(x, y);
	 	double x = 1.0492187499999897;
	 	double y = -0.234375;
	 	int escapeTime = sets.burningShipSet(x, y);
	 	assertEquals(255, escapeTime, 0);
	 				
	 			}
	public void multibrotTest(int x, int y) {
		double xCalc;
		double yCalc;
		xCalc = (0.6 - (-2.15)) / 512;
		yCalc = (1.3 - (-1.3)) / 512;
		double[][] grid = new double[512][512];
		for(int i = 0; i < grid.length; i++){
			for(int k =0; k < grid[i].length;i++){
				grid[i][k] = -2.15 + i*(xCalc) -1.3+(k*yCalc);
			}
		}
		// Point ori = original(0, 0);

		double xPrime;
		double yPrime;
		double dist = 0;
		int passes = 0;

		while (dist <= 2 && passes < 255) {
			xPrime = Math.pow(x, 3) - (3 * x * Math.pow(y, 2))+ xCalc;
			yPrime = (3 * Math.pow(x, 2) * y) - Math.pow(y, 3) + yCalc;
			passes++;
			dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		}
	}
}

