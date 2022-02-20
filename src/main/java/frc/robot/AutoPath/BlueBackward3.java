package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueBackward3 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(6.7908958967001425, 2.4725048022955534, new Rotation2d(-2.09263060660930)),
        List.of(
            new Translation2d(6.750848403062233, 2.4024493595977328),
            new Translation2d(6.718484616708068, 2.345793239329451),
            new Translation2d(6.674630830536146, 2.269761083157504),
            new Translation2d(6.618818564399689, 2.1745035988945425),
            new Translation2d(6.586630449769851, 2.120380912753715),
            new Translation2d(6.551827180367047, 2.062557032649675),
            new Translation2d(6.514655302104371, 2.0016247564725225),
            new Translation2d(6.475404417935028, 1.9382520938883765),
            new Translation2d(6.43439845457775, 1.8731637952474953),
            new Translation2d(6.391986929242214, 1.807122880492396),
            new Translation2d(6.348536216354455, 1.7409121680659805),
            new Translation2d(6.304420814282287, 1.6753158038196583),
            new Translation2d(6.260014612060715, 1.6111007899214629),
            new Translation2d(6.215682156117352, 1.548998513764178),
            new Translation2d(6.171769916997839, 1.4896862768734618),
            new Translation2d(6.128597556091255, 1.4337688238159627),
            new Translation2d(6.08644919235554, 1.3817598711074464),
            new Translation2d(6.045564669042908, 1.3340636361209173),
            new Translation2d(5.968272738519613, 1.2525678665407565),
            new Translation2d(5.932045039813495, 5.932045039813495),
            new Translation2d(5.897423131990381, 1.1896233697129084),
            new Translation2d(5.8642944806551025, 1.1644285375032437),
            new Translation2d(5.832449876059258, 1.1426378641104202),
            new Translation2d(5.7712401916786416, 1.105493857101866),
            new Translation2d(5.7083268070366815, 1.0710819427034952),
            new Translation2d(5.67269902658133, 1.0553392027400177),
            new Translation2d(5.63265883916874, 1.0411591286853614),
            new Translation2d(5.5873746932764465, 1.028853887620726),
            new Translation2d(5.5363001483913985, 1.0186420624973618),
            new Translation2d(5.479149994432282, 1.010656147849983),
            new Translation2d(5.415876371171857, 1.0049500455101796),
            new Translation2d(5.34664488765928, 1.0015065603198368),
            new Translation2d(5.271810741642438, 1.0002448958445465),
            new Translation2d(5.191894838990272, 1.0010281500870217),
            new Translation2d(5.107559913115116, 1.0036708112005135),
            new Translation2d(5.019586644395012, 1.0079462532022223),
            new Translation2d(4.928849779596051, 1.0135942316867155),
            new Translation2d(4.836294251294695, 1.0203283795393405),
            new Translation2d(4.74291129730011, 1.0278437026496405),
            new Translation2d(4.649714580076493, 1.0358240756247667),
            new Translation2d(4.557716306165402, 1.0439497375028957),
            new Translation2d(4.467903345608082, 1.0519047874666416 ),
            new Translation2d(4.3812133513678, 1.059384680556474),
            new Translation2d(4.29851087875217, 1.0661037233841286),
            new Translation2d(4.22056350483548, 1.0718025698460236),
            new Translation2d(4.148017947881027, 1.076255716836675),
            new Translation2d(4.08137618676344, 1.0792789999621117),
            new Translation2d(3.9669449871280316, 1.080550984879495),
            new Translation2d(3.919220884217106, 1.078705512861788),
            new Translation2d(3.877483487201494, 1.0752568207863842),
            new Translation2d(3.841152869347431, 1.0703398735180913),
            new Translation2d(3.8093610810664744, 1.0641759489137144)
            ),
            new Pose2d(3.754338797130559, 1.0494688183644074, new Rotation2d(-2.8562632334076126)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
    }

