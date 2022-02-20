package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedForward1 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(10.600598530846487, 7.67162839713056, new Rotation2d(-3.0853141173010314)),
        List.of(
            new Translation2d(10.550400667621169,7.669542653567669),
            new Translation2d(10.524464195337389,7.669723986421017),
            new Translation2d(10.497603623359426,7.671200960006403),
            new Translation2d(10.469599285738342,7.6742184757598535),
            new Translation2d(10.440272197853492,7.678938020762617),
            new Translation2d(10.377122092148271,7.693753910475699),
            new Translation2d(10.307439122924865,7.715537196287383),
            new Translation2d(10.230998436884116,7.743288060020554),
            new Translation2d(10.147983725130125,7.7753414203580595),
            new Translation2d(10.058906437553803,7.809590055021521),
            new Translation2d(9.9645249972164,7.843707722950141),
            new Translation2d(9.865764014733031,7.8753722864795135),
            new Translation2d(9.763633502656225,7.902488833520436),
            new Translation2d(9.659148089859446,7.923412799737715),
            new Translation2d(9.553246235920637,7.937173090728981),
            new Translation2d(9.446709445505752,7.943695204203492),
            new Translation2d(9.340081482752282,7.944024352160949),
            new Translation2d(9.233587585652804,7.940548583070302),
            new Translation2d(9.128411487893022,7.936319381246832),
            new Translation2d(9.030046130525845,7.9319270053012145),
            new Translation2d(8.943187466028386,7.927212128045421),
            new Translation2d(8.870497188116481,7.922023116159657),
            new Translation2d(8.812902792605838,7.916219877126481),
            new Translation2d(8.769897638273193,7.909677706164919),
            new Translation2d(8.753389397422307,7.906095705257573),
            new Translation2d(8.739841007717471,7.902291133164585),
            new Translation2d(8.734074089172985,7.900302335085984),
            new Translation2d(8.728919408815802,7.898254442677065),
            new Translation2d(8.724330192961126,7.8961465264499235),
            new Translation2d(8.720258168220946,7.8939777696197995),
            new Translation2d(8.716653854532202,7.891747471861854),
            new Translation2d(8.713466858184992,7.889455053067941),
            new Translation2d(8.71064616485074,7.887100057103373),
            new Translation2d(8.708140432610389,7.884682155563702),
            new Translation2d(8.705898284982577,7.882201151531481),
            new Translation2d(8.703868603951841,7.879656983333044),
            new Translation2d(8.700245220118235,7.874379606502372),
            new Translation2d(8.693396117243744,7.863080060348947),
            new Translation2d(8.68946316340871,7.857069932731427),
            new Translation2d(8.684782938614145,7.850831924357738),
            new Translation2d(8.679110621568487,7.844378728106857),
            new Translation2d(8.672261787845809,7.837725922058348),
            new Translation2d(8.664121786787746,7.830892089709052),
            new Translation2d(8.654655118405394,7.823898940189785),
            new Translation2d(8.632051794471014,7.8095378756345895),
            new Translation2d(8.60610715179339,7.794883482352941),
            new Translation2d(8.592701768525025,7.787300870992513),
            new Translation2d(8.578740276200714,7.778425966934895),
            new Translation2d(8.563774290605743,7.767189340527952),
            new Translation2d(8.547465513956716,7.752750150150582),
            new Translation2d(8.529577560166565,7.734480153392796),
            new Translation2d(8.509967780109548,7.711947718235782),
            new Translation2d(8.465431781088594,7.653256123685214),
            new Translation2d(8.414280423184492,7.5765469430149235),
            new Translation2d(8.35791322102916,7.483814234524672),
            new Translation2d(8.298444706075795,7.378662896060313),
            new Translation2d(8.268339383752929,7.3228713231461455),
            new Translation2d(8.23844283507891,7.265797022776184),
            new Translation2d(8.209103984992636,7.20811581511956),
            new Translation2d(8.180667398574332,7.150508264897486),
            new Translation2d(8.127808429359227,7.038164185482669),
            new Translation2d(8.082224610972117,6.933696618185824),
            new Translation2d(8.045681686172891,6.841090025019055),
            new Translation2d(8.019090865422829,6.7628698541148715),
            new Translation2d(8.002247235364607,6.699590897488573),
            new Translation2d(7.997047015276006,6.673062983795449),
            new Translation2d(7.993568167302325,6.649325648800634)

            ),
            new Pose2d(7.9898317256815155, 6.607152661119081, new Rotation2d(-1.6396528160958104)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
