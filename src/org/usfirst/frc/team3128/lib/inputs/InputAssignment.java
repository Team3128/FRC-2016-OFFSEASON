package org.usfirst.frc.team3128.lib.inputs;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import org.usfirst.frc.team3128.lib.inputs.Narwhal3DJoystick;
import org.usfirst.frc.team3128.lib.inputs.InputScanner;
import org.usfirst.frc.team3128.lib.inputs.JoystickElement;
import org.usfirst.frc.team3128.lib.inputs.InputCallback;


/**
 * Singleton class for assigning functions to input states/values
 * 
 * Lists controller/input object (joysticks, gamepads, etc.)
 * In teleopInit(), create the instance of InputAssignment and test the values(joystick axis, gamepad buttons, etc.) and run the code
 * 
 * @author Ronak
 */
public class InputAssignment {
	private static InputAssignment instance = null;
	private HashMap<String, Narwhal3DJoystick> joysticks;
	
	private HashMap<String, InputScanner> inputScanners;
	
	protected InputAssignment() {} //Prevent instantiation of singleton
	
	public static InputAssignment getInstance() {
		if(instance == null) {
	         instance = new InputAssignment();
	      }
	      return instance;
	}
	
	public void addJoystick(String joyName, Narwhal3DJoystick joystick) {
		joysticks.put(joyName, joystick);
	}
	
	public void newJoystickScanner(String scannerName, String joyName, JoystickElement joyElement, List<Integer> elementID, float freq, InputCallback funcToRun) {
		inputScanners.put(scannerName, new InputScanner(joyElement, elementID, joysticks.get(joyName), freq, funcToRun));
		inputScanners.get(scannerName).startScanning();
	}
	
	public void stopJoystickScanner(String scannerName) {
		inputScanners.get(scannerName).stopScanning();
		inputScanners.remove(scannerName);
	}
}
