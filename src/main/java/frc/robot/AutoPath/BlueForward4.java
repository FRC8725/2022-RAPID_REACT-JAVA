package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueForward4 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(6.320285571305594, 0.6797035626972736, new Rotation2d(-0.07677189126978037)),
        List.of(
            new Translation2d(6.366610608409706, 0.6756009891218344),
            new Translation2d(6.417103841373743, 0.6683552780257669),
            new Translation2d(6.474243208693865, 0.6560114816061713),
            new Translation2d(6.538914531066175, 0.6377394955960805),
            new Translation2d(6.610688490643169, 0.6136455594927028),
            new Translation2d(6.688097610290194, 0.5845837567856718),
            new Translation2d(6.768913232841896, 0.551967515185293),
            new Translation2d(6.850422500358681, 0.5175811068507876),
            new Translation2d(6.929705333383158, 0.48339114861854426),
            new Translation2d(7.003911410196603, 0.45135810223036366),
            new Translation2d(7.070537146075408, 0.4232477745617045),
            new Translation2d(7.12770267254753, 0.40044281784993263),
            new Translation2d(7.174428816648952, 0.38375422992256514),
            new Translation2d(7.2109140801801335, 0.3732328544255221),
            new Translation2d(7.225768596851831, 0.3700465167029856),
            new Translation2d(7.23881161896246, 0.36798088105136806),
            new Translation2d(7.261506222094705, 0.36596334576756195),
            new Translation2d(7.283238867293091, 0.36435455791967364),
            new Translation2d(7.305197477127175, 0.3617012847151848),
            new Translation2d(7.327824897829427, 0.3574798301895896),
            new Translation2d(7.351748115545417, 0.3516506991526178),
            new Translation2d(7.406564362095748, 0.336878472141767),
            new Translation2d(7.439112726680812, 0.32944645188920685),
            new Translation2d(7.476152151757532, 0.32324425373027044),
            new Translation2d(7.518364762860494, 0.31926849006364044),
            new Translation2d(7.566270601366802, 0.3184460155493376),
            new Translation2d(7.620169920484321, 0.321541600689903),
            new Translation2d(7.680085481239914, 0.3290656054115795),
            new Translation2d(7.745704848467675 , 0.3411816526454938),
            new Translation2d(7.81632268679718, 0.3576143019088409),
            new Translation2d(7.890783056641714, 0.37755672288606057),
            new Translation2d(7.967421710186519, 0.39957836901002786),
            new Translation2d(8.044295026712478, 0.4231724921982156),
            new Translation2d(8.082426201339725, 0.43699819643049853),
            new Translation2d(8.120186712510963, 0.45297518235847445),
            new Translation2d(8.157449962032329, 0.471515172113282),
            new Translation2d(8.194089576114457, 0.4928935140115982),
            new Translation2d(8.229980487322692, 0.5172604829246064 ),
            new Translation2d(8.265000016527303, 0.5446525806469689),
            new Translation2d(8.299028954853718, 0.575003836265795),
            new Translation2d(8.331952645632732, 0.6081571065296121),
            new Translation2d(8.363662066350738, 0.6438753762173341),
            new Translation2d(8.39405491059994, 0.6818530585072331),
            new Translation2d(8.45052171629113, 0.7630892578172492),
            new Translation2d(8.500710047668578, 0.8484789918938329),
            new Translation2d(8.544153592201685, 0.9342616261749406),
            new Translation2d(8.580597362274036, 1.0166642159093557),
            new Translation2d(8.610032317590454, 1.0922631179637232),
            new Translation2d(8.632729987584062, 1.1583456026295806),
            new Translation2d(8.660610172419146, 1.2568346389286376)
            ),
            new Pose2d(8.67333719827833, 1.3183890043041782, new Rotation2d(1.3886280163221583)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
