package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueForward3 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(4.012053975322812, 1.0718788338593974, new Rotation2d(-0.7613516906840638)),
        List.of(
            new Translation2d(4.0762711030069925, 1.1067672777821524),
            new Translation2d(4.182766207616346, 1.1722862079716645),
            new Translation2d(4.2550749017215885, 1.2191319917241366),
            new Translation2d(4.3379508460132215, 1.2740572774848404),
            new Translation2d(4.428129596314782, 1.3349039352139105),
            new Translation2d(4.521531671341464, 1.3989249974892406),
            new Translation2d(4.613689562387149, 1.4630770264994126),
            new Translation2d(4.700174743011448, 1.524312481036616),
            new Translation2d(4.777024678726724, 1.579872083489569),
            new Translation2d(4.841169836685125, 1.6275771868364464),
            new Translation2d(4.926094754261044, 1.695366663029481),
            new Translation2d(4.949043543565096, 1.7166281977155649)
            ),
            new Pose2d(4.964479633859401, 1.7329742909612742, new Rotation2d(0.8329812666744828)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
