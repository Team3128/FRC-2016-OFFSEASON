
package org.usfirst.frc.team3128.robot;

import java.util.Arrays;
import java.util.List;

import org.usfirst.frc.team3128.lib.NarwhalIterativeRobot;
import org.usfirst.frc.team3128.lib.Subsystem;
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
	
	private List<Subsystem> subsystems;

    public void robotInit() {
    }
    
    public void autonomousInit() {
    	for(Subsystem s : subsystems)
    		s.initAutonomous();
    }

    public void autonomousPeriodic() {
    	for(Subsystem s : subsystems)
    		s.updateAutonomous();
    }
    
    public void teleopInit() {
    	Narwhal3DJoystick rightJoy = new Narwhal3DJoystick(0);
    	
    	InputManager.getInstance().addJoystick("rightJoy", rightJoy);
    	
    	//This is how I want the button mapping to look
    	//This allows us to quickly map buttons and give them names that have meaning
    	//It also is very clean and relatively straight forward and can all be put in one place
    	InputManager.getInstance().mapAxis("rightX", "rightJoy", JoystickElement.XAXIS);
    	InputManager.getInstance().mapAxis("rightYThreshed", "rightJoy", JoystickElement.YAXIS_THRESHED);
    	InputManager.getInstance().mapButton("ToggleIntake", "rightJoy", JoystickElementID.BUTTON1);
    	InputManager.getInstance().mapPOV("IntakePOV", "rightJoy", 0);
    	
    	for(Subsystem s : subsystems)
    		s.initTeleop();
    }

    public void teleopPeriodic() {
    	for(Subsystem s : subsystems)
    		s.updateTeleop();
    }
    
    public void disabledInit() {
    }

    public void disabledPeriodic() {
    }
}
