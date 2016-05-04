package org.usfirst.frc.team3128.lib.inputs;

import java.util.concurrent.Callable;
import java.util.List;

import org.usfirst.frc.team3128.lib.NarwhalRunnable;
import org.usfirst.frc.team3128.lib.NarwhalThread;

import org.usfirst.frc.team3128.lib.inputs.Narwhal3DJoystick;
import org.usfirst.frc.team3128.lib.inputs.JoystickElement;
import org.usfirst.frc.team3128.lib.inputs.InputCallback;


public class InputScanner implements NarwhalRunnable {
	private InputCallback inputFunc;
	public Narwhal3DJoystick joy;
	private float freq;
	private JoystickElement joyElement;
	private List<Integer> elementID;
	
	private NarwhalThread inputScannerThread = new NarwhalThread(this, freq / 100.0);
	
	public InputScanner(JoystickElement joyElement, List<Integer> elementID, Narwhal3DJoystick joy, float freq, InputCallback inputFunc) {
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
				inputFunc.inputCallback();
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
				inputFunc.inputCallback();
			}
		}
		else {
			inputFunc.inputCallback();
		}
	}
}
