package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedBackward4 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(10.051553151219508, 2.6853999494978487, new Rotation2d(-0.21729343092302145)),
        List.of(
            new Translation2d(10.106990699001658, 2.674247965325611),
            new Translation2d(10.137321475039272, 2.6699488207633477),
            new Translation2d(10.170452481171885, 2.666981854792793),
            new Translation2d(10.206955768524423, 2.665575980030046),
            new Translation2d(10.24724098348649, 2.665864769240666),
            new Translation2d(10.3400602159366, 2.6716344224018123),
            new Translation2d(10.449423487764614, 2.683772375788341),
            new Translation2d(10.574061182480648, 2.700773324080112),
            new Translation2d(10.641324015396618, 2.710423436454481),
            new Translation2d(10.711328532878987, 2.720414380512948),
            new Translation2d(10.783596172316324, 2.7304003529433647),
            new Translation2d(10.85761339605452, 2.7400243622668583),
            new Translation2d(10.932844434366038, 2.748926644006213),
            new Translation2d(11.008744028419189, 2.7567530758542533),
            new Translation2d(11.084770173247394, 2.763163592842223),
            new Translation2d(11.160396860718441, 2.7678406025081683),
            new Translation2d(11.235126822503757, 2.77049740006532),
            new Translation2d(11.308504273047665, 2.7708865835704763),
            new Translation2d(11.380127652536654, 2.7688084690923818),
            new Translation2d(11.44966236986864, 2.764119505880111),
            new Translation2d(11.51685354562223, 2.7567406915314514),
            new Translation2d(11.581538755025981, 2.7466659871612826),
            new Translation2d(11.64366077092768, 2.7339707325699614),
            new Translation2d(11.703280306763585, 2.7188200614116997),
            new Translation2d(11.815920952741072, 2.682312464290784),
            new Translation2d(11.922789445050238, 2.64057991850789),
            new Translation2d(12.028798136898207, 2.5969502251072134),
            new Translation2d(12.136037826291913, 2.548625882912643),
            new Translation2d(12.24488557689041, 2.492879736212781),
            new Translation2d(12.299812179357817, 2.4618858024969006),
            new Translation2d(12.354937268264662, 2.4288337222953285),
            new Translation2d(12.410115407461577, 2.393849011851702),
            new Translation2d(12.465173014064574, 2.357131882047107),
            new Translation2d(12.519913527772756, 2.3189470199813247),
            new Translation2d(12.574122580186044, 2.279613370554083),
            new Translation2d(12.62757316412289, 2.2394939180463105),
            new Translation2d(12.680030802938003, 2.198985467701382),
            new Translation2d(12.731258719840067, 2.1585084273063746),
            new Translation2d(12.781023007209466, 2.118496588773313),
            new Translation2d(12.875270424636591, 2.0416092950533873),
            new Translation2d(12.96115561176971, 1.9716733044243373),           
            new Translation2d(13.037437868240389, 1.9115985019681414),
            new Translation2d(13.103418654928477, 1.8635279505660378),
            new Translation2d(1.8635279505660378, 1.8443738281674937),
            new Translation2d(13.15910701212915, 1.8285109014985519),
            new Translation2d(13.183328541887374, 1.8158457722082302),
            new Translation2d(13.205384977719959, 1.8061758050455081),
            new Translation2d(13.225550119151878, 1.7991789094405695),
            new Translation2d(13.244173005327884, 1.794403321086059)
        
            ),
            new Pose2d(13.278595382496377, 1.7889993296986981, new Rotation2d(-0.12435499454686752)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
