package frc.robot.lib;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;
class D_Solenoid {
    DoubleSolenoid First_Solenoid,Second_Solenoid;
    boolean Is_Forward;
    public D_Solenoid () {
            First_Solenoid = new DoubleSolenoid(null,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[0]);   
            Second_Solenoid = new DoubleSolenoid(null,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[1],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[1]);
    }
    public void Run(boolean Is_Forward){
        this.Is_Forward = Is_Forward;
            if(Is_Forward){
                First_Solenoid.set(Value.kForward);
            }
            else{
                First_Solenoid.set(Value.kReverse);
            
            }
            if(Is_Forward){
                Second_Solenoid.set(Value.kForward);
            }
            else{
                Second_Solenoid.set(Value.kReverse);
            }
        
    }
    public void stop(int number){
        First_Solenoid.set(Value.kOff);
        Second_Solenoid.set(Value.kOff);

    }

    
}
    
