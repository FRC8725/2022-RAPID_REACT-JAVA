package frc.robot.lib;

import frc.robot.Constants;
import frc.robot.lib.PID;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
// import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Encoder; // Victor
import edu.wpi.first.wpilibj.CounterBase.EncodingType; // Victor

public class Climber {

    private WPI_VictorSPX Winch_Front_VictorPG; // 絞盤馬達 (前)
    private WPI_VictorSPX Winch_Back_VictorPG; // 絞盤馬達 (後)

    private WPI_VictorSPX Angle_Back_VictorPG; // 後邊轉角馬達

    private Encoder Winch_Front_Encoder_VictorPG; // 絞盤馬達 (前)
    private Encoder Winch_Back_Encoder_VictorPG; // 絞盤馬達 (後)

    private Encoder Angle_Back_Encoder_VictorPG; // 後邊轉角馬達

    public Climber() {

        Winch_Front_Encoder_VictorPG = new Encoder(Constants.Climber.WINCH_FRONT_ENCODER_VICTORPG,
                Constants.Climber.WINCH_FRONT_ENCODER_VICTORPG + 1, false, EncodingType.k1X);
        Winch_Front_Encoder_VictorPG.setDistancePerPulse(7. / 360); // 一次轉距

        Winch_Back_Encoder_VictorPG = new Encoder(Constants.Climber.WINCH_BACK_ENCODER_VICTORPG,
                Constants.Climber.WINCH_BACK_ENCODER_VICTORPG + 1, false, EncodingType.k1X);
        Winch_Back_Encoder_VictorPG.setDistancePerPulse(7. / 360); // 一次轉距

        Angle_Back_Encoder_VictorPG = new Encoder(Constants.Climber.ANGLE_BACK_ENCODER_VICTORPG,
                Constants.Climber.ANGLE_BACK_ENCODER_VICTORPG + 1, false, EncodingType.k1X);
        Angle_Back_Encoder_VictorPG.setDistancePerPulse(7. / 360); // 一次轉距


        Winch_Front_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_FRONT_VICTORPG);
        Winch_Back_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_BACK_VICTORPG);

        Angle_Back_VictorPG = new WPI_VictorSPX(Constants.Climber.ANGLE_BACK_VICTORPG);

    }

    public void Encoder_Zero() { // 歸零
        Winch_Front_Encoder_VictorPG.reset();
        Winch_Back_Encoder_VictorPG.reset();

        Angle_Back_Encoder_VictorPG.reset(); 

    }


    // 後桿轉角
    private boolean direction_Back_Angle = true; // 旋轉方向
    private boolean buffer_Back_Angle = true; // 存取方向是否已經轉換過
    private boolean keep_turning_Back_Angle = false; // 持續運轉

    PID Angle_Back_VictorPG_PID = new PID(Constants.Climber.ANGLE_BACK_VICTORPG_KP, Constants.Climber.ANGLE_BACK_VICTORPG_KI, Constants.Climber.ANGLE_BACK_VICTORPG_KD);

    public void Back_Angle_Turn(boolean run) { // direction: (true 正轉,false 反轉)

        if (run) {
            keep_turning_Back_Angle = true;
        }

        if (keep_turning_Back_Angle && direction_Back_Angle == true) {
            
            Angle_Back_VictorPG_PID.setup_Distance_PID(Constants.Climber.ANGLE_BACK_VICTORPG_HIGH_I_MIN, Constants.Climber.ANGLE_BACK_VICTORPG_HIGH_I_MAX);
            Angle_Back_VictorPG_PID.setSetpoint(Constants.Climber.ANGLE_BACK_VICTORPG_HIGH_SETPOINT);

            Angle_Back_VictorPG.set(Angle_Back_VictorPG_PID.Distance_PID(Angle_Back_Encoder_VictorPG.getDistance()));

            if (Angle_Back_VictorPG_PID.is_Distance(Angle_Back_Encoder_VictorPG.getDistance()) == true) {
                buffer_Back_Winch = false;
                keep_turning_Back_Winch = false;
            }

        } else if (keep_turning_Back_Angle && direction_Back_Angle == false) {

            Angle_Back_VictorPG_PID.setup_Distance_PID(Constants.Climber.ANGLE_BACK_VICTORPG_LOW_I_MIN, Constants.Climber.ANGLE_BACK_VICTORPG_LOW_I_MAX);
            Angle_Back_VictorPG_PID.setSetpoint(Constants.Climber.ANGLE_BACK_VICTORPG_LOW_SETPOINT);

            Angle_Back_VictorPG.set(Angle_Back_VictorPG_PID.Distance_PID(Angle_Back_Encoder_VictorPG.getDistance()));

            if (Angle_Back_VictorPG_PID.is_Distance(Angle_Back_Encoder_VictorPG.getDistance()) == true) {
                buffer_Back_Winch = false;
                keep_turning_Back_Winch = false;
            }

        } else if (!run && !buffer_Back_Angle) {

            Angle_Back_VictorPG.set(0);
            direction_Back_Angle = !direction_Back_Angle;
            buffer_Back_Angle = true;

        } else {

            Angle_Back_VictorPG.set(0);

        }
    }

    // 前伸縮桿
    private boolean direction_Front_Winch = true; // 旋轉方向
    private boolean buffer_Front_Winch = true; // 存取方向是否已經轉換過
    private boolean keep_turning_Front_Winch = false; // 持續運轉

    // 建構 Winch_Back_VictorPG 的 PID (需 kp, ki, kd) ,常數取自 Constant     
    PID Winch_Front_VictorPG_PID = new PID(Constants.Climber.WINCH_FRONT_VICTORPG_KP, Constants.Climber.WINCH_FRONT_VICTORPG_KI, Constants.Climber.WINCH_FRONT_VICTORPG_KD);

    public void Front_Winch_Turn(boolean run) {

        if (run) {
            keep_turning_Front_Winch = true;
        }

        if (keep_turning_Front_Winch && direction_Front_Winch == true) {

            Winch_Front_VictorPG_PID.setup_Distance_PID(Constants.Climber.WINCH_FRONT_VICTORPG_HIGH_I_MIN, Constants.Climber.WINCH_FRONT_VICTORPG_HIGH_I_MAX);
            Winch_Front_VictorPG_PID.setSetpoint(Constants.Climber.WINCH_FRONT_VICTORPG_HIGH_SETPOINT);

            Winch_Front_VictorPG.set(Winch_Front_VictorPG_PID.Distance_PID(Winch_Front_Encoder_VictorPG.getDistance()));

            if (Winch_Front_VictorPG_PID.is_Distance(Winch_Front_Encoder_VictorPG.getDistance()) == true) {
                buffer_Front_Winch = false;
                keep_turning_Front_Winch = false;
            }

        } else if (keep_turning_Front_Winch && direction_Front_Winch == false) {

            Winch_Front_VictorPG_PID.setup_Distance_PID(Constants.Climber.WINCH_FRONT_VICTORPG_LOW_I_MIN, Constants.Climber.WINCH_FRONT_VICTORPG_LOW_I_MAX);
            Winch_Front_VictorPG_PID.setSetpoint(Constants.Climber.WINCH_FRONT_VICTORPG_LOW_SETPOINT);

            Winch_Front_VictorPG.set(Winch_Front_VictorPG_PID.Distance_PID(Winch_Front_Encoder_VictorPG.getDistance()));

            if (Winch_Front_VictorPG_PID.is_Distance(Winch_Front_Encoder_VictorPG.getDistance()) == true) {
                buffer_Front_Winch = false;
                keep_turning_Front_Winch = false;
            }

        } else if (!run && !buffer_Front_Winch) {

            Winch_Front_VictorPG.set(0);
            direction_Front_Winch = !direction_Front_Winch;
            buffer_Front_Winch = true;

        } else {

            Winch_Front_VictorPG.set(0);

        }
    }


    // 後伸縮桿
    private boolean direction_Back_Winch = true; // 旋轉方向
    private boolean buffer_Back_Winch = true; // 存取方向是否已經轉換過
    private boolean keep_turning_Back_Winch = false; // 持續運轉

    // 建構 Winch_Back_VictorPG 的 PID (需 kp, ki, kd) ,常數取自 Constant     
    PID Winch_Back_VictorPG_PID = new PID(Constants.Climber.WINCH_BACK_VICTORPG_KP, Constants.Climber.WINCH_BACK_VICTORPG_KI, Constants.Climber.WINCH_BACK_VICTORPG_KD);

    public void Back_Winch_Turn(boolean run) {
        
        if (run) {
            keep_turning_Back_Winch = true;
        }

        if (keep_turning_Back_Winch && direction_Back_Winch == true) {

            Winch_Back_VictorPG_PID.setup_Distance_PID(Constants.Climber.WINCH_BACK_VICTORPG_HIGH_I_MIN, Constants.Climber.WINCH_BACK_VICTORPG_HIGH_I_MAX);
            Winch_Back_VictorPG_PID.setSetpoint(Constants.Climber.WINCH_BACK_VICTORPG_HIGH_SETPOINT);

            Winch_Back_VictorPG.set(Winch_Back_VictorPG_PID.Distance_PID(Winch_Back_Encoder_VictorPG.getDistance()));

            if (Winch_Back_VictorPG_PID.is_Distance(Winch_Back_Encoder_VictorPG.getDistance()) == true) {
                buffer_Back_Winch = false;
                keep_turning_Back_Winch = false;
            }

        } else if (keep_turning_Back_Winch && direction_Back_Winch == false) {

            Winch_Back_VictorPG_PID.setup_Distance_PID(Constants.Climber.WINCH_BACK_VICTORPG_LOW_I_MIN, Constants.Climber.WINCH_BACK_VICTORPG_LOW_I_MAX);
            Winch_Back_VictorPG_PID.setSetpoint(Constants.Climber.WINCH_BACK_VICTORPG_LOW_SETPOINT);

            Winch_Back_VictorPG.set(Winch_Back_VictorPG_PID.Distance_PID(Winch_Back_Encoder_VictorPG.getDistance()));

            if (Winch_Back_VictorPG_PID.is_Distance(Winch_Back_Encoder_VictorPG.getDistance()) == true) {
                buffer_Back_Winch = false;
                keep_turning_Back_Winch = false;
            }

        } else if (!run && !buffer_Back_Winch) {

            Winch_Back_VictorPG.set(0);
            direction_Back_Winch = !direction_Back_Winch;
            buffer_Back_Winch = true;

        } else {

            Winch_Back_VictorPG.set(0);

        }
    }

}
