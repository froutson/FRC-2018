/**
 * DriveBase.class for 2018 Robot
 * Created by Fred Routson
 * Creation Date: 14 January 2018
 * Modified: 16 January 2018, Fred Routson
 * Note(s): 1st iteration just sets up basic movement w/o feedback
 */

package org.usfirst.frc.team3559.robot.subsystems;


import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 *
 */

public class DriveBase extends Subsystem {

	private WPI_TalonSRX m_leftMaster, m_rightMaster;
	private WPI_TalonSRX m_leftSlave, m_rightSlave;
	private DifferentialDrive driveBase;
	private Timer m_timer = new Timer();
	private ADXRS450_Gyro gyro;
	//private boolean brake = true;						//May not be needed??
	private double speedModifier = 0.8;					//Adjust the max input for speed limiting.
	private double Kp = 0.03;
	private double angle;
	
	
	public DriveBase(){
		super();
		m_leftMaster = new WPI_TalonSRX(0);
		m_leftMaster.setNeutralMode(NeutralMode.Brake);
		m_leftSlave = new WPI_TalonSRX(1);
		m_leftSlave.setNeutralMode(NeutralMode.Brake);
		m_leftSlave.set(ControlMode.Follower, m_leftMaster.getDeviceID());
		// TODO: Add code for sensor input/feedback to close the loop
		
		m_rightMaster = new WPI_TalonSRX(2);
		m_rightMaster.setNeutralMode(NeutralMode.Brake);
		m_rightSlave = new WPI_TalonSRX(3);
		m_rightSlave.setNeutralMode(NeutralMode.Brake);
		m_rightSlave.set(ControlMode.Follower, m_rightMaster.getDeviceID());
		// TODO: Add code for sensor input/feedback. Close the loop!
		
		driveBase = new DifferentialDrive(m_leftMaster, m_rightMaster);
		driveBase.setSafetyEnabled(true);
		
		gyro = new ADXRS450_Gyro();
		
	}
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new TankDriveWithGamepad());
    }
    
    public void drive(double left, double right) {
    	driveBase.tankDrive(-left, -right);
    }
    
    public void stop() {
    	this.drive(0.0, 0.0);
    }
    
    public void moveAhead(double time) {
    	m_timer.reset();
    	m_timer.start();
    	gyro.reset();
    	if (m_timer.get() < time) {
        	angle = gyro.getAngle();
    		driveBase.arcadeDrive(0.5, -angle*Kp);
    		Timer.delay(0.004);
    	} else {
    		driveBase.stopMotor();
    	}
    }
    
    /**
     * Code to drive with gamepad
     */
    public void drive(Joystick gamepad) {
    	drive(speedModifier*gamepad.getY(), speedModifier*gamepad.getRawAxis(3));
    }
    
    public void modifySpeed(double newSpeed) {
    	this.speedModifier = newSpeed;
    }
   
}

