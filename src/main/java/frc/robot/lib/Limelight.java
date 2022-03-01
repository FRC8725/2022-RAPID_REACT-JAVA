package frc.robot.lib;

import frc.robot.subsystem.DriveSub;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Limelight {
    double tx, steering_adjust, ts, lasterror, ta, ty, distance;
    boolean tv;

    public Limelight () {
        SmartDashboard.putNumber("limelight kp", 0.03);
        SmartDashboard.putNumber("limelight kd", 0.075);
        update();
        lasterror = 0;
        steering_adjust = 0.0f;
    }

    public void update() {
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(-1);
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getBoolean(false);
        ts = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(.0);
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(.0);
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(.0);
        put_limelight();
        calcV();

    }

    private void put_limelight() {
        SmartDashboard.putNumber("limelight speed", steering_adjust);
        SmartDashboard.putNumber("limelight tx", tx);
    }

    public void aim_target() {
        update();
        double kp = SmartDashboard.getNumber("limelight kp", .75);
        double kd = SmartDashboard.getNumber("limelight kd", .0);
        double dt = tx-lasterror;
        lasterror = tx;

        if (tx < -0.1 || tx > .1) {
            steering_adjust = kp * tx + kd * dt;
            double left = Math.max(Math.min(steering_adjust, 1), -1);
            double right = Math.max(Math.min(-steering_adjust, 1), -1);
            DriveSub.Move(left, right);
        } else if (tx == .0) {
            DriveSub.Move(.5, -.5);
        }
    }

    public void calcV() {
        if (ty == 0){
            distance = 0;
            return;
        }
        distance = Math.tan(Constants.Limelight.PRETHETA + ty)/Constants.Limelight.HEIGH_DIFF;
        SmartDashboard.putNumber("Target distance", distance);
        
    }

    public void test_shoot() {

    }
}
