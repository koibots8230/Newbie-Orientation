// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.commands.Autos;
import frc.robot.commands.Drive;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController controller =
      new CommandXboxController(Constants.CONTROLLER_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }


  private void configureBindings() {
    InstantCommand aButtonCommand = new InstantCommand(() -> TankDrive.get().setBrakeMode());
    InstantCommand bButtonCommand = new InstantCommand(() -> TankDrive.get().setCoastMode());

    Trigger aButton = controller.a();
    Trigger bButton = controller.b();

    aButton.onTrue(aButtonCommand);
    bButton.onTrue(bButtonCommand);


    TankDrive.get().setDefaultCommand(
      new Drive(
        controller.getLeftY(),
        controller.getRightY()
      )
    );
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
