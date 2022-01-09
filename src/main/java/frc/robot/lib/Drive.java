package frc.robot.lib;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Drive {
    private final static double MOTOR_PULSE = Constants.Driver.ENCODER_PULSE;
    private final static double MOTOR_PERIMETER = Constants.Driver.MOTOR_PERIMETER;
    private final static double MAX_PERIOD = .1;

    public MotorControllerGroup[] Drive_Setup(String Motor_Port_Type) {
        MotorControllerGroup Motors[] = {};
        switch (Motor_Port_Type) {
            case "CAN":
                Motors = Motor_Setup_CAN();
                break;
            case "PWM":
                Motors = Motor_Setup_PWM();
                break;
            default:
                System.out.println("Error");
        }
        return Motors;
    }

    private MotorControllerGroup[] Motor_Setup_CAN() {
        WPI_VictorSPX leftfront_VictorSPX = new WPI_VictorSPX(Constants.Driver.LEFT_FRONT_MOTOR);
        WPI_VictorSPX leftback_VictorSPX = new WPI_VictorSPX(Constants.Driver.LEFT_BACK_MOTOR);
        WPI_VictorSPX rightfront_VictorSPX = new WPI_VictorSPX(Constants.Driver.RIGHT_FRONT_MOTOR);
        WPI_VictorSPX rightback_VictorSPX = new WPI_VictorSPX(Constants.Driver.RIGHT_BACK_MOTOR);

        MotorControllerGroup leftMotors = new MotorControllerGroup(leftfront_VictorSPX, leftback_VictorSPX);
        MotorControllerGroup rightMotors = new MotorControllerGroup(rightfront_VictorSPX, rightback_VictorSPX);

        leftMotors.setInverted(true);

        MotorControllerGroup[] Motors = { leftMotors, rightMotors };

        return Motors;
    }

    private MotorControllerGroup[] Motor_Setup_PWM() {
        PWMVictorSPX leftfront_VictorSPX = new PWMVictorSPX(Constants.Driver.LEFT_FRONT_MOTOR);
        PWMVictorSPX leftback_VictorSPX = new PWMVictorSPX(Constants.Driver.LEFT_BACK_MOTOR);
        PWMVictorSPX rightfront_VictorSPX = new PWMVictorSPX(Constants.Driver.RIGHT_FRONT_MOTOR);
        PWMVictorSPX rightback_VictorSPX = new PWMVictorSPX(Constants.Driver.RIGHT_BACK_MOTOR);

        MotorControllerGroup leftMotors = new MotorControllerGroup(leftfront_VictorSPX, leftback_VictorSPX);
        MotorControllerGroup rightMotors = new MotorControllerGroup(rightfront_VictorSPX, rightback_VictorSPX);

        leftMotors.setInverted(true);

        MotorControllerGroup[] Motors = { leftMotors, rightMotors };

        return Motors;
    }

    public Encoder[] Encoder_Setup() {
        Encoder Left_Motor_Encoder = new Encoder(Constants.Driver.LEFT_ENCODER, Constants.Driver.LEFT_ENCODER + 1, false, Encoder.EncodingType.k1X);
        Encoder Right_Motor_Encoder = new Encoder(Constants.Driver.RIGHT_ENCODER, Constants.Driver.RIGHT_ENCODER + 1, false, Encoder.EncodingType.k1X);
        Left_Motor_Encoder.setDistancePerPulse(MOTOR_PERIMETER / MOTOR_PULSE);
        Right_Motor_Encoder.setDistancePerPulse(MOTOR_PERIMETER / MOTOR_PULSE);
        Left_Motor_Encoder.setMaxPeriod(MAX_PERIOD);
        Right_Motor_Encoder.setMaxPeriod(MAX_PERIOD);
        Encoder[] Motor_Encoder = { Right_Motor_Encoder, Left_Motor_Encoder };
        return Motor_Encoder;
    }

    public double[] DriveDistance(Encoder Right_Motor_Encoder, Encoder Left_Motor_Encoder) {
        double[] Distance = { Right_Motor_Encoder.getDistance(), Left_Motor_Encoder.getDistance() };
        return Distance;
    }

    public void Encoder_Zero(Encoder Right_Motor_Encoder, Encoder Left_Motor_Encoder) {
        Right_Motor_Encoder.reset();
        Left_Motor_Encoder.reset();
    }
}
