package frc.robot.lib;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsControlModule;

import frc.robot.Constants;

public class Pneumatic {
    // private Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    private PneumaticsControlModule PCM = new PneumaticsControlModule(Constants.Pneumatic.PCM_CAN);
    private DoubleSolenoid doubleSolenoid;
    // Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0],
    // Constants.Pneumatic.DOUBLESOLENOID_BACKWARD_CHANNEL[0]);
    // private AnalogPotentiometer PressureSensor = new
    // AnalogPotentiometer(Constants.Pneumatic.SENSOR_A,
    // Constants.Pneumatic.SENSOR_SCALE, Constants.Pneumatic.SENSOR_OFFSET);

    public Pneumatic() {
        doubleSolenoid = PCM.makeDoubleSolenoid(Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0], Constants.Pneumatic.DOUBLESOLENOID_BACKWARD_CHANNEL[0]);
    }

    public void Pumping() {
        PCM.enableCompressorDigital();

    }

    public void Solenoid_Release(boolean release) {
        // if actually use this library, turn joystick to boolean.
        if (release) {
            doubleSolenoid.set(Value.kForward);
        } else {
            doubleSolenoid.set(Value.kReverse);
        }

    }

    public void Stop() {
        // PressureSensor.close();
        PCM.disableCompressor();
        doubleSolenoid.set(Value.kOff);
    }

    // public double get_PSI() {
    // return PressureSensor.get();
    // }

}
