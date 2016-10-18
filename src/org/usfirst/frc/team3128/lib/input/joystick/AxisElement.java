package org.usfirst.frc.team3128.lib.input.joystick;

public class AxisElement extends InputElement{
	public AxisElement(String joyName, JoystickElement axis) {
		this.joyName = joyName;
		this.jsElement = axis;
	}
}
