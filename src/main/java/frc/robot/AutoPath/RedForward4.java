package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedForward4 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(13.17775031276901, 1.788999329698708, new Rotation2d(2.969401839066854)),
        List.of(
            new Translation2d(13.10146562741697, 1.8009608480065182),
            new Translation2d(13.04487154216809, 1.8081743351120778),
            new Translation2d(12.971459279543234, 1.8166013982906302),
            new Translation2d(12.880990373373207, 1.8263726544632446),
            new Translation2d(12.775186572221969, 1.8375111808435998),
            new Translation2d(12.657263821280035, 1.8499516992870664),
            new Translation2d(12.531466244257864, 1.8635597606397818),
            new Translation2d(12.467107143046832, 1.8707454117470945),
            new Translation2d(12.402600125279251, 1.8781509290877283),
            new Translation2d(12.338557357939562, 1.8857485952015525),
            new Translation2d(12.275567890774719, 1.8935099665058104),
            new Translation2d(12.154902091374913, 1.9094100168069321),
            new Translation2d(12.044299383803995, 1.9256317902910745),
            new Translation2d(11.946154512773031, 1.9419827479943743),
            new Translation2d(11.861094292873393, 1.9583162860381993),
            new Translation2d(11.787511590470139, 1.9745509199782258),
            new Translation2d(11.721099305595414, 1.9906894691535193),
            new Translation2d(11.654240574602833, 2.0077149363537474),
            new Translation2d(11.577876904811653, 2.029492092127577),
            new Translation2d(11.486250012310888, 2.0589685532081665),
            new Translation2d(11.37713776544502, 2.097384592259144),
            new Translation2d(11.3161479480597, 2.119936268427206),
            new Translation2d(11.251247966429837, 2.1445599456066455), 
            new Translation2d(11.182884640296148, 2.1710581864290335),
            new Translation2d(11.11161213296829, 2.1991806209713536),
            new Translation2d(11.038073007000353, 2.2286329094976276),
            new Translation2d(10.962979279866357, 2.2590857052005404),
            new Translation2d(10.887093479635743, 2.290183616943068),
            new Translation2d(10.811209700648877, 2.321554172000104),
            new Translation2d(10.736134659192542, 2.352816778800081),
            new Translation2d(10.662668749175426, 2.3835916896666074),
            new Translation2d(10.591587097803629, 2.413508963560081),
            new Translation2d(10.523620621256148, 2.4422174288193235),
            new Translation2d(10.459437080360384, 2.469393645903205),
            new Translation2d(10.399622136267626, 2.49475087013227),
            new Translation2d(10.294916518768726, 2.539098612066253),
            new Translation2d(10.211827180116455, 2.5740411786009014),
            new Translation2d(10.150151500081812, 2.5995198269667146)
            ),
            new Pose2d(10.073963166714488, 2.6293749107603928, new Rotation2d(2.780834988843236)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
