

package frc.robot.subsystems;
import frc.robot.Constants;
import frc.robot.commands.ControllerDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrainSubsystem extends SubsystemBase {

  CANSparkMax frontleft = new CANSparkMax(Constants.driveConstants.LEFTFRONTCANID,MotorType.kBrushless);
  CANSparkMax backleft = new CANSparkMax(Constants.driveConstants.LEFTBACKCANID,MotorType.kBrushless);
  CANSparkMax frontright = new CANSparkMax(Constants.driveConstants.RIGHTFRONTCANID,MotorType.kBrushless);
  CANSparkMax backright = new CANSparkMax(Constants.driveConstants.RIGHTBACKCANID,MotorType.kBrushless);

  RelativeEncoder lEncoder = frontleft.getEncoder();
  RelativeEncoder rEncoder = frontright.getEncoder();

  DifferentialDrive differentialDrive = new DifferentialDrive(frontleft, frontright);


  public DriveTrainSubsystem(){
    lEncoder.setPosition(0);
    rEncoder.setPosition(0);

    backleft.follow(frontleft);
    backright.follow(frontright);

    frontright.setInverted(true);

    frontleft.set(0);

  }

  public void drivespeed(double frontLeftSpeed, double frontRightSpeed){
    frontleft.set(frontLeftSpeed);
    frontright.set(frontRightSpeed);
  }
  
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
