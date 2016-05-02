package org.usfirst.frc.team3128.lib.input;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * Singleton class used for mapping inputs to virtual buttons and axis.
 */
public class InputMap {
	
	private static InputMap instance = null;
	private HashMap<String, InputMonitor> inputMap;
	
	protected InputMap() {} //Prevent instantiation of singleton
	
	public static InputMap getInstance() {
		if(instance == null) {
	         instance = new InputMap();
	      }
	      return instance;
	}
	
	public void MapAxis(String inputName, Callable<Double> inputFunction) {
		
	}
	
	public void MapButton(String inputName, Callable<Boolean> inputFunction) {
		
	}
	
	public void MapToggle(String inputName, Callable<Boolean> inputFunction) {
		
	}
	
	public void MapPOV(String inputName, Callable<Boolean> inputFunction) {
		
	}
	
	/**
	 * Returns the value of the virtual axis identified by axisName.
	 * This will return a value that has been modified by an input axis modifier.
	 * @param axisName
	 * @return the modified axis value (-1.0 to 1.0)
	 */
	public double GetAxis(String axisName) {
		return 0;
	}
	
	/**
	 * Returns the value of the virtual axis identified by axisName without any modification.
	 * @param axisName
	 * @return the unmodified axis value (-1.0 to 1.0)
	 */
	public double GetAxisRaw(String axisName) {
		return 0;
	}
	
	/**
	 * Returns true if the button is pressed
	 * @param buttonName
	 * @return True if the button is held down, false if the button is up
	 */
	public boolean GetButton(String buttonName) {
		return false;
	}
	
	/**
	 * Returns the current state of the specified toggle.
	 * @param toggleName
	 * @return True if the toggle is on, false if the toggle is off.
	 */
	public boolean GetToggle(String toggleName) {
		return false;
	}
	
	/**
	 * Returns the current state of the specified POV.
	 * @param povName
	 * @return An integer 0-8 corresponding to the position of the POV
	 *       1
	 *   8       2
	 *  
	 * 7     0     3
	 *    
	 *   6       4
	 *       5
	 */
	public int GetPOV(String povName) {
		return 0;
	}
}
