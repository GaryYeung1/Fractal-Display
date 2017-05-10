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
	
	public SwingWorkerHandler(int i, int j, int[][] grid, int escapeTime){
		_grid= grid;
		_escapeTime = escapeTime;
		rowToStart = i;
		rowsToCreate = j;
	}
	//calculates in parallelism
	//Calculating results should be split as equally as possible along the rows of the 
	//fractal. Each SwingWorker instance will need to calculate the escape times for all 
	//of the pixels in the range of rows it is assigned. 
	@Override
	protected WorkerResult doInBackground() throws Exception {
		// TODO Auto-generated method stub

		
		return null;
	}

}
