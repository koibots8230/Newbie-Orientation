// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.subsystems.ExampleSubsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.proto.Controller;
import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/** An example command that uses an example subsystem. */
public class WestCoastDrive extends Command {
  private JoystickButton buttonA;
  private JoystickButton buttonB;

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ExampleSubsystem m_subsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public WestCoastDrive(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      double leftSpeed = deadzone(Constants.controller.getRawAxis(1)); 
      double rightSpeed = deadzone(Constants.controller.getRawAxis(5));

      buttonA = new JoystickButton(Constants.controller, XboxController.Button.kA.value);
      buttonB = new JoystickButton(Constants.controller, XboxController.Button.kB.value);

      if (buttonA.get()) {
          new InstantCommand(() -> {
              Constants.frontleft.set(0.0);
              Constants.backleft.set(0.0);
              Constants.frontright.set(0.0);
              Constants.backright.set(0.0);
          }, m_subsystem).schedule();
      }
      if (buttonB.get()) {
          new InstantCommand(() -> {
              Constants.frontleft.set(leftSpeed);
              Constants.backleft.set(leftSpeed);
              Constants.frontright.set(rightSpeed);
              Constants.backright.set(rightSpeed);
          }, m_subsystem).schedule();
      }

}
}
final double deadzone(double num){
  if(Math.abs(num) > 0.15){
    return num; 
  }
  else{
    return 0.0;
  }

    }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
}

