package org.usfirst.frc.team3128.lib.inputs;

import java.util.HashMap;
import java.util.List;

import org.usfirst.frc.team3128.lib.inputs.Narwhal3DJoystick;

/**
 * Singleton class for assigning functions to input states/values
 * 
 * Assigns names to controller/input object (joysticks, gamepads, etc.)
 * In teleopInit(), create the instance of InputAssignment
 * Then in teleopPeriodic(), get the controllers and test the values(joystick axis, gamepad buttons, etc.) and run the code
 * 
 * @author Ronak
 */
public class InputAssignment {
	private static InputAssignment instance = null;
	private HashMap<String, Narwhal3DJoystick> joysticks;
	
	protected InputAssignment() {} //Prevent instantiation of singleton
	
	public static InputAssignment getInstance() {
		if(instance == null) {
	         instance = new InputAssignment();
	      }
	      return instance;
	}
	
	public void addJoy(String joyName, Narwhal3DJoystick joystick) {
		joysticks.put(joyName, joystick);
	}
	
	public Narwhal3DJoystick getJoy(String joyName) {
		return (joysticks.get(joyName));
	}
}
