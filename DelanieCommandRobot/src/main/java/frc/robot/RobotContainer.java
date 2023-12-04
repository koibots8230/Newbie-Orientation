// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Mycommands.DrivetrainCommands;
import java.util.function.DoubleSupplier;
//import frc.robot.commands.Autos;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger; //apparently the trigger is deprecated???? what????  not in the docs
import frc.robot.Mysubsystems.DTSubsystem;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  final DTSubsystem m_DriveTrain = DTSubsystem.get();
  

  private CommandXboxController driverController =
    new CommandXboxController(OperatorConstants.kDriverControllerPort); //(fill this in!)
  
  DoubleSupplier rightJoystick;
  DoubleSupplier leftJoystick;
  Trigger buttonA;
  Trigger buttonB;
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    buttonA = driverController.a();
    buttonB = driverController.b();

    buttonA.onTrue(new InstantCommand(() -> DTSubsystem.get().setIdleBrakeMode()));
    buttonB.onTrue(new InstantCommand(() -> DTSubsystem.get().setIdleCoastMode()));

    rightJoystick = () -> driverController.getRightY();
    leftJoystick = () -> driverController.getLeftY();

    DTSubsystem.get().setDefaultCommand(
      new DrivetrainCommands(rightJoystick, leftJoystick)
    );
  }

   /* @return the command to run in autonomous */
  /*public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_DriveTrain);
  }*///i'm so scared of touching this ngl!!
}
