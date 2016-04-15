package org.usfirst.frc.team3128.lib.input;

import org.usfirst.frc.team3128.lib.NarwhalRunnable;
import org.usfirst.frc.team3128.lib.NarwhalThread;

public class InputMonitor implements NarwhalRunnable {
	private NarwhalThread inputMonitorThread = new NarwhalThread(this, 1.0 / 100.0);

	@Override
	public void run() {
		
	}
}
