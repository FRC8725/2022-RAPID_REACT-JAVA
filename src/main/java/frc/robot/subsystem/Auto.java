package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;

public class Auto {

    double distance_kp = 0, distance_ki = 0, distance_kd = 0, distance_min = 0, distance_max = 0;
    double setpoint = 0;
    PIDController PID;

    public Auto() {
        SmartDashboard.putNumber("Distance_kp", distance_kp);
        SmartDashboard.putNumber("Distance_ki", distance_ki);
        SmartDashboard.putNumber("Distance_kd", distance_kd);
        SmartDashboard.putNumber("Distance_min", distance_min);
        SmartDashboard.putNumber("Distance_max", distance_max);
    }

    public void setup_Distance_PID() {
        distance_kp = SmartDashboard.getNumber("Distance_kp", 0);
        distance_ki = SmartDashboard.getNumber("Distance_ki", 0);
        distance_kd = SmartDashboard.getNumber("Distance_kd", 0);
        distance_max = SmartDashboard.getNumber("Distance_max", 0);
        distance_min = SmartDashboard.getNumber("Distance_min", 0);
        PID = new PIDController(distance_kp, distance_ki, distance_kd);
        PID.setIntegratorRange(distance_min, distance_max);
    }

    public void Distance_PID_setsetpoint(double _setpoint) {
        PID.setSetpoint(_setpoint);
        setpoint = _setpoint;
    }

    double lasttime = 0, error = 0, lasterror = 0, errorSum = 0, errorRate = 0, dt;

    public double Distance_PID(double measurement) {
        error = setpoint - measurement;
        dt = Timer.getFPGATimestamp() - lasttime;
        errorSum += error * dt;
        errorRate = (error - lasterror) * dt;
        double pspeed = distance_kp * error;
        double ispeed = distance_ki * errorSum;
        double dspeed = distance_kd * errorRate;
        lasttime = Timer.getFPGATimestamp();
        SmartDashboard.putNumber("pspd", pspeed);
        SmartDashboard.putNumber("ispd", ispeed);
        SmartDashboard.putNumber("dspd", dspeed);
        if (distance_min > ispeed || ispeed > distance_max) ispeed = 0;
        return pspeed + ispeed + dspeed;
    }

    public boolean is_Distance(double positionTolerance) {
        PID.setTolerance(positionTolerance);
        return PID.atSetpoint();
    }
}
