
package frc.robot.subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.lib.Drive;
import frc.robot.Constants;

public class Simulation {
    private CANSparkMax leftfront_SparkMax = new CANSparkMax(Constants.Driver.LEFT_FRONT_MOTOR, MotorType.kBrushless);
    //private CANSparkMax leftback_SparkMax = new CANSparkMax(Constants.Driver.LEFT_BACK_MOTOR, MotorType.kBrushless);
    private CANSparkMax rightfront_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
    //private CANSparkMax rightback_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_BACK_MOTOR, MotorType.kBrushless);
    
    private static final double WheelRadius = Units.inchesToMeters(3.);
    private static final double kVLinear = 0.;
    private static final double kALinear = 0.;
    private static final double kVAngular = 0.; 
    private static final double kAAngular = 0.; 
    private static final double gearing = 0.;
    private static final double trackWidthMeters = 0.;
    private static final double update_time = 0.02;
    private DifferentialDrivetrainSim SimDrivetrain = new DifferentialDrivetrainSim(
        LinearSystemId.identifyDrivetrainSystem(kVLinear, kALinear, kVAngular, kAAngular),
        DCMotor.getNEO(2),
        gearing,
        trackWidthMeters,
        WheelRadius,
        VecBuilder.fill(0.001 ,0.001 ,0.001 ,0.1 ,0.1 ,0.005 ,0.005));
    private EncoderSim SimLeftEncoder;
    private EncoderSim SimRightEncoder;
    private AHRS Simgyro;
    private DifferentialDriveOdometry m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(Simgyro.getAngle()));
    private Field2d field = new Field2d();
    Drive Sim_Drive = new Drive("Spark");

    public Simulation(){
        SmartDashboard.putData("Field", field);
    }

    private void Sim_Odometry_Update(){
        m_odometry.update(Rotation2d.fromDegrees(Simgyro.getAngle()), 
        SimLeftEncoder.getDistance(), 
        SimRightEncoder.getDistance());
    }

    
    public void simulationPeriodic(){
        SimDrivetrain.setInputs(leftfront_SparkMax.get() * RobotController.getInputVoltage(), 
            -rightfront_SparkMax.get() * RobotController.getInputVoltage());
        SimDrivetrain.update(update_time);
        SimLeftEncoder.setDistance(SimDrivetrain.getLeftPositionMeters());
        SimLeftEncoder.setRate(SimDrivetrain.getLeftVelocityMetersPerSecond());
        SimRightEncoder.setDistance(SimDrivetrain.getRightPositionMeters());
        SimRightEncoder.setRate(SimDrivetrain.getLeftVelocityMetersPerSecond());
        Simgyro.setAngleAdjustment(SimDrivetrain.getHeading().getDegrees());
        field.setRobotPose(m_odometry.getPoseMeters());
    }

    public void periodic(){
        Sim_Odometry_Update();
        field.setRobotPose(m_odometry.getPoseMeters());
    }
}
