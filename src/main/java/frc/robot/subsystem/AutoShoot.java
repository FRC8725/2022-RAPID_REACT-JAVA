package frc.robot.subsystem;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;

public class AutoShoot extends DriveSub {
    // This class is for AutoShoot.
    // including RotationPID, ShootSpeedController

    Odometry Odometry = new Odometry();
    

    public void Aim(double angle) {
        double error = 0 - angle;
        double kp = 1 / 46.;
        double speed = kp * error;
        speed = MathUtil.clamp(speed, -0.9, 0.9);
        SmartDashboard.putNumber("diffspeed", speed);
        Move(speed, -speed);
    }

}

