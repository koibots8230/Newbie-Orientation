package frc.robot.Mycommands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Mysubsystems.DTSubsystem;

public class DrivetrainCommands extends CommandBase{
    DoubleSupplier rightJoystick;
    DoubleSupplier leftJoystick;

    public void TeleopDrive (DoubleSupplier rightJoystick, DoubleSupplier leftJoystick){
        this.rightJoystick = rightJoystick;
        this.leftJoystick = leftJoystick;
    }
    
    private double deadzoneChecker (double joystickValue){
        return (Math.abs(joystickValue) <= 0.15) ? 0 : joystickValue;
    }

    public void execute (){
        DTSubsystem.get().drive(
            deadzoneChecker(rightJoystick.getAsDouble()),
            deadzoneChecker(leftJoystick.getAsDouble())
        );
    } 
    
    @Override
    public boolean isFinished() {
        return false;
    }
    
    @Override
    public void end(boolean interrupted) {}
}