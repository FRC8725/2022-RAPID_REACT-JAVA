package frc.robot.lib;

import java.util.List;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;

public class Trajectorytest {
    TrajectoryConfig configtrajectory = new TrajectoryConfig(3., 3.);
    Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(0, 0, new Rotation2d(0)),
        List.of(
            new Translation2d(0, 0),
            new Translation2d(0, 0),
            new Translation2d(0, 0),
            new Translation2d(0, 0),
            new Translation2d(0, 0),
            new Translation2d(0, 0),
            new Translation2d(0, 0),
            new Translation2d(0, 0)
        ),
        new Pose2d(0, 0, new Rotation2d(0)),
        configtrajectory);
    
}
