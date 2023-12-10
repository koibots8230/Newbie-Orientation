

package frc.robot;

import com.koibots.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;


public class Robot extends TimedRobot {
  
  
  private final CANSparkMax Leftmotor = new CANSparkMax(Constants.LeftMOTOR_PORT, MotorType.kBrushless);
  private final CANSparkMax Rightmotor2 = new CANSparkMax(Constants.RightMOTOR_PORT2, MotorType.kBrushless);
  private final RelativeEncoder Leftencoder = Leftmotor.getEncoder();
  private final RelativeEncoder rightEncoder = Rightmotor2.getEncoder();
  private final XboxController controller = new XboxController(0);

  
    
  
  
  
  public void robotPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    Leftmotor.setIdleMode(IdleMode.kBrake);
    Rightmotor2.setIdleMode(IdleMode.kBrake);
    rightEncoder.setPosition(0);
    Leftencoder.setPosition(0);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    Leftmotor.set(.50);
    Rightmotor2.set(.50);
    System.out.println(Leftencoder.getPosition());
    double rp = controller.getRightY();
    rightEncoder.setPosition(rp);
    double lp= controller.getLeftY();
    Leftencoder.setPosition(lp);

    if (Math.abs(rp) < Constants.DEAD_SPACE) {
      rp = 0;
    }

    
    if (Math.abs(lp) < Constants.DEAD_SPACE){
      lp = 0;
    }



  
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /*t This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
