package edu.buffalo.cse116;


import java.awt.image.IndexColorModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import edu.buffalo.fractal.ComputePool;
//:)
import edu.buffalo.fractal.FractalPanel;
/**
 * This class creates the GUI that will run the program.
 * @author Yang Cai, Gary Yeung, Genessy Munoz
 */
public class GUI extends JFrame {
    private JTextField Escapedis,EscapeTime,getWorkers;
    private JButton SetButton,SetTimeButton,Reset,setWorkers;
    private JDialog jDialog1,jDialog2;
    private JLabel jLabel1,jLabel2,workers;
    private JMenu jMenu2,FractalMenu,FileMenu,EditMenu,ColorMenu;
    private JMenuBar jMenuBar1,jMenuBar2;
    private JMenuItem MandelbrotItem,JuliaItem,BurningShipItem,MultibrotItem,RedItem,BlueItem,GrayItem,GreenItem,Exit;
    private FractalPanel jPanel1;
    private JPanel jPanel2;
    private Sets set;
    private final int numberOfColors = 50;
	private IndexColorModel colorModel;
	private int[][] escapeSteps;
	private int _userEscapeDistance,_userEscapeTime, numWorkers;
	private MouseDragHandler _mouse;
	private double xCoordinate,yCoordinate;
	private boolean startPic; // used for the if statements in the fractal actions
	private ComputePool computePool;
	private SwingWorkerHandler[] workerArray;
	/**
	 * This gives the basis of the ui. It has all the methods needed to run the program.
	 * @author Yang Cai
	 */
    public GUI() {
    	startPic = true;
        initComponents();
        this.colorModel = ColorModelFactory.createRainbowColorModel(numberOfColors);		
		this.escapeSteps = this.set.Mandelbrot_set(-2.15,-1.3,0.6,1.3,2,255);	
//		jPanel1.setSize(2048, 2048);
		updatePanel();
    }

    /**
     * This creates the components of the GUI
     * @author Yang Cai and Gary Yeung
     */
    @SuppressWarnings("unchecked")

    private void initComponents() {
    	computePool = new ComputePool();
    	workerArray = new SwingWorkerHandler[4];

    	//these are the dialog boxes used to tell you what to place in the jtextfields
        jDialog1 = new JDialog();
        jDialog2 = new JDialog();
        // menubar holds menus
        jMenuBar2 = new JMenuBar();
        FileMenu = new JMenu();
        EditMenu = new JMenu();
        //the jPanel is the fractal panel and the labels give instructions
        jPanel1 = new FractalPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        workers = new JLabel();
        // the user inputs the escapetime, number of Workers, or escapedistance
        Escapedis = new JTextField();
        EscapeTime = new JTextField();
        getWorkers = new JTextField();
        // these set buttons collect the number in the jtextfield and reset resets the fractal
        SetButton = new JButton();
        SetTimeButton = new JButton();
        Reset = new JButton();
        setWorkers = new JButton();
        //more menu components
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
        // our model class 
        set = new Sets(this);
        // initiates the int variables needed for the escapeTime, escapeDistance and 
        // number of swing workers
        _userEscapeDistance = 2;
        _userEscapeTime = 255;
        numWorkers = 1; 
        //this is the mouse eventhandler
        _mouse = new MouseDragHandler();
        xCoordinate = 0.0;
        yCoordinate = 0.0; 

        //creates the file menu
        FileMenu.setText("File");
        jMenuBar2.add(FileMenu);

        EditMenu.setText("Edit");
        jMenuBar2.add(EditMenu);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // adds the mouseListener in the panel
        jPanel1.addMouseListener(_mouse);
        jPanel1.addMouseMotionListener(_mouse);
        
        //sets the instructions on the label and the action done in the jtextfield
        jLabel1.setText("Please enter an escape distance.");


        //collects the the number put into the textfield
        SetButton.setText("Set");
        SetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SetButtonActionPerformed(evt);
            }
        });
      //sets the instructions on the label and the action done in the jtextfield
        jLabel2.setText("Please enter an escape time.");
        
      //collects the the number put into the textfield
        SetTimeButton.setText("Set");
        SetTimeButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt){
        		SetTimeButtonActionPerformed(evt);
        	}
        }); 
        //the button resets the fractal by making the startPic boolean true
        Reset.setText("Reset");
        Reset.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt){
        		startPic=true;
        		computePool.clearPool();
        	}
        });
        workers.setText("Please enter the number of workers you want.");
        setWorkers.setText("Set");
        //helps to create the workers
        setWorkers.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt){
        		SetWorkerButtonActionPerformed(evt);
        	}
        });
        // sets everything for the menu items and the menus
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
        RedItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RedItemActionPerformed(evt);
            }
        });
        ColorMenu.add(RedItem);

        BlueItem.setText("Blue");
        BlueItem.addActionListener(new ActionListener() {
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
        GreenItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		GreenItemActionPerformed(evt);
        	}
        });
        ColorMenu.add(GreenItem);

        jMenuBar1.add(ColorMenu);

        setJMenuBar(jMenuBar1);
        //sets the layout of everything in the bottom of the application
        GridLayout layout = new GridLayout(2,1); 
        this.setLayout(layout);
