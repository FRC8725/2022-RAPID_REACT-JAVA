package frc.robot.lib;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class Shooter {
    CANSparkMax ShooterMotor;
    
    Shooter () {
        ShooterMotor = new CANSparkMax (Constants.Shooter.SHOOT_MOTOR[0], MotorType.kBrushless);
    }
}
