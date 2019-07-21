/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//The import library for the Joystick input value(s)
import edu.wpi.first.wpilibj.Joystick;

/**
 * Add your docs here.
 */
public class InputManager {

    //Initializes the Logitech Controller we have seen in the driver station screen
    Joystick joy1 = new Joystick(0);

    //The Joystick input axis method for driving
    Double[] Driver(){
        Double[] var = new Double[2];
        var[0] = joy1.getRawAxis(1);    //sets one side of the robot's motors to move when axis 1 is moved
        var[1] = joy1.getRawAxis(3);    //sets one side of the robot's motors to move when axis 3 is moved
        
        var = scaleFactor(var);     //Scales the var variable (seen in the methods below)
        var = deadZone(var);        //Sets the dead zone for the var variable (seen in the methods below)

        return var;
    }

    //Makes the input value of the joystick axis set to a certain value before going to the MotorController Class
    //This basically omits the need for the equation in the MotorController Class
    Double[] scaleFactor(Double[] scale) {
        scale[0] = 0.8 * Math.pow(scale[0], 3) + 0.2 * scale[0];
        scale[1] = 0.8 * Math.pow(scale[1], 3) + 0.2 * scale[1];
        return scale;
    }
    
    //When the joystick axis value is slightly off from 0 when at rest, this sets it back to 0 so nothing crazy happens
    Double[] deadZone(Double[] in) {
        if (-.09 < in[0] && in[0] < .09) {  //Sets the dead zone for one side of the robot's input (axis 1)
            in[0] = 0.0;
        }
        if (-.09 < in[1] && in[1] < .09) {  //Sets the dead zone for one side of the robot's input (axis 3)
            in[1] = 0.0;
        }
        return in;
    }
}
