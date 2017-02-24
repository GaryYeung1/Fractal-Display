package tests;

import static org.junit.Assert.assertTrue;

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

