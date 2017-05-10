package edu.buffalo.cse116;

import javax.swing.SwingWorker;

import edu.buffalo.fractal.WorkerResult;

public class SwingWorkerHandler extends SwingWorker<WorkerResult,Void> {
	String fractal = "";
	int rowToStart = 0;
	int rowsToCreate = 0;
	
	public SwingWorkerHandler(int i, int j){
		
		rowToStart = i;
		rowsToCreate = j;
	}

	@Override
	protected WorkerResult doInBackground() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
