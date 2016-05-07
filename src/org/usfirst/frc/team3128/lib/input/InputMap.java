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
public class InputMap {
	
	private static InputMap instance = null;
	private HashMap<String, InputMonitor> inputMap;
	
	private HashMap<String, Narwhal3DJoystick> joystickMap;
	
	private HashMap<String, ButtonElement> buttonMap;
	private HashMap<String, AxisElement> axisMap;
	private HashMap<String, POVElement> povMap;
	
	protected InputMap() {} //Prevent instantiation of singleton
	
	public static InputMap getInstance() {
		if(instance == null) {
	         instance = new InputMap();
	      }
	      return instance;
	}
	
	public void addMonitor(String monitorName, InputMonitor inMonitor) {
		inputMap.put(monitorName, inMonitor);
		inputMap.get(monitorName).startScanning();
	}
	
	public void removeMonitor(String monitorName) {
		inputMap.get(monitorName).stopScanning();
		inputMap.remove(monitorName);
	}
	
	public void addJoystick(String joyName, Narwhal3DJoystick joy) {
		joystickMap.put(joyName, joy);
	}
	
	
	
	public void MapAxis(String inputName, String joyName, JoystickElement axis) {
		axisMap.put(inputName, new AxisElement(joyName, axis));
	}
	
	public void MapButton(String inputName, String joyName, int buttonID) {
		buttonMap.put(inputName, new ButtonElement(joyName, buttonID));
	}
	
	public void MapPOV(String inputName, String joyName, int povID) {
		povMap.put(inputName, new POVElement(joyName, povID));
	}
	
	public void MapToggle(String inputName, String joyName) {
		
	}
	
	/**
	 * Returns the value of the virtual axis identified by axisName without any modification.
	 * @param axisName
	 * @return the unmodified axis value (-1.0 to 1.0)
	 */
	public double GetAxis(String axisName) {
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
	public boolean GetButton(String buttonName) {
		ButtonElement button = buttonMap.get(buttonName);
		Narwhal3DJoystick joystick = joystickMap.get(button.joyName);
		
		if (joystick.buttonIsDown(button.buttonID)) {
			return true;
		}
		else {
			return false;
		}
		
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
		POVElement pov = povMap.get(povName);
		Narwhal3DJoystick joystick = joystickMap.get(pov.joyName);
		
		return joystick.getPOV(pov.povID);
	}
	
	/**
	 * Returns the current state of the specified toggle.
	 * @param toggleName
	 * @return True if the toggle is on, false if the toggle is off.
	 */
	public boolean GetToggle(String toggleName) {
		return false;
	}
}
