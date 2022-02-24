package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
    private final DifferentialDrive Drive;
    private final MotorControllerGroup LeftMotors,RightMotors;
    private final DifferentialDriveOdometry Odometry;
    private Field2d Field = new Field2d();
    private final RelativeEncoder RightEncoder;
    private final RelativeEncoder LeftEncoder;
    

    private final AHRS Gyro;
    private DifferentialDrivetrainSim SimDrivetrain = new DifferentialDrivetrainSim(
        LinearSystemId.identifyDrivetrainSystem(Constants.Sim.KvLINEAR, Constants.Sim.KaLINEAR, Constants.Sim.KvANGULAR, Constants.Sim.KaANGULAR), 
        DCMotor.getNEO(2), 
        Constants.Sim.GEARING, 
        Constants.Sim.TRACK_WIDTH_METER, 
        Constants.Sim.WHEELRADIUS, 
        VecBuilder.fill(0.001, 0.001, 0.001, 0.1, 0.1, 0.005, 0.005));
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

    private EncoderSim LeftEncoder_Sim;
    private EncoderSim RightEncoder_Sim;

    public synchronized void tankDrive(double LeftVelocity, double RightVelocity){
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

    @Override
    public void simulationPeriodic(){

    }



    
}
