package frc.robot.lib;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;


public class Climber {
    private CANSparkMax Winch_Front_VictorPG; // 絞盤馬達 (前)
    private CANSparkMax Winch_Back_VictorPG; // 絞盤馬達 (後)

    // private CANSparkMax Hook_Front_SparkNeo; // 前鉤子(高度控制)
    // private CANSparkMax Hook_Back_SparkNeo; // 後鉤子(高度控制)
    private CANSparkMax Angle_Front_SparkNeo; // 前邊轉角馬達
    private CANSparkMax Angle_Back_SparkNeo; // 後邊轉角馬達


    private RelativeEncoder Winch_Front_Encoder_VictorPG; // 絞盤馬達 (前)
    private RelativeEncoder Winch_Back_Encoder_VictorPG; // 絞盤馬達 (後)

    // private RelativeEncoder Hook_Front_Encoder_SparkNeo; // 前鉤子(高度控制)
    // private RelativeEncoder Hook_Back_Encoder_SparkNeo; // 後鉤子(高度控制)
    private RelativeEncoder Angle_Front_Encoder_SparkNeo; // 前邊轉角馬達
    private RelativeEncoder Angle_Back_Encoder_SparkNeo; // 後邊轉角馬達


    public void Climber_Setup_Spark() {
        Winch_Front_VictorPG = new CANSparkMax(Constants.Climber.WINCH_FRONT_VICTORPG, MotorType.kBrushed);
        Winch_Back_VictorPG = new CANSparkMax(Constants.Climber.WINCH_BACK_VICTORPG, MotorType.kBrushed);

        // Hook_Front_SparkNeo = new CANSparkMax(Constants.Climber.HOOK_FRONT_SPARKNEO, MotorType.kBrushless);
        // Hook_Back_SparkNeo = new CANSparkMax(Constants.Climber.HOOK_BACK_SPARKNEO, MotorType.kBrushless);
        Angle_Front_SparkNeo = new CANSparkMax(Constants.Climber.ANGLE_FRONT_SPARKNEO, MotorType.kBrushless);
        Angle_Back_SparkNeo = new CANSparkMax(Constants.Climber.ANGLE_BACK_SPARKNEO, MotorType.kBrushless);
    }

    public void Encoder_Setup() {
        Winch_Front_Encoder_VictorPG = Winch_Front_VictorPG.getEncoder();
        Winch_Back_Encoder_VictorPG = Winch_Back_VictorPG.getEncoder();

        // Winch_Front_Encoder_SparkNeo = Hook_Front_SparkNeo.getEncoder();
        // Hook_Back_Encoder_SparkNeo = Hook_Back_SparkNeo.getEncoder();
        Angle_Front_Encoder_SparkNeo = Angle_Front_SparkNeo.getEncoder();
        Angle_Back_Encoder_SparkNeo = Angle_Back_SparkNeo.getEncoder();

    }

    public void Encoder_Zero() { // 歸零
        Winch_Front_Encoder_VictorPG.setPosition(0);
        Winch_Back_Encoder_VictorPG.setPosition(0);

        // Winch_Front_Encoder_SparkNeo.setPosition(0);
        // Hook_Back_Encoder_SparkNeo.setPosition(0);
        Angle_Front_Encoder_SparkNeo.setPosition(0);
        Angle_Back_Encoder_SparkNeo.setPosition(0);

    }


    public void Front_Rise_Up() {

    }
}
