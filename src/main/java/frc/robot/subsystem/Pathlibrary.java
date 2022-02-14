package frc.robot.subsystem;

import java.io.IOException;
import java.nio.file.Path;

import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj.Filesystem;

public class Pathlibrary {

    private static Pathlibrary kInstance;
    public final String trajectoryJSONFolder = "trajectories";
    public static synchronized Pathlibrary getInstance(){
        if(kInstance == null){
            kInstance = new Pathlibrary();
        }
        return kInstance;
    }
    public Path getPathFoilder(){
        return Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSONFolder);
    }
    public Path getPath(String ProjectName){
        return Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSONFolder + "/" + ProjectName);
    }
    

    public Trajectory get_circle(){
        Trajectory trajectory = null;
        String ProjectName = "paths/circle.wpilib.json";
        try{
            Path TrajectoryPath = getPath(ProjectName);
            trajectory = TrajectoryUtil.fromPathweaverJson(TrajectoryPath);
        } catch(IOException ex){
            System.out.println("Unable to open path: " + ProjectName);
        }
        return trajectory;
    }
    
}