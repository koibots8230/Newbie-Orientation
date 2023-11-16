package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import java.lang.Math;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Robot extends TimedRobot {

  private CANSparkMax leftMotor;
  private CANSparkMax rightMotor;
  private XboxController controller;

  @Override
  public void robotInit() {
    leftMotor = new CANSparkMax(Constants.LEFT_MOTOR_01, MotorType.kBrushless);
    rightMotor = new CANSparkMax(Constants.RIGHT_MOTOR_01, MotorType.kBrushless);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {

    if (Math.abs(controller.getLeftY()) <= Constants.DEADZONE) {
      leftMotor.set(0);
    }
    else {
      leftMotor.set(controller.getLeftY());
    }

    if (Math.abs(controller.getRightY()) <= Constants.DEADZONE) {
      rightMotor.set(0);
    }
    else {
      rightMotor.set(controller.getRightY());
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
