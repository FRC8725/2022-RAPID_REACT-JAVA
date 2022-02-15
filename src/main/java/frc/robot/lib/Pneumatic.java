package frc.robot.lib;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

import frc.robot.Constants;

public class Pneumatic {
    private Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    private DoubleSolenoid doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0], Constants.Pneumatic.DOUBLESOLENOID_BACKWARD_CHANNEL[0]);
    private AnalogPotentiometer PressureSensor = new AnalogPotentiometer(Constants.Pneumatic.SENSOR_A, Constants.Pneumatic.SENSOR_SCALE, Constants.Pneumatic.SENSOR_OFFSET);

    public void Pumping() {
        compressor.enableDigital();
    }

    public void Solenoid_Release(boolean release) {
        // if actually use this library, turn joystick to boolean.
        if (release) {
            doubleSolenoid.set(Value.kForward);
        }
        else {
            doubleSolenoid.set(Value.kReverse);
        }

    }

    public void Stop() {
        compressor.disable();;
        PressureSensor.close();
        doubleSolenoid.set(Value.kOff);
    }

    public double get_PSI() {
        return PressureSensor.get();
    }

    public boolean get_PressureSwitch() {
        return compressor.getPressureSwitchValue();
    }
}
