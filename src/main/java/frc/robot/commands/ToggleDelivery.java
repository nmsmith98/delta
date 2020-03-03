/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.RobotMap;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ToggleDelivery extends Command {

  public boolean IntakeMotorEnabled = false;
  PWMVictorSPX IntakeMotor = new PWMVictorSPX(RobotMap.DELIVERY_PWMVictorSPX);
  public void toggleDelivery() {
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
    toggleDelivery();
    end();
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
