package frc.robot.lib;

import frc.robot.Constants;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.math.geometry.Pose2d;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.kauailabs.navx.frc.AHRS;

public class Drive {


    private RelativeEncoder left_Encoder;
    private RelativeEncoder right_Encoder;
    private CANSparkMax leftfront_SparkMax = new CANSparkMax(Constants.Driver.LEFT_FRONT_MOTOR, MotorType.kBrushless);
    private CANSparkMax leftback_SparkMax = new CANSparkMax(Constants.Driver.LEFT_BACK_MOTOR, MotorType.kBrushless);
    private CANSparkMax rightfront_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
    private CANSparkMax rightback_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_BACK_MOTOR, MotorType.kBrushless);
    MotorControllerGroup left_motor = new MotorControllerGroup(leftfront_SparkMax, leftback_SparkMax);
    MotorControllerGroup right_motor = new MotorControllerGroup(rightfront_SparkMax, rightback_SparkMax);
    DifferentialDrive m_drive = new DifferentialDrive(left_motor, right_motor);
    private final AHRS m_gyro = new AHRS(Port.kMXP);
    private final DifferentialDriveOdometry m_odometry;

    public Drive() {
        Encoder_Setup();
        Encoder_Reset();
        m_odometry = new DifferentialDriveOdometry(m_gyro.getRotation2d());

    }
    public void UpdateOdometry(){
        m_odometry.update(m_gyro.getRotation2d(), left_Encoder.getPosition(), right_Encoder.getPosition());
    }

    public Pose2d getPose(){
        return m_odometry.getPoseMeters();
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeeds(){
        return new DifferentialDriveWheelSpeeds(left_Encoder.getVelocity(), right_Encoder.getVelocity());
    }

    public void resetodometry(Pose2d pose){
        Encoder_Reset();
        m_odometry.resetPosition(pose, m_gyro.getRotation2d());
    }

    public void tankDrive(double leftVelocity, double rightVelocity){
        m_drive.tankDrive(leftVelocity, rightVelocity);
    }

    public void setVoltage(double leftVoltage, double rightVoltage){
        left_motor.setVoltage(leftVoltage);
        right_motor.setVoltage(rightVoltage);
        m_drive.feed();
    }

    public void Motor_Run(double LSpeed, double RSpeed) {
        RSpeed = -RSpeed;
        if (Math.abs(LSpeed) > 0.08) {
            left_motor.set(LSpeed);
        } else {
            left_motor.set(0);
        }
        if (Math.abs(RSpeed) > 0.08) {
            right_motor.set(RSpeed);
        } else {
            right_motor.set(0);
            }
        }
    

    public void Encoder_Setup() {
        left_Encoder = leftfront_SparkMax.getEncoder();
        right_Encoder = rightfront_SparkMax.getEncoder();
    }

    public void Encoder_Reset() {
        left_Encoder.setPosition(0);
        right_Encoder.setPosition(0);
    }

    public double getLeftPosition() {
        return left_Encoder.getPosition();
    }
    public double getRightPosition(){
        return right_Encoder.getPosition();
    }

    public void zeroHeaing(){
        m_gyro.reset();
    }

    public double getHeading(){
        return m_gyro.getAngle();
    }
}
