package frc.robot.lib;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class Test {
    public static final double speed = Constants.Test.MOTOR_SPEED;

    public void Spark_Spin(boolean run) {
        CANSparkMax SparkTest = new CANSparkMax(Constants.Test.MOTOR, MotorType.kBrushless);
        if (run)
            SparkTest.set(speed);
        else
            SparkTest.close();
    }
}
