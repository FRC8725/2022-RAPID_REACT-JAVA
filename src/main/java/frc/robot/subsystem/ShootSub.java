package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.lib.Hopper;
import frc.robot.lib.Shooter;
import frc.robot.Constants;


public class ShootSub {
    Hopper Hopper = new Hopper();
    Shooter Shooter = new Shooter();

    public ShootSub() {
        SmartDashboard.putNumber("Rise Speed", Constants.Hopper.RISE_SPEED);
        SmartDashboard.putNumber("Shoot Speed", Constants.Shooter.SPEED);
        SmartDashboard.putNumber("Lid_kp", Constants.Shooter.LID_kp);
        SmartDashboard.putNumber("Lid_ki", Constants.Shooter.LID_ki);
        SmartDashboard.putNumber("Lid_kiLimit", Constants.Shooter.LID_iLimit);
        SmartDashboard.putNumber("Lid_kd", Constants.Shooter.LID_kd);
    }

    public void Rise(boolean rise) {
        if (rise)
            Hopper.Rise(SmartDashboard.getNumber("Rise Speed", Constants.Hopper.RISE_SPEED));
        else
            Hopper.Rise(0);
    }
    

    public void Shoot(boolean shoot) {
        if (shoot)
            Shooter.Shoot(SmartDashboard.getNumber("Shoot Speed", Constants.Shooter.SPEED));
        else
            Shooter.Shoot(0);
    }

    double setpoint = 0, error = 0, errorSum = 0, errorRate = 0, lasterror = 0;
    double lasttime = 0, speed = 0, dt = 0;
    double kp, ki, iLimit, kd;

    public void Open_Lid(boolean close) {
        kp = SmartDashboard.getNumber("Lid_kp", Constants.Shooter.LID_kp);
        ki = SmartDashboard.getNumber("Lid_ki", Constants.Shooter.LID_ki);
        iLimit = SmartDashboard.getNumber("Lid_iLimit", Constants.Shooter.LID_iLimit);
        kd = SmartDashboard.getNumber("Lid_kd", Constants.Shooter.LID_kd);
        SmartDashboard.putNumber("LidEncoder", Shooter.get_LidEncoder());
        if (close) {
            setpoint =  (25. / 180.) * 64;
        } else {
            setpoint = 0;
        }
        dt = Timer.getFPGATimestamp() - lasttime;
        error = setpoint - Shooter.get_LidEncoder();
        if (Math.abs(error) < iLimit) {
            errorSum += error * dt;
        }
        errorRate = (error - lasterror) / dt;
        double speed_p = kp * error;
        double speed_i = ki * errorSum;
        double speed_d = kd * errorRate;
        SmartDashboard.putNumber("Speed_p", speed_p);
        SmartDashboard.putNumber("Speed_i", speed_i);
        SmartDashboard.putNumber("Speed_d", speed_d);
        speed = speed_p + speed_i + speed_d;


        Shooter.Lid(speed);
        SmartDashboard.putNumber("Lid Speed", speed);
        lasttime = Timer.getFPGATimestamp();
    }
    
    public void Init() {
        Hopper.Rise(0);
        Shooter.Shoot(0);
    }

    public void zero_Encoder() {
        Shooter.zero_LidEncoder();
    }

}
