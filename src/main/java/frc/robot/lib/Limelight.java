package frc.robot.lib;

import frc.robot.subsystem.DriveSub;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Limelight {
    double tx, steering_adjust = 0.0f, ts, lasterror;
    boolean tv;

    public Limelight () {
        SmartDashboard.putNumber("limelight kp", 0.03);
        SmartDashboard.putNumber("limelight kd", 0.05);
        update();
        lasterror = 0;
    }

    public void update() {
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(-1);
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getBoolean (false);
        ts = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0.0);
        put_limelight();

    }

    private void put_limelight() {
        SmartDashboard.putNumber("limelight speed", steering_adjust);
        SmartDashboard.putNumber("limelight tx", tx);
    }

    public void aim_target() {
        update();
        double kp = SmartDashboard.getNumber("limelight kp", 0.0);
        double kd = SmartDashboard.getNumber("limelight kd", 0.0);
        double dt = tx-lasterror;
        lasterror = tx;

        if (tx < -0.5 || tx > .5) {
            steering_adjust = kp * tx + kd * dt;
            double left = Math.max(Math.min(steering_adjust, 1), -1);
            double right = Math.max(Math.min(-steering_adjust, 1), -1);
            DriveSub.(left, right, false);
        } else {
            DriveSub.Move(0, 0, false);
        }
    }
}
