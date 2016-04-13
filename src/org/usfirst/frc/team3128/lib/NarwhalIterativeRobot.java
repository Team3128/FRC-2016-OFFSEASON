package org.usfirst.frc.team3128.lib;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;
import edu.wpi.first.wpilibj.communication.UsageReporting;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tInstances;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary.tResourceType;


/**
 * A slightly modified version of the Iterative Robot, inspired by Team 254 2014 Codebase
 */
public class NarwhalIterativeRobot extends RobotBase implements NarwhalRunnable {
	private boolean m_disabledInitialized;
	private boolean m_autonomousInitialized;
	private boolean m_teleopInitialized;
	private boolean m_testInitialized;

	private NarwhalThread mainRobotThread = new NarwhalThread(this, 1.0 / 100.0);

	@Override
	public void startCompetition() {
		LiveWindow.setEnabled(false);
		UsageReporting.report(tResourceType.kResourceType_Framework, tInstances.kFramework_Iterative);

		robotInit();
		mainRobotThread.start();
		// Tell the DS that the robot is ready to be enabled
		FRCNetworkCommunicationsLibrary.FRCNetworkCommunicationObserveUserProgramStarting();
	}

	@Override
	public void run() {
		// Call the appropriate function depending upon the current robot mode
		if (isDisabled()) {
			// call DisabledInit() if we are now just entering disabled mode
			// from
			// either a different mode or from power-on
			if (!m_disabledInitialized) {
				LiveWindow.setEnabled(false);
				disabledInit();
				m_disabledInitialized = true;
				// reset the initialization flags for the other modes
				m_autonomousInitialized = false;
				m_teleopInitialized = false;
				m_testInitialized = false;
			}
			if (nextPeriodReady()) {
				FRCNetworkCommunicationsLibrary.FRCNetworkCommunicationObserveUserProgramDisabled();
				disabledPeriodic();
			}
		} else if (isTest()) {
			// call TestInit() if we are now just entering test mode from either
			// a different mode or from power-on
			if (!m_testInitialized) {
				LiveWindow.setEnabled(true);
				testInit();
				m_testInitialized = true;
				m_autonomousInitialized = false;
				m_teleopInitialized = false;
				m_disabledInitialized = false;
			}
			if (nextPeriodReady()) {
				FRCNetworkCommunicationsLibrary.FRCNetworkCommunicationObserveUserProgramTest();
				testPeriodic();
			}
		} else if (isAutonomous()) {
			// call Autonomous_Init() if this is the first time
			// we've entered autonomous_mode
			if (!m_autonomousInitialized) {
				LiveWindow.setEnabled(false);
				// KBS NOTE: old code reset all PWMs and relays to "safe values"
				// whenever entering autonomous mode, before calling
				// "Autonomous_Init()"
				autonomousInit();
				m_autonomousInitialized = true;
				m_testInitialized = false;
				m_teleopInitialized = false;
				m_disabledInitialized = false;
			}
			if (nextPeriodReady()) {
				FRCNetworkCommunicationsLibrary.FRCNetworkCommunicationObserveUserProgramAutonomous();
				autonomousPeriodic();
			}
		} else {
			// call Teleop_Init() if this is the first time
			// we've entered teleop_mode
			if (!m_teleopInitialized) {
				LiveWindow.setEnabled(false);
				teleopInit();
				m_teleopInitialized = true;
				m_testInitialized = false;
				m_autonomousInitialized = false;
				m_disabledInitialized = false;
			}
			if (nextPeriodReady()) {
				FRCNetworkCommunicationsLibrary.FRCNetworkCommunicationObserveUserProgramTeleop();
				teleopPeriodic();
			}
		}
		m_ds.waitForData();
	}

	/**
	 * Determine if the appropriate next periodic function should be called.
	 * Call the periodic functions whenever a packet is received from the Driver
	 * Station, or about every 20ms.
	 */
	private boolean nextPeriodReady() {
		return m_ds.isNewControlData();
	}

	/* ----------- Overridable initialization code ----------------- */

	/**
	 * Robot-wide initialization code should go here.
	 *
	 * Users should override this method for default Robot-wide initialization
	 * which will be called when the robot is first powered on. It will be
	 * called exactly one time.
	 *
	 * Warning: the Driver Station "Robot Code" light and FMS "Robot Ready"
	 * indicators will be off until RobotInit() exits. Code in RobotInit() that
	 * waits for enable will cause the robot to never indicate that the code is
	 * ready, causing the robot to be bypassed in a match.
	 */
	public void robotInit() {
		System.out.println("Default IterativeRobot.robotInit() method... Overload me!");
	}

	/**
	 * Initialization code for disabled mode should go here.
	 *
	 * Users should override this method for initialization code which will be
	 * called each time the robot enters disabled mode.
	 */
	public void disabledInit() {
		System.out.println("Default IterativeRobot.disabledInit() method... Overload me!");
	}

	/**
	 * Initialization code for autonomous mode should go here.
	 *
	 * Users should override this method for initialization code which will be
	 * called each time the robot enters autonomous mode.
	 */
	public void autonomousInit() {
		System.out.println("Default IterativeRobot.autonomousInit() method... Overload me!");
	}

	/**
	 * Initialization code for teleop mode should go here.
	 *
	 * Users should override this method for initialization code which will be
	 * called each time the robot enters teleop mode.
	 */
	public void teleopInit() {
		System.out.println("Default IterativeRobot.teleopInit() method... Overload me!");
	}

	/**
	 * Initialization code for test mode should go here.
	 *
	 * Users should override this method for initialization code which will be
	 * called each time the robot enters test mode.
	 */
	public void testInit() {
		System.out.println("Default IterativeRobot.testInit() method... Overload me!");
	}

	/* ----------- Overridable periodic code ----------------- */

	private boolean dpFirstRun = true;

	/**
	 * Periodic code for disabled mode should go here.
	 *
	 * Users should override this method for code which will be called
	 * periodically at a regular rate while the robot is in disabled mode.
	 */
	public void disabledPeriodic() {
		if (dpFirstRun) {
			System.out.println("Default IterativeRobot.disabledPeriodic() method... Overload me!");
			dpFirstRun = false;
		}
		Timer.delay(0.001);
	}

	private boolean apFirstRun = true;

	/**
	 * Periodic code for autonomous mode should go here.
	 *
	 * Users should override this method for code which will be called
	 * periodically at a regular rate while the robot is in autonomous mode.
	 */
	public void autonomousPeriodic() {
		if (apFirstRun) {
			System.out.println("Default IterativeRobot.autonomousPeriodic() method... Overload me!");
			apFirstRun = false;
		}
		Timer.delay(0.001);
	}

	private boolean tpFirstRun = true;

	/**
	 * Periodic code for teleop mode should go here.
	 *
	 * Users should override this method for code which will be called
	 * periodically at a regular rate while the robot is in teleop mode.
	 */
	public void teleopPeriodic() {
		if (tpFirstRun) {
			System.out.println("Default IterativeRobot.teleopPeriodic() method... Overload me!");
			tpFirstRun = false;
		}
		Timer.delay(0.001);
	}

	private boolean tmpFirstRun = true;

	/**
	 * Periodic code for test mode should go here
	 *
	 * Users should override this method for code which will be called
	 * periodically at a regular rate while the robot is in test mode.
	 */
	public void testPeriodic() {
		if (tmpFirstRun) {
			System.out.println("Default IterativeRobot.testPeriodic() method... Overload me!");
			tmpFirstRun = false;
		}
	}
}
