package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import frc.robot.Constants;

public class PneumaticsCommand {
    private PneumaticsControlModule PCM = new PneumaticsControlModule(Constants.Pneumatic.PCM_CAN);
    private DoubleSolenoid DoubleSolenoid;
    public PneumaticsCommand(){
        DoubleSolenoid = PCM.makeDoubleSolenoid(Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0], Constants.Pneumatic.DOUBLESOLENOID_BACKWARD_CHANNEL[0]);
    }

    public void Pull(){
        PCM.enableCompressorDigital();
    }

    public void SolenoidForward() {
        DoubleSolenoid.set(Value.kForward);
    }

    public void SolenoidReverse(){
        DoubleSolenoid.set(Value.kReverse);
    }

    public void SolenoidOff(){
        DoubleSolenoid.set(Value.kOff);
    }

    public void Stop() {
        PCM.disableCompressor();
        DoubleSolenoid.set(Value.kOff);
    }

}
