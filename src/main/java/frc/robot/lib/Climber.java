package frc.robot.lib;

import frc.robot.Constants;
import frc.robot.lib.PID;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder; // Spark

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
// import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Encoder; // Victor
import edu.wpi.first.wpilibj.CounterBase.EncodingType; // Victor

public class Climber {

    private WPI_VictorSPX Winch_Front_VictorPG; // 絞盤馬達 (前)
    private WPI_VictorSPX Winch_Back_VictorPG; // 絞盤馬達 (後)

    // private CANSparkMax Hook_Front_SparkNeo; // 前鉤子(高度控制)
    // private CANSparkMax Hook_Back_SparkNeo; // 後鉤子(高度控制)

    private CANSparkMax Angle_Front_SparkNeo; // 前邊轉角馬達
    private CANSparkMax Angle_Back_SparkNeo; // 後邊轉角馬達

    private Encoder Winch_Front_Encoder_VictorPG; // 絞盤馬達 (前)
    private Encoder Winch_Back_Encoder_VictorPG; // 絞盤馬達 (後)

    // private RelativeEncoder Hook_Front_Encoder_SparkNeo; // 前鉤子(高度控制)
    // private RelativeEncoder Hook_Back_Encoder_SparkNeo; // 後鉤子(高度控制)

    private RelativeEncoder Angle_Front_Encoder_SparkNeo; // 前邊轉角馬達
    private RelativeEncoder Angle_Back_Encoder_SparkNeo; // 後邊轉角馬達

    public Climber() {
        
        Winch_Front_Encoder_VictorPG = new Encoder(Constants.Climber.WINCH_FRONT_ENCODER_VICTORPG,
                Constants.Climber.WINCH_FRONT_ENCODER_VICTORPG + 1, false, EncodingType.k1X);
        Winch_Front_Encoder_VictorPG.setDistancePerPulse(7. / 360); // 一次轉距

        Winch_Back_Encoder_VictorPG = new Encoder(Constants.Climber.WINCH_BACK_ENCODER_VICTORPG,
                Constants.Climber.WINCH_BACK_ENCODER_VICTORPG + 1, false, EncodingType.k1X);
        Winch_Back_Encoder_VictorPG.setDistancePerPulse(7. / 360); // 一次轉距

        Winch_Front_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_FRONT_VICTORPG);
        Winch_Back_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_BACK_VICTORPG);

        // Hook_Front_SparkNeo = new CANSparkMax(Constants.Climber.HOOK_FRONT_SPARKNEO,
        // MotorType.kBrushless);
        // Hook_Back_SparkNeo = new CANSparkMax(Constants.Climber.HOOK_BACK_SPARKNEO,
        // MotorType.kBrushless);

        Angle_Front_SparkNeo = new CANSparkMax(Constants.Climber.ANGLE_FRONT_SPARKNEO, MotorType.kBrushless);
        Angle_Back_SparkNeo = new CANSparkMax(Constants.Climber.ANGLE_BACK_SPARKNEO, MotorType.kBrushless);

    }

    public void Encoder_Zero() { // 歸零
        Winch_Front_Encoder_VictorPG.reset();
        Winch_Back_Encoder_VictorPG.reset();

        // Winch_Front_Encoder_SparkNeo.setPosition(0);
        // Hook_Back_Encoder_SparkNeo.setPosition(0);

        Angle_Front_Encoder_SparkNeo.setPosition(0);
        Angle_Back_Encoder_SparkNeo.setPosition(0);

    }

    // 前桿轉角
    private boolean direction_Front_Angle = true; // 旋轉方向
    private boolean buffer_Front_Angle = true; // 存取方向是否已經轉換過

    public void Front_Angle_Turn(boolean run) { // direction: (true 正轉,false 反轉)
        if (run && Angle_Front_Encoder_SparkNeo.getPosition() < 0.5 && direction_Front_Angle == true) {
            Angle_Front_SparkNeo.set(Constants.Climber.ANGLE_ENCODER_SPEED);
            if (Angle_Front_Encoder_SparkNeo.getPosition() >= 0.5) {
                buffer_Front_Angle = false;
            }
        } else if (run && Angle_Front_Encoder_SparkNeo.getPosition() > 0 && direction_Front_Angle == false) {
            Angle_Front_SparkNeo.set(-Constants.Climber.ANGLE_ENCODER_SPEED);
            if (Angle_Front_Encoder_SparkNeo.getPosition() <= 0) {
                buffer_Front_Angle = false;
            }
        } else if (!run && !buffer_Front_Angle) {
            Angle_Front_SparkNeo.set(0);
            direction_Front_Angle = !direction_Front_Angle;
            buffer_Front_Angle = true;
        } else {
            Angle_Front_SparkNeo.set(0);
        }
    }

    // 後桿轉角
    private boolean direction_Back_Angle = true; // 旋轉方向
    private boolean buffer_Back_Angle = true; // 存取方向是否已經轉換過

    public void Back_Angle_Turn(boolean run) { // direction: (true 正轉,false 反轉)
        if (run && Angle_Back_Encoder_SparkNeo.getPosition() < 0.5 && direction_Back_Angle == true) {
            Angle_Back_SparkNeo.set(Constants.Climber.ANGLE_ENCODER_SPEED);
            if (Angle_Back_Encoder_SparkNeo.getPosition() >= 0.5) {
                buffer_Back_Angle = false;
            }
        } else if (run && Angle_Back_Encoder_SparkNeo.getPosition() > 0 && direction_Back_Angle == false) {
            Angle_Back_SparkNeo.set(-Constants.Climber.ANGLE_ENCODER_SPEED);
            if (Angle_Back_Encoder_SparkNeo.getPosition() <= 0) {
                buffer_Back_Angle = false;
            }
        } else if (!run && !buffer_Back_Angle) {
            Angle_Back_SparkNeo.set(0);
            direction_Back_Angle = !direction_Back_Angle;
            buffer_Back_Angle = true;
        } else {
            Angle_Back_SparkNeo.set(0);
        }
    }

    // 前伸縮桿
    private boolean direction_Front_Winch = true; // 旋轉方向
    private boolean buffer_Front_Winch = true; // 存取方向是否已經轉換過

    public void Front_Winch_Turn(boolean run) {
        if (run && Winch_Front_Encoder_VictorPG.getDistance() < 0.5 && direction_Front_Winch == true) {
            Winch_Front_VictorPG.set(Constants.Climber.WINCH_ENCODER_SPEED);
            if (Winch_Front_Encoder_VictorPG.getDistance() >= 0.5) {
                buffer_Front_Winch = false;
            }
        } else if (run && Winch_Front_Encoder_VictorPG.getDistance() > 0 && direction_Front_Winch == false) {
            Winch_Front_VictorPG.set(-Constants.Climber.WINCH_ENCODER_SPEED);
            if (Winch_Front_Encoder_VictorPG.getDistance() <= 0) {
                buffer_Front_Winch = false;
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
    private boolean keep_turning_Back_Winch = false; // 持續運轉方向

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
