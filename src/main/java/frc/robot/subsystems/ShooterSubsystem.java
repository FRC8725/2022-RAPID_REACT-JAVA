package frc.robot.subsystems;

import frc.robot.commands.ColorSensor;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
public class ShooterSubsystem {

    ColorSensor ColorSensor = new ColorSensor();
    TalonFX ShooterLeftMotor;
    TalonFX ShooterRightMotor;
    
    public ShooterSubsystem(TalonFX ShooterLeftMotor, TalonFX ShooterRightMotor){
        this.ShooterLeftMotor = ShooterLeftMotor;
        this.ShooterRightMotor = ShooterRightMotor;
    }

    



}
