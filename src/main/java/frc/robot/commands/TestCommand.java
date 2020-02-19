package frc.robot.commands;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.PWMVictorSPX;

public class TestCommand extends Command {
    PWMVictorSPX intakePWMVictorSPX = null;

    public TestCommand() {
        
    }

    @Override
    protected void initialize() {
        
    }

    @Override
    public void execute() {
        double intakeSpeed = 0.4;

        System.out.println("X has been pressed");

        intakePWMVictorSPX = new PWMVictorSPX(RobotMap.INTAKE_PWMVictorSPX);
        intakePWMVictorSPX.set(intakeSpeed);
        cancel();
    }

    @Override
    protected boolean isFinished() {
      return false;
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected void interrupted() {
        intakePWMVictorSPX = new PWMVictorSPX(RobotMap.INTAKE_PWMVictorSPX);
        intakePWMVictorSPX.set(0);
        end();
    }
}

