package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;

public class Auto {

    double gyro_kp = 0, gyro_ki = 0, gyro_kd = 0, gyro_min = 0, gyro_max = 0;
    double setpoint = 0;
    PIDController PID;

    public Auto() {
        SmartDashboard.putNumber("Gyro_kp", gyro_kp);
        SmartDashboard.putNumber("Gyro_ki", gyro_ki);
        SmartDashboard.putNumber("Gyro_kd", gyro_kd);
        SmartDashboard.putNumber("Gyro_min", gyro_min);
        SmartDashboard.putNumber("Gyro_max", gyro_max);
    }

    public void setup_Distance_PID() {
        gyro_kp = SmartDashboard.getNumber("Gyro_kp", 0);
        gyro_ki = SmartDashboard.getNumber("Gyro_ki", 0);
        gyro_kd = SmartDashboard.getNumber("Gyro_kd", 0);
        PID = new PIDController(gyro_kp, gyro_ki, gyro_kd);
        PID.setIntegratorRange(gyro_min, gyro_max);
    }

    public void Distance_PID_setsetpoint(double _setpoint) {
        PID.setSetpoint(_setpoint);
        setpoint = _setpoint;
    }

    double lasttime = 0, errorSum = 0, error = 0;

    public double Distance_PID(double measurement) {
        error = setpoint - measurement;
        double dt = Timer.getFPGATimestamp() - lasttime;
        errorSum += error * dt;
        double pspeed = gyro_kp * error;
        double ispeed = gyro_ki * errorSum;
        lasttime = Timer.getFPGATimestamp();
        SmartDashboard.putNumber("pspd", pspeed);
        SmartDashboard.putNumber("ispd", ispeed);
        return pspeed + ispeed;
    }

    public boolean is_Distance(double positionTolerance) {
        PID.setTolerance(positionTolerance);
        return PID.atSetpoint();
    }
}