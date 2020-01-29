// ORIGINAL TEMPLATE CODE BY FIRST
// CODE FROM THE OLD REPO PORTED TO THIS PROJECT
// ROBOTBUILDER WILL BE THE DEATH OF ME

package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.RobotBase;
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

    public void test() {}

    private volatile boolean m_exit;

    @SuppressWarnings("PMD.CyclomaticComplexity")
    @Override
    public void startCompetition() {
        robotInit();

        // Tell the DS that the robot is ready to be enabled
        HAL.observeUserProgramStarting();

        while (!Thread.currentThread().isInterrupted() && !m_exit) {
            if (isDisabled()) {
                m_ds.InDisabled(true);
                disabled();
                m_ds.InDisabled(false);
                while (isDisabled()) {
                    m_ds.waitForData();
                }
            } else if (isAutonomous()) {
                m_ds.InAutonomous(true);
                autonomous();
                m_ds.InAutonomous(false);
                while (isAutonomous() && !isDisabled()) {
                    m_ds.waitForData();
                }
            } else if (isTest()) {
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