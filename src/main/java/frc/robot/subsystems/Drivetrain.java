/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
PWMVictorSPX leftFrontPWMVictorSPX = null;
PWMVictorSPX leftBackPWMVictorSPX = null;
PWMVictorSPX rightFrontPWMVictorSPX = null;
PWMVictorSPX rightBackPWMVictorSPX = null;

DifferentialDrive differentialDrive = null;
public Drivetrain () {
  //Victors
  leftFrontPWMVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT_PWMVictorSPX);
  leftBackPWMVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_LEFT_BACK_PWMVictorSPX);
  rightFrontPWMVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT_PWMVictorSPX);
  rightBackPWMVictorSPX = new PWMVictorSPX(RobotMap.DRIVETRAIN_RIGHT_BACK_PWMVictorSPX);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontPWMVictorSPX, leftBackPWMVictorSPX);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontPWMVictorSPX, rightBackPWMVictorSPX);
  
  differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand()); public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
  }
public void arcadeDrive(double moveSpeed, double rotateSpeed) {
  differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  System.out.println(moveSpeed);
  System.out.println(rotateSpeed);
}

}
