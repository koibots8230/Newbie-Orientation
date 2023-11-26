// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private static TankDrive tankDrive = new TankDrive();

  public static TankDrive get() {
      return tankDrive;
  }


  private final CANSparkMax motorL;
  private final CANSparkMax motorR;

  private final RelativeEncoder encoderL;
  private final RelativeEncoder encoderR;

  private TankDrive() {
      motorL = new CANSparkMax(
          Constants.LEFT_MOTOR_PORT,
          MotorType.kBrushless
      );
      motorR = new CANSparkMax(
          Constants.RIGHT_MOTOR_PORT,
          MotorType.kBrushless
      );

      motorL.setIdleMode(IdleMode.kBrake);
      motorR.setIdleMode(IdleMode.kBrake);

      encoderL = motorL.getEncoder();
      encoderR = motorR.getEncoder();

      encoderL.setPosition(0);
      encoderR.setPosition(0);
  }

  public void setSpeed(double leftSpeed, double rightSpeed) {
    motorL.set(leftSpeed);
    motorR.set(rightSpeed);
  }

  public void setCoastMode() {
    motorL.setIdleMode(IdleMode.kCoast);
    motorR.setIdleMode(IdleMode.kCoast);
  }

  public void setBrakeMode() {
    motorL.setIdleMode(IdleMode.kBrake);
    motorR.setIdleMode(IdleMode.kBrake);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
