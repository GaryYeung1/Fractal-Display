package edu.buffalo.cse116;

import java.awt.Point;

public class Sets {
	/**
	 * This is to create the sets.
	 */
	public Sets(){}
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
	/** Set mandelbrot set method and calculates the fractal into a 2D array with 512 rows and columns. 
	 * @author Genessy 
	 * @return
	 */
	public int[][] Mandelbrot_set(){
		double w = (0.6 - (-2.15)) / 512; // sets the range for the x coordinates
		double h = (1.3 - (-1.3)) / 512; // sets the range for the y coordinates
		int[][] grid = new int[512][512];

		for(int i = 0; i < 512 ;i++){
			for(int j = 0; j < 512 ;j++){
				double x = w * j;
				double y = h * i;
				grid[i][j] = this.mandelbrotSet(x,y); // sets the points up
			}
		}

		return grid;
	}
	/**
	 * This is for the Mandelbrot Set.
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 */
	public int mandelbrotSet(double x, double y){
		int escapeTime;
		double xCalc, yCalc;
		xCalc = x;
		yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		while(dist<=2 && passes< 255){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = 2 * xCalc * yCalc + y;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			xCalc = xPrime;
			yCalc = yPrime;
		}
		escapeTime = passes;
		return escapeTime;
	}
	/**
	 * @author Genessy - Julia set method and calculates the fractal into a 2D array with 512 rows and columns. 
	 * @return
	 */
	public int[][] Julia_set()
  	{
  		double w = (1.7 - (-1.7)) / 512; //sets range for x coordinates
		double h = (1.0 - (-1.0)) / 512; //sets range for y coordinates
 		int[][] grid = new int[512][512];

  		for(int i = 0; i < 512 ;i++)
  		{
  			for(int j = 0; j < 512 ;j++)
  			{
  				double x = w * j;
  				double y = h * i;
  				grid[i][j] = this.juliaSet(x, y); //sets the points up
  			}
  		}

  		return grid;
  	}
	/**
	 * This is for the Julia Set.
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 */
	public int juliaSet(double x, double y){
		int escapeTime; 
		double xCalc, yCalc;
		xCalc = x; 
		yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));//must look like the distance formula
		int passes = 0;
		while(dist <= 2 && passes < 255){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) - 0.72689;
			double yPrime = 2 * xCalc * yCalc + 0.188887;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			xCalc = xPrime;
			yCalc = yPrime;
		}
		escapeTime = passes;
		return escapeTime;
	}
	/**
	 * @author Genessy  
	 * Creates Burning Ship set method and calculates the fractal into a 2D array with 512 rows and columns.
	 * @return
	 */
	public int[][] BurningShip_set()
  	{
  		double w = (1.7 - (-1.8)) / 512; // sets the x coordinates 
		double h = (0.025 - (-0.08)) / 512; // sets the y coordinates
 		int[][] grid = new int[512][512];

  		for(int i = 0; i < 512 ;i++)
  		{
  			for(int j = 0; j < 512 ;j++)
  			{
  				double x = w * j;
  				double y = h * i;
  				grid[i][j] = this.burningShipSet(x,y); //sets up the points 
  			}
  		}

  		return grid;
  	}
	/**
	 * This is for the Burning Ship set
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 * @return
	 */
	public int burningShipSet(double x, double y){
		int escapeTime;
		double xCalc = x;
		double yCalc = y;
		double dist = Math.pow(Math.pow(xCalc, 2) + Math.pow(yCalc, 2),1/2);
		int passes = 0;
		
		while(dist <= 2 && passes < 255){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = Math.abs(2 * xCalc * yCalc) + y;
			passes++;
			dist = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			xCalc = xPrime;
			yCalc = yPrime;
		}
		escapeTime = passes;
		return escapeTime;
		}
	/**
	 * This method creates and calculates the fractal for the Multibrot_set
	 * @author Genessy and Yang 
	 * @return
	 */
	public int[][] Multibrot_set()
  	{
  		double w = (1 - (-1)) / 512;
		double h = (1.3 - (-1.3)) / 512;
		int[][] grid = new int[512][512];

  		for(int i = 0; i < 512 ;i++)
  		{
  			for(int j = 0; j < 512 ;j++)
  			{
  				double x = w * j;
  				double y = h * i;
  				grid[i][j] = this.Multibrot(x,y);
  			}
  		}

  		return grid;
  	}
	/**
	 * This creates the Multibrot Set
	 * @author Genessy and Yang
	 * @param x
	 * @param y
	 * @return
	 */
	public int Multibrot(double x, double y) {
		double xCalc = x;
		double yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

		int passes = 0;

		while (dist <= 2 && passes < 255) {
			double xPrime = Math.pow(xCalc, 3) - (3 * x * Math.pow(yCalc, 2))+ x;
			double yPrime = (3 * Math.pow(xCalc, 2) * yCalc) - Math.pow(yCalc, 3) + y;
			passes++;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			xCalc = xPrime;
			yCalc = yPrime;
		}
		//Set the current point's escape-time equal to passes ***********************************
	  	int res = passes;
	  	return res;
	}
	
}
