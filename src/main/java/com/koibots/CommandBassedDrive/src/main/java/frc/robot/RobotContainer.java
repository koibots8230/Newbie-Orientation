// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.ControllerDrive;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {

  private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();

  private final ControllerDrive controllerDrive = new ControllerDrive(driveTrainSubsystem);

  public static XboxController xboxController = new XboxController(0);




  public RobotContainer() {

    configureBindings();
    driveTrainSubsystem.setDefaultCommand(controllerDrive);
  }

  private void configureBindings() {


  }

}
