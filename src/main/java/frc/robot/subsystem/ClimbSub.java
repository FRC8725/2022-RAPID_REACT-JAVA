package frc.robot.subsystem;

import frc.robot.lib.Pneumatic;
import frc.robot.lib.Climber;

public class ClimbSub {
    Pneumatic Pneumatic;
    Climber Climber;

    public ClimbSub() {
        Pneumatic = new Pneumatic();
        Climber = new Climber();
    }

    public void Release_Angle(boolean release) {
        Pneumatic.Solenoid_Release(release);
    }

    public void Rise_Winch(boolean rise) {
        
    }

    public void init() {
        Pneumatic.Pumping();
    }

    public void stop() {
        Pneumatic.Stop();
    }
}
