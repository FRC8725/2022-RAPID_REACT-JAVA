package frc.robot.commands;


import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

public class FollowTrajectory extends SequentialCommandGroup {
    private DriveSubsystem DriveSubsystem;
    Trajectory Trajectory;
    TrajectoryConfig config = new TrajectoryConfig(
        Constants.Driver.MaxVelocity, 
        Constants.Driver.MaxAcceleration).setKinematics(Constants.Sim.m_kinematics).addConstraint(new DifferentialDriveVoltageConstraint(new SimpleMotorFeedforward(Constants.Driver.Ks_DRIVE, Constants.Driver.Kv_DRIVE, Constants.Driver.Ka_DRIVE), Constants.Sim.m_kinematics, 10));
        
    public FollowTrajectory(DriveSubsystem DriveSubsystem, Trajectory Trajectory){
        this.DriveSubsystem = DriveSubsystem;
        this.Trajectory = Trajectory;
        RamseteCommand ramseteCommand = 
        new RamseteCommand(
            Trajectory, 
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
        
        addCommands(
            new InstantCommand(() -> this.DriveSubsystem.resetOdometry(Trajectory.getInitialPose())),
            ramseteCommand,
            new InstantCommand(() -> this.DriveSubsystem.StopDrive())
        
        );
    }
}
