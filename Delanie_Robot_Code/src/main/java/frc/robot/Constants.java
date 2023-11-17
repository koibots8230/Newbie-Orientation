package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Constants {
final CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless);
final CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless);
    
}
