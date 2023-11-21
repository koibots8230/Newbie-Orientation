package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TeleopDrive extends CommandBase {
    DoubleSupplier leftStick;
    DoubleSupplier rightStick;
    public TeleopDrive(DoubleSupplier leftStick, DoubleSupplier rightStick) {
        this.leftStick = leftStick;
        this.rightStick = rightStick;
    }

    @Override
    public void execute() {
        DriveTrain.get().moveMotors(
            deadzoneAjuster(leftStick.getAsDouble()),
            deadzoneAjuster(rightStick.getAsDouble())
        );
    }

    private double deadzoneAjuster(double stickValue) {
        return (Math.abs(stickValue) <= 0.15) ? 0 : stickValue;
    }
}
