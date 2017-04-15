package edu.buffalo.cse116;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseDragHandler implements MouseListener, MouseMotionListener {

	private boolean _isMousePressed;
	private int firstX, lastX, firstY, lastY;
	/**
	 * This class is used for the methods necessary to get the mouse actions needed 
	 * to recalculate the fractal to zoom in.
	 */
	public MouseDragHandler(){
		_isMousePressed = false;
		firstX = 0; 
		lastX = 0;
		firstY = 0;
		lastY = 0;
	}
	/**
	 * The method starts when the button is pressed on a certain component and dragged.
	 * Luckily the mouse events will continue under the user stops pressing the button.
	 * So in other words it will get the last x and y coordinates to recalculate the fractal
	 * when the button stops being pressed.
	 * @author Florebencia Fils-Aime
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(_isMousePressed){
			lastX= arg0.getX();
			lastY= arg0.getY();
		}
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
	}
	/**
	 * This method starts when the user stops holding down the mouse. It sets the boolean 
	 * isMousePressed to false.
	 * @author Florebencia Fils-Aime
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		_isMousePressed= false;
	}
	/**
	 * This gets the height of the region selected by the user.
	 * @return the height of the region selected to make zoom in
	 * @author Florebencia Fils-Aime
	 */
	public int height(){
		if(firstY > lastY){
			return firstX-lastX;
		}
		else if (lastY> firstY){
			return lastY-firstY;
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
	public int width(){
		if(firstX > lastX){
			return firstX-lastX;
		}
		else if (lastX> firstX){
			return lastX-firstX;
		}
		else{
			return 0;
		}
	}
 /**
  * returns the first coordinate of X
  * @author Florebencia Fils-Aime
  * @return firstX
  */
	public int firstXValue(){return firstX;}
	
	/**
	 * returns the first coordinate of Y
	 * @author Florebencia Fils-Aime
	 * @return firstY
	 */
	public int firstYValue() {	return firstY;}
	
	/**
	 * return the last coordinate of X
	 * @author Florebencia Fils-Aime
	 * @return lastX
	 */
	public int lastXValue(){return lastX;}
	
	/**
	 * return the last coordinate of Y
	 * @author Florebencia Fils-Aime
	 * @return
	 */
	public int lastYValue(){return lastY;}
	/**
	 * "Invoked when the mouse cursor has been moved onto a component but no buttons have 
	 * been pushed."
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print("You're moving the mouse");
	}
	/**
	 * "Invoked when the mouse button has been clicked (pressed and released) on a component."
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print("All you did was click on the panel");

	}
	/**
	 * "Invoked when the mouse enters a component."
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Yay! The mouse in the panel!");

	}
}
