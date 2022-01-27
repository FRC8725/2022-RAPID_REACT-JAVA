package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import edu.wpi.first.wpilibj.GenericHID;
import frc.robot.lib.Intake;


public class IntakeSub extends SubsystemBase {
    Intake Intake = new Intake();
    Joystick Intake_Joystick = new Joystick(Constants.Joystick.INTAKE_BUTTON);  
    public void Move(){
        while(Intake_Joystick.getRawButton(Constants.Joystick.INTAKE_BUTTON)){
            Intake.Set_Neo(.1);
        }
    }
     
    
}
