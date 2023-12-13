package frc.robot.Mycommands;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Mysubsystems.DTSubsystem;

public class DrivetrainCommands extends CommandBase{
    DoubleSupplier rightDriverJoystick;
    DoubleSupplier leftDriverJoystick;
    CANSparkMax rightMotor;
    CANSparkMax leftMotor;
    double speedMultiplied;

    public DrivetrainCommands (DoubleSupplier rightDriverJoystick, DoubleSupplier leftDriverJoystick){
        this.rightDriverJoystick = rightDriverJoystick;
        this.leftDriverJoystick = leftDriverJoystick;
        addRequirements(DTSubsystem.get());
    }
    
    private double deadzoneChecker (double joystickValue){
        return (Math.abs(joystickValue) <= 0.15) ? 0 : joystickValue;
    }

    
    public void execute (){
        DTSubsystem.get().drive(
            deadzoneChecker((Math.pow(rightDriverJoystick.getAsDouble(), 2))* speedMultiplied),
            deadzoneChecker((Math.pow(leftDriverJoystick.getAsDouble(), 2)) * speedMultiplied));
            addRequirements(DTSubsystem.get());
    } 

    @Override
    public boolean isFinished() {
        return false;
    }
    
    @Override
    public void end(boolean interrupted) {}
}