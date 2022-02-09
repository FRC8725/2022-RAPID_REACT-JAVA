package frc.robot.subsystem;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;

public class AutoShoot extends DriveSub {
    // This class is for AutoShoot.
    // including RotationPID, ShootSpeedController

    Odometry Odometry = new Odometry();
    PIDController o_pid;

    public AutoShoot() {
        SmartDashboard.putNumber("Aim_kp", 0);
        SmartDashboard.putNumber("Aim_ki", 0);
        SmartDashboard.putNumber("Aim_kd", 0);
        SmartDashboard.putNumber("min_Integral", 0);
        SmartDashboard.putNumber("max_Integral", 0);
        o_pid = new PIDController(0, 0, 0);
    }

    double kp, ki, kd, min_Integral, max_Integral;

    public void Aim(double angle) {
        kp = SmartDashboard.getNumber("Aim_kp", 0);
        ki = SmartDashboard.getNumber("Aim_ki", 0);
        kd = SmartDashboard.getNumber("Aim_kd", 0);
        min_Integral = SmartDashboard.getNumber("min_Integral", 0);
        max_Integral = SmartDashboard.getNumber("max_Integral", 0);
        o_pid.setPID(kp, ki, kd);
        o_pid.setTolerance(2);
        o_pid.setIntegratorRange(min_Integral, max_Integral);
        double speed = o_pid.calculate(angle, 0);
        speed = MathUtil.clamp(speed, -0.9, 0.9);
        SmartDashboard.putNumber("diffspeed", speed);
        Move(speed, -speed);
    }

}
