package frc.robot.subsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;

public class Auto {

    double gyro_kp = 0, gyro_ki = 0, gyro_kd = 0, gyro_min = 0, gyro_max = 1000;
    PIDController gyro_pid;

    public Auto() {
        SmartDashboard.putNumber("Gyro_kp", gyro_kp);
        SmartDashboard.putNumber("Gyro_ki", gyro_ki);
        SmartDashboard.putNumber("Gyro_kd", gyro_kd);
        SmartDashboard.putNumber("Gyro_min", gyro_min);
        SmartDashboard.putNumber("Gyro_max", gyro_max);
    }

    public void setup_Direction_PID() {
        gyro_kp = SmartDashboard.getNumber("Gyro_kp", 0);
        gyro_ki = SmartDashboard.getNumber("Gyro_ki", 0);
        gyro_kd = SmartDashboard.getNumber("Gyro_kd", 0);
        gyro_pid = new PIDController(gyro_kp, gyro_ki, gyro_kd);
        gyro_pid.setIntegratorRange(gyro_min, gyro_max);
    }

    public void Direction_PID_setsetpoint(double setpoint) {
        gyro_pid.setSetpoint(setpoint);
    }

    public double Direction_PID(double measurement) {
        return gyro_pid.calculate(measurement);
    }

    public boolean is_Direction(double positionTolerance) {
        gyro_pid.setTolerance(positionTolerance);
        return gyro_pid.atSetpoint();
    }
}