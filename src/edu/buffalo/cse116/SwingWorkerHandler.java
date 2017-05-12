package edu.buffalo.cse116;

import javax.swing.SwingWorker;
import edu.buffalo.cse116.*;
import edu.buffalo.fractal.WorkerResult;

public class SwingWorkerHandler extends SwingWorker<WorkerResult,Void> {
	private int[][] _grid;
	private int _escapeTime; 
	private int _workers; 
	private String fractal = "";
	private int rowToStart = 0;
	private int rowsToCreate = 0;
	private int[][] workGrid;
	/**
	 * This creates the swing workers needed to draw the fractal
	 * @param i is the int needed to tell the workers where to start
	 * @param j is the number of rows each worker wil do based on the userinput of the 
	 * num of workers they want assigned
	 * @param grid this passes through the values of the set we are working with
	 * @param escapeTime is the escapeTime given to do the set
	 * @param workers is the number of workers given by the user
	 * @author Gary and Florebencia 
	 */
	public SwingWorkerHandler(int i, int j, int[][] grid, int escapeTime,int workers){
		_grid= grid;
		_escapeTime = escapeTime;
		rowToStart = i;
		rowsToCreate = j;
		_workers= workers;
		int rows = 2048/_workers;
		workGrid = new int[rows][2048];
	}
	//calculates in parallelism
	//Calculating results should be split as equally as possible along the rows of the 
	//fractal. Each SwingWorker instance will need to calculate the escape times for all 
	//of the pixels in the range of rows it is assigned. 
	@Override
	protected WorkerResult doInBackground() throws Exception {
		// TODO Auto-generated method stub
		int rows = 2048/_workers;
		int[][] workGrid = new int[rows][2048];
		for(int i = 0; i<rows;i++){
			for(int j = 0; j<2048; j++){
			workGrid[i][j]= _grid[rowToStart+i][j];
			System.out.println("Hello, I am doing "+ (rowToStart + i) +"th row");}
		}

		WorkerResult workerRes = new WorkerResult(rowToStart, workGrid);
		
		return workerRes;
	}

}
