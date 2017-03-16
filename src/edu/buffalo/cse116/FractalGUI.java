package edu.buffalo.cse116;

import java.awt.*;

import javax.swing.*;

public class FractalGUI {
	/**
	This class is used to create the program that will show the fractal.
	@author Gary Yeung 
	**/
	JPanel _panel = new JPanel();
	JFrame _frame = new JFrame("Fractal Creator");
	JButton _button = new JButton();
	MenuBar _menuBar = new MenuBar();
	Sets _set = new Sets();
	
	public FractalGUI(){
		
		
	}
	/** Runs the actual program.
	 * 
	 */
	public void run(){
		Menu file = new Menu("file");
		Menu fractal = new Menu("fractal");
		Menu color = new Menu("color"); //Choose color pallets, and place within color menu.
		
		_menuBar.add(file);
		_menuBar.add(fractal);
		_menuBar.add(color);
		
		MenuItem closeProgram = new MenuItem("Close Program");
		
		MenuItem mandelbrot = new MenuItem("Menubrot Set");
		MenuItem julia = new MenuItem("Julia Set");
		MenuItem burningShip = new MenuItem("BurningShip Set");
		MenuItem multibrot = new MenuItem("Multibrot");
		
		file.add(closeProgram);
		fractal.add(mandelbrot);
		fractal.add(julia);
		fractal.add(burningShip);
		fractal.add(multibrot);
		
		_frame.setSize(500,500);
		_frame.setLayout(new GridBagLayout());
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.add(_panel);
		
		_panel.setSize(400,400);
		
		
	}
}
