package org.usfirst.frc.team199.Robot2018.subsystems;

public interface LiftInterface {
	
	/**
	 * Set the default command for a subsystem here.
	 * */
	public void initDefaultCommand();
	
	public enum Position {
		GROUND,
		SWITCH,
		SCALE,
		BAR
	}
	
	/**
	 * Uses (insert sensor here) to detect the current lift position 
	 */
	public double getHeight();
	
	/**
	 * stops the lift
	 */
	public void stopLift();
	
	/**
	 * gets current motor values
	 */
	public double getLiftSpeed();
	
	
	/**
	 * Goes to specified height
	 * @param position - ground, switch, scale, bar
	 * @param offset - distance up or down from position
	 */
	public void goToPosition(Position position, double offset);
	
	
}
