package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

/**
 * This class's purpose is to test the methods of the fractal class that will be made eventually.
 * @author Florebencia Fils-Aime
 */
public class FractalTest {
	
	public FractalTest(){
	}
	/**
	 * this sets the point system up for the coordinates.
	 * @param x
	 * @param y
	 * @author Florebencia Fils-Aime
	 */
	public Point original(int x, int y){
		Point original = new Point(x,y);
		return original;
	}
	/**
	 * this is made to test the range of the mandelbrot set
	 * @param x
	 * @param y
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void mandelbrotTest(double x, double y){
		double xprime, yprime;
		Point start = original(1,1);
		xprime = Math.pow(x,2) - Math.pow(y,2) + start.x;
		yprime = 2 * x * y + start.y;
		//sets the boundary for the x value
		assertTrue(-2.15<xprime);
		assertTrue(xprime < 0.6);
		//sets the boundary for the y value
		assertTrue(-1.3 <yprime);
		assertTrue(yprime < 1.3);
	}
	/**
	 * This method is used to check the range of the coordinates for the Julia Set.
	 * @param x
	 * @param y
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void juliaTest(double x, double y){
		double xprime, yprime;
		xprime = Math.pow(x, 2) - Math.pow(y, 2) + -0.72689;
		yprime = 2 * x * y + 0.188887;
		assertTrue(-1.7<xprime);
		assertTrue(xprime < 1.7);
		//sets the boundary for the y value
		assertTrue(-1.0 <yprime);
		assertTrue(yprime < 1.0);
	}
	/**
	 * This method is used to check the range of the coordinates for the Burning Ship Set.
	 * @param x
	 * @param y
	 * @author Florebencia Fils-Aime
	 */
	@Test
	public void burningShipSet(double x, double y){
		double xprime, yprime;
		Point start = original(1,1);
		xprime = Math.pow(x, 2) - Math.pow(y, 2) + start.x;
		yprime = Math.abs(2 * x * y) + start.y;
		assertTrue(-1.8<xprime);
		assertTrue(xprime < -1.7);
		//sets the boundary for the y value
		assertTrue(-0.08 <yprime);
		assertTrue(yprime < 0.025);
	}
//	@Test
//	public void checkIfPointIsNull(){
//		
//	}

}