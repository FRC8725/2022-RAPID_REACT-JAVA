package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedBackward3 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(10.555778499856526, 4.310126072883788, new Rotation2d(0.3487710035839062)),
        List.of(
            new Translation2d(10.625925142186288, 4.337697787032296),
            new Translation2d(10.662377951885944, 4.355522729577707),
            new Translation2d(10.700265241910012, 4.377623182083896),
            new Translation2d(10.739827706110324, 4.404808172828259),
            new Translation2d(10.781200952921745, 4.4376118345877185),
            new Translation2d(10.824424882264074, 4.476316366026733),
            new Translation2d(10.869453062443954, 4.520974993085321),
            new Translation2d(10.916162107056797, 4.5714349303670625),
            new Translation2d(10.96436105188868, 4.62736034252712),
            new Translation2d(11.013800731818261, 4.688255305660247),
            new Translation2d(11.064183157718695, 4.753486768688807),
            new Translation2d(11.11517089335954, 4.822307514750781),
            new Translation2d(11.166396432308668, 4.893879122587782),
            new Translation2d(11.217471574834178, 4.967294927933072),
            new Translation2d(11.267996804806312, 5.04160298489957),
            new Translation2d(11.317570666599353, 5.115829027367871),
            new Translation2d(11.36579914199355, 5.188999430374254),
            new Translation2d(11.412305027077023, 5.260164171498699),
            new Translation2d(11.456737309147673, 5.328419792252896),
            new Translation2d(11.498780543615094, 5.392932359468265),
            new Translation2d(11.538164230902488, 5.452960426683964),
            new Translation2d(11.60815195210949, 5.557197477139752),
            new Translation2d(11.665791698699007, 5.637921638832814),
            new Translation2d(11.711493938541368, 5.69487292313238),
            new Translation2d(11.730431337962361, 5.7153397643796815),
            new Translation2d(11.747288442308058, 5.731475421980786),
            new Translation2d(11.777124344332867, 5.755572072309905),
            new Translation2d(11.847910667690773, 5.813172473312138),
            new Translation2d(11.903946477843746, 5.863798863626277),
            new Translation2d(11.978551866418579, 5.933922093087563),
            new Translation2d(12.02289837721943, 5.976326724641652),
            new Translation2d(12.071680670205858, 6.0233182060147925),
            new Translation2d(12.124544667150136, 6.074494819108161),
            new Translation2d(12.18102985798063, 6.129341217006443),
            new Translation2d(12.24058661198531, 6.187247297998345),
            new Translation2d(12.302593489015297, 6.2475270795971065),
            new Translation2d(12.366374550688377, 6.309437572561015),
            new Translation2d(12.431216671592535, 6.372197654913917),
            new Translation2d(12.496386850489484, 6.435006945965738),
            new Translation2d(12.561149521518189, 6.49706468033299),
            new Translation2d(12.624783865398403, 6.557588581959285),
            new Translation2d(12.686601120634185, 6.615833738135853),
            new Translation2d(12.745961894717441, 6.67111147352205),
            new Translation2d(12.802293475331439, 12.802293475331439),
            new Translation2d(12.855107141554347, 6.770404411524489),
            new Translation2d(12.90401547506276, 6.813493316484713),
            new Translation2d(12.989176850855758, 6.8851999440287255),
            new Translation2d(13.057362133825754, 6.93764875526542),
            new Translation2d(13.110884613688684, 6.973574086849883)            
            ),
            new Pose2d(13.155340297274005, 6.999327932281211, new Rotation2d(0.5084893240797728)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
