package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.frc.robot.Constants;

public class Robot extends TimedRobot {
  private CANSparkMax motor01 = new CANSparkMax(Constants.MOTOR_PORT01, MotorType.kBrushless);
  private CANSparkMax motor02 = new CANSparkMax(Constants.MOTOR_PORT02, MotorType.kBrushless);

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
  private final RelativeEncoder motorEncoder01 = motor01.getEncoder();

  @Override
  public void teleopInit() {
    motorEncoder01.setPosition(0);
    if(motorEncoder01.getPosition() >= 2) {
      motorEncoder01.setPosition(0);
    }

    while (True = True) {
      System.out.println(motorEncoder01.getPosition());
    }
  }

  @Override
  public void teleopPeriodic() {
    motor01.set(0.5);
    motor02.folow(motor01);
    motor01.setIdleMode(IdleMode.kBreak);
    motor02.setIdleMode(IdleMode.kBreak);
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
