/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//Import libraries for the COM-based motor controllers
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class MotorController {
    //Initializing the variable for the motors
    VictorSPX Motor1 = new VictorSPX(0);
    VictorSPX Motor2 = new VictorSPX(1);
    VictorSPX Motor3 = new VictorSPX(2);
    VictorSPX Motor4 = new VictorSPX(3);
    
    //Motor Driving method
    public void drive(Double[] var){
        Motor1.set(ControlMode.PercentOutput, var[0]); //Sets the first motor to a certain input value % of speed
        Motor2.set(ControlMode.PercentOutput, -var[1]);    //Sets the first motor to a certain input value % of speed

        Motor3.follow(Motor1);  //Follows the % speed of motor 1
        Motor4.follow(Motor2);  //Follows the % speed of motor 2
    }
}
