package frc.robot.subsystem;


import frc.robot.Constants;
import frc.robot.subsystem.DriveSub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import java.util.List;

public class Ramsete {
    private DriveSub DriveSub = new DriveSub();
    public Command getAutoCommand(){
    var voltageConstraint = new DifferentialDriveVoltageConstraint(new SimpleMotorFeedforward(Constants.Driver.Ks_DRIVE, Constants.Driver.Kv_DRIVE, Constants.Driver.Ka_DRIVE), Constants.Sim.m_kinematics, 10);
    TrajectoryConfig config = new TrajectoryConfig(Constants.Driver.MaxVelocity, Constants.Driver.MaxAcceleration).setKinematics(Constants.Sim.m_kinematics).addConstraint(voltageConstraint);
    Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
        List.of(
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0)),
            new Pose2d(0, 0, new Rotation2d(0))
        ), 
        config);
        RamseteCommand ramseteCommand = 
        new RamseteCommand(
            trajectory, 
            DriveSub::getPose, 
            new RamseteController(2, 0.7), 
            new SimpleMotorFeedforward(Constants.Driver.Ks_DRIVE, Constants.Driver.Kv_DRIVE, Constants.Driver.Ka_DRIVE), 
            Constants.Sim.m_kinematics, 
            DriveSub::getWheelSpeeds, 
            new PIDController(0, 0, 0), 
            new PIDController(0, 0, 0), 
            DriveSub::setVoltage,
            DriveSub 
            );

    
}}
