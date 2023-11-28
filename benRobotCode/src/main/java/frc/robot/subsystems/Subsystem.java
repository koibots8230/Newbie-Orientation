package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

class CommandSubSystem extends SubsystemBase {
    private static CommandSubSystem m_CommandSubsystem = new CommandSubSystem();

    private final CANSparkMax motor1 = new CANSparkMax(0, MotorType.kBrushless);
    private final CANSparkMax motor2 = new CANSparkMax(0, MotorType.kBrushless);
    private RelativeEncoder encoder1 = motor1.getEncoder();
    private RelativeEncoder encoder2 = motor2.getEncoder();
    private XboxController controller = new XboxController(0);

    public CommandSubSystem get() {
        return m_CommandSubsystem;
    }

    public void run() {
    }

    public class DoThing extends CommandBase {
        public DoThing() {
            addRequirements(CommandSubSystem.this);
        }

        @Override
        public void initialize() {
            int encoderValues = 1;
            encoder1.setPositionConversionFactor(encoderValues);
            encoder2.setPositionConversionFactor(encoderValues);
            motor1.set(0);
            motor2.set(0);
            motor2.follow(motor1);
        }

        @Override
        public void execute() {
            motor1.set(controller.getLeftY());
        }
    }
}
