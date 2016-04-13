package org.usfirst.frc.team3128.lib.sensors;

import org.usfirst.frc.team3128.lib.NarwhalRunnable;

public abstract class SensorBase implements NarwhalRunnable {
	public double sensorValue;
	public boolean loggingEnabled = false;
	
	//Update Sensor Value
	public abstract void SensorUpdate();
	public abstract void LogSensorValue();
	
	@Override
	public void run() {
		SensorUpdate();
		
		if(loggingEnabled)
			LogSensorValue();
	}
}
