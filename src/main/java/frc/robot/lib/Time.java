package frc.robot.lib;

import edu.wpi.first.wpilibj.Timer;

public class Time {

    private Timer timer;

    public Time() {
        timer = new Timer();
    }

    public double get_Time() {
        return timer.get();
    }
    
    public void zero_Timer() {
        timer.stop();
        timer.reset();
    }

    public void start_Timer() {
        timer.start();
    }

    public void stop_Timer() {
        timer.stop();
    }
}
