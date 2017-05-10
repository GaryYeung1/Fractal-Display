package edu.buffalo.cse116;

import javax.swing.SwingWorker;
import edu.buffalo.cse116.*;
import edu.buffalo.fractal.WorkerResult;

public class SwingWorkerHandler extends SwingWorker<WorkerResult,Void> {
	private int[][] _grid;
	private int _escapeTime; 
	private int _workers; 
	public SwingWorkerHandler(int[][] grid, int escapeTime, int workers){
		_grid= grid;
		_escapeTime = escapeTime;
		_workers = workers;
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
