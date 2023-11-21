package frc.robot;

import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private CommandXboxController driverController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    Trigger aButton = driverController.a();
    Trigger bButton = driverController.b();
    
    aButton.onTrue(new InstantCommand(() -> DriveTrain.get().setIdleBrake()));
    bButton.onTrue(new InstantCommand(() -> DriveTrain.get().setIdleCoast()));
    
    DriveTrain.get().setDefaultCommand(new TeleopDrive(
      () -> driverController.getLeftY(), 
      () -> driverController.getRightY())
    );
  }
  
  public Command getAutonomousCommand() {
    return null;
  }
}
