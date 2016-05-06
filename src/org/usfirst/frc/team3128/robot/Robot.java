
package org.usfirst.frc.team3128.robot;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team3128.lib.NarwhalIterativeRobot;
import org.usfirst.frc.team3128.lib.input.InputMap;
import org.usfirst.frc.team3128.lib.inputs.InputAssignment;
import org.usfirst.frc.team3128.lib.inputs.InputFunction;
import org.usfirst.frc.team3128.lib.inputs.joystick.JoystickElement;
import org.usfirst.frc.team3128.lib.inputs.joystick.Narwhal3DJoystick;
import org.usfirst.frc.team3128.lib.inputs.joystick.JoystickElementID;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends NarwhalIterativeRobot {

    public void robotInit() {
    }
    
    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
    }
    
    public void teleopInit() {
    	InputAssignment inAssign;
    	inAssign = InputAssignment.getInstance();
    	
    	Narwhal3DJoystick rightJoy = new Narwhal3DJoystick(0);
    	
    	inAssign.addJoystick("rightJoy", rightJoy);
    	
    	inAssign.newJoystickScanner("rightButton1", "rightJoy", JoystickElement.BUTTON, 1, () ->
    	{
			
    	}, JoystickElementID.BUTTON1);
    	inAssign.newJoystickScanner("rightPOVTop", "rightJoy", JoystickElement.POV, 1, () ->
    	{
    		
    	}, JoystickElementID.POVPos8, JoystickElementID.POVPos1, JoystickElementID.POVPos2);
    	
    	inAssign.newJoystickScanner("rightPOVaxisX", "rightJoy", JoystickElement.XAXIS, 1, () -> 
    	{
    		double xPos = rightJoy.getX();
    	});
    }

    public void teleopPeriodic() {
    }
    
    public void disabledInit() {
    }

    public void disabledPeriodic() {
    }
}
