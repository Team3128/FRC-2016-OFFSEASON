package org.usfirst.frc.team3128.lib.inputs;

import java.util.List;

import org.usfirst.frc.team3128.lib.NarwhalRunnable;
import org.usfirst.frc.team3128.lib.NarwhalThread;
import org.usfirst.frc.team3128.lib.input.joystick.JoystickElement;
import org.usfirst.frc.team3128.lib.input.joystick.Narwhal3DJoystick;
import org.usfirst.frc.team3128.lib.inputs.InputFunction;


public class InputScanner implements NarwhalRunnable {
	private InputFunction inputFunc;
	private Narwhal3DJoystick joy;
	private float freq;
	private JoystickElement joyElement;
	private int[] elementID;
	
	private boolean buttonOldState = false;
	
	private NarwhalThread inputScannerThread = new NarwhalThread(this, freq / 100.0);
	
	public InputScanner(JoystickElement joyElement, Narwhal3DJoystick joy, float freq, InputFunction inputFunc, int... elementID) {
		this.joy = joy;
		this.elementID = elementID;
		this.inputFunc = inputFunc;
		this.freq = freq;
		this.joyElement = joyElement;
	}
	
	public void startScanning() {
		inputScannerThread.start();
	}

	public void stopScanning() {
		inputScannerThread.stop();
	}

	@Override
	public void run() {
		if (joyElement == JoystickElement.BUTTON) {
			boolean shouldRun = false;
			for (int buttonID : elementID) {
				if (joy.buttonIsDown(buttonID)) {
					shouldRun = true;
				}
			}
			if (shouldRun) {
				if (buttonOldState == false) {
					inputFunc.runFunction();
					buttonOldState = true;
				}
				else {
					buttonOldState = false;
				}
			}
		}
		else if (joyElement == JoystickElement.POV) {
			boolean shouldRun = false;
			for (int povPos : elementID) {
				if (joy.getPOV(0) == povPos) {
					shouldRun = true;
				}
			}
			if (shouldRun) {
				inputFunc.runFunction();
			}
		}
		else {
			inputFunc.runFunction();
		}
	}
}
