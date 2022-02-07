package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Shooter {

    private TalonFX Shooter_Left_TalonFalcon, Shooter_Right_TalonFalcon;
    private VictorSPX lid; // 775 Red line
    private Encoder lid_Encoder;
    private AnalogPotentiometer Ultrasonic;

    
    VictorSPX Riser;
    CANSparkMax Intake;

    public Shooter() {
        Shooter_Left_TalonFalcon = new TalonFX(Constants.Shooter.LEFT_SHOOT_MOTOR[0]);
        Shooter_Right_TalonFalcon = new TalonFX(Constants.Shooter.RIGHT_SHOOT_MOTOR[0]);
    }

    public void Shoot(double speed) {
        Shooter_Left_TalonFalcon.set(ControlMode.PercentOutput, speed);
        Shooter_Right_TalonFalcon.set(ControlMode.PercentOutput, -speed);
    }

    public void stop() {
        Shooter_Left_TalonFalcon.set(ControlMode.PercentOutput, 0.);
        Shooter_Right_TalonFalcon.set(ControlMode.PercentOutput, 0.);
    }

    public void Lid(double speed) {
        lid.set(ControlMode.PercentOutput, speed);
    }

    public void zero_LidEncoder() {
        lid_Encoder.reset();
    }

    public double get_LidEncoder() {
        return lid_Encoder.getDistance();
    }

    public void Hopper() {
        Riser = new VictorSPX(Constants.Shooter.RISER_MOTOR);
    }

    public void Run(double Riser_speed) {
        Riser.set(ControlMode.PercentOutput, -Riser_speed);
    }
    
    public double get_Ultrasonic() {
        Ultrasonic = new AnalogPotentiometer(0, 4000, 30);
        return Ultrasonic.get();
    }
}
