package frc.robot.lib;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
class Intake {
    DoubleSolenoid First_Solenoid,Second_Solenoid;//We decide to use two double solenoids.
    public Intake () {
        First_Solenoid = new DoubleSolenoid(null,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[0]);   
        Second_Solenoid = new DoubleSolenoid(null,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[1],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[1]);
    }
    private CANSparkMax Neo = new CANSparkMax(10, MotorType.kBrushless);
    public void Set_Neo(int speed){
        Neo.set(speed);
    }
    public void Stop_Neo(){
        Neo.disable();
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
    
