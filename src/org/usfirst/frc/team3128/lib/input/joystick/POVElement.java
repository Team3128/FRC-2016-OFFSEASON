package org.usfirst.frc.team3128.lib.input.joystick;

public class POVElement extends InputElement {
	public int povID;
	public POVElement(String joyName, int povID) {
		this.joyName = joyName;
		this.jsElement = JoystickElement.POV;
		this.povID = povID;
	}
}
