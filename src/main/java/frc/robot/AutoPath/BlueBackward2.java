package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueBackward2 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(6.072205272386661, 4.394698902060697, new Rotation2d(3.0011496486258773)),
        List.of( 
            new Translation2d(6.02312607201091, 4.403148351852772),            
            new Translation2d(5.994731278570086, 4.410516024079486),            
            new Translation2d(5.962264822000414, 4.42122911522134),            
            new Translation2d(5.924967217466922, 4.435942743584489),            
            new Translation2d(5.882345356432073, 4.455106167085896),            
            new Translation2d(5.780353530141739, 4.507650716138875),            
            new Translation2d(5.721127056217975, 4.541051935948662),            
            new Translation2d(5.656818381105097, 4.578976668384302),            
            new Translation2d(5.587929322618777, 4.621096336700539),            
            new Translation2d(5.515093292818535, 4.666977090676426),            
            new Translation2d(5.439052834332143, 4.716096571100897),            
            new Translation2d(5.360637156680026, 4.767860674258358),            
            new Translation2d(5.280739672599665, 4.82162031641427),            
            new Translation2d(5.200295534370001, 4.876688198300724 ),            
            new Translation2d(5.120259170135834, 4.932355569602028),            
            new Translation2d(5.041581820232227, 4.98790899344029),            
            new Translation2d(4.96518907350891 , 5.042647110861),            
            new Translation2d(4.89195840365468, 5.0958974053186115),            
            new Translation2d(4.822696705521807, 5.147032967162127),            
            new Translation2d(4.758117831450428, 5.1954892581206735),            
            new Translation2d(4.6988201275929615, 5.2407808757890955),            
            new Translation2d(4.645263970238499, 5.282518318113526),            
            new Translation2d(4.556393168824764, 5.354352757184933),            
            new Translation2d(4.491575420582807, 5.410431616382),            
            new Translation2d(4.4472355258348095, 5.4528012694498305),            
            new Translation2d(4.415434254232422, 5.4866518863701526),            
            new Translation2d(4.385133621194377, 5.521082897768569),            
            new Translation2d(4.35016426342402, 5.567117095967477),            
            new Translation2d(4.307544294055809, 5.632002168959649),            
            new Translation2d(4.255894202515242, 5.718860352590343),            
            new Translation2d(4.1951752629988714, 5.827377031764323),            
            new Translation2d(4.161705118233895, 5.888888686487033),            
            new Translation2d(4.126427942954317, 5.954489341652877),            
            new Translation2d(4.089599502177823, 6.02347969877294),            
            new Translation2d(4.051510311560289, 6.095074768900833),            
            new Translation2d(4.012477462660792, 6.16842539142043),            
            new Translation2d(3.9728364482065985, 6.242639752833573),            
            new Translation2d(3.932932987358173, 6.316804905547797),
            new Translation2d(3.8931148509741753, 6.39000828666405),            
            new Translation2d(3.853723686876462, 6.46135923676441 ),            
            new Translation2d(3.815086845115085, 6.5300105186998065),            
            new Translation2d(3.7775092032332966, 6.595179836377737),            
            new Translation2d(3.741264991532545, 6.656171353549988),            
            new Translation2d(3.6736714952609395, 6.763399053332362),            
            new Translation2d(3.6135766139458374, 3.6135766139458374),
            new Translation2d(3.586468122758964 , 6.882871219491449),
            new Translation2d(3.561237066324006, 6.91173649094995),
            new Translation2d(3.515634440703431, 6.955776951426943)            
            ),
            new Pose2d(3.4742136034433293, 6.988122924533718, new Rotation2d(2.503631654320273)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
