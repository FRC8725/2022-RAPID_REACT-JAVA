package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    private final DifferentialDrive Drive;
    private final MotorControllerGroup LeftMotors,RightMotors;
    private final DifferentialDriveOdometry Odometry;
    private final Field2d Field;
    private final RelativeEncoder RightEncoder;
    private final RelativeEncoder LeftEncoder;
    private final AHRS Gyro;

    public DriveSubsystem(DifferentialDrive Drive,
    AHRS Gyro, 
    MotorControllerGroup LeftMotors, 
    MotorControllerGroup RightMotors, 
    RelativeEncoder RightEncoder,
    RelativeEncoder LeftEncoder,
    DifferentialDriveOdometry Odometry,
    Field2d Field){
        this.Gyro = Gyro;
        this.Drive = Drive;
        this.RightMotors = RightMotors;
        this.LeftMotors = LeftMotors;
        this.Odometry = Odometry;
        this.Field = Field;
        this.RightEncoder = RightEncoder;
        this.LeftEncoder = LeftEncoder;
        SmartDashboard.putData("Field", Field);
    }

    public void tankDrive(double LeftVelocity, double RightVelocity){
        LeftMotors.set(LeftVelocity);
        RightMotors.set(RightVelocity);
        Drive.feed();
    }
    public void setVoltage(double LeftVoltage, double RightVoltage){
        LeftMotors.setVoltage(LeftVoltage);
        RightMotors.setVoltage(RightVoltage);
    }

    public void resetEncoder(){
        RightEncoder.setPosition(0);
        LeftEncoder.setPosition(0);
    }

    public Pose2d getPose(){
        return Odometry.getPoseMeters();
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds(){
        return new DifferentialDriveWheelSpeeds(LeftEncoder.getVelocity(),RightEncoder.getVelocity());
    }

    public void resetOdometry(Pose2d Pose){
        resetEncoder();
        Odometry.resetPosition(Pose, Gyro.getRotation2d());
    }

    public void resetHeading(){
        Gyro.reset();
    }

    public double getHeading(){
        return Gyro.getAngle();
    }

    public void setMaxOutput(double MaxOutput){
        Drive.setMaxOutput(MaxOutput);
    }

    public void StopDrive(){
        Drive.stopMotor();
    }

    @Override
    public void periodic(){
        Field.setRobotPose(Odometry.getPoseMeters());
        Odometry.update(Gyro.getRotation2d(), LeftEncoder.getPosition(), RightEncoder.getPosition());
    }



    
}
