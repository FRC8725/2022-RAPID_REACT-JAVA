package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;

public class Shooter {

    private TalonFX Shooter_Left_TalonFalcon, Shooter_Right_TalonFalcon;

    VictorSPX Riser;

    public Shooter() {
        Shooter_Left_TalonFalcon = new TalonFX(Constants.Shooter.LEFT_SHOOT_MOTOR[0]);
        Shooter_Right_TalonFalcon = new TalonFX(Constants.Shooter.RIGHT_SHOOT_MOTOR[0]);
        Riser = new VictorSPX(Constants.Shooter.RISER_MOTOR);
    }

    public void Shoot(double speed) {
        Shooter_Left_TalonFalcon.set(ControlMode.PercentOutput, speed);
        Shooter_Right_TalonFalcon.set(ControlMode.PercentOutput, -speed);
    }

    public void stop() {
        Shooter_Left_TalonFalcon.set(ControlMode.PercentOutput, 0.);
        Shooter_Right_TalonFalcon.set(ControlMode.PercentOutput, 0.);
    }

    public void Run(double Riser_speed) {
        Riser.set(ControlMode.PercentOutput, Riser_speed);
    }

}
