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
			for(int j = 0; j<2048; i++){
			workGrid[i][j]= _grid[rowToStart+i][j];}
		}

		WorkerResult workerRes = new WorkerResult(rowToStart, workGrid);
		
		return null;
	}

}