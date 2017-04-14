package edu.buffalo.cse116;

import java.awt.image.IndexColorModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.IndexColorModel;
import java.util.*;

import javax.swing.*;

import edu.buffalo.fractal.FractalPanel;
import edu.buffalo.cse116.*;
/**
 * This class creates the GUI that will run the program.
 * @author Yang Cai, Gary Yeung, Genessy Munoz
 */
public class GUI extends JFrame {
    private JTextField Escapedis;
    private JMenuItem Exit;
    private JButton SetButton;
    private JDialog jDialog1,jDialog2;
    private JLabel jLabel1;
    private JMenu jMenu1,jMenu2,FractalMenu,FileMenu,EditMenu,ColorMenu;
    private JMenuBar jMenuBar1,jMenuBar2;
    private JMenuItem MandelbrotItem,JuliaItem,BurningShipItem,MultibrotItem,RedItem,BlueItem,GrayItem,GreenItem;
    private FractalPanel jPanel1;
    private Sets set;
    private final int numberOfColors = 50;
	private IndexColorModel colorModel;
	private int[][] escapeSteps;
	private MouseDragHandler mouseHandler;

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

        jMenu1 = new JMenu();
        jDialog1 = new JDialog();
        jDialog2 = new JDialog();
        
        jMenuBar2 = new JMenuBar();
        FileMenu = new JMenu();
        EditMenu = new JMenu();
        
        jPanel1 = new FractalPanel();
        jLabel1 = new JLabel();
        Escapedis = new JTextField();
        
        SetButton = new JButton();
        jMenuBar1 = new JMenuBar();
        jMenu2 = new JMenu();
        
        Exit = new JMenuItem();
        FractalMenu = new JMenu();
        MandelbrotItem = new JMenuItem();
        JuliaItem = new JMenuItem();
        BurningShipItem = new JMenuItem();
        MultibrotItem = new JMenuItem();
        
        ColorMenu = new JMenu();
        RedItem = new JMenuItem();
        BlueItem = new JMenuItem();
        GrayItem = new JMenuItem();
        GreenItem = new JMenuItem();
        
        set = new Sets(this);
        mouseHandler = new MouseDragHandler();
        jMenu1.setText("jMenu1");

		// this creates the file menu and its item. It also creates the menu bar. 

        GroupLayout jDialog1Layout = new GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        GroupLayout jDialog2Layout = new GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        FileMenu.setText("File");
        jMenuBar2.add(FileMenu);

        EditMenu.setText("Edit");
        jMenuBar2.add(EditMenu);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        //adds the mouseListener to the fractal panel
        jPanel1.addMouseListener(mouseHandler);
        jPanel1.addMouseMotionListener(mouseHandler);

        jLabel1.setText("Please enter a valid escape distance.");

        Escapedis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EscapedisActionPerformed(evt);
            }
        });

        SetButton.setText("Set");
        SetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SetButtonActionPerformed(evt);
            }
        });

        jMenu2.setText("File");

        Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK | InputEvent.CTRL_MASK));
        Exit.setText("Exit");
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu2.add(Exit);

        jMenuBar1.add(jMenu2);

        FractalMenu.setText("Fractal");

        MandelbrotItem.setText("Mandelbrot Set");
        MandelbrotItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MandelbrotItemActionPerformed(evt);
            }
        });
        FractalMenu.add(MandelbrotItem);

        JuliaItem.setText("Julia Set");
        JuliaItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JuliaItemActionPerformed(evt);
            }
        });
        FractalMenu.add(JuliaItem);

        BurningShipItem.setText("Burning Ship Set");
        BurningShipItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BurningShipItemActionPerformed(evt);
            }
        });
        FractalMenu.add(BurningShipItem);

        MultibrotItem.setText("Multibrot Set");
        MultibrotItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	MultibrotItemActionPerformed(evt);
            }
        });
        FractalMenu.add(MultibrotItem);

        jMenuBar1.add(FractalMenu);

        ColorMenu.setText("Color");

        RedItem.setText("Red");
        GrayItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RedItemActionPerformed(evt);
            }
        });
        ColorMenu.add(RedItem);

        BlueItem.setText("Blue");
        GrayItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BlueItemActionPerformed(evt);
            }
        });
        ColorMenu.add(BlueItem);

        GrayItem.setText("Gray");
        GrayItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                GrayItemActionPerformed(evt);
            }
        });
        ColorMenu.add(GrayItem);

        GreenItem.setText("Green");
        ColorMenu.add(GreenItem);

        jMenuBar1.add(ColorMenu);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Escapedis, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetButton)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Escapedis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(SetButton))
                .addContainerGap())
        );

        pack();
    }
	/**
	 * Gets the value inputed by the user and sets it as the escape distance for the fractals. If invalid input is entered, displays
	 * message requesting for valid input.
	 * @return userInputEscapeDistance.
	 * @author Gary Yeung
	 */
    public int getEscapeDistance(){
		String userInput;
		userInput = Escapedis.getText();
		int userEscapeDistance = 2;
		try{
			userEscapeDistance = Integer.parseInt(userInput);
			Escapedis.setText("");
			if(userEscapeDistance <= 0){
				jLabel1.setText("please enter a valid escape distance.");
				userEscapeDistance = 2;
			}	
		}
		catch(NumberFormatException e){
			jLabel1.setText("please enter a valid escape distance.");
		}
	
		return userEscapeDistance;
	}

    private void ExitActionPerformed(ActionEvent evt) {
    	this.dispose();
    }

    /**
     * @author Genessy Munoz
     * @param evt
     */
    private void SetButtonActionPerformed(ActionEvent evt) {
    	this.getEscapeDistance();
		updatePanel();
    }

    /**
     * @author Genessy Munoz
     * @param evt
     */
    private void EscapedisActionPerformed(ActionEvent evt) {
    }

    /**
     * @author Genessy Munoz
     * @param evt
     */
    private void MandelbrotItemActionPerformed(ActionEvent evt) {
    	this.escapeSteps = this.set.Mandelbrot_set();
		updatePanel();
    }

    private void BurningShipItemActionPerformed(ActionEvent evt) {
    	this.escapeSteps = this.set.BurningShip_set();
		updatePanel();
    }
    
    private void MultibrotItemActionPerformed(ActionEvent evt) {
    	this.escapeSteps = this.set.Multibrot_set();
		updatePanel();
    }
    /**
     * @author Genessy Munoz
     * @param evt
     */
    private void JuliaItemActionPerformed(ActionEvent evt) {
    	this.escapeSteps = this.set.Julia_set();
		updatePanel();
    }

    /**
     * @author Genessy Munoz
     * @param evt
     */
    private void GrayItemActionPerformed(ActionEvent evt) {
    	this.colorModel = ColorModelFactory.createGrayColorModel(numberOfColors);
		updatePanel();
    }
    private void RedItemActionPerformed(ActionEvent evt) {
    	this.colorModel = ColorModelFactory.createRainbowColorModel(numberOfColors);
		updatePanel();
    }
    private void BlueItemActionPerformed(ActionEvent evt) {
    	this.colorModel = ColorModelFactory.createBluesColorModel(numberOfColors);
		updatePanel();
    }

	/*Update the panel with */
	private void updatePanel(){
		this.jPanel1.setIndexColorModel(this.colorModel);
		this.jPanel1.updateImage(this.escapeSteps);
	}
    /**
     * @param args the command line arguments
     */


}
