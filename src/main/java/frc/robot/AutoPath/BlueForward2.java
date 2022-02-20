package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueForward2 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(3.563853665423242, 6.920892878048781, new Rotation2d(-0.7061990924279968)),
        List.of(
            new Translation2d(3.589253047933434, 6.899909049262263),
            new Translation2d(3.6229959176197366, 6.875402625648146),
            new Translation2d(3.67037078304449, 6.845200345892369),
            new Translation2d(3.7337671032191526, 6.8084051049587515),
            new Translation2d(3.8131523074348648, 6.765180525778422),
            new Translation2d(3.9065488150930037, 6.716535530939238),
            new Translation2d(4.010511055535743, 6.664108914375215),
            new Translation2d(4.120602487876614, 6.6099539130559535),
            new Translation2d(4.231872620831058, 6.5563227786760585),
            new Translation2d(4.339334032546993, 6.505451349344568),
            new Translation2d(4.438439390435367, 6.4593436212743764),
            new Translation2d(4.5255584710007195, 6.4195563204716635),
            new Translation2d(4.598455179671737, 6.386983474425314),
            new Translation2d(4.656764570631815, 6.361640983796347)
            ),
            new Pose2d(4.740379478909623, 6.327027467431848 , new Rotation2d(-0.38381762328855856)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
