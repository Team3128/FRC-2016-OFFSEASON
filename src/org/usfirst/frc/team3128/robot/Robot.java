
package org.usfirst.frc.team3128.robot;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team3128.lib.NarwhalIterativeRobot;
import org.usfirst.frc.team3128.lib.input.InputFunction;
import org.usfirst.frc.team3128.lib.input.InputManager;
import org.usfirst.frc.team3128.lib.input.joystick.JoystickElement;
import org.usfirst.frc.team3128.lib.input.joystick.JoystickElementID;
import org.usfirst.frc.team3128.lib.input.joystick.Narwhal3DJoystick;

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
    	
    	Narwhal3DJoystick rightJoy = new Narwhal3DJoystick(0);
    	
    	InputManager.getInstance().addJoystick("rightJoy", rightJoy);
    	
    	//This is how I want the button mapping to look
    	//This allows us to quickly map buttons and give them names that have meaning
    	//It also is very clean and relatively straight forward and can all be put in one place
    	InputManager.getInstance().MapAxis("rightX", "rightJoy", JoystickElement.XAXIS);
    	InputManager.getInstance().MapAxis("rightYThreshed", "rightJoy", JoystickElement.YAXIS_THRESHED);
    	InputManager.getInstance().MapButton("ToggleIntake", "rightJoy", JoystickElementID.BUTTON1);
    	InputManager.getInstance().MapPOV("IntakePOV", "rightJoy", 0);
    }

    public void teleopPeriodic() {
    	//Then, in subsystems, we can just call them like this:
    	//Note; these would be in different classes for each sub system, not in the teleop loop
    	//but this gives a good idea of how it will be used.
    	//Super clean and makes total sense for anyone looking at it
    	if(InputManager.getInstance().GetButton("FireBall")) {
    		//fire the ball
    	}
    }
    
    public void disabledInit() {
    }

    public void disabledPeriodic() {
    }
}
