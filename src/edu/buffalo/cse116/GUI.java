package edu.buffalo.cse116;

import javax.swing.*;

import edu.buffalo.fractal.FractalPanel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.IndexColorModel;
import java.util.*;
/**
 * This class creates the GUI that will run the program.
 * @author Yang Cai, Gary Yeung, Genessy Munoz
 */
public class GUI extends JFrame {

	private JMenu jMenu1,jMenu2,jMenu3,jMenu4;
	private JMenuBar jMenuBar1;
	
	private JMenuItem jMenuItem1,jMenuItem2,jMenuItem3,jMenuItem4, jMenuItem5;
	private JMenuItem jMenuItem6,jMenuItem7,jMenuItem8;
	private JMenuItem jMenuItem9;
	public JLabel	escapeDistanceRequest;
	public JTextField escapeDistance;
	public JButton enterEscapeDistance;
	private FractalPanel jPanel1; // FractalPanel is the jpanel 
	
	private Sets set;
	
	private final int numberOfColors = 50;
	private IndexColorModel colorModel;
	private int[][] escapeSteps;
	
/**
 * This gives the basis of the ui. It has all the methods needed to run the program.
 * @author Yang Cai
 */
	public GUI() {		
		initComponents();		
		this.colorModel = ColorModelFactory.createRainbowColorModel(numberOfColors);		
		this.escapeSteps = this.set.Mandelbrot_set();		
		updatePanel();
	
	}
/**
 * This creates the components of the GUI
 * @author Yang Cai and Gary Yeung
 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		jPanel1 = new FractalPanel();
		//
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 479, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 309, Short.MAX_VALUE));
		set = new Sets(this);
		
		// this creates the file menu and its item. It also creates the menu bar. 
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem1 = new JMenuItem();
		
		// this creates the fractal menu and its items.
		jMenu2 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenuItem4 = new JMenuItem();
		jMenuItem5 = new JMenuItem();
		
		// this creates the Color menu and lets you chose different color models.
		jMenu3 = new JMenu();
		jMenuItem6 = new JMenuItem();
		jMenuItem7 = new JMenuItem();
		jMenuItem8 = new JMenuItem();
		JMenuItem jMenuItem9 = new JMenuItem();
		
		//creates the elements necessary to tell the user to put in the escape distance.
		jMenu4 = new JMenu();
		jMenuItem9 = new JMenuItem();
		escapeDistance = new JTextField();
		escapeDistanceRequest = new JLabel("Please enter desired escape distance.");	
		enterEscapeDistance = new JButton("Enter");


		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		jMenu1.setText("File");
		
		jMenuItem1.setText("Exit");
		
		jMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		
		jMenu1.add(jMenuItem1);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Fractal");

		jMenuItem2.setText("Mandelbrot Set");
		jMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem2);

		jMenuItem3.setText("Julia Set");
		jMenuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem3);

		jMenuItem4.setText("Burning Ship Set");
		jMenuItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem4);

		jMenuItem5.setText("Multibrot Set");
		jMenuItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem5ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem5);

		jMenuBar1.add(jMenu2);

		jMenu3.setText("Color");

		jMenuItem6.setText("Red");
		jMenuItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem6ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem6);

		jMenuItem7.setText("Blue");
		jMenuItem7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem7ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem7);

		jMenuItem8.setText("Gray");
		jMenuItem8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem8ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem9);
		jMenuItem9.setText("Green");
		jMenuItem9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jMenuItem9ActionPerformed(evt);
			}
		});

		jMenu3.add(jMenuItem8);
		jMenuBar1.add(jMenu3);
		
		jMenu4.setText("Escape Distance");
		jMenuItem9.setText("Set Escape Distance");
		jMenuItem9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				jMenuItem10ActionPerformed(evt);
			}
		});
		jMenu4.add(jMenuItem9);
		enterEscapeDistance.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				jMenuItem11ActionPerformed(evt);
			}
		});		
		jMenuBar1.add(jMenu4);
		setJMenuBar(jMenuBar1);
			
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
				addComponent(escapeDistance, 150, 150, 150).
				addComponent(escapeDistanceRequest, 400, 400, 400).
				addComponent(enterEscapeDistance, 80, 80, 80).
				addComponent(jPanel1,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
				addComponent(escapeDistance, 20, 20, 20).
				addComponent(escapeDistanceRequest, 60, 60, 60).
				addComponent(enterEscapeDistance, 80, 80, 80).
				addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		pack();
	
		
//		.
//		addComponent(escapeDistance, 150, 150, 150).
//		.
//		addComponent(escapeDistance, 20, 20, 20).
	}
	/**
	 * Gets the value inputed by the user and sets it as the escape distance for the fractals. If invalid input is entered, displays
	 * message requesting for valid input.
	 * @return userInputEscapeDistance.
	 * @author Gary Yeung
	 */
	public int getEscapeDistance(){
		String userInput;
		userInput = escapeDistance.getText();
		int userEscapeDistance = 2;
		try{
			userEscapeDistance = Integer.parseInt(userInput);
			escapeDistance.setText("");
			if(userEscapeDistance <= 0){
				escapeDistanceRequest.setText("please enter a valid escape distance.");
				userEscapeDistance = 2;
			}	
		}
		catch(NumberFormatException e){
			escapeDistanceRequest.setText("please enter a valid escape distance.");
		}
	
		return userEscapeDistance;
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {
		this.dispose();
	}
	
/**
 * This changes the color model to red
 * @author Genessy Munoz
 * @param evt
 */
	private void jMenuItem6ActionPerformed(ActionEvent evt) {
		this.colorModel = ColorModelFactory.createRainbowColorModel(numberOfColors);
		updatePanel();
	}
	/**
	 * This changes the color model to blue.
	 * @author Genessy Munoz
	 * @param evt
	 */
	private void jMenuItem7ActionPerformed(ActionEvent evt) {
		this.colorModel = ColorModelFactory.createBluesColorModel(numberOfColors);
		updatePanel(); 
	}
	
	/**
	 * This changes the color model to gray
	 * @author Genessy Munoz
	 * @param evt
	 */
	private void jMenuItem8ActionPerformed(ActionEvent evt) {
		this.colorModel = ColorModelFactory.createGrayColorModel(numberOfColors);
		updatePanel();
	}
	
	/**
	 * This changes the color model to green.
	 * @author Genessy Munoz
	 * @param evt
	 */
	private void jMenuItem9ActionPerformed(ActionEvent evt) {
		this.colorModel = ColorModelFactory.createGreenColorModel(numberOfColors);
		updatePanel();
	}
	
	/**
	 * This changes the fractal to Mandelbrot set
	 * @author Genessy Munoz
	 * @param evt
	 */
	private void jMenuItem2ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.Mandelbrot_set();
		updatePanel();
	}
	
	/**
	 * This changes the fractal to Julia set
	 * @author Genessy Munoz
	 * @param evt
	 */
	private void jMenuItem3ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.Julia_set();
		updatePanel();
	}
	
	/**
	 * This changes the fractal to BurningShip set
	 * @author Genessy Munoz
	 * @param evt
	 */
	private void jMenuItem4ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.BurningShip_set();
		updatePanel();
	}
	
	/**
	 * This changes the fractal to Multibrot set
	 * @author Genessy Munoz
	 * @param evt
	 */
	private void jMenuItem5ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.Multibrot_set();
		updatePanel();
	}
	/* for the escape distance button*/
	private void jMenuItem10ActionPerformed(ActionEvent evt){
		this.getEscapeDistance();
		updatePanel();
	}
	private void jMenuItem11ActionPerformed(ActionEvent evt){
		
	}
	
	/*Update the panel with */
	private void updatePanel(){
		this.jPanel1.setIndexColorModel(this.colorModel);
		this.jPanel1.updateImage(this.escapeSteps);
	}

	
}

