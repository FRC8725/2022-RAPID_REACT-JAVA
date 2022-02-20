package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueForward1 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(3.9336189210903867, 6.9657129090387375, new Rotation2d(-0.7613516906840638)),
        List.of(
            new Translation2d(4.0159536764170705, 6.89100721703379),
            new Translation2d(4.071533689333018, 6.845748683947409),
            new Translation2d(4.13988737061887, 6.79359071141173),
            new Translation2d(4.220738349095126, 6.734821566698699),
            new Translation2d(4.312184661738096, 6.670649102586641),
            new Translation2d(4.411110963696821, 6.602960409737604),
            new Translation2d(4.513600738309999, 6.534081469074698),
            new Translation2d(4.615348507122913, 6.466536804159428),
            new Translation2d(4.71207203990435, 6.402809133569043),
            new Translation2d(4.799924564663531, 6.345099023273872),
            new Translation2d(4.875906977667032, 6.29508453901466),
            new Translation2d(4.93828005345571, 6.253680898679912),
            new Translation2d(4.986976654861628, 6.220800124683233)
            ),
            new Pose2d(5.053905587411013, 6.173797202248032, new Rotation2d(-0.6226707887570873)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
