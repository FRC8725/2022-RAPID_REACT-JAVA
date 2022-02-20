package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

public class IntakeSubsystem {
    CANSparkMax IntakeMotor;

    public IntakeSubsystem(CANSparkMax IntakeMotor){
        this.IntakeMotor = IntakeMotor;
    }
}
