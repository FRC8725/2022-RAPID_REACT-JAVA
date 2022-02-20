package frc.robot.lib;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber {

    private WPI_VictorSPX Winch_VictorPG; // 馬達


    public Climber() {
        Winch_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_VICTORPG);
    }

    public void reset() {
        Winch_VictorPG.set(0); // 我不確定 reset 對不對
    }

    // 伸縮
    public void Climb_Up(boolean run) {
        if (run) {
            Winch_VictorPG.set(Constants.Climber.WINCH_ENCODER_SPEED);
        } else {
            Winch_VictorPG.set(0);
        }
    }

    public void Climb_Down(boolean run) {
        if (run) {
            Winch_VictorPG.set(- Constants.Climber.WINCH_ENCODER_SPEED);
        } else {
            Winch_VictorPG.set(0);
        }
    }

    public void Stop() {
        Winch_VictorPG.set(0);
    }

}
