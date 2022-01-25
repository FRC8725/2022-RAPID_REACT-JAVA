package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;

// 775 Red line
public class Hopper {

    VictorSPX Riser;

    public Hopper() {
        Riser = new VictorSPX(Constants.Hopper.RISER_MOTOR);
    }

    public void Rise(double speed) {
        Riser.set(ControlMode.PercentOutput, speed);
    }
}
