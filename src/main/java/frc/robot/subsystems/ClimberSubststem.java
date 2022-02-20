package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;

public class ClimberSubststem {
    WPI_VictorSPX ClimberMotor;

    public ClimberSubststem(WPI_VictorSPX ClimberMotor){
        this.ClimberMotor = ClimberMotor;
    }

    public void ClimberMotorUp(){
        ClimberMotor.set(Constants.Climber.WINCH_ENCODER_SPEED);
    }

    public void ClimberMotorDown(){
        ClimberMotor.set(-Constants.Climber.WINCH_ENCODER_SPEED);
    }

    public void ClimberMotorStop(){
        ClimberMotor.set(0);
    }


}
