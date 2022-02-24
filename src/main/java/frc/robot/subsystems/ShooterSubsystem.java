package frc.robot.subsystems;

import frc.robot.commands.ColorSensor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
public class ShooterSubsystem {

    ColorSensor ColorSensor = new ColorSensor();
    TalonFX ShooterLeftMotor;
    TalonFX ShooterRightMotor;
    
    public ShooterSubsystem(TalonFX ShooterLeftMotor, TalonFX ShooterRightMotor){
        this.ShooterLeftMotor = ShooterLeftMotor;
        this.ShooterRightMotor = ShooterRightMotor;
    }

    public void SetSpeed(double Speed){
        ShooterLeftMotor.set(ControlMode.PercentOutput, Speed);
        ShooterRightMotor.set(ControlMode.PercentOutput, -Speed);
    }
}
