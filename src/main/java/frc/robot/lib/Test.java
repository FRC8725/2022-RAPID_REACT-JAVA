package frc.robot.lib;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

import com.revrobotics.RelativeEncoder;

import frc.robot.Constants;

public class Test {
    public static final double speed = Constants.Test.MOTOR_SPEED;

    CANSparkMax SparkTest;
    RelativeEncoder SparkEncoder;

    public Test() {
        SparkTest = new CANSparkMax(Constants.Test.MOTOR, MotorType.kBrushless);
        SparkEncoder = SparkTest.getEncoder();
    }

    public void Spark_Spin(boolean run) {
        if (run && get_Encoder() <= 1)
            SparkTest.set(speed);
        else if (!run) {
            SparkEncoder.setPosition(0.);
        } else {
            SparkTest.set(0);
        }
    }

    public double get_Encoder() {
        return SparkEncoder.getPosition();
    }

    public void Zero_Encoder() {
        SparkEncoder.setPosition(.0);
        SparkEncoder.setPositionConversionFactor(2);
    }
}
