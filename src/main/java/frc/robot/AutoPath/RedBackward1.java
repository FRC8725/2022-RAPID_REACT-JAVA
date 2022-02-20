package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedBackward1 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(8.101881803156385, 6.360642490674318, new Rotation2d(1.2776094302370176)),
        List.of(
            new Translation2d(8.113998790751975, 6.398574372408493),
            new Translation2d(8.121631065297201, 6.418927253241597),
            new Translation2d(8.130950263196624, 6.4407353170490715),
            new Translation2d(8.155928662883234, 6.489656607245311),
            new Translation2d(8.190558934782999, 6.546269201053622),
            new Translation2d(8.235144730228917, 6.610180711194031),
            new Translation2d(8.288914610699313, 6.679952384306627),
            new Translation2d(8.350268251601344, 6.753376080208016),
            new Translation2d(8.417022646054518, 6.8277512511477765),
            new Translation2d(8.486658308674206, 6.900161921064914),
            new Translation2d(8.556565479355159, 6.967753664844311),
            new Translation2d(8.624290327055018, 7.028010587573181),
            new Translation2d(8.68778115357783, 7.079032303797526),
            new Translation2d(8.74563459735757, 7.119810916778583),
            new Translation2d(8.797341837241637, 7.150507997749283),
            new Translation2d(8.843534796274385, 7.172731565170705),
            new Translation2d(8.88623234548063, 7.189813063988524),
            new Translation2d(8.986956365014473, 7.2270825036676785),
            new Translation2d(9.062975309530746, 7.253395928410095),
            new Translation2d(9.161871159112714, 7.286401543858725),
            new Translation2d(9.219919011314577, 7.305360511823789),
            new Translation2d(9.283327311082516, 7.325807688291899),
            new Translation2d(9.351615508222473, 7.347568516623867),
            new Translation2d(9.424169147175325, 7.370427133725418),
            new Translation2d(9.50026222732143, 7.394133703265352),
            new Translation2d(9.579079563285198, 7.418411748893709),
            new Translation2d(9.659739145239634, 7.442965487459922),
            new Translation2d(9.741314499210906, 7.46748716223099),
            new Translation2d(9.822857047382898, 7.491664376109628),
            new Translation2d(9.903418468401771, 7.515187424852435),
            new Translation2d(9.982073057680516, 7.5377566302880545),
            new Translation2d(10.057940087703512, 7.559089673535332),
            new Translation2d(10.130206168331089, 7.578928928221481),
            new Translation2d(10.198147607104074, 7.597048793700243),
            new Translation2d(10.318744439479472, 7.627432082392172),
            new Translation2d(10.416584690339626, 7.6493539112617235),
            new Translation2d(10.491388687574197, 7.662910389546264),
            new Translation2d(10.546458511198438, 7.669414027051084)
            ),
            new Pose2d(10.58939352309901, 7.671628397130561, new Rotation2d(0.03446910099951338)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
