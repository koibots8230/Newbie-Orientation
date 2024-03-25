// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private CANSparkMax leftmotor1; 
  private CANSparkMax leftmotor2; 

  private CANSparkMax rightmotor1; 
  private CANSparkMax rightmotor2; 
  private RelativeEncoder encoder1;
  private XboxController controller;


  public class Constants {
    public static final int MOTOR_PORT_4 = 4;
    public static final int MOTOR_PORT_3 = 3;
    public static final int MOTOR_PORT_2 = 2;
    public static final int MOTOR_PORT_1 = 1;
    XboxController controller = new XboxController(0);
  }


  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    leftmotor1 = new CANSparkMax(Constants.MOTOR_PORT_1, MotorType.kBrushless);
    leftmotor2 = new CANSparkMax(Constants.MOTOR_PORT_2, MotorType.kBrushless);
    rightmotor1 = new CANSparkMax(Constants.MOTOR_PORT_3, MotorType.kBrushless);
    rightmotor2 = new CANSparkMax(Constants.MOTOR_PORT_4, MotorType.kBrushless);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit(
  ) {
    encoder1.setPosition(0);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    double leftSpeed = deadzone(controller.getRawAxis(1)); 
    double rightSpeed = deadzone(controller.getRawAxis(5));


    leftmotor1.set(leftSpeed);
    leftmotor2.set(leftSpeed);
    rightmotor1.set(-rightSpeed); 
    rightmotor2.set(-rightSpeed);




    System.out.println(encoder1);
  }


  final double deadzone(double num){
    if (Math.abs(num)> .15){
      return num;
    }
    else{
      return 0.0;
    }
  }

  private double applydeadzone(double leftSpeed, double d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'applydeadzone'");
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
