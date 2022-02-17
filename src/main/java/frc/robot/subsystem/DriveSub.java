package frc.robot.subsystem;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.List;

import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.lib.Drive;
import frc.robot.Constants;

public class DriveSub extends SubsystemBase {
    static double Move_Speed = Constants.Driver.SPEED;
    private Trajectory m_trajectory;

    private final RamseteController m_RamseteController = new RamseteController();
    private Field2d m_field;

    static Drive Drive = new Drive();
    
    public void Init() {
        m_trajectory = TrajectoryGenerator.generateTrajectory(
            new Pose2d(0, 0, new Rotation2d(0)), 
            List.of(
                new Translation2d(1, 1),
                new Translation2d(2, -1)
            ), 
            new Pose2d(3, 0, new Rotation2d(0)), 
            new TrajectoryConfig(Units.feetToMeters(3), Units.feetToMeters(3)));
        m_field = new Field2d();
        SmartDashboard.putNumber("Drive Speed", Move_Speed);
        SmartDashboard.putData(m_field);
        m_field.getObject("trajetory").setTrajectory(m_trajectory);
    }


    static public void Move(double LSpeed, double RSpeed, boolean helf) {
        Move_Speed = SmartDashboard.getNumber("Drive Speed", Move_Speed);
        if (helf) Move_Speed *= 0.5;
        Drive.Motor_Run(LSpeed * Move_Speed, RSpeed * Move_Speed);
    }

    static public void Drive_Stop() {
        Drive.Motor_Run(0, 0);
    }

    


}
