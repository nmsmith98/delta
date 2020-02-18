package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class TestCommand extends Command {
    public TestCommand() {
        System.out.println("pp Music");
    }

    @Override
    protected boolean isFinished() {
      return false;
    }

    @Override
    protected void interrupted() {
        end();
    }
}

