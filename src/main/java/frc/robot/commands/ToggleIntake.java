package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.RobotMap;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ToggleIntake extends Command {
  /**
   * Creates a new Intake.
   */
  public boolean IntakeMotorEnabled = false;
  PWMVictorSPX IntakeMotor = new PWMVictorSPX(RobotMap.INTAKE_PWMVictorSPX);
  
  public void toggleIntake() {
    if (IntakeMotorEnabled == false) {
      IntakeMotorEnabled = true;
      IntakeMotor.set(0.3);
    }
    else {
      IntakeMotorEnabled = false;
      IntakeMotor.set(0);
    }
  }
  
  @Override
  protected void initialize() {
    
  }

  @Override
  public void execute() {
    toggleIntake();
  }

  // Returns true when the command should end.
  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
      
  }

  @Override
  protected void interrupted() {
      end();
  }
}