//        this.setPreferredSize(new Dimension(2048,2048));
        jPanel1.setPreferredSize(new Dimension(2048,2048));
        this.add(jPanel1);
        jLabel1.setPreferredSize(new Dimension(200,200));
        jPanel2.add(jLabel1);
        Escapedis.setPreferredSize(new Dimension(50,25));
        jPanel2.add(Escapedis);
        jPanel2.add(SetButton);
        jPanel2.add(jLabel2);
        EscapeTime.setPreferredSize(new Dimension(50,25));
        jPanel2.add(EscapeTime);
        jPanel2.add(SetTimeButton);
        jPanel2.add(workers);
        getWorkers.setPreferredSize(new Dimension(50,25));
        jPanel2.add(getWorkers);
        jPanel2.add(setWorkers);
        jPanel2.add(Reset);
//        jPanel2.setPreferredSize(new Dimension(1024,150));
        this.add(jPanel2);

        this.pack();
    }
    /** 
     * Returns the user input of the number of SwingWorkers
     * @author Florebencia Fils-Aime
     * @return int collects the number of workers the user wants
     */
    public int getNumOfWorkers(){
    	String userInput;
    	userInput = getWorkers.getText();
    	try{
    		numWorkers = Integer.parseInt(userInput);
    		getWorkers.setText("");
    		workers.setText("Please enter the number of workers you want.");
    		if(numWorkers < 1 || numWorkers > 128){
    			workers.setText("Please enter a valid number of swing workers.");
    			numWorkers = 4;
    		}
    	}
    	catch(NumberFormatException e){
    		workers.setText("Please enter a valid number of swing workers.");
    		getWorkers.setText("");
    	}
    	startPic = false;
    	return numWorkers;
    }
    /**
     * @author garyy
     * creates an array of swingworkers based on user-input.
     * @return an array of swingworkers based on user-input.
     */
    public SwingWorkerHandler[] createSwingWorkerArray(){
    	int desiredWorkers = getNumOfWorkers();
    	workerArray = new SwingWorkerHandler[desiredWorkers];
		for(int i = 0; i < desiredWorkers-1; i++){
			workerArray[i] = new SwingWorkerHandler(i*((2048/desiredWorkers)),2048/desiredWorkers,escapeSteps,_userEscapeTime,numWorkers);
		}
			workerArray[desiredWorkers-1] = new SwingWorkerHandler((desiredWorkers-1)*(2048/desiredWorkers), (2048/desiredWorkers)+2048%desiredWorkers,escapeSteps, _userEscapeTime,numWorkers);
		
    	return workerArray;
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
		try{
			_userEscapeDistance = Integer.parseInt(userInput);
			Escapedis.setText("");
			jLabel1.setText("Please enter an escape distance.");
			if(_userEscapeDistance <= 1){
				jLabel1.setText("Please enter a valid escape distance.");
				_userEscapeDistance = 2;
			}	
		}
		catch(NumberFormatException e){
			jLabel1.setText("Please enter a valid escape distance.");
			Escapedis.setText("");
		}
		startPic = false;
		return _userEscapeDistance;
	}
	/**
	 * Gets the value inputed by the user and sets it as the escape time for the fractals. If invalid input is entered, displays
	 * message requesting for valid input.
	 * @return userInputEscapeTime. 
	 * @author Gary Yeung
	 */
    public int getEscapeTime(){
    	String userInput;
    	userInput = EscapeTime.getText();
    	try{
    		_userEscapeTime = Integer.parseInt(userInput);
    		EscapeTime.setText("");
    		jLabel2.setText("Please enter an escape time.");
    		if(_userEscapeTime <= 1 || _userEscapeTime > 255){
    			jLabel2.setText("Please enter a valid escape time.");
    			_userEscapeTime = 255;
    		}
    	}
    	catch(NumberFormatException e){
    		jLabel2.setText("Please enter a valid escape time.");
    		EscapeTime.setText("");
    	}
    	startPic = false;
    	return _userEscapeTime;
    }
   /**
    * @author garyy
    * Acts as an on/off switch for the reset button.
    * @return a value of 1 to act as on.
    */
 
    public double setXCoordinate(){
    	return xCoordinate;
    }
    public double setYCoordinate(){
    	return yCoordinate;
    }
    /**
     * sets the action done to close the window
     * @param evt
     * @author Florebencia and Gary
     */
    private void ExitActionPerformed(ActionEvent evt) {
    	this.dispose();
    }

    /**
     * this gets the escapeDistance needed to recalculate the fractal
     * @author Florebencia and Gary
     * @param evt
     */
    private void SetButtonActionPerformed(ActionEvent evt) {
    	this.getEscapeDistance();
		updatePanel();
    }
    /**
     * @author garyy
     * creates an array of swing workers.
     * @param evt
     */
    private void SetWorkerButtonActionPerformed(ActionEvent evt){
    	this.createSwingWorkerArray();
    	updatePanel();
    }
    
    /**
     * Gets the escapeTime needed to recalculate the fractal
     * @author garyy
     */
    private void SetTimeButtonActionPerformed(ActionEvent evt){
    	this.getEscapeTime();
    	updatePanel();
    }
    /**
	@author Florebencia
     * Displays the Mandelbrot fractal.
	**/
    private void MandelbrotItemActionPerformed(ActionEvent evt) {
    	
    	if(startPic){
    	this.escapeSteps = this.set.Mandelbrot_set(-2.15,-1.3,0.6,1.3,2,255);}
    	else{
    		this.escapeSteps = set.Mandelbrot_set(_mouse.retXInitialMandelbrot(), _mouse.retYInitialMandelbrot(), _mouse.retXFinalMandelbrot(), _mouse.retYFinalMandelbrot(), this.getEscapeDistance(), this.getEscapeTime());
    		System.out.println(_mouse.retXInitialMandelbrot() +" - "+ _mouse.retXFinalMandelbrot());
    		System.out.println(_mouse.retYInitialMandelbrot() +" - "+ _mouse.retYFinalMandelbrot());

    	}
    	computePool.generateFractal(2048, workerArray);
		updatePanel();
    }
	/**
	 * @author Florebencia
     * Displays the Burningship fractal.
	 * @param evt
	 */
    private void BurningShipItemActionPerformed(ActionEvent evt) {
    	if(startPic){
    	this.escapeSteps = this.set.BurningShip_set(-1.8,-0.08,-1.7,0.025, 2, 255);
    	}
    	else{
    		this.escapeSteps = set.BurningShip_set(_mouse.retXInitialBurningShip(), _mouse.retYInitialBurningShip(), _mouse.retXFinalBurningShip(), _mouse.retYFinalBurningShip(), this.getEscapeDistance(), this.getEscapeTime());
    	}
    	computePool.generateFractal(2048, workerArray);
		updatePanel();
    }
    /**
     * @author Florebencia
     * Displays the Multibrot fractal.
     * @param evt
     */
    private void MultibrotItemActionPerformed(ActionEvent evt) {
    	if(startPic){
    		this.escapeSteps=this.set.Multibrot_set(-1.0,-1.3,1.0,1.3,2,255);
    	}
    	else{
    	this.escapeSteps=this.set.Multibrot_set(_mouse.retXInitialMultibrot(), _mouse.retYInitialMultibrot(), _mouse.retXFinalMultibrot(), _mouse.retYFinalMultibrot(), this.getEscapeDistance(), this.getEscapeTime());
		    	}
    	computePool.generateFractal(2048, workerArray);
    	updatePanel();
    }
    /**
     * @author Florebencia
     * Displays the Julia fractal.
     * @param evt
     */
    private void JuliaItemActionPerformed(ActionEvent evt) {
    	if(startPic){
    		this.escapeSteps=this.set.Julia_set(-1.7, -1.0, 1.7, 1.0, 2, 255);
    	}
    	else{
    	this.escapeSteps = this.set.Julia_set(_mouse.retXInitialJulia(),_mouse.retYInitialJulia(),_mouse.retXFinalJulia(),_mouse.retYFinalJulia(),this.getEscapeDistance(),this.getEscapeTime());
    	}
    	computePool.generateFractal(2048, workerArray);
    	updatePanel();
    }

    /**
     * creates the action needed to make the fractal gray
     * @author Gary 
     * @param evt
     */
    private void GrayItemActionPerformed(ActionEvent evt) {
    	this.colorModel = ColorModelFactory.createGrayColorModel(numberOfColors);
		updatePanel();
    }
    /**
     * creates the action needed to make the fractal red
     * @author Gary
     * @param evt
     */
    private void RedItemActionPerformed(ActionEvent evt) {
    	this.colorModel = ColorModelFactory.createRainbowColorModel(numberOfColors);
		updatePanel();
    }
    /**
     * creates the action needed to make the fractal blue
     * @author Gary
     * @param evt
     */
    private void BlueItemActionPerformed(ActionEvent evt) {
    	this.colorModel = ColorModelFactory.createBluesColorModel(numberOfColors);
		updatePanel();
    }
    /**
     * creates the action needed to make the fractal green
     * @author Gary
     * @param evt
     */
    private void GreenItemActionPerformed(ActionEvent evt){
    	this.colorModel=ColorModelFactory.createGreenColorModel(numberOfColors);
    	updatePanel();
    }

	/**
	 * This method updates the fractal panel according to all the information given by the
	 * user
	 * @author Florebencia and Gary
	 */
	private void updatePanel(){
		this.jPanel1.setIndexColorModel(this.colorModel);
		this.jPanel1.updateImage(this.escapeSteps);
		computePool.changePanel(jPanel1);
	}
}
