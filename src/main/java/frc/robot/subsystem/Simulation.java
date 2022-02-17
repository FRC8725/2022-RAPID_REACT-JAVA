
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
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

public class Simulation {
    private CANSparkMax leftfront_SparkMax = new CANSparkMax(Constants.Driver.LEFT_FRONT_MOTOR, MotorType.kBrushless);
    private CANSparkMax leftback_SparkMax = new CANSparkMax(Constants.Driver.LEFT_BACK_MOTOR, MotorType.kBrushless);
    private CANSparkMax rightfront_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
    private CANSparkMax rightback_SparkMax = new CANSparkMax(Constants.Driver.RIGHT_BACK_MOTOR, MotorType.kBrushless);
    
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
    private DifferentialDriveKinematics m_kinematics = new DifferentialDriveKinematics(trackWidthMeters);
    private Field2d field = new Field2d();
    private static final double ks_simple_motor = 0.;
    private static final double kv_simple_motor = 0.;

    private final SimpleMotorFeedforward m_Feedforward = new SimpleMotorFeedforward(ks_simple_motor, kv_simple_motor);
    private final PIDController left_PID = new PIDController(0, 0, 0);
    private final PIDController right_PID = new PIDController(0, 0, 0);
    public Simulation(){
        SmartDashboard.putData("Field", field);
    }

    public void Sim_Odometry_Update(){
        m_odometry.update(Rotation2d.fromDegrees(Simgyro.getAngle()), 
        SimLeftEncoder.getDistance(), 
        SimRightEncoder.getDistance());
    }

    public void setspeed(DifferentialDriveWheelSpeeds speeds){
        final double leftforward = m_Feedforward.calculate(speeds.leftMetersPerSecond);
        final double rightforward = m_Feedforward.calculate(speeds.rightMetersPerSecond);
        final double left_output = left_PID.calculate(SimLeftEncoder.getRate(), speeds.leftMetersPerSecond);
        final double right_output = right_PID.calculate(SimRightEncoder.getRate(), speeds.rightMetersPerSecond);
        leftfront_SparkMax.setVoltage(leftforward + left_output);
        leftback_SparkMax.setVoltage(leftforward + left_output);
        rightfront_SparkMax.setVoltage(rightforward + right_output);
        rightback_SparkMax.setVoltage(rightforward + right_output);
    }

    public void drive(double Speed, double rotation){
        var wheelSpeeds = m_kinematics.toWheelSpeeds(new ChassisSpeeds(Speed, 0., rotation));
        setspeed(wheelSpeeds);
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
