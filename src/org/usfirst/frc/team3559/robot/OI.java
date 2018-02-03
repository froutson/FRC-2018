/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3559.robot;

import org.usfirst.frc.team3559.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

public class OI {
	private Joystick gamepad = new Joystick(0);
	private Joystick gamepad2 = new Joystick(1);
	Button lTrigger = new JoystickButton(gamepad, 7);
	Button rTrigger = new JoystickButton(gamepad, 8);
	Button greenA2 = new JoystickButton(gamepad2, 1);
	
	public OI() {
		lTrigger.whileHeld(new SloGear());
		rTrigger.whileHeld(new HiGear());
		greenA2.whenPressed(new ChangeColor());
	}
	
	public Joystick getJoystick() {
		return gamepad;
	}
}
