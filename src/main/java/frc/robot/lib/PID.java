package frc.robot.lib;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;

public class PID {
    double kp, ki, kd;
    double i_min, i_max; // i_min, i_max 標出執行 kI 動作的位置範圍
    double setpoint = 0;
    
    PIDController PID;

    public PID(double kp, double ki, double kd) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
    }

    public void setup_moving_PID(double i_min, double i_max, double setpoint) {
        this.i_min = i_min;
        this.i_max = i_max;
        this.setpoint = setpoint;
    }

    public void setup_Distance_PID() {
        PID = new PIDController(kp, ki, kd);
        PID.setIntegratorRange(i_min, i_max);
    }

    public void setSetpoint(double _setpoint) { // 初始化終點位置距離
        PID.setSetpoint(_setpoint);
        setpoint = _setpoint;
    }

    double lasttime = 0, error = 0, lasterror = 0, errorSum = 0, errorRate = 0, dt;

    public double Distance_PID(double measurement) {
        error = setpoint - measurement;
        dt = Timer.getFPGATimestamp() - lasttime;
        errorSum += error * dt;
        errorRate = (error - lasterror) * dt;
        double p_speed = kp * error;
        double i_speed = ki * errorSum;
        double d_speed = kd * errorRate;
        lasttime = Timer.getFPGATimestamp();

        SmartDashboard.putNumber("pspd", p_speed);
        SmartDashboard.putNumber("ispd", i_speed);
        SmartDashboard.putNumber("dspd", d_speed);

        if (i_min > error || error > i_max) { // 如果現在位置在可執行 kI 的範圍外，就將積值與速度歸零
            i_speed = 0; 
            errorSum = 0;
        }

        return p_speed + i_speed + d_speed;
    }

    public boolean is_Distance(double positionTolerance) {
        PID.setTolerance(positionTolerance);
        return PID.atSetpoint();
    }

}
