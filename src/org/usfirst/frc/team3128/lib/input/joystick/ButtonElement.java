package org.usfirst.frc.team3128.lib.input.joystick;

public class ButtonElement extends InputElement {
	public int buttonID;
	public ButtonElement(String joyName, int buttonID) {
		this.joyName = joyName;
		this.jsElement = JoystickElement.BUTTON;
		this.buttonID = buttonID;
	}
}
