package org.usfirst.frc.team3128.lib.input.joystick;

import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team3128.lib.util.NarMath;

/**
 * Logitech 3D Extreme USB Joystick Methods
 * @author Ronak
 */

public class Narwhal3DJoystick {
	Joystick joy;
	
	public Narwhal3DJoystick(int joyID) {
		this.joy = new Joystick(joyID);
	}
	
	/**
	 * @return The raw value of the x axis (from -1.0 to 1.0)
	 */
	public double getX() {
		return joy.getX();
	}
	
	/**
	 * @return The raw value of the y axis (from -1.0 to 1.0)
	 */
	public double getY() {
		return joy.getY();
	}
	
	/**
	 * @return The thresholded value of the x axis (from -1.0 to 1.0) that discards any control within 0.2 of 0
	 */
	public double getXThreshed() {
		return NarMath.Thresh(0.2, joy.getX());
	}
	
	/**
	 * @return The thresholded value of the y axis (from -1.0 to 1.0) that discards any control within 0.2 of 0
	 */
	public double getYThreshed() {
		return NarMath.Thresh(0.2, joy.getY());
	}
	
	/**
	 * @return The throttle value (from -1.0 to 1.0)
	 */
	public double getThrottle() {
		return joy.getThrottle();
	}
	
	/**
	 * @return The z-axis/twist value
	 */
	public double getTwist() {
		return joy.getTwist();
	}
	
	/**
	 * @param buttonID
	 * @return The value of the button
	 * true - button is being pressed
	 * false - button is not being pressed 
	 */
	public boolean buttonIsDown(int buttonID) {
		return joy.getRawButton(buttonID);
	}
	
	/**
	 * Returns the current state of the specified POV.
	 * @param povID
	 * @return An integer 0-8 corresponding to the position of the POV
	 *       1
	 *   8       2
	 *  
	 * 7     0     3
	 *    
	 *   6       4
	 *       5
	 */
	public int getPOV(int povID) {
		return joy.getPOV(povID);
	}
}
