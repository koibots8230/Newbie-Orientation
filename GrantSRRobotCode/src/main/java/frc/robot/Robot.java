package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.frc.robot.Constants;
import java.lang.Math;

public class Robot extends TimedRobot {
  private CANSparkMax leftMotor01 = new CANSparkMax(Constants.LEFT_MOTOR_01, MotorType.kBrushless);
  private CANSparkMax leftMotor02 = new CANSparkMax(Constants.LEFT_MOTOR_02, MotorType.kBrushless);
  private CANSparkMax rightMotor01 = new CANSparkMax(Constants.RIGHT_MOTOR_01, MotorType.kBrushless);
  private CANSparkMax rightMotor02 = new CANSparkMax(Constants.RIGHT_MOTOR_02, MotorType.kBrushless);
  private XboxControler controller = new XboxControler(0);

  @Override
  public void robotInit() {
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
    leftMotor02.follow(leftMotor01);
    rightMotor02.follow(rightMotor01);

    if (Math.abs(controller.getLeftY()) <= 0.15) {
      leftMotor01.set(0);
    }
    else {
      leftMotor01.set(controller.getLeftY());
    }

    if (Math.abs(controller.getRightY()) <= 0.15) {
      rightMotor01.set(0);
    }
    else {
      rightMotor01.set(controller.getRightY());
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
