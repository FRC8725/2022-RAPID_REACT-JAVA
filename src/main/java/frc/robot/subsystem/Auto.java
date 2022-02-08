package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.Constants;
import edu.wpi.first.math.controller.PIDController;

public class Auto extends DriveSub{ 
    double distance_kp = 0, distance_ki = 0, distance_kd = 0, distance_min = 0, distance_max = 0;
    double setpoint = 0;
    double angle_kp = 0, angle_ki = 0, angle_kd = 0, angle_min = 0, angle_max = 0;

    PIDController PID, Angle_PID;
    Timer m_Timer;

    public Auto() {
        SmartDashboard.putNumber("Distance_kp", distance_kp);
        SmartDashboard.putNumber("Distance_ki", distance_ki);
        SmartDashboard.putNumber("Distance_kd", distance_kd);
        SmartDashboard.putNumber("Distance_min", distance_min);
        SmartDashboard.putNumber("Distance_max", distance_max);
        SmartDashboard.putNumber("angle_kp", angle_kp);
        SmartDashboard.putNumber("angle_ki", angle_ki);
        SmartDashboard.putNumber("angle_kd", angle_kd);
        SmartDashboard.putNumber("angle_min", angle_min);
        SmartDashboard.putNumber("angle_max", angle_max);
        m_Timer = new Timer();
    }

    public void Action() {
        // Some actions will be done within auto mode 
        m_Timer.reset();
        m_Timer.start();
        while (m_Timer.get() < 5) {
            Move(.1, .1);
        }
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

    // Angle
    public void setup_Angle_PID() {
        angle_kp = SmartDashboard.getNumber("Angle_kp", 0);
        angle_ki = SmartDashboard.getNumber("Angle_ki", 0);
        angle_kd = SmartDashboard.getNumber("Angle_kd", 0);
        angle_max = SmartDashboard.getNumber("Angle_max", 0);
        angle_min = SmartDashboard.getNumber("Angle_min", 0);
        Angle_PID = new PIDController(angle_kp, angle_ki, angle_kd);
        Angle_PID.setIntegratorRange(angle_min, angle_max);
    }

    public void Angle_PID_setsetpoint(double _setpoint) {
        Angle_PID.setSetpoint(_setpoint);
        setpoint = _setpoint;
    }

    double Angle_lasttime = 0, Angle_error = 0, Angle_lasterror = 0, Angle_errorSum = 0, Angle_errorRate = 0, Angle_dt;

    public double Angle_PID(double measurement) {
        Angle_error = setpoint - measurement;
        Angle_dt = Timer.getFPGATimestamp() - Angle_lasttime;
        Angle_errorSum += Angle_error * Angle_dt;
        Angle_errorRate = (Angle_error - Angle_lasterror) * Angle_dt;
        double Angle_pspeed = angle_kp * Angle_error;
        double Angle_ispeed = angle_ki * Angle_errorSum;
        double Angle_dspeed = angle_kd * Angle_errorRate;
        Angle_lasttime = Timer.getFPGATimestamp();
        SmartDashboard.putNumber("Angle_pspd", Angle_pspeed);
        SmartDashboard.putNumber("Angle_ispd", Angle_ispeed);
        SmartDashboard.putNumber("Angle_dspd", Angle_dspeed);
        if (angle_min > Angle_ispeed || Angle_ispeed > angle_max) Angle_ispeed = 0;
        return Angle_pspeed + Angle_ispeed + Angle_dspeed;
    }

    public boolean is_Angle(double positionTolerance) {
        Angle_PID.setTolerance(positionTolerance);
        return Angle_PID.atSetpoint();
    }

    public void Angle_PID_TO_ZERO(double Angle) {
        // if Angle >= 180:

    } 
}
// kp*error + ki*errerSum + kd*errorRate