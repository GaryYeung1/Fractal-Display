package edu.buffalo.cse116;

import java.awt.Point;

public class Main {
/*
	Worked on writing the main method. Didn't create update for xCalc/yCalc, or set current point escape time.
	*/ 
  public static void main(String[] args) {
    // TODO Auto-generated method stub
	 int [][] grid = new int[512][512];


  }
  public Point escapeTimeAlgorithm(Point point){
	  float xCalc = point.x;
	  float yCalc = point.y;
	  double dist = Math.pow(Math.pow(xCalc, 2) + Math.pow(yCalc, 2),1/2);
	  int passes = 0;
	  while(dist <= 2 && passes < 255){
		  passes = passes + 1;
		  dist = Math.pow(Math.pow(xCalc, 2) + Math.pow(yCalc, 2),1/2);
	  }
	  
	  Point retPoint = new Point(0,0);
	  return retPoint;
  }


	
	
	
	
	/**
	 * @author Yang Cai
	 * @param x
	 * @param y
	 * @return
	 */
	public Point original(int x, int y) {
		Point original = new Point(x, y);
		x = 0;
		y = 0;
		return original;

	}

	// public void getX(){
	//
	// }

	public void Coordinate() {
		double[][] Coordinate = new double[512][512];
		// double MandelbrotX;
		// double MandelbrotY;
		// double JuliaX;
		// double JuliaY;
		// double BurningShipX;
		// double BurningShipY;
		// double MultibrotX;
		// double MultibrotY;
		// MandelbrotX = (0.6 - (-2.15))/512;
		// MandelbrotY = (1.3-(-1.3))/512;
		// JuliaX = (1.7-(-1.7))/512;
		// JuliaY = (1.0-(-1.0))/512;
		// BurningShipX = (-1.7-(-1.8))/512;
		// BurningShipY = (0.025-(-0.08))/512;
		// MultibrotX = (1.0-(-1.0))/512;
		// MultibrotY = (1.3-(-1.3))/512;
	}

	/**
	 * @param x
	 * @param y
	 */
	public void Mandelbrot(int x, int y) {
		double xCalc;
		double yCalc;
		xCalc = (0.6 - (-2.15)) / 512;
		yCalc = (1.3 - (-1.3)) / 512;
		// Point ori = original(0, 0);

		double xPrime;
		double yPrime;
		double dist = 0;
		int passes = 0;

		while (dist <= 2 && passes < 255) {
			// xPrime = x * x - y * y + ori.getX();
			xPrime = x * x - y * y + xCalc;
			// yPrime = 2 * x * y + ori.getY();
			yPrime = 2 * x * y + yCalc;
			passes++;
			dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		}
	}

	/**
	 * @param x
	 * @param y
	 */
	public void Julia(int x, int y) {
		double xCalc;
		double yCalc;
		xCalc = (1.7 - (-1.7)) / 512;
		yCalc = (1.0 - (-1.0)) / 512;
		// Point ori = original(0, 0);
		// double xCalc;
		// double yCalc;
		double xPrime;
		double yPrime;
		double dist = 0;
		int passes = 0;

		while (dist <= 2 && passes < 255) {
			xPrime = x * x - y * y - 0.72689;
			yPrime = 2 * x * y + 0.188887;
			passes++;
			dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		}
	}

	/**
	 * @param x
	 * @param y
	 */
	public void BurningShip(int x, int y) {
		double xCalc;
		double yCalc;
		xCalc = (-1.7 - (-1.8)) / 512;
		yCalc = (0.025 - (-0.08)) / 512;
		// Point ori = original(0, 0);
		// double xCalc;
		// double yCalc;
		double xPrime;
		double yPrime;
		double dist = 0;
		int passes = 0;

		while (dist <= 2 && passes < 255) {
			// xPrime = x * x - y * y + ori.getX();
			// yPrime = Math.abs(2 * x * y) + ori.getY();
			xPrime = x * x - y * y + xCalc;
			yPrime = Math.abs(2 * x * y) + yCalc;
			passes++;
			dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		}
	}
	
	/**
	 * @param x
	 * @param y
	 */
	public void Multibrot(int x, int y) {
		double xCalc;
		double yCalc;
		xCalc = (0.6 - (-2.15)) / 512;
		yCalc = (1.3 - (-1.3)) / 512;
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




