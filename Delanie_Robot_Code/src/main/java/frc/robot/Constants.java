package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxRelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;

public class Constants {
final CANSparkMax motor1 = new CANSparkMax(1, MotorType.kBrushless);
final CANSparkMax motor2 = new CANSparkMax(2, MotorType.kBrushless);
XboxController controller = new XboxController(0);
}
