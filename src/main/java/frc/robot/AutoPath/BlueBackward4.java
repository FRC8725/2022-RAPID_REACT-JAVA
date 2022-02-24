package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueBackward4 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(8.389714900262268, 2.194235214986886, new Rotation2d(-1.8395405375236418)),
        List.of(
            new Translation2d(8.36899463437931, 2.1208589686220103),
            new Translation2d(8.34496419140626, 2.0453356338438446),
            new Translation2d(8.315517135603498, 1.9665859075472554),
            new Translation2d(8.279689931671676, 1.8845234007417844),
            new Translation2d(8.237474645615464, 1.7998655017079983),
            new Translation2d(8.189631645607275, 1.713944239153852),
            new Translation2d(8.13750230285101, 1.6285171453710383),
            new Translation2d(8.082821692445785, 1.5455781193913412),
            new Translation2d(8.027531294249675, 1.4671682901429959),
            new Translation2d(7.973591693743442, 1.3951868796070412),
            new Translation2d(7.922795282894278, 1.3312020659736739),
            new Translation2d(7.8765789610195345, 1.2762618467986027),
            new Translation2d(7.8007329233959535, 1.1939714578118883),
            new Translation2d(7.743321555236744, 1.1391088803443337),
            new Translation2d(7.714576932247677, 1.1141118764568931),
            new Translation2d(7.696544953184606, 1.100792041055632),
            new Translation2d(7.67462283479319, 1.0866192595482103),
            new Translation2d(7.648055065259721, 1.071451786437681),
            new Translation2d(7.616328136984257, 1.0552109338888407),
            new Translation2d(7.536433780352177, 1.0194757263372036),
            new Translation2d(7.434918029719189, 0.9798305804360572),
            new Translation2d(7.376774338433579, 0.958854018414586),
            new Translation2d(7.31436172906909, 0.9373397505089827),
            new Translation2d(7.248305322408966, 0.915492287350653),
            new Translation2d(7.179313557417877, 0.8935339957568651),
            new Translation2d(7.108158355487877, 0.871699448546261),
            new Translation2d(7.03565528468436, 0.8502297743543759),
            new Translation2d(6.962643723992018, 0.8293670074491537),
            new Translation2d(6.8899670275607985, 0.8093484375464568),
            new Translation2d(6.818452688951859, 0.7904009596255861),
            new Translation2d(6.748892505383527, 0.7727354237447956),
            new Translation2d(6.682022741977255, 0.7565409848568052),
            new Translation2d(6.6185042960035805, 0.7419794526243155),
            new Translation2d(6.503669091657324, 0.7182317192196495),
            new Translation2d(6.40741295483708, 0.7020250880216272),
            new Translation2d(6.3302865741617556, 0.693093287073757),
            new Translation2d(6.269730520247473, 0.6901901020687022)
            ),
            new Pose2d(6.219440501578186, 0.6909085704447708, new Rotation2d(-3.112615259738194)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
    }

