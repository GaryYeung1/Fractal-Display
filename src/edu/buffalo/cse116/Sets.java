package edu.buffalo.cse116;

import java.awt.Point;
import java.util.Scanner;

import edu.buffalo.cse116.*;

public class Sets {
	/**
	 * This is to create the sets. It is also the model class for our GUI.
	 */
	private GUI _gui; 
	private OurScanner scan;
	private int num;
	private MouseDragHandler _mouse;
	public Sets(GUI gui){
		_gui = gui;
		scan = new OurScanner();
		_mouse = new MouseDragHandler();
//		num = scan.getEscapeDistance();
	}

	/**
	 * This is for the Mandelbrot Set.
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 * @return passes (since it's the escapeTime)
	 */
	//run a second loop for to get the new escapeTime
	public int mandelbrotSet(double x, double y){
		int escapeDistance = _gui.getEscapeDistance();
		int escapeTime = _gui.getEscapeTime();
		double xCalc, yCalc;
		xCalc = x;
		yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		int passes2 = 0;
		while(escapeDistance> dist && passes< escapeTime){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = 2 * xCalc * yCalc + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1; 
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2)); 
		}
			/*while(escapeDistance> dist && passes2< passes){
				double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
				double yPrime = 2 * xCalc * yCalc + y;
				xCalc = xPrime;
				yCalc = yPrime;
				passes2 += 1; 
				dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2)); 
			}
			return passes2;
			*/
		return passes;
		 
	}
	/**
	 * This is for the Julia Set.
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 * @return passes since it's the escape distance
	 */
	public int juliaSet(double x, double y){
		int escapeDistance = _gui.getEscapeDistance();
		int escapeTime = _gui.getEscapeTime();
		double xCalc, yCalc;
		xCalc = x; 
		yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));//must look like the distance formula
		int passes = 0;
		int passes2 = 0;
		while(escapeDistance > dist && passes < escapeTime){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) - 0.72689;
			double yPrime = 2 * xCalc * yCalc + 0.188887;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		
		}
		/*while(escapeDistance > dist && passes2 < passes){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) - 0.72689;
			double yPrime = 2 * xCalc * yCalc + 0.188887;
			xCalc = xPrime;
			yCalc = yPrime;
			passes2 += 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		}
		return passes2;
		*/
		return passes;
	}
	/**
	 * This is for the Burning Ship set
	 * @author Gary Yeung, Yang Cai, Genessy Munoz, Florebencia Fils-Aime
	 * @param x
	 * @param y
	 * @return
	 */
	public int burningShipSet(double x, double y){
		int escapeDistance = _gui.getEscapeDistance();
		int escapeTime = _gui.getEscapeTime();
		double xCalc = x;
		double yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		int passes2 = 0;
		while(escapeDistance > dist && passes < escapeTime){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = Math.abs(2 * xCalc * yCalc) + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		}
		/*
		while(escapeDistance > dist && passes2 < passes){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = Math.abs(2 * xCalc * yCalc) + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes2 += 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		}
		return passes2;
		*/
		return passes;
		}
	/**
	 * This creates the Multibrot Set
	 * @author Genessy and Yang
	 * @param x
	 * @param y
	 * @return passes since it's the escape distance
	 */
	public int Multibrot(double x, double y) {
		int escapeDistance = _gui.getEscapeDistance();
		int escapeTime = _gui.getEscapeTime();
		double xCalc = x;
		double yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		int passes2= 0;
		while (escapeDistance> dist && passes < escapeTime) {
			double xPrime = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2))+ x;
			double yPrime = (3 * Math.pow(xCalc,2) * yCalc) - Math.pow(yCalc, 3) + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		}
		/*while (escapeDistance> dist && passes2 < passes) {
			double xPrime = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2))+ x;
			double yPrime = (3 * Math.pow(xCalc,2) * yCalc) - Math.pow(yCalc, 3) + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes2 += 1;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		}
		//Set the current point's escape-time equal to passes 
	  	return passes2;
	  	*/
		return passes;
	}

	/** Set mandelbrot set method and calculates the fractal into a 2D array with 
	 * 512 rows and columns. 
	 * @author Genessy 
	 * @return grid
	 */
	public int[][] Mandelbrot_set(){
		double w = _mouse.width();
		double h = _mouse.height();
		int reset = _gui.reset();
		if(w == 0 && h == 0){
		w = (0.6 - (-2.15)) / 512; // sets the range for the x coordinates
		h = (1.3 - (-1.3)) / 512; // sets the range for the y coordinates
		}
		if(reset > 0){
			w = (0.6 - (-2.15)) / 512; // sets the range for the x coordinates
			h = (1.3 - (-1.3)) / 512; // sets the range for the y coordinates
			reset -= 1;
		}
		int[][] grid = new int[512][512];
		for(int i = 0; i < 512 ;i++){
			for(int j = 0; j < 512 ;j++){
				double x = -2.15 + (i*w);
				double y = -1.3 + (j*h);
				grid[i][j] = this.mandelbrotSet(x,y); // sets the points up
			}
		}
		return grid;
	}
	/**
	 *  Julia set method and calculates the fractal into a 2D array with 512 rows and 
	 *  columns.
	 * @author Genessy  
	 * @return
	 */
	public int[][] Julia_set(){
		double w = _mouse.width();
		double h = _mouse.height();
		int reset = _gui.reset();
		if(w == 0 && h == 0){
  		w = (1.7 - (-1.7)) / 512; //sets range for x coordinates
		h = (1.0 - (-1.0)) / 512; //sets range for y coordinates
		}
		if( reset > 0){
	  		w = (1.7 - (-1.7)) / 512; //sets range for x coordinates
			h = (1.0 - (-1.0)) / 512; //sets range for y coordinates
			reset -=1;
		}
 		int[][] grid = new int[512][512];
  		for(int i = 0; i < 512 ;i++){
  			for(int j = 0; j < 512 ;j++){
  				double x = -1.7 + (w * i);
  				double y = -1.0 + (h * j);
  				grid[i][j] = this.juliaSet(x, y); //sets the points up
  			}
  		}
  		return grid;
  	}
	/**
	 * @author Genessy  
	 * Creates Burning Ship set method and calculates the fractal into a 2D array with 512 rows and columns.
	 * @return
	 */
	public int[][] BurningShip_set(){
		double w = _mouse.width();
		double h = _mouse.height();
		int reset = _gui.reset();
		if(w == 0 && h == 0){
  		w = (-1.7 - (-1.8)) / 512; // sets the x coordinates 
		h = (0.025 - (-0.08)) / 512; // sets the y coordinates
		}
		if(reset > 0){
	  		w = (-1.7 - (-1.8)) / 512; // sets the x coordinates 
			h = (0.025 - (-0.08)) / 512; // sets the y coordinates
			reset -=1;
		}
 		int[][] grid = new int[512][512];
  		for(int i = 0; i < 512 ;i++){
  			for(int j = 0; j < 512 ;j++){
  				double x = -1.8 + (w * i);
  				double y = -0.08 + (h * j);
  				grid[i][j] = this.burningShipSet(x,y); //sets up the points 
  			}
  		}
  		return grid;
  	}
	
	/**
	 * This method creates and calculates the fractal for the Multibrot_set
	 * @author Genessy and Yang 
	 * @return
	 */
	public int[][] Multibrot_set(){
		double w = _mouse.width();
		double h = _mouse.height();
		int reset = _gui.reset();
		if (w == 0 && h == 0){
  		w = (1 - (-1)) / 512.0;
		h = (1.3 - (-1.3)) / 512;
		}
		if(reset > 0){
	  		w = (1 - (-1)) / 512.0;
			h = (1.3 - (-1.3)) / 512;			
		}
		int[][] grid = new int[512][512];
  		for(int i = 0; i < 512 ;i++){
  			for(int j = 0; j < 512 ;j++){
  				double x = -1 + (w * i);
  				double y = -1.3 + (h * j);
  				grid[i][j] = this.Multibrot(x,y);
  			}
  		}
  		return grid;
  	}	
	/**
	 * This method will be used to change the escapeTime so that the fractal looks different
	 * with each user input 
	 * @author Florebencia Fils-Aime
	 * @return an integer that equals the new escape time
	 */
	public int getNewEscapeTime(double x, double y){
		int escapeDistance = _gui.getEscapeDistance();
		int escapeTime;
		double xCalc, yCalc;
		xCalc = x;
		yCalc = y;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		while(escapeDistance> dist && passes< 255){
			double xPrime = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + x;
			double yPrime = 2 * xCalc * yCalc + y;
			xCalc = xPrime;
			yCalc = yPrime;
			passes += 1; 
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2)); 
		}
		escapeTime = passes;
		return escapeTime;
		
	}

}


