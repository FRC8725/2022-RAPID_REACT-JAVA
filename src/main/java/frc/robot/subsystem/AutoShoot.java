package frc.robot.subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoShoot extends DriveSub {
    // This class is for AutoShoot.
    // including RotationPID, ShootSpeedController

    Odometry Odometry = new Odometry();

    public void Aim(double angle) {
        double error = 0 - angle;
        double kp = 1 / 180.;
        Move(kp * error, -kp * error);
    }

}
