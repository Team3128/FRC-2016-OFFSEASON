package org.usfirst.frc.team3128.lib;

import java.util.Timer;
import java.util.TimerTask;

public class NarwhalThread {
	protected NarwhalRunnable runnable;
	private boolean running = false;
	private double period = 1.0/100.0; //100Hz
	
	private Timer threadTimer;
	private TimerTask periodicTask;
	
	public NarwhalThread(NarwhalRunnable runnable, double period) {
		this.runnable = runnable;
		this.period = period;
		periodicTask = new NarwhalRunnableTimerTask();
		threadTimer = new Timer();
	}
	
	public void start() {
		if(!running) {
			threadTimer.schedule(periodicTask, 0l, (long)period * 1000);
			running = true;
		}
	}
	
	public void stop() {
		if(running) {
			threadTimer.cancel();
			running = false;
		}
	}
	
	private class NarwhalRunnableTimerTask extends TimerTask {

		@Override
		public void run() {
			if(runnable == null)
				throw new NullPointerException("NarwhalRunnable is null.");
			runnable.run();
		}
	}
}
