package frc.robot.lib;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;
import frc.robot.Constants;

public class Test {
    public static final double speed = Constants.Test.MOTOR_SPEED;

    CANSparkMax SparkTest;
    public Test() {
        SparkTest = new CANSparkMax(Constants.Test.MOTOR, MotorType.kBrushed);
    }

    public void Spark_Spin(boolean run) {
        if (run)
            SparkTest.set(speed);
        else
            SparkTest.set(0);
    }
}
