package edu.buffalo.cse116;

import java.awt.EventQueue;

import edu.buffalo.cse116.*;

public class Main {
	/**
	 * This runs our gui and shows all the things needed in our application.
	 * @author Gary and Yang
	 */ 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}
}




