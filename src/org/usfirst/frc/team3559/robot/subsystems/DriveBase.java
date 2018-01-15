/**
 * DriveBase.class for 2018 Robot
 * Created by Fred Routson
 * Creation Date: 14 January 2018
 */

package org.usfirst.frc.team3559.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;



/**
 *
 */
public class DriveBase extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private TalonSRX m_leftMaster, m_rightMaster;
	private TalonSRX m_leftSlave, m_rightSlave;
	//private RobotDrive drive;
	//private boolean brake = true;						//May not be needed??
	private double speedModifier = 0.8;					//Adjust the max input for speed limiting.
	
	public DriveBase(){
		super();
		m_leftMaster = new TalonSRX(1);
		m_leftMaster.setNeutralMode(NeutralMode.Brake);
		m_leftSlave = new TalonSRX(2);
		m_leftSlave.setNeutralMode(NeutralMode.Brake);
		m_leftSlave.set(ControlMode.Follower, m_leftMaster.getDeviceID());
		// TODO: Add code for sensor input/feedback to close the loop
		
		m_rightMaster = new TalonSRX(3);
		m_rightMaster.setNeutralMode(NeutralMode.Brake);
		m_rightSlave = new TalonSRX(4);
		m_rightSlave.setNeutralMode(NeutralMode.Brake);
		m_rightSlave.set(ControlMode.Follower, m_rightMaster.getDeviceID());
		// TODO: Add code for sensor input/feedback. Close the loop!
		
		
		
		
		
	}
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

