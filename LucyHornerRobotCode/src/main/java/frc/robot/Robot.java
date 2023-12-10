

package frc.robot;

import com.koibots.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.TimedRobot;


public class Robot extends TimedRobot {
  
  private final CANSparkMax motor = new CANSparkMax(Constants.MOTOR_PORT, MotorType.kBrushless);
  private final CANSparkMax motor2 = new CANSparkMax(Constants.MOTOR_PORT2, MotorType.kBrushless);
  private final RelativeEncoder encoder = motor.getEncoder();
    
  
  
  
  public void robotPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    motor2.follow(motor);
    motor.setIdleMode(IdleMode.kBrake);
    motor2.setIdleMode(IdleMode.kBrake);
    encoder.setPositionConversionFactor(2);
    encoder.setPosition(0);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    motor.set(.50);
    System.out.println(encoder.getPosition());
  
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
