// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final String leftmotor1 = null;
public static CANSparkMax frontleft = new CANSparkMax(0, MotorType.kBrushless);
  public static CANSparkMax backleft = new CANSparkMax(1, MotorType.kBrushless);
  public static CANSparkMax frontright = new CANSparkMax(2, MotorType.kBrushless);
  public static CANSparkMax backright = new CANSparkMax(3, MotorType.kBrushless);
  public static XboxController controller = new XboxController(0);
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
