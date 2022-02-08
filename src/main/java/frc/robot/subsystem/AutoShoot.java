package frc.robot.subsystem;

public class AutoShoot extends DriveSub{
    // This class is for AutoShoot.
    // including RotationPID, ShootSpeedController

    Odometry Odometry = new Odometry();

    public void Aim() {
        double error = 0 - Odometry.get_angle();
        double kp = 1 / 180;
        Move(kp * error, -kp * error);
    }
    
}
