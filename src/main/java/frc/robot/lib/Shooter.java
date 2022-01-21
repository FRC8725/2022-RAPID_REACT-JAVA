package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import frc.robot.Constants;

public class Shooter {

    private TalonFX Shooter_Left_TalonFalcon, Shooter_Right_TalonFalcon;

    public Shooter() {
        Shooter_Left_TalonFalcon = new TalonFX(Constants.Shooter.LEFT_SHOOT_MOTOR[0]);
        Shooter_Right_TalonFalcon = new TalonFX(Constants.Shooter.RIGHT_SHOOT_MOTOR[0]);
    }

    public void Shoot(boolean shoot, double speed) {
        if (shoot) {
            Shooter_Left_TalonFalcon.set(ControlMode.PercentOutput, -speed);
            Shooter_Right_TalonFalcon.set(ControlMode.PercentOutput, speed);
        } else {
            Shooter_Left_TalonFalcon.set(ControlMode.PercentOutput, 0.);
            Shooter_Right_TalonFalcon.set(ControlMode.PercentOutput, 0.);
        }
    }

    public void stop() {
        Shooter_Left_TalonFalcon.set(ControlMode.PercentOutput, 0.);
        Shooter_Right_TalonFalcon.set(ControlMode.PercentOutput, 0.);
    }
}
