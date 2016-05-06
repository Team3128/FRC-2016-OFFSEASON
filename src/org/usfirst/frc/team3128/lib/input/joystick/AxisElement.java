package org.usfirst.frc.team3128.lib.input.joystick;

public class AxisElement {
	public String joyName;
	public JoystickElement axis;
	public AxisElement(String joyName, JoystickElement axis) {
		this.joyName = joyName;
		this.axis = axis;
	}
}
