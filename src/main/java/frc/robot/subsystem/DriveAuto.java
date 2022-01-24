package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystem.*;

class DriveAuto{
    private static final double time = Timer.getFPGATimestamp();

    public void drive() {
        if (time < 3) {
            DriveSub.Move(100, 100);
        } else if (time < 6) {
            DriveSub.Move(-100, -100);
        } else {
            DriveSub.Move(0 ,0);
        }
    }
}
