package frc.robot.lib;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class Test {
    Intake m_Intake = new Intake();
    public static final double speed = Constants.Test.MOTOR_SPEED;
    CANSparkMax SparkTest = new CANSparkMax(Constants.Test.MOTOR, MotorType.kBrushless);

    public void Spark_Spin(boolean run) {
        if (run)
            m_Intake.Set_Neo(speed);
        else
            m_Intake.Stop_Neo();
    }
}
