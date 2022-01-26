package frc.robot.lib;

import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import com.revrobotics.RelativeEncoder;

import frc.robot.Constants;

public class Test {
    public static final double speed = Constants.Test.MOTOR_SPEED;

    CANSparkMax SparkTest;
    VictorSPX VictorTest;
    RelativeEncoder SparkEncoder;
    Encoder m_Encoder;

    public Test() {
        // SparkTest = new CANSparkMax(Constants.Test.MOTOR, MotorType.kBrushless);
        // SparkEncoder = SparkTest.getEncoder();
        VictorTest = new VictorSPX(Constants.Test.MOTOR);
        m_Encoder = new Encoder(Constants.Test.ENCODER[0], Constants.Test.ENCODER[1], false, EncodingType.k2X);
        m_Encoder.setMinRate(20);
        m_Encoder.setDistancePerPulse(Constants.DataSheet.CIMCODER_PPR / 360.);
    }

    public void Motor_Spin(boolean run) {
        if (run && get_Encoder() < 1)
            // SparkTest.set(speed);
            VictorTest.set(ControlMode.PercentOutput, speed);
        else if (!run) {
            // SparkEncoder.setPosition(0.);
            m_Encoder.reset();
            VictorTest.set(ControlMode.PercentOutput, 0);
        } else {
            // SparkTest.set(0.);
            VictorTest.set(ControlMode.PercentOutput, 0);
        }
    }

    public void Motor_Stop() {
        VictorTest.set(ControlMode.PercentOutput, 0);
    }

    public double get_Encoder() {
        // return SparkEncoder.getPosition();
        return m_Encoder.getDistance();
    }

    public void Zero_Encoder() {
        // SparkEncoder.setPosition(.0);
        // SparkEncoder.setPositionConversionFactor(2);
        m_Encoder.reset();
    }
}
