package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractalTest2 {
	/**
	 * @author Genessy and Florebencia
	 */
	public FractalTest2(){
		
	}
	/**
	 * @author Genessy and Florebencia
	 */
	@Test
	public void mandelbrotExceedsDist(){
			int escapeTime;
			double xCalc, yCalc;
			double x = 0.46007827788650374;
			double y = -0.3383561643835661;
			xCalc = x;
			yCalc = y;
			double dist = 3;
			int passes = 0;
			while(dist>=0 && passes< 255){
				double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
				double yPrime = 2 * xCalc * yCalc + y;
				xCalc = xPrime;
				yCalc = yPrime;
				passes += 1; 
				dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2)); 
			}
			escapeTime = passes;
			assertEquals(10, escapeTime);
	}
	/**
	 * @author Genessy and Florebencia
	 */
	@Test 
	public void juliaExceedsDist(){
		int escapeTime; 
		double xCalc, yCalc;
		double x = 1.4538160469667272;
		double y = -0.13502935420743645;
		xCalc = x; 
		yCalc = y;
		double dist = 3;
		int passes = 0;
		while(dist >= 0 && passes < 255){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) - 0.72689;
			double yPrime = 2 * xCalc * yCalc + 0.188887;
			passes++;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
			xCalc = xPrime;
			yCalc = yPrime;
		}
		escapeTime = passes;
		assertEquals(10, escapeTime);
	}
	/**
	 * @author Genessy and Florebencia
	 */
	@Test
	public void burningShipExceedsDist(){
		int escapeTime;
		double x = -1.6999999999999802;
		double y = 0.0030136986301371603;
		double xCalc = x;
		double yCalc = y;
		double dist = 3;
		int passes = 0;
		
		while(dist >= 0 && passes < 255){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = Math.abs(2 * xCalc * yCalc) + y;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			xCalc = xPrime;
			yCalc = yPrime;
		}
		escapeTime = passes;
		assertEquals(10, escapeTime);
	}
	/**
	 * @author Genessy and Florebencia
	 */
	@Test
	public void multibrotExceedsDist(){
		double x = 0.7025440313111545;
		double y = -0.5520547945205528;
		double xCalc = x;
		double yCalc = y;
		double dist =3;

		int passes = 0;

		while (dist >= 0 && passes < 255) {
			double xPrime = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2))+ x;
			double yPrime = (3 * Math.pow(xCalc, 2) * yCalc) - Math.pow(yCalc, 3) + y;
			passes++;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			xCalc = xPrime;
			yCalc = yPrime;
		}
		int res = passes;
		assertEquals(10, res);
	}
}
