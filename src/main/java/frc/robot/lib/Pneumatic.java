package frc.robot.lib;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

import frc.robot.Constants;

public class Pneumatic {
    private Compressor compressor = new Compressor(Constants.Pneumatic.COMPRESSOR);
    private DoubleSolenoid doubleSolenoid_A = new DoubleSolenoid(Constants.Pneumatic.PCM_CAN, Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0], Constants.Pneumatic.DOUBLESOLENOID_BACKWARD_CHANNEL[0]);
    private AnalogPotentiometer PressureSensor = new AnalogPotentiometer(Constants.Pneumatic.SENSOR_A, Constants.Pneumatic.SENSOR_SCALE, Constants.Pneumatic.SENSOR_OFFSET);

    public void Pumping() {
        compressor.start();
    }

    public void Solenoid_A_Release(boolean release) {
        // if actually use this library, turn joystick to boolean.
        if (release) {
            doubleSolenoid_A.set(Value.kForward);
        }
        else {
            doubleSolenoid_A.set(Value.kReverse);
        }

    }

    public void Stop() {
        compressor.stop();
        PressureSensor.close();
        doubleSolenoid_A.set(Value.kOff);
    }

    public double get_PSI() {
        return PressureSensor.get();
    }

    public boolean get_PressureSwitch() {
        return compressor.getPressureSwitchValue();
    }
}
