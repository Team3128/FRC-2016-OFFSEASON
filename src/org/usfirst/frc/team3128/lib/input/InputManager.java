package org.usfirst.frc.team3128.lib.input;

import java.util.ArrayList;
import java.util.HashMap;

import org.usfirst.frc.team3128.lib.Log;
import org.usfirst.frc.team3128.lib.input.joystick.AxisElement;
import org.usfirst.frc.team3128.lib.input.joystick.ButtonElement;
import org.usfirst.frc.team3128.lib.input.joystick.InputElement;
import org.usfirst.frc.team3128.lib.input.joystick.JoystickElement;
import org.usfirst.frc.team3128.lib.input.joystick.Narwhal3DJoystick;
import org.usfirst.frc.team3128.lib.input.joystick.POVElement;

/**
 * Singleton class used for mapping inputs to virtual buttons and axis.
 */
public class InputManager {
	
	private static InputManager instance = null;
	
	private HashMap<String, Narwhal3DJoystick> joystickMap;
	private HashMap<String, InputElement> inputMap;
	private ArrayList<String> invalidElementsAccessed;
	
	protected InputManager() {
		joystickMap = new HashMap<String, Narwhal3DJoystick>();
		inputMap = new HashMap<String, InputElement>();
		invalidElementsAccessed = new ArrayList<String>();
	}
	
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
		inputMap.put(inputName, new AxisElement(joyName, axis));
	}
	
	public void mapButton(String inputName, String joyName, int buttonID) {
		inputMap.put(inputName, new ButtonElement(joyName, buttonID));
	}
	
	public void mapPOV(String inputName, String joyName, int povID) {
		inputMap.put(inputName, new POVElement(joyName, povID));
	}
	
	/**
	 * Returns the value of the virtual axis identified by axisName without any modification.
	 * @param axisName
	 * @return the unmodified axis value (-1.0 to 1.0)
	 */
	public double getAxis(String axisName) {
		AxisElement axis = (AxisElement)inputMap.get(axisName);
		if(axis == null) {
			if(!invalidElementsAccessed.contains(axisName)) {
				invalidElementsAccessed.add(axisName);
				Log.recoverable("InputManager", "Axis " + axisName + " has not been mapped to any input.");
			}
			return 0;
		}
		
		if(axis.jsElement.equals(JoystickElement.BUTTON) || axis.jsElement.equals(JoystickElement.POV)) {
			Log.recoverable("InputManager", axisName + " is not an axis element.");
			return 0;
		}
			
		Narwhal3DJoystick joystick = joystickMap.get(axis.joyName);
		double result = 0;
		
		if (axis.jsElement == JoystickElement.XAXIS) {
			result = joystick.getX();
		}
		else if (axis.jsElement == JoystickElement.YAXIS) {
			result = joystick.getY();
		}
		else if (axis.jsElement == JoystickElement.XAXIS_THRESHED) {
			result = joystick.getXThreshed();
		}
		else if (axis.jsElement == JoystickElement.YAXIS_THRESHED) {
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
		ButtonElement button = (ButtonElement)inputMap.get(buttonName);
		
		if(button == null) {
			if(!invalidElementsAccessed.contains(buttonName)) {
				invalidElementsAccessed.add(buttonName);
				Log.recoverable("InputManager", "Button " + buttonName + " has not been mapped to any input.");
			}
			return false;
		}
		
		if(!button.jsElement.equals(JoystickElement.BUTTON)) {
			Log.recoverable("InputManager", buttonName + " is not a button element.");
			return false;
		}
		
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
		POVElement pov = (POVElement)inputMap.get(povName);
		
		if(pov == null) {
			if(!invalidElementsAccessed.contains(povName)) {
				invalidElementsAccessed.add(povName);
				Log.recoverable("InputManager", "POV " + povName + " has not been mapped to any input.");
			}
			return 0;
		}
		
		if(!pov.jsElement.equals(JoystickElement.POV)) {
			Log.recoverable("InputManager", povName + " is not a POV element.");
			return 0;
		}
		
		Narwhal3DJoystick joystick = joystickMap.get(pov.joyName);
		
		return joystick.getPOV(pov.povID);
	}
}
