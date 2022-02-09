package frc.robot.lib;

import frc.robot.subsystem.DriveSub;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    NetworkTable table;
    NetworkTableEntry tx;
    double x, left_command, right_command;

    public Limelight () {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
    }

    public boolean aim_target() {
        x = tx.getDouble(0.0);
        double kp = -0.1;
        double min_command = 0.05f;

        if (table.getEntry("tv").getBoolean(false)) {
            double heading_error = 0 - x;
            double steering_adjust = 0.0f;
            if (x > 1.0) {
                steering_adjust = kp * heading_error - min_command;
            } else if (x < 1.0) {
                steering_adjust = kp * heading_error + min_command;
            }
            left_command += steering_adjust;
            right_command -= steering_adjust;
            DriveSub.Move(left_command, right_command, false);
            return true;
        } else {
            return false;
        }
    }
}
