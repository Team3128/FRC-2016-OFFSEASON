package org.usfirst.frc.team3128.lib.input.joystick;

public class InputElement {
	public String joyName;
	public JoystickElement jsElement;
	
	public InputElement() {
		throw new UnsupportedOperationException("InputElement must be constructed with a joystick name and a joystick element.");
	}
	
	public InputElement(String joyName, JoystickElement jsElement) {
		this.joyName = joyName;
		this.jsElement = jsElement;
	}
}
