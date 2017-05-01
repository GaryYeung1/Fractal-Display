package edu.buffalo.cse116;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseDragHandler implements MouseListener, MouseMotionListener {

	private boolean _isMousePressed;
	private double firstX, lastX, firstY, lastY, testX, testY, retYVal, retXVal;
	/**
	 * This class is used for the methods necessary to get the mouse actions needed 
	 * to recalculate the fractal to zoom in.
	 */
	public MouseDragHandler(){
		_isMousePressed = false;
		firstX = 0.0; 
		lastX = 0.0;
		firstY = 0.0;
		lastY = 0.0;
		testX = 0.0;
		testY = 0.0;
		retYVal = 0.0;
		retXVal = 0.0;
	}
	/**
	 * The method starts when the button is pressed on a certain component and dragged.
	 * Luckily the mouse events will continue under the user stops pressing the button.
	 * So in other words it will get the last x and y coordinates to recalculate the fractal
	 * when the button stops being pressed. It also attempts to let the viewer see what they 
	 * have selected.
	 * @author Florebencia Fils-Aime
	 */
	@SuppressWarnings("null")
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(_isMousePressed){
			lastX= arg0.getX();
			lastY= arg0.getY();
		}
		//attempts to draw the rectangle onto the jpanel1
		Graphics2D drawer = null;
//		drawer.draw(new Rectangle(firstX, firstY, this.width(), this.height()));
		System.out.println("The last coordinate was ("+lastX + ", " + lastY+ ").");
	}
	/**
	 * This method starts working when the mouse leaves the fractal panel;
	 * It resets the _isMousePressed to be false.
	 * @author Florebencia Fils-Aime
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		_isMousePressed= false;
	}
	/**
	 * This method starts working when the mouse starts pressing on the fractal panel.
	 * It sets the boolean isMousePressed to be true and gets the first coordinates of the
	 * position of the mouse.
	 * @author Florebencia Fils-Aime
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		_isMousePressed = true;
		firstX = e.getX();
		firstY = e.getY();
		System.out.println("You pressed at coordinate (" + firstX +", "+ firstY+").");
	}
	/**
	 * This method starts when the user stops holding down the mouse. It sets the boolean 
	 * isMousePressed to false.
	 * @author Florebencia Fils-Aime
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		testX = e.getX();
		testY = e.getY();
		retYVal = (Math.abs(firstY-testY))/2048;
		retXVal = (Math.abs(firstX - testX))/2048;
		System.out.println("x range is " + firstX + " - " + testX + " y range is " + firstY + " - " + testY);
		_isMousePressed= false;
		System.out.println("Aw, you stopped clicking.");
	}
	public double retXInitial(){
		return firstX;
	}
	public double retXFinal(){
		return testX;
	}
	public double retX(){
		return retXVal;
	}
	public double retYInitial(){
		return firstY;
	}
	public double retYFinal(){
		return testY;
	}
	public double retY(){
		return retYVal;
	}
	
	/**
	 * This gets the height of the region selected by the user.
	 * @return the height of the region selected to make zoom in
	 * @author Florebencia Fils-Aime
	 */
	public double height(){
		if(firstY > testY){
			double retVal = (firstY-testY)/512;
			System.out.print(retVal);
			return retVal;
		}
		else if (testY> firstY){
			double retVal = (testY-firstY)/512;
			System.out.println(retVal);
			return retVal;
		}
		else{
			return 0;
		}
	}
	/**
	 * This gets the width of the region selected by the user.
	 * @return the width of the region selected to make zoom in
	 * @author Florebencia Fils-Aime
	 */
	public double width(){
		if(firstX > testX){
			double retVal = (firstX-testX)/512;
			System.out.println(retVal);
			return retVal;
		}
		else if (lastX> testX){
			double retVal =  (lastX-testX)/512;
			System.out.println(retVal);
			return retVal;
		}
		else{
			return 0;
		}
	}
	public double firstX(){
		return firstX;
	}
	public double firstY(){
		return firstY;
	}


	/**
	 * "Invoked when the mouse cursor has been moved onto a component but no buttons have 
	 * been pushed."
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("You're moving the mouse!");
	}
	/**
	 * "Invoked when the mouse button has been clicked (pressed and released) on a component."
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("All you did was click on the panel");

	}
	/**
	 * "Invoked when the mouse enters a component."
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		/*System.out.println("Yay! The mouse in the panel!");*/

	}
	

}
