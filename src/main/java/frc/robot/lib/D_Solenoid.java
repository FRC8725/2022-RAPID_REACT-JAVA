package frc.robot.lib;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Constants;
class D_Solenoid {
    DoubleSolenoid First_Solenoid,Second_Solenoid;
    int number;
    public D_Solenoid (int number) {
        this.number = number;
        if(number == 0 ){
            First_Solenoid = new DoubleSolenoid(null,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[number],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[number]);   
    }   else if(number == 1){
            Second_Solenoid = new DoubleSolenoid(null,Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[number],Constants.Pneumatic.DOUBLESOLENOID_REVERSE_CHANNEL[number]);
    }
}
    public void Run(boolean Is_Forward,int number){
        this.number = number;
        if(number == 0){
            if(Is_Forward){
                First_Solenoid.set(Value.kForward);
            }
            else{
                First_Solenoid.set(Value.kReverse);
            
            }
        }
        else if(number == 1){
            if(Is_Forward){
                Second_Solenoid.set(Value.kForward);
            }
            else{
                Second_Solenoid.set(Value.kReverse);
            }
        }
    }
    public void stop(int number){
        this.number = number;
        if(number == 0){
            First_Solenoid.set(Value.kOff);
        }
        else if(number == 1){
            Second_Solenoid.set(Value.kOff);
        }
    }

    
}
    
