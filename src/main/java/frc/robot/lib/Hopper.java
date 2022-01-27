package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;

// 775 Red line
public class Hopper {

    VictorSPX Riser, Intake;

    public Hopper() {
        Riser = new VictorSPX(Constants.Hopper.RISER_MOTOR);
    }

    public void Run(double Riser_speed, double Intake_speed) {
        Riser.set(ControlMode.PercentOutput, Riser_speed);
        Intake.set(ControlMode.PercentOutput, Intake_speed);
    }
}
