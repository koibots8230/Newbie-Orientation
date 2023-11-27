// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.TankDrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Drive extends CommandBase {
  private DoubleSupplier leftSpeed;
  private DoubleSupplier rightSpeed;

  public Drive(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;

    addRequirements(TankDrive.get());
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    TankDrive.get().setSpeed(
      leftSpeed.getAsDouble(), 
      rightSpeed.getAsDouble()
    );
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
