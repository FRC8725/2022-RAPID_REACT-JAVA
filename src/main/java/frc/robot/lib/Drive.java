package frc.robot.lib;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class Drive {
    MotorControllerGroup Motors[] = {};

    private CANSparkMax leftfront_SparkMax;
    private CANSparkMax leftback_SparkMax;
    private CANSparkMax rightfront_SparkMax;
    private CANSparkMax rightback_SparkMax;

    private RelativeEncoder left_Encoder;
    private RelativeEncoder righ_Encoder;

    String Motor_Port_Type;

    public Drive(String Motor_Port_Type) {
        this.Motor_Port_Type = Motor_Port_Type;
        Drive_Setup(Motor_Port_Type);
        Encoder_Setup();
    }

    public void Drive_Setup(String Motor_Port_Type) {
        switch (Motor_Port_Type) {
            case "CAN":
                Motors = Motor_Setup_CAN();
                break;
            case "PWM":
                Motors = Motor_Setup_PWM();
                break;
            case "Spark":
                Motor_Setup_Spark();
                break;
            default:
                System.out.println("Error");
        }
    }

    public void Motor_Run(double LSpeed, double RSpeed) {
        RSpeed = -RSpeed;
        if (Motor_Port_Type == "Spark") {
            if (Math.abs(LSpeed) > 0.08) {
                leftfront_SparkMax.set(LSpeed);
                leftback_SparkMax.set(LSpeed);
            } else {
                leftfront_SparkMax.set(0);
                leftback_SparkMax.set(0);
            }
            if (Math.abs(RSpeed) > 0.08) {
                rightfront_SparkMax.set(RSpeed);
                rightback_SparkMax.set(RSpeed);
            } else {
                rightfront_SparkMax.set(0);
                rightback_SparkMax.set(0);
            }
        } else {
            Motors[0].set(LSpeed);
            Motors[1].set(RSpeed);
        }
    }

    private MotorControllerGroup[] Motor_Setup_CAN() {
        WPI_VictorSPX leftfront_VictorSPX = new WPI_VictorSPX(Constants.Driver.LEFT_FRONT_MOTOR);
        WPI_VictorSPX leftback_VictorSPX = new WPI_VictorSPX(Constants.Driver.LEFT_BACK_MOTOR);
        WPI_VictorSPX rightfront_VictorSPX = new WPI_VictorSPX(Constants.Driver.RIGHT_FRONT_MOTOR);
        WPI_VictorSPX rightback_VictorSPX = new WPI_VictorSPX(Constants.Driver.RIGHT_BACK_MOTOR);

        MotorControllerGroup leftMotors = new MotorControllerGroup(leftfront_VictorSPX, leftback_VictorSPX);
        MotorControllerGroup rightMotors = new MotorControllerGroup(rightfront_VictorSPX, rightback_VictorSPX);

        MotorControllerGroup[] Motors = { leftMotors, rightMotors };

        return Motors;
    }

    private MotorControllerGroup[] Motor_Setup_PWM(){
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

    private void Motor_Setup_Spark() {
        leftfront_SparkMax = new CANSparkMax(Constants.Driver.LEFT_FRONT_MOTOR, MotorType.kBrushless);
        leftback_SparkMax = new CANSparkMax(Constants.Driver.LEFT_BACK_MOTOR, MotorType.kBrushless);
        rightfront_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
        rightback_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_BACK_MOTOR, MotorType.kBrushless);
    }

    public void Encoder_Setup() {
        left_Encoder = leftfront_SparkMax.getEncoder();
        righ_Encoder = rightfront_SparkMax.getEncoder();
    }

    public void Encoder_Zero() {
        left_Encoder.setPosition(0);
        righ_Encoder.setPosition(0);
    }

    public double[] get_Position() {
        double L = left_Encoder.getPosition();
        double R = righ_Encoder.getPosition();
        double Position[] = { L, R };
        return Position;
    }
}
