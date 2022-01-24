package frc.robot.subsystem;

import frc.robot.lib.Time;
import frc.robot.lib.Gyro;

public class DriveAuto{
    DriveSub DriveSub = new DriveSub();
    Time Time = new Time();
    Gyro Gyro = new Gyro();
    double kgs = 1; //Gyro speed adjust variable

    public void setup_Auto() {
        Gyro.zero_Yaw();
        Time.zero_Timer();
    }

    public void drive(double kangle) {
        if (Math.abs(Gyro.get_Yaw()) > kangle) {
            Time.stop_Timer();
            DriveSub.Move(-Gyro.get_Yaw() * kgs, Gyro.get_Yaw() * kgs);
        } else {
            Time.start_Timer();
            if (Time.get_Time() < 10) {
                DriveSub.Move(.5, .5);
            } else if (Time.get_Time() < 20) {
                DriveSub.Move(-.5, -.5);
            } else {
                DriveSub.Drive_Stop();
            }
        }
    }
}
