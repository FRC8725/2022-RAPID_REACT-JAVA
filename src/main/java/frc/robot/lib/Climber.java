package frc.robot.lib;

import frc.robot.Constants;
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
        Winch_Front_Encoder_VictorPG = new Encoder(Constants.Climber.WINCH_FRONT_ENCODER, Constants.Climber.WINCH_FRONT_ENCODER + 1, false, EncodingType.k1X);
        Winch_Front_Encoder_VictorPG.setDistancePerPulse(7/360); // 一次轉距
        Winch_Back_Encoder_VictorPG.getDistance();

        Winch_Back_Encoder_VictorPG = new Encoder(Constants.Climber.WINCH_BACK_ENCODER , Constants.Climber.WINCH_BACK_ENCODER + 1, false, EncodingType.k1X);
        Winch_Back_Encoder_VictorPG.setDistancePerPulse(7/360); // 一次轉距
        Winch_Back_Encoder_VictorPG.getDistance();
        

    }


    public void Climber_Setup_Motors() {
        Winch_Front_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_FRONT_VICTORPG);
        Winch_Back_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_BACK_VICTORPG);

        // Hook_Front_SparkNeo = new CANSparkMax(Constants.Climber.HOOK_FRONT_SPARKNEO, MotorType.kBrushless);
        // Hook_Back_SparkNeo = new CANSparkMax(Constants.Climber.HOOK_BACK_SPARKNEO, MotorType.kBrushless);

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
    boolean direction_Front_Angle = true; // 旋轉方向
    boolean buffer_Front_Angle = true; // 存取方向是否已經轉換過

    public void Front_Angle_Turn(boolean run) { //  direction: (true 正轉,false 反轉)
        if (run && get_Encoder(Angle_Front_Encoder_SparkNeo) < 0.5 && direction_Front_Angle == true) {
            Angle_Front_SparkNeo.set(Constants.Climber.ANGLE_ENCODER_PULSE);
            buffer_Front_Angle = true;
        } else if (run && get_Encoder(Angle_Front_Encoder_SparkNeo) > 0 && direction_Front_Angle == false) {
            Angle_Front_SparkNeo.set(- Constants.Climber.ANGLE_ENCODER_PULSE);
            buffer_Front_Angle = true;
        } else if (!run && buffer_Front_Angle) {
            Angle_Front_SparkNeo.set(0);
            direction_Front_Angle = !direction_Front_Angle;
            buffer_Front_Angle = false;
        } else {
            Angle_Front_SparkNeo.set(0);
        }
    }

    // 後桿轉角
    boolean direction_Back_Angle = true; // 旋轉方向
    boolean buffer_Back_Angle = true; // 存取方向是否已經轉換過

    public void Back_Angle_Turn(boolean run) { //  direction: (true 正轉,false 反轉)
        if (run && get_Encoder(Angle_Back_Encoder_SparkNeo) < 0.5 && direction_Back_Angle == true) {
            Angle_Back_SparkNeo.set(Constants.Climber.ANGLE_ENCODER_PULSE);
            buffer_Back_Angle = true;
        } else if (run && get_Encoder(Angle_Back_Encoder_SparkNeo) > 0 && direction_Back_Angle == false) {
            Angle_Back_SparkNeo.set(- Constants.Climber.ANGLE_ENCODER_PULSE);
            buffer_Back_Angle = true;
        } else if (!run && buffer_Back_Angle) {
            Angle_Back_SparkNeo.set(0);
            direction_Back_Angle = !direction_Back_Angle;
            buffer_Back_Angle = false;
        } else {
            Angle_Back_SparkNeo.set(0);
        }
    }

    // 前伸縮桿
    boolean direction_Front_Winch = true; // 旋轉方向
    boolean buffer_Front_Winch = true; // 存取方向是否已經轉換過

    public void Front_Winch_Turn(boolean run) {
        if (run && get_Encoder(Winch_Front_Encoder_VictorPG) < 0.5 && direction_Front_Winch == true) {
            Winch_Front_VictorPG.set(Constants.Climber.WINCH_ENCODER_PULSE);
            buffer_Front_Winch = true;
        } else if (run && get_Encoder(Winch_Front_Encoder_VictorPG) > 0 && direction_Front_Winch == false) {
            Winch_Front_VictorPG.set(- Constants.Climber.WINCH_ENCODER_PULSE);
            buffer_Front_Winch = true;
        } else if (!run && buffer_Front_Winch) {
            Winch_Front_VictorPG.set(0);
            direction_Front_Winch = !direction_Front_Winch;
            buffer_Front_Winch = false;
        } else {
            Winch_Front_VictorPG.set(0);
        }
    }

    // 後伸縮桿
    boolean direction_Back_Winch = true; // 旋轉方向
    boolean buffer_Back_Winch = true; // 存取方向是否已經轉換過

    public void Back_Winch_Turn(boolean run) {
        if (run && get_Encoder(Winch_Back_Encoder_VictorPG) < 0.5 && direction_Back_Winch == true) {
            Winch_Back_VictorPG.set(Constants.Climber.WINCH_ENCODER_PULSE);
            buffer_Back_Winch = true;
        } else if (run && get_Encoder(Winch_Back_Encoder_VictorPG) > 0 && direction_Back_Winch == false) {
            Winch_Back_VictorPG.set(- Constants.Climber.WINCH_ENCODER_PULSE);
            buffer_Back_Winch = true;
        } else if (!run && buffer_Back_Winch) {
            Winch_Back_VictorPG.set(0);
            direction_Back_Winch = !direction_Back_Winch;
            buffer_Back_Winch = false;
        } else {
            Winch_Back_VictorPG.set(0);
        }
    }



    // 取 Encoder 位置 Spark
    public double get_Encoder(RelativeEncoder The_encoder) {
        return The_encoder.getPosition();
    }

    // 取 Encoder 位置 Victor
    public double get_Encoder(Encoder The_Encoder) {
        return The_Encoder.getDistance();
    }
}
