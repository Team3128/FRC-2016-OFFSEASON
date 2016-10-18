package org.usfirst.frc.team3128.robot.subsystems;

import org.usfirst.frc.team3128.lib.Subsystem;
import org.usfirst.frc.team3128.lib.input.InputManager;

import edu.wpi.first.wpilibj.CANTalon;

public class DriveSubsystem implements Subsystem {
	
	private CANTalon leftDriveMotorMaster, leftDriveMotorSlave, rightDriveMotorMaster, rightDriveMotorSlave;
	private boolean isBrakeMode = false;
	
	public DriveSubsystem(int leftDriveMotorMasterID, int leftDriveMotorSlaveID,int rightDriveMotorMasterID, int rightDriveMotorSlaveID) {
		leftDriveMotorMaster = new CANTalon(leftDriveMotorMasterID);
		leftDriveMotorSlave = new CANTalon(leftDriveMotorSlaveID);
		rightDriveMotorMaster = new CANTalon(rightDriveMotorMasterID);
		rightDriveMotorSlave = new CANTalon(rightDriveMotorSlaveID);
		
		//PercentVbus is -1 to 1 and is the percentage of voltage applied
		//Follower means to do exactly what the master one does
		leftDriveMotorMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		leftDriveMotorMaster.set(0);
		leftDriveMotorSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftDriveMotorSlave.set(leftDriveMotorMasterID);
		
		rightDriveMotorMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rightDriveMotorMaster.set(0);
		rightDriveMotorSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightDriveMotorSlave.set(leftDriveMotorMasterID);
		
		leftDriveMotorMaster.reverseOutput(false);
		leftDriveMotorSlave.reverseOutput(false);
		
		rightDriveMotorMaster.reverseOutput(true);
		rightDriveMotorSlave.reverseOutput(false); //Reads output from master so its already reversed
		
		setBrakeMode(false);
	}
	
	public void initAutonomous() {
		// Let's figure this out at some point!
	}

	public void updateAutonomous() {
		// Let's figure this out at some point!
	}
	
	public void initTeleop() {
		setBrakeMode(false);
		leftDriveMotorMaster.set(0);
		rightDriveMotorMaster.set(0);
	}

	public void updateTeleop() {
		leftDriveMotorMaster.set(InputManager.getInstance().getAxis("leftY"));
		rightDriveMotorMaster.set(InputManager.getInstance().getAxis("rightY"));
		
		//Brake Mode button Toggle Example
		if(InputManager.getInstance().getButton("driveBrakeMode"))
			setBrakeMode(!isBrakeMode);
	}
	
	//Shamelessly stolen from Team 254
	private void setBrakeMode(boolean on) {
		if(isBrakeMode != on) {
			leftDriveMotorMaster.enableBrakeMode(on);
			leftDriveMotorSlave.enableBrakeMode(on);
			rightDriveMotorMaster.enableBrakeMode(on);
			rightDriveMotorSlave.enableBrakeMode(on);
			isBrakeMode = on;
		}
	}
}
