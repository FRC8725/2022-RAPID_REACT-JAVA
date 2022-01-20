package frc.robot.lib;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;


public class Climber {
    private CANSparkMax Front_Winch; // 絞盤馬達 (前)
    private CANSparkMax Back_Winch; // 絞盤馬達 (後)

    // private CANSparkMax Front_Hook; // 前鉤子(高度控制)
    // private CANSparkMax Back_Hook; // 後鉤子(高度控制)
    private CANSparkMax Front_Angle; // 前邊轉角馬達
    private CANSparkMax Back_Angle; // 後邊轉角馬達


    private RelativeEncoder Front_Winch_Encoder; // 絞盤馬達 (前)
    private RelativeEncoder Back_Winch_Encoder; // 絞盤馬達 (後)

    // private RelativeEncoder Front_Hook_Encoder; // 前鉤子(高度控制)
    // private RelativeEncoder Back_Hook_Encoder; // 後鉤子(高度控制)
    private RelativeEncoder Front_Angle_Encoder; // 前邊轉角馬達
    private RelativeEncoder Back_Angle_Encoder; // 後邊轉角馬達


    public void Climber_Setup_Spark() {
        Front_Winch = new CANSparkMax(Constants.Climber.FRONT_WINCH_CLIMBER, MotorType.kBrushed);
        Back_Winch = new CANSparkMax(Constants.Climber.BACK_WINCH_CLIMBER, MotorType.kBrushed);

        // Front_Hook = new CANSparkMax(Constants.Climber.FRONT_HOOK_NEO, MotorType.kBrushless);
        // Back_Hook = new CANSparkMax(Constants.Climber.BACK_HOOK_NEO, MotorType.kBrushless);
        Front_Angle = new CANSparkMax(Constants.Climber.FRONT_ANGLE_NEO, MotorType.kBrushless);
        Back_Angle = new CANSparkMax(Constants.Climber.BACK_ANGLE_NEO, MotorType.kBrushless);
    }

    public void Encoder_Setup() {
        Front_Winch_Encoder = Front_Winch.getEncoder();
        Back_Winch_Encoder = Back_Winch.getEncoder();

        // Front_Hook_Encoder = Front_Hook.getEncoder();
        // Back_Hook_Encoder = Back_Hook.getEncoder();
        Front_Angle_Encoder = Front_Angle.getEncoder();
        Back_Angle_Encoder = Back_Angle.getEncoder();

    }

    public void Encoder_Zero() { // 歸零
        Front_Winch_Encoder.setPosition(0);
        Back_Winch_Encoder.setPosition(0);

        // Front_Hook_Encoder.setPosition(0);
        // Back_Hook_Encoder.setPosition(0);
        Front_Angle_Encoder.setPosition(0);
        Back_Angle_Encoder.setPosition(0);
    }


    public void Front_Rise_Up() {

    }
}
