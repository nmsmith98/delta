// ORIGINAL TEMPLATE CODE BY FIRST
// CODE FROM THE OLD REPO PORTED TO THIS PROJECT
// ROBOTBUILDER WILL BE THE DEATH OF ME

package frc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

/**
 * The VM is configured to automatically run this class. If you change the name
 * of this class or the package after creating this project, you must also
 * update the build.gradle file in the project.
 */
public class Robot extends RobotBase {
    public void robotInit() {}

    public void disabled() {}

    public void autonomous() {}

    public void teleop() {}

    public void test() {
        // Define joystick under port 0
        Joystick Stick = new Joystick(0);

        // Define buttons under Joystick 0
        Button Button1 = new JoystickButton(Stick, 1);
        
        // Define commands
        Command Command1 = new Command(){
            @Override

            protected boolean isFinished() {
                System.out.print("asd");
                return false;
            }
        };

        // Events and all that jazz
        Button1.whenPressed(Command1);
    }

    private volatile boolean m_exit;

    @SuppressWarnings("PMD.CyclomaticComplexity")
    @Override
    public void startCompetition() {
        robotInit();

        // Tell the DS that the robot is ready to be enabled
        HAL.observeUserProgramStarting();

        while (!Thread.currentThread().isInterrupted() && !m_exit) {
            if (isDisabled()) {
                System.out.print("--I AM NOW SAD-- \n");
                
                m_ds.InDisabled(true);
                
                disabled();
                
                m_ds.InDisabled(false);
                
                while (isDisabled()) {
                    m_ds.waitForData();
                }
            } else if (isAutonomous()) {
                System.out.print("--AUTONOMOUS MODE-- \n");

                m_ds.InAutonomous(true);
                
                autonomous();
                
                m_ds.InAutonomous(false);
                
                while (isAutonomous() && !isDisabled()) {
                    m_ds.waitForData();
                }
            } else if (isTest()) {
                System.out.print("--TEST MODE-- \n");

                LiveWindow.setEnabled(true);
                Shuffleboard.enableActuatorWidgets();
                m_ds.InTest(true);

                test();

                m_ds.InTest(false);

                while (isTest() && isEnabled()) {
                    m_ds.waitForData();
                }

                LiveWindow.setEnabled(false);
                Shuffleboard.disableActuatorWidgets();
            } else {
                System.out.print("--TELEOP MODE-- \n");

                m_ds.InOperatorControl(true);
                
                teleop();
                
                m_ds.InOperatorControl(false);
                
                while (isOperatorControl() && !isDisabled()) {
                    m_ds.waitForData();
                }
            }
        }
    }

    @Override
    public void endCompetition() {
        m_exit = true;
    }
}