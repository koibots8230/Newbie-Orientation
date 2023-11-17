package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Constants {
   private int MOTOR_PORT;
   public int MOTOR_PORT1 = 1;
   //public String MotorType = (this.MotorType);
   
   public CANSparkMax motor(int MOTOR_PORT, String MotorType){
    this.MOTOR_PORT = MOTOR_PORT;
    this.MotorType = MotorType;
   }
}
