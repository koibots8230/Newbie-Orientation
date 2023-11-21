package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;



public class DriveTrain extends SubsystemBase {
  private static DriveTrain m_DriveTrain = new DriveTrain();

  private CANSparkMax rightMotor;
  private CANSparkMax leftMotor;

  private DriveTrain() {
    rightMotor = new CANSparkMax(Constants.RIGHT_MOTOR, MotorType.kBrushless);
    leftMotor = new CANSparkMax(Constants.LEFT_MOTOR, MotorType.kBrushless);
  }

  public void moveMotors(double leftSpeed, double rightSpeed) {
    rightMotor.set(rightSpeed);
    leftMotor.set(leftSpeed);
  }

  public void setIdleBrake() {
    rightMotor.setIdleMode(IdleMode.kBrake);
    leftMotor.setIdleMode(IdleMode.kBrake);
  }
  public void setIdleCoast() {
    rightMotor.setIdleMode(IdleMode.kCoast);
    leftMotor.setIdleMode(IdleMode.kCoast);
  }

  public static DriveTrain get() {
    return m_DriveTrain;
  }
}
