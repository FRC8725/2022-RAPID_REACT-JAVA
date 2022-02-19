package frc.robot.commands;


import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import java.util.List;

public class FollowTrajectory  {
    private DriveSubsystem DriveSubsystem = new DriveSubsystem();
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
            DriveSubsystem::getPose, 
            new RamseteController(2, 0.7), 
            new SimpleMotorFeedforward(Constants.Driver.Ks_DRIVE, Constants.Driver.Kv_DRIVE, Constants.Driver.Ka_DRIVE), 
            Constants.Sim.m_kinematics, 
            DriveSubsystem::getWheelSpeeds, 
            new PIDController(0, 0, 0), 
            new PIDController(0, 0, 0), 
            DriveSubsystem::setVoltage,
            DriveSubsystem 
            );
        DriveSubsystem.resetodometry(trajectory.getInitialPose());
        return ramseteCommand.andThen(() -> DriveSubsystem.tankDrive(0, 0));

    }   
}
