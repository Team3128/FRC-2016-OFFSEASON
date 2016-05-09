package org.usfirst.frc.team3128.lib.sensors;

import org.usfirst.frc.team3128.lib.NarwhalRunnable;

public abstract class SensorBase implements NarwhalRunnable {
	public double sensorValue;
	public boolean loggingEnabled = false;
	
	//Update Sensor Value
	public abstract void update();
	public abstract void logSensorValue();
	
	@Override
	public void run() {
		update();
		
		if(loggingEnabled)
			logSensorValue();
	}
}
