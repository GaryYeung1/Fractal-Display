package edu.buffalo.cse116;

import edu.buffalo.cse116.*;
/**
 * This class was created to be the model to the GUI of this project. It inherits
 * methods from the sets class so that it's easier to run tests and set an association 
 * relationship without changing the older tests. It also has an update method which updates 
 * the UI.
 * @author Florebencia Fils-Aime
 *
 */
public class Model extends Sets{
	private GUI _gui; 
	
	public Model (GUI gui){
		_gui = gui;
	}
	/**
	 * This updates the GUI.
	 * @author Florebencia Fils-Aime
	 */
	public void update(){
		
	}
}
