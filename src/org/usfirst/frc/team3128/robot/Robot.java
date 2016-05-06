
package org.usfirst.frc.team3128.robot;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team3128.lib.NarwhalIterativeRobot;
import org.usfirst.frc.team3128.lib.input.InputFunction;
import org.usfirst.frc.team3128.lib.input.InputMap;
import org.usfirst.frc.team3128.lib.input.InputMonitor;
import org.usfirst.frc.team3128.lib.input.joystick.JoystickElement;
import org.usfirst.frc.team3128.lib.input.joystick.JoystickElementID;
import org.usfirst.frc.team3128.lib.input.joystick.Narwhal3DJoystick;
import org.usfirst.frc.team3128.lib.inputs.InputAssignment;

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
    	/*
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
    	
    	*/
    	
    	Narwhal3DJoystick rightJoy = new Narwhal3DJoystick(0);
    	
    	InputMap.getInstance().addJoystick("rightJoy", rightJoy);
    	
    	//This is how I want the button mapping to look
    	//This allows us to quickly map buttons and give them names that have meaning
    	//It also is very clean and relatively straight forward and can all be put in one place
    	InputMap.getInstance().MapAxis("rightX", "rightJoy", JoystickElement.XAXIS);
    	InputMap.getInstance().MapAxis("rightYThreshed", "rightJoy", JoystickElement.YAXIS_THRESHED);
    	InputMap.getInstance().MapButton("ToggleIntake", "rightJoy", JoystickElementID.BUTTON1);
    	InputMap.getInstance().MapPOV("IntakePOV", "rightJoy", 0);
    	
    	InputMap.getInstance().addMonitor("IntakePOVMonitor", new InputMonitor(1, () -> 
    	{
    		if(InputMap.getInstance().GetPOV("IntakePOV") == JoystickElementID.POVPos1 || InputMap.getInstance().GetPOV("IntakePOV") == JoystickElementID.POVPos8 || InputMap.getInstance().GetPOV("IntakePOV") == JoystickElementID.POVPos2) {
    			//Run the intake foreward
    		}	
    	})
    	);
    }

    public void teleopPeriodic() {
    	//Then, in subsystems, we can just call them like this:
    	//Note; these would be in different classes for each sub system, not in the teleop loop
    	//but this gives a good idea of how it will be used.
    	//Super clean and makes total sense for anyone looking at it
    	if(InputMap.getInstance().GetButton("FireBall")) {
    		//fire the ball
    	}
    }
    
    public void disabledInit() {
    }

    public void disabledPeriodic() {
    }
}
