package frc.robot.AutoPath;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

import java.util.List;

public class RedBackward2 {
    TrajectoryConfig config;
    Trajectory Trajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(9.917093058249641, 5.7219570490674325, new Rotation2d(0.8465463260467517)),
        List.of(
            new Translation2d(9.986889755958895, 5.806089718775093),
            new Translation2d(10.03023739935402, 5.865563175332937),
            new Translation2d(10.081440827160565, 5.940610570196727),
            new Translation2d(10.140806174945139, 6.0310845833169475),
            new Translation2d(10.20778218513384, 6.134912634193512),
            new Translation2d(10.24376494278672, 6.190778041359681),
            new Translation2d(10.281153083042975, 6.248575306784921),
            new Translation2d(10.319722446992525, 6.307716926997359),
            new Translation2d(10.359231452909771, 6.367584774417429),
            new Translation2d(10.399427123629549, 6.427545048136284),
            new Translation2d(10.440051113923094, 6.486963224694207),
            new Translation2d(10.480845737873995, 6.545219008859021),
            new Translation2d(10.521559996254163, 6.601721284404506),
            new Translation2d(10.561955603899783, 6.6559230648888),
            new Translation2d(10.601813017087274, 6.70733644443282),
            new Translation2d(10.679164956650498, 6.800231484668053),
            new Translation2d(10.752463334246416, 6.878252898912679),
            new Translation2d(10.821241284282822, 6.94114931979191),
            new Translation2d(10.885910432303449, 6.991049943662851),
            new Translation2d(10.947953771018671, 7.032942955523678),
            new Translation2d(11.01204549529211, 7.073014935632598),
            new Translation2d(11.048471557287941, 7.092540695026212),
            new Translation2d(11.089532178982958, 7.111505189589749),
            new Translation2d(11.136101904438798, 7.12977694633853),
            new Translation2d(11.188756283026327, 7.147250013583875),
            new Translation2d(11.247796891038824, 7.163842321808134),
            new Translation2d(11.313276353305124, 7.179494044539714),
            new Translation2d(11.385023364802795, 7.194165959228116),
            new Translation2d(11.462667712271298, 7.207837808118957),
            new Translation2d(11.545665295825154, 7.220506659129004),
            new Translation2d(11.63332315056711, 7.2321852667212045),
            new Translation2d(11.724824468201293, 7.242900432779716),
            new Translation2d(11.819253618646393, 7.252691367484934),
            new Translation2d(11.915621171648809, 7.261608050188524),
            new Translation2d(12.012888918395827, 7.269709590288454),
            new Translation2d(12.109994893128777, 7.277062588104019),
            new Translation2d(12.2058783947562, 7.283739495750874),
            new Translation2d(12.299505008467012, 7.289816978016065),
            new Translation2d(12.389891627343673, 7.295374273233057),
            new Translation2d(12.476131473975343, 7.300491554156767),
            new Translation2d(12.557419122071051, 7.305248288838589),
            new Translation2d(12.633075518072864, 12.633075518072864),
            new Translation2d(12.702573002769046, 7.313984633414733),
            new Translation2d(12.821887702807544, 7.322142670553395),
            new Translation2d(12.915120656716875, 7.330165584592085),
            new Translation2d(12.986052991809071, 7.338327928614877)
            ),
            new Pose2d(13.043290219799143, 7.346683172453369, new Rotation2d(0.1526493283952524)), 
        config);

        public Trajectory getTrajectory(){
            return Trajectory;
        }
}
