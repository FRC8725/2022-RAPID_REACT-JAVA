package frc.robot.subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.MathUtil;

public class AutoShoot extends DriveSub {
    // This class is for AutoShoot.
    // including RotationPID, ShootSpeedController

    Odometry Odometry = new Odometry();

    public void Aim(double angle) {
        double error = 0 - angle;
        double kp = 1 / 45.f;
        var speed = MathUtil.clamp(kp * error, -1, 1);
        Move(kp * speed, -speed);
    }

}
