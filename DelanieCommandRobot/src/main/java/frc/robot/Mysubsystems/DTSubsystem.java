package frc.robot.Mysubsystems;

import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;


public class DTSubsystem extends SubsystemBase { //im so glad it does.
    CANSparkMax rightMotor;
    CANSparkMax leftMotor;

    private static DTSubsystem DriveTrain = new DTSubsystem();


    private void DriveTrain(){
        final CANSparkMax rightMotor = new CANSparkMax(1, MotorType.kBrushless);
        final CANSparkMax leftMotor = new CANSparkMax(2, MotorType.kBrushless);
    }

    public static DTSubsystem get() {
        return DriveTrain;
    }
     
    public void drive(double leftSpeed, double rightSpeed){
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
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