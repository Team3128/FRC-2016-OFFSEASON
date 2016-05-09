package org.usfirst.frc.team3128.lib.input;

import java.util.HashMap;

import org.usfirst.frc.team3128.lib.input.joystick.AxisElement;
import org.usfirst.frc.team3128.lib.input.joystick.ButtonElement;
import org.usfirst.frc.team3128.lib.input.joystick.JoystickElement;
import org.usfirst.frc.team3128.lib.input.joystick.Narwhal3DJoystick;
import org.usfirst.frc.team3128.lib.input.joystick.POVElement;

/**
 * Singleton class used for mapping inputs to virtual buttons and axis.
 */
public class InputManager {
	
	private static InputManager instance = null;
	
	private HashMap<String, Narwhal3DJoystick> joystickMap;
	private HashMap<String, ButtonElement> buttonMap;
	private HashMap<String, AxisElement> axisMap;
	private HashMap<String, POVElement> povMap;
	
	protected InputManager() {} //Prevent instantiation of singleton
	
	public static InputManager getInstance() {
		if(instance == null) {
	         instance = new InputManager();
	      }
	      return instance;
	}
	
	public void addJoystick(String joyName, Narwhal3DJoystick joy) {
		joystickMap.put(joyName, joy);
	}
	
	public void mapAxis(String inputName, String joyName, JoystickElement axis) {
		axisMap.put(inputName, new AxisElement(joyName, axis));
	}
	
	public void mapButton(String inputName, String joyName, int buttonID) {
		buttonMap.put(inputName, new ButtonElement(joyName, buttonID));
	}
	
	public void mapPOV(String inputName, String joyName, int povID) {
		povMap.put(inputName, new POVElement(joyName, povID));
	}
	
	/**
	 * Returns the value of the virtual axis identified by axisName without any modification.
	 * @param axisName
	 * @return the unmodified axis value (-1.0 to 1.0)
	 */
	public double getAxis(String axisName) {
		AxisElement axis = axisMap.get(axisName);
		Narwhal3DJoystick joystick = joystickMap.get(axis.joyName);
		double result = 0;
		
		if (axis.axis == JoystickElement.XAXIS) {
			result = joystick.getX();
		}
		else if (axis.axis == JoystickElement.YAXIS) {
			result = joystick.getY();
		}
		else if (axis.axis == JoystickElement.XAXIS_THRESHED) {
			result = joystick.getXThreshed();
		}
		else if (axis.axis == JoystickElement.YAXIS_THRESHED) {
			result = joystick.getYThreshed();
		}
		
		return result;
	}
	
	/**
	 * Returns true if the button is pressed
	 * @param buttonName
	 * @return True if the button is held down, false if the button is up
	 */
	public boolean getButton(String buttonName) {
		ButtonElement button = buttonMap.get(buttonName);
		Narwhal3DJoystick joystick = joystickMap.get(button.joyName);
		
		return joystick.buttonIsDown(button.buttonID);
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
	public int getPOV(String povName) {
		POVElement pov = povMap.get(povName);
		Narwhal3DJoystick joystick = joystickMap.get(pov.joyName);
		
		return joystick.getPOV(pov.povID);
	}
}
