package frc.robot.subsystem;

import frc.robot.lib.Time;
import frc.robot.lib.Gyro;

class DriveAuto{
    DriveSub DriveSub = new DriveSub();
    Time Time = new Time();
    Gyro Gyro = new Gyro();

    public void setup_Auto() {
        Gyro.zero_Yaw();
        Time.zero_Timer();
    }

    public void drive(double kangle) {
        if (Gyro.get_Yaw() > kangle) {
            Time.stop_Timer();
        } else {
            Time.start_Timer();
            if (Time.get_Time() < 3) {
                DriveSub.Move(.5, .5);
            } else if (Time.get_Time() < 6) {
                DriveSub.Move(-.5, -.5);
            } else {
                DriveSub.Move(0, 0);
            }
        }
    }
}
