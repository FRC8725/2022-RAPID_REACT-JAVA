package frc.robot.lib;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake {

    DoubleSolenoid First_Solenoid,Second_Solenoid;//We decide to use two double solenoids.
    private CANSparkMax Intake_Motor_SparkNeo; // 上升用馬達

    public Intake () {
        First_Solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM ,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[0]);   
        Second_Solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM ,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[1],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[1]);
        Intake_Motor_SparkNeo = new CANSparkMax(Constants.Intake.INTAKE_MOTOR, MotorType.kBrushless);
    }


    public void Set_Neo(double speed){ // 讓馬達旋轉
        Intake_Motor_SparkNeo.set(speed);
    }

    public void Stop_Neo(){
        Intake_Motor_SparkNeo.disable();
    }

    public void Forward(){
        First_Solenoid.set(Value.kForward);
        Second_Solenoid.set(Value.kForward);
    }

    public void Reverse(){
        First_Solenoid.set(Value.kReverse);
        Second_Solenoid.set(Value.kReverse);
    }

    public void Off(){
        First_Solenoid.set(Value.kOff);
        Second_Solenoid.set(Value.kOff);
    }    

}
    
