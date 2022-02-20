package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedForward2 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(12.920035134576755, 7.346683172453372, new Rotation2d(-3.109345771154539)),
        List.of(
            new Translation2d(12.853973401983277, 7.343356910182826),
            new Translation2d(12.81935821193529, 7.339583339970879),
            new Translation2d(12.783084279997, 7.333554013747779),
            new Translation2d(12.744859599825556, 7.32481608525595),
            new Translation2d(12.704507957795041, 7.31305087006516),
            new Translation2d(12.661958834794419, 7.298063146287008),
            new Translation2d(12.617237308025464, 7.27977045528941),
            new Translation2d(12.521794744341413, 7.233439957676037),
            new Translation2d(12.41990907893525, 7.175248400445163),
            new Translation2d(12.314192380072697, 7.107504264645076),
            new Translation2d(12.260875656419662, 7.070993224985634),
            new Translation2d(12.20781682962697, 7.033293112015782),
            new Translation2d(12.155446924619135, 6.994854868562152),
            new Translation2d(12.104191580612914, 6.956135207852553),
            new Translation2d(12.006639614721148, 6.879643143869478),
            new Translation2d(11.9180745998522, 6.807179461063017),
            new Translation2d(11.840677747650638, 6.741514272575547),
            new Translation2d(11.775574671039218, 6.684482886558914),
            new Translation2d(11.722512241753012, 6.636643429037988 )
        
            ),
            new Pose2d(11.642664251362973, 6.562332630129124, new Rotation2d(-2.386488250111132)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
