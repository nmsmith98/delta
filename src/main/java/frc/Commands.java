package frc;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class Commands {
    /* Using temporary variable names while I test things out. 
    
    ...Java is stupid. :) */

    // Method(s)

    public static boolean PrintStuff() {
        System.out.print("A MAN HAS FALLEN INTO THE RIVER IN LEGO CITY! START THE RESCUE HELICOPTER! HEY! BUILD THE HELICOPTER AND OFF TO THE RESCUE! PREPARE THE LIFELINE, LOWER THE STRETCHER AND MAKE THE RESCUE! THE NEW EMERGENCY COLLECTION FROM LEGO CITY");
        return true;
    }

    public static void Main() {
        // Define joystick under port 0
        Joystick Stick = new Joystick(0);

        // Define buttons under Joystick 0
        Button Button1 = new JoystickButton(Stick, 1);
        
        // Define commands
        Command Command1 = new Command(){
            @Override

            protected boolean isFinished() {
                PrintStuff();
                return false;
            }
        };

        // Events and all that jazz
        Button1.whenPressed(Command1);
    }
}