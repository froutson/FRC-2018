/**
 *  FRC-2018
 *  Team 3559
 *  Blinkin Subsystem
 *  Control of the LED driver module
 *  Created on: February 3, 2018
 *  Modifide on: February 3, 2018
 *  by Fred Routson
 */
package org.usfirst.frc.team3559.robot.subsystems;
 
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Blinkin extends Subsystem {

    private static Spark ledController = new Spark(0);
    private double confetti = -0.87;
    // private double rest = 0.89;
    public Blinkin() {
    	super();
    }
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setMode(double setting) {
    	if (setting > -1.00 && setting < 1.00) {
    		ledController.set(setting);
    	} else {
    		ledController.set(confetti);
    	}
    }
    
   
}

