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
}package edu.buffalo.cse116;

import java.awt.Point;
import java.awt.geom.*;

/**
 * 
 * @author yang
 *
 */

public class Main {


  public static void main(String[] args) {
		}
  
  
  public Point original (int x, int y){
	  Point original = new Point(x, y);
	  x = 0;
	  y = 0;
	return original;
	
  }
  
//  public void getX(){
//	  
//  }
  
  public void Mandelbrot(float x, float y){
	  	Point ori = original(0, 0);
//		double xCalc;
//		double yCalc;
		double xPrime;
		double yPrime;
		double dist = 0;
		int passes = 0;
		
		
		while(dist <= 2 && passes < 255){
			xPrime = x * x - y * y + ori.getX();
			yPrime = 2 * x * y + ori.getY();
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
		}
  }

  public void Julia(float x, float y){
	  	Point ori = original(0, 0);
//		double xCalc;
//		double yCalc;
		double xPrime;
		double yPrime;
		double dist = 0;
		int passes = 0;
		
		while(dist <= 2 && passes < 255){
			xPrime = x * x - y * y - 0.72689;
			yPrime = 2 * x * y + 0.188887;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
		}
}
  
  public void BurningShip(float x, float y){
	  	Point ori = original(0, 0);
//		double xCalc;
//		double yCalc;
		double xPrime;
		double yPrime;
		double dist = 0;
		int passes = 0;
		
		while(dist <= 2 && passes < 255){
			xPrime = x * x - y * y + ori.getX();
			yPrime = Math.abs(2 * x * y) + ori.getY();
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
		}
}

}



