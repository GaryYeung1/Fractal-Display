package edu.buffalo.cse116;

import javax.swing.*;

import edu.buffalo.fractal.FractalPanel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.IndexColorModel;
import java.util.*;
/**
 * This class creates the GUI that will run the program.
 * @author Yang Cai
 */
public class GUI extends JFrame {

	private JMenu jMenu1,jMenu2,jMenu3;
	private JMenuBar jMenuBar1;
	
	private JMenuItem jMenuItem1,jMenuItem2,jMenuItem3,jMenuItem4, jMenuItem5;
	private JMenuItem jMenuItem6,jMenuItem7,jMenuItem8;
	public JLabel	escapeDistanceRequest;
	public JTextField escapeDistance;
	private FractalPanel jPanel1; // FractalPanel is the jpanel 
	
	private Sets set;
	
	private final int numberOfColors = 50;
	private IndexColorModel colorModel;
	private int[][] escapeSteps;
	private Model _model;	
/**
 * 
 * @author Yang Cai
 */
	public GUI() {		
		initComponents();		
		this.colorModel = ColorModelFactory.createRainbowColorModel(numberOfColors);		
		this.escapeSteps = this.set.Mandelbrot_set();		
		updatePanel();
	}
/**
 * 
 * @author Yang Cai
 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		_model = new Model(this);
		jPanel1 = new FractalPanel();
		
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		
		jMenuItem1 = new JMenuItem();
		
		jMenu2 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenuItem4 = new JMenuItem();
		jMenuItem5 = new JMenuItem();
		
		jMenu3 = new JMenu();
		jMenuItem6 = new JMenuItem();
		jMenuItem7 = new JMenuItem();
		jMenuItem8 = new JMenuItem();
		escapeDistance = new JTextField(10);
		escapeDistanceRequest = new JLabel("Please enter desired escape distance.");
		set = new Sets();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//
		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 479, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 309, Short.MAX_VALUE));
		
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
		jMenu3.add(jMenuItem8);

		jMenuBar1.add(jMenu3);
		

		setJMenuBar(jMenuBar1);
		

		
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
				addComponent(escapeDistance, 150, 150, 150).
				addComponent(escapeDistanceRequest, 400, 400, 400).
				addComponent(jPanel1,GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).
				addComponent(escapeDistance, 20, 20, 20).
				addComponent(escapeDistanceRequest, 60, 60, 60).
				addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		
		pack();
	
		
//		.
//		addComponent(escapeDistance, 150, 150, 150).
//		.
//		addComponent(escapeDistance, 20, 20, 20).
	}
	
	public int getEscapeTime(){
		Scanner getEscapeTime = new Scanner(System.in);
		int eT;
		String change = "Set escape time";
		eT = getEscapeTime.nextInt();
		if(eT <= 0){
			System.out.println("please input valid escape time");
		}
		return eT;
	}

	private void jMenuItem1ActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	/*To change the color model*/
	private void jMenuItem6ActionPerformed(ActionEvent evt) {
		this.colorModel = ColorModelFactory.createRainbowColorModel(numberOfColors);
		updatePanel();
	}
	
	private void jMenuItem7ActionPerformed(ActionEvent evt) {
		this.colorModel = ColorModelFactory.createBluesColorModel(numberOfColors);
		updatePanel(); 
	}
	
	private void jMenuItem8ActionPerformed(ActionEvent evt) {
		this.colorModel = ColorModelFactory.createGrayColorModel(numberOfColors);
		updatePanel();
	}
	
	/*To change the fractal*/
	private void jMenuItem2ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.Mandelbrot_set();
		updatePanel();
	}
	
	private void jMenuItem3ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.Julia_set();
		updatePanel();
	}
	
	private void jMenuItem4ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.BurningShip_set();
		updatePanel();
	}
	
	private void jMenuItem5ActionPerformed(ActionEvent evt) {
		this.escapeSteps = this.set.Multibrot_set();
		updatePanel();
	}
	
	/*Update the panel with */
	private void updatePanel(){
		this.jPanel1.setIndexColorModel(this.colorModel);
		this.jPanel1.updateImage(this.escapeSteps);
	}

	/**
	 * @param args
	 *
	 */
	public static void main(String args[]) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}
}

