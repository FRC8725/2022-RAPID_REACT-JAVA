package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class BlueBackward1 {
    TrajectoryConfig config;
    public Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(6.552093629674034, 5.1789067054327464, new Rotation2d(2.2253670941182873)),
        List.of(
            new Translation2d(6.494210712879447, 5.259387015267425),
            new Translation2d(6.450443168147573, 5.3266359935415455),
            new Translation2d(6.393352372454477, 5.417961135314837),
            new Translation2d(6.3597585103380565, 5.47267209018681),
            new Translation2d(6.322989200482914, 5.533021320442696),
            new Translation2d(6.283301516877625, 5.598501732196171),
            new Translation2d(6.24102908637666 , 5.668465221619106),
            new Translation2d(6.1965695976501705, 5.742146238944459),
            new Translation2d(6.150372310133782, 5.818685352469167),
            new Translation2d(6.1029255629783785, 5.8971528125570405),
            new Translation2d(6.054744283999899, 5.976572115641649),
            new Translation2d(6.00635749862912, 6.05594356822922),
            new Translation2d(5.95829583886145, 6.134267850901528),
            new Translation2d(5.911079052206719, 6.210569582318783),
            new Translation2d(5.865203510638962, 6.283920883222528),
            new Translation2d(5.821129719546219, 6.353464940438531),
            new Translation2d(5.779269826680312, 6.418439570879672),
            new Translation2d(5.739975131106647, 6.478200785548835),
            new Translation2d(5.703523592153992, 6.532246353541809),
            new Translation2d(5.639820176442381, 6.622031800364168),
            new Translation2d(5.5884417995349995, 6.687508658080899),
            new Translation2d(5.547697818421788, 6.732165899097615),
            new Translation2d(5.513525013486365, 6.764022769583929),
            new Translation2d(5.496755613895589, 6.778703611205508),
            new Translation2d(5.478229841768123, 6.793237434492489),
            new Translation2d(5.467843281213169, 6.800408622030314),
            new Translation2d(5.456499971571678, 6.807496941990596),
            new Translation2d(5.44406820656745, 6.814489663550965),
            new Translation2d(5.430434656047331, 6.821375257054158),
            new Translation2d(5.399196565904974, 6.834784721679197),
            new Translation2d(5.362220029518757 , 6.847655694336518),
            new Translation2d(5.3191886726225315, 6.859935347804798),
            new Translation2d(5.27001305800529, 6.871586467003677),
            new Translation2d(5.153871830212101, 6.892925089975101),
            new Translation2d(5.087660785148839, 6.902605404789515),
            new Translation2d(5.016769897980812, 6.911640403084439),
            new Translation2d(4.941909012204369, 6.920052897980633),
            new Translation2d(4.863880746543652, 6.9278741017383485),
            new Translation2d(4.783558134646045, 6.935142423590413),
            new Translation2d(4.701862264777618, 6.941902267575323),
            new Translation2d(4.619739919518563, 6.948202830370326),
            new Translation2d(4.538141215458643, 6.954096899124515),
            new Translation2d(4.457997242892632, 6.959639649291914),
            new Translation2d(4.380197705515757, 6.9648874424645655),
            new Translation2d(4.305568560119138, 6.969896624205621),
            new Translation2d(4.234849656285239, 6.974722321882427),
            new Translation2d(4.168672376083302, 6.979417242499616),
            new Translation2d(4.107537273764795, 6.98403047053219),
            new Translation2d(4.001607518867707, 6.993182861093911),
            new Translation2d(3.917598577676999, 7.002454036432434)
            ),
            new Pose2d(3.7991588281205146, 7.021737947776179, new Rotation2d(2.9521124957086666)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
    }

