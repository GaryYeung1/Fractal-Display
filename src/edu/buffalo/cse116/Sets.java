package edu.buffalo.cse116;

import java.awt.Point;
import java.util.Scanner;

import javax.swing.SwingWorker;

import edu.buffalo.cse116.*;

public class Sets extends SwingWorker{
	/**
	 * This is to create the sets. It is also the model class for our GUI.
	 */
	private GUI _gui; 
	private int num;
	private MouseDragHandler _mouse;
	public Sets(GUI gui){
		_gui = gui;
		_mouse = new MouseDragHandler();
	}

	/**
	 * This is for the Mandelbrot Set,  and uses user input for the escape 
	 * distance/ escape time.
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 * @return passes (since it's the escapeTime)
	 */
	public int mandelbrotSet(double x, double y, int escDis, int escTime){
		double xCalc, yCalc;
		xCalc = x;
		yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		while(escDis>dist && passes< escTime){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = 2 * xCalc * yCalc + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1; 
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2)); 
		}
		return passes;
	}
	/**
	 * This is for the Julia Set,  and uses user input for the escape distance/ escape time.
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 * @return passes since it's the escape distance
	 */
	public int juliaSet(double x, double y, int escDist, int escTime){
		double xCalc, yCalc;
		xCalc = x; 
		yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));//must look like the distance formula
		int passes = 0;
		while(escDist > dist && passes < escTime){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) - 0.72689;
			double yPrime = 2 * xCalc * yCalc + 0.188887;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		}
		return passes;
	}
	/**
	 * This is for the Burning Ship set, and uses user input for the escape distance/ escape time.
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 * @return
	 */
	public int burningShipSet(double x, double y, int escDist, int escTime){
//		int escapeDistance = _gui.getEscapeDistance();
//		int escapeTime = _gui.getEscapeTime();
		double xCalc = x;
		double yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		int passes2 = 0;
		while(escDist > dist && passes < escTime){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = Math.abs(2 * xCalc * yCalc) + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		}
		return passes;
		}
	/**
	 * This creates the Multibrot Set, and uses user input for the escape distance/ escape time.
	 * @author Genessy and Yang and Garyyeun
	 * @param x
	 * @param y
	 * @return passes since it's the escape distance
	 */
	public int Multibrot(double x, double y, int escDist, int escTime) {

		double xCalc = x;
		double yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		while (escDist> dist && passes < escTime) {
			double xPrime = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2))+ x;
			double yPrime = (3 * Math.pow(xCalc,2) * yCalc) - Math.pow(yCalc, 3) + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		}

		return passes;
	}

	/** Set mandelbrot set method and calculates the fractal into a 2D array with 
	 * 512 rows and columns. Uses user input for the coordinate range.
	 * @author Genessy and Garyyeun
	 * @return grid
	 */
	public int[][] Mandelbrot_set(double x, double y, double x2, double y2, int escDist, int escTime){
			double w = Math.abs(x2 - x) / 2048.0; // sets the range for the x coordinates
			double h = Math.abs(y2 - y) / 2048.0; // sets the range for the y coordinates
			System.out.println("x factor is " +w+ " y factor is " +h);
			int[][] grid = new int[2048][2048];
			for(int i = 0; i < 2048 ;i++){
				for(int j = 0; j < 2048 ;j++){
					double newX = x + (i*w);
					double newY = y + (j*h);
					grid[i][j] = this.mandelbrotSet(newX,newY,escDist,escTime); // sets the points up
					}
				}
			return grid;
			}
//	}
	/**
	 *  Julia set method and calculates the fractal into a 2D array with 512 rows and 
	 *  columns. Uses user input for the coordinate range.
	 * @author Genessy  and Garyyeun
	 * @return
	 */
	public int[][] Julia_set(double x, double y, double x2, double y2,int escDist, int escTime){

		double w = Math.abs(x2 - x) / 2048.0; // sets the range for the x coordinates
		double h = Math.abs(y2 - y) / 2048.0; // sets the range for the y coordinates
		int[][] grid = new int[2048][2048];
		for(int i = 0; i < 2048 ;i++){
			for(int j = 0; j < 2048 ;j++){
				double newX = x + (i*w);
				double newY = y + (j*h);
	  				grid[i][j] = this.juliaSet(newX, newY, escDist, escTime); //sets the points up
	  			}
	  		}
	  		return grid;
			}

	/**
	 * @author Genessy and Garyyeun
	 * Creates Burning Ship set method and calculates the fractal into a 2D array with 512 rows and columns. Uses user input for the coordinate range.
	 * @return
	 */
	public int[][] BurningShip_set(double x, double y, double x2, double y2, int escDist, int escTime){
		double w = Math.abs(x2 - x) / 2048.0; // sets the range for the x coordinates
		double h = Math.abs(y2 - y) / 2048.0; // sets the range for the y coordinates
		int[][] grid = new int[2048][2048];
		for(int i = 0; i < 2048 ;i++){
			for(int j = 0; j < 2048 ;j++){
				double newX = x + (i*w);
				double newY = y + (j*h);
	  				grid[i][j] = this.burningShipSet(newX,newY, escDist, escTime); //sets up the points 
	  			}
	  		}
	  		return grid;

  	}
	
	/**
	 * This method creates and calculates the fractal for the Multibrot_set. Uses user input for the coordinate range.
	 * @author Genessy and Yang and Garyyeun
	 * @return
	 */
	public int[][] Multibrot_set(double x, double y, double x2, double y2, int escDist, int escTime){
		double w = Math.abs(x2 - x) / 2048.0; // sets the range for the x coordinates
		double h = Math.abs(y2 - y) / 2048.0; // sets the range for the y coordinates
		int[][] grid = new int[2048][2048];
		for(int i = 0; i < 2048 ;i++){
			for(int j = 0; j < 2048 ;j++){
				double newX = x + (i*w);
				double newY = y + (j*h);
	  				grid[i][j] = this.Multibrot(newX,newY,escDist, escTime);
	  			}
	  		}
	  		return grid;

  	}	

	@Override
	protected Object doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
