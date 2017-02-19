package tests;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

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
		assertTrue(-2.15<x);
		assertTrue(x < 0.6);	
		}
	
}

