package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

// 775 Red line
public class Hopper {

    VictorSPX Riser;
    CANSparkMax Intake;

    public Hopper() {
        Riser = new VictorSPX(Constants.Hopper.RISER_MOTOR);
        Intake = new CANSparkMax(Constants.Hopper.INTAKE_MOTOR, MotorType.kBrushless);
    }

    public void Run(double Riser_speed, double Intake_speed) {
        Riser.set(ControlMode.PercentOutput, -Riser_speed);
        Intake.set(Intake_speed);
    }
}
