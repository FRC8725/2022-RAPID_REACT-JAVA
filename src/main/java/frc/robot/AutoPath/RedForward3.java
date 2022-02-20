package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedForward3 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(13.088110250789093, 6.988122924533716, new Rotation2d(-2.62381079497710)),
        List.of(
            new Translation2d(13.031057524974038, 6.9562303446704625),
            new Translation2d(12.965012462428401, 6.922390617731825),
            new Translation2d(12.884509595620445, 6.885484798814189),
            new Translation2d(12.787413363190456, 6.845171536630201),
            new Translation2d(12.67434876370138, 6.80174858388055),
            new Translation2d(12.612638366410893, 6.779104694827348),
            new Translation2d(12.548132009389429, 6.756014307625735),
            new Translation2d(12.481430687933925, 6.732632718197361),
            new Translation2d(12.413201179914724, 6.70912919965784),
            new Translation2d(12.344158253705292, 6.685682674515862),
            new Translation2d(12.275046876111906, 6.66247738687231),
            new Translation2d(12.206624420303381, 6.639698574619387),
            new Translation2d(12.13964287374076, 6.6175281416397205),
            new Translation2d(12.074831046107036, 6.596140330005493),
            new Translation2d(12.012876777236844, 6.575697392177553),
            new Translation2d(11.899980673462107, 6.538209232921965),
            new Translation2d(11.804961785455518, 6.50595743489957),
            new Translation2d(11.730033126183686, 6.479366956099203),
            new Translation2d(11.675044152291482, 6.4582554518437),
            new Translation2d(11.636911417852662, 6.441694785161666),
            new Translation2d(11.609049228120503, 6.427872537159254),
            new Translation2d(11.581920552551196, 6.413308739176071),
            new Translation2d(11.548425307876846, 6.392156916913832),
            new Translation2d(11.504599549067317, 6.360291682340596),
            new Translation2d(11.448754151467226, 6.315920941197767),
            new Translation2d(11.381093964318323, 6.25919735265424),
            new Translation2d(11.303336964281876, 6.191829788960536),
            new Translation2d(11.21833340896104, 6.116694795102946),
            new Translation2d(11.129684990423241, 6.0374480484576765),
            new Translation2d(11.041363988722546, 5.958135818444985),
            new Translation2d(10.957332425422042, 5.882806426183329),
            new Translation2d(5.882806426183329, 5.8151217041435),
            new Translation2d(5.8151217041435, 5.757968455802771),
            new Translation2d(10.7216545375525, 5.680597207084947),
            new Translation2d(10.69148218908134, 5.658780805582069)        
            ),
            new Pose2d(10.66782857733141, 5.643521994835007, new Rotation2d(-2.582993338246277)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
