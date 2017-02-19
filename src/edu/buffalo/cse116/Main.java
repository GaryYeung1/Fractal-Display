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
  //Please show up//
}

