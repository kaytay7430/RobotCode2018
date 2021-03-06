/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team199.Robot2018;

import org.usfirst.frc.team199.Robot2018.commands.PIDMove;
import org.usfirst.frc.team199.Robot2018.commands.PIDTurn;
import org.usfirst.frc.team199.Robot2018.commands.SetDistancePerPulse;
import org.usfirst.frc.team199.Robot2018.commands.ShiftDriveType;
import org.usfirst.frc.team199.Robot2018.commands.ShiftHighGear;
import org.usfirst.frc.team199.Robot2018.commands.ShiftLowGear;
import org.usfirst.frc.team199.Robot2018.commands.UpdatePIDConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public Joystick leftJoy;
	private JoystickButton shiftLowGear;
	private JoystickButton shiftHighGear;
	private JoystickButton shiftDriveType;
	private JoystickButton PIDMove;
	private JoystickButton PIDTurn;
	public Joystick rightJoy;
	private JoystickButton updatePidConstants;
	private JoystickButton updateEncoderDPP;
	public Joystick manipulator;

	public int getButton(String key, int def) {
		if (!SmartDashboard.containsKey("Button/" + key)) {
			SmartDashboard.putNumber("Button/" + key, def);
		}
		return (int) SmartDashboard.getNumber("Button/" + key, def);
	}

	public OI() {
		leftJoy = new Joystick(0);
		shiftLowGear = new JoystickButton(leftJoy, getButton("Shift Low Gear", 3));
		shiftLowGear.whenPressed(new ShiftLowGear());
		shiftHighGear = new JoystickButton(leftJoy, getButton("Shift High Gear", 5));
		shiftHighGear.whenPressed(new ShiftHighGear());
		shiftDriveType = new JoystickButton(leftJoy, getButton("Shift Drive Type", 2));
		shiftDriveType.whenPressed(new ShiftDriveType());
		PIDMove = new JoystickButton(leftJoy, getButton("PID Move", 7));
		PIDMove.whenPressed(new PIDMove(40, Robot.dt));
		PIDTurn = new JoystickButton(leftJoy, getButton("PID Turn", 8));
		PIDTurn.whenPressed(new PIDTurn(30, Robot.dt));

		rightJoy = new Joystick(1);
		updatePidConstants = new JoystickButton(rightJoy, getButton("Get PID Constants", 8));
		updatePidConstants.whenPressed(new UpdatePIDConstants());
		updateEncoderDPP = new JoystickButton(rightJoy, getButton("Get Encoder Dist Per Pulse", 9));
		updateEncoderDPP.whenPressed(new SetDistancePerPulse());

		manipulator = new Joystick(2);
	}
}
