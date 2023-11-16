package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.frc.robot.Constants;
import java.lang.Math;
import vendordeps.REVLib;

public class Robot extends TimedRobot {

  @Override
  public void robotInit() {
    CANSparkMax leftMotor01 = new CANSparkMax(Constants.LEFT_MOTOR_01, MotorType.kBrushless);
    CANSparkMax rightMotor01 = new CANSparkMax(Constants.RIGHT_MOTOR_01, MotorType.kBrushless);
    XboxControler controller = new XboxControler(0);
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

    if (Math.abs(controller.getLeftY()) <= constants.DEADZONE) {
      leftMotor01.set(0);
    }
    else {
      leftMotor01.set(controller.getLeftY());
    }

    if (Math.abs(controller.getRightY()) <= constants.DEADZONE) {
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
