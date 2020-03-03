/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import frc.robot.commands.DriveArcade;
import frc.robot.commands.ToggleDelivery;
import frc.robot.commands.ToggleIntake;
import frc.robot.commands.ToggleShooter;
import frc.robot.commands.TestCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick driverController = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is. 
  Joystick Joystick1 = new Joystick(0);

  XboxController Controller1 = new XboxController(0); // Creates an XboxController on port 0.
  XboxController Controller2 = new XboxController(1);

  Button ButtonX = new JoystickButton(this.Controller1, XboxController.Button.kX.value);
  Button ButtonA =  new JoystickButton(this.Controller2, XboxController.Button.kA.value);
  Button ButtonY = new JoystickButton(this.Controller2, XboxController.Button.kY.value);
  Button ButtonB = new JoystickButton(this.Controller2, XboxController.Button.kB.value);
  public OI() {
    ButtonX.whenPressed(new TestCommand());
  
    ButtonA.whileHeld(new ToggleIntake());

    ButtonY.whileHeld(new ToggleDelivery());

    ButtonB.whileHeld(new ToggleShooter());
  }


  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
