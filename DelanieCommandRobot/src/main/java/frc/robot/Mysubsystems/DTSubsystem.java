package frc.robot.Mysubsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;


public class DTSubsystem extends SubsystemBase { //im so glad it does.
    CANSparkMax rightMotor;
    CANSparkMax leftMotor;
    DoubleSupplier rightJoystick;
    DoubleSupplier leftJoystick;

    private static DTSubsystem DriveTrain = new DTSubsystem();


    private DTSubsystem(){
        rightMotor = new CANSparkMax(1, MotorType.kBrushless);
        leftMotor = new CANSparkMax(2, MotorType.kBrushless);
    }

    public static DTSubsystem get() {
        return DriveTrain;
    }
  
    public void drive(double rightJoystick, double leftJoystick){
        leftMotor.set(leftJoystick);
        rightMotor.set(rightJoystick);
    }

    public void setIdleCoastMode(){
        leftMotor.setIdleMode(IdleMode.kCoast);
        rightMotor.setIdleMode(IdleMode.kCoast);
    }

    public void setIdleBrakeMode(){
        leftMotor.setIdleMode(IdleMode.kBrake);
        rightMotor.setIdleMode(IdleMode.kBrake);
    }
}