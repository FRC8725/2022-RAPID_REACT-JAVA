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

    private CANSparkMax Angle_Back_SparkNeo; // 後邊轉角馬達

    private Encoder Winch_Front_Encoder_VictorPG; // 絞盤馬達 (前)
    private Encoder Winch_Back_Encoder_VictorPG; // 絞盤馬達 (後)

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

        Angle_Back_SparkNeo = new CANSparkMax(Constants.Climber.ANGLE_BACK_SPARKNEO, MotorType.kBrushless);

    }

    public void Encoder_Zero() { // 歸零
        Winch_Front_Encoder_VictorPG.reset();
        Winch_Back_Encoder_VictorPG.reset();

        Angle_Back_Encoder_SparkNeo.setPosition(0); 

    }

    // 後桿轉角
    private boolean direction_Back_Angle = true; // 旋轉方向
    private boolean buffer_Back_Angle = true; // 存取方向是否已經轉換過
    public void Back_Angle_Turn(boolean run) { // direction: (true 正轉,false 反轉)
        if (run && Angle_Back_Encoder_SparkNeo.getPosition() < 0.5 && direction_Back_Angle == true) {
            Angle_Back_SparkNeo.set(Constants.Climber.ANGLE_ENCODER_SPEED);
            buffer_Back_Angle = false;
            if (Angle_Back_Encoder_SparkNeo.getPosition() >= 0.5) {
                buffer_Back_Angle = false;
            }
        } else if (run && Angle_Back_Encoder_SparkNeo.getPosition() > 0 && direction_Back_Angle == false) {
            Angle_Back_SparkNeo.set(-Constants.Climber.ANGLE_ENCODER_SPEED);
            buffer_Back_Angle = false;
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
    public void Front_Winch_Turn_Up(boolean run) {
        Winch_Front_Encoder_VictorPG.getDistance();
        if (run) {
            Winch_Front_VictorPG.set(Constants.Climber.WINCH_ENCODER_SPEED);
        } else {
            Winch_Front_VictorPG.set(0);
        }
    }

    public void Front_Winch_Turn_Down(boolean run) {
        Winch_Front_Encoder_VictorPG.getDistance();
        if (run) {
            Winch_Front_VictorPG.set(- Constants.Climber.WINCH_ENCODER_SPEED);
        } else {
            Winch_Front_VictorPG.set(0);
        }
    }


    // 後伸縮桿
    private boolean direction_Back_Winch = true; // 旋轉方向
    private boolean buffer_Back_Winch = true; // 存取方向是否已經轉換過
    public void Back_Winch_Turn(boolean run) {
        if (run && Winch_Back_Encoder_VictorPG.getDistance() < 0.5 && direction_Back_Winch == true) {
            Winch_Back_VictorPG.set(Constants.Climber.WINCH_ENCODER_SPEED);
            buffer_Back_Winch = false;
            if (Winch_Back_Encoder_VictorPG.getDistance() >= 0.5) {
                buffer_Back_Winch = false;
            }
        } else if (run && Winch_Back_Encoder_VictorPG.getDistance() > 0 && direction_Back_Winch == false) {
            Winch_Back_VictorPG.set(-Constants.Climber.WINCH_ENCODER_SPEED);
            buffer_Back_Winch = false;
            if (Winch_Back_Encoder_VictorPG.getDistance() <= 0.5) {
                buffer_Back_Winch = false;
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
