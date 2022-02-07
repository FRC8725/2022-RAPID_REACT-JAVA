package frc.robot.lib;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

// 775 Red line
public class Intake {
    CANSparkMax Intake;

    public Intake() {
        Intake = new CANSparkMax(Constants.Intake.INTAKE_MOTOR, MotorType.kBrushless);
    }

    public void Run_Intake(double Intake_speed) {
        Intake.set(Intake_speed);
    }
}
