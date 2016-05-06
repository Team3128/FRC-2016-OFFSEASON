package org.usfirst.frc.team3128.lib.input;

import org.usfirst.frc.team3128.lib.NarwhalRunnable;
import org.usfirst.frc.team3128.lib.NarwhalThread;
import org.usfirst.frc.team3128.lib.input.InputFunction;;

public class InputMonitor implements NarwhalRunnable {
	private int frequency;
	private InputFunction inFunc;
	
	public InputMonitor(int frequency, InputFunction inFunc) {
		this.frequency = frequency;
		this.inFunc = inFunc;
	}

	private NarwhalThread inputMonitorThread = new NarwhalThread(this, frequency / 100.0);
	
	public void startScanning() {
		inputMonitorThread.start();
	}
	
	public void stopScanning() {
		inputMonitorThread.stop();
	}
	
	@Override
	public void run() {
		inFunc.runFunction();
	}
}
