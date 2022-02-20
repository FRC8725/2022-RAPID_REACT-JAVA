package frc.robot.lib;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder; // Spark

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
// import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Encoder; // Victor
import edu.wpi.first.wpilibj.CounterBase.EncodingType; // Victor
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber {

    private WPI_VictorSPX Winch_Front_VictorPG; // 絞盤馬達 (前)

    private CANSparkMax Angle_Back_SparkNeo; // 後邊轉角馬達

    private Encoder Winch_Front_Encoder_VictorPG; // 絞盤馬達 (前)

    private RelativeEncoder Angle_Back_Encoder_SparkNeo; // 後邊轉角馬達

    public Climber() {

        Winch_Front_Encoder_VictorPG = new Encoder(Constants.Climber.WINCH_FRONT_ENCODER_VICTORPG,
                Constants.Climber.WINCH_FRONT_ENCODER_VICTORPG + 1, false, EncodingType.k1X);
        Winch_Front_Encoder_VictorPG.setDistancePerPulse(7. / 360); // 一次轉

        Winch_Front_VictorPG = new WPI_VictorSPX(Constants.Climber.WINCH_FRONT_VICTORPG);


    }

    public void Encoder_Zero() { // 歸零
        Winch_Front_Encoder_VictorPG.reset();

        Angle_Back_Encoder_SparkNeo.setPosition(0); 

    }

    public void print_Encoders() {
        SmartDashboard.putNumber("Winch_Front", Winch_Front_Encoder_VictorPG.getDistance());
        SmartDashboard.putNumber("Angle_Back", Angle_Back_Encoder_SparkNeo.getPosition());
    }

    // 後桿轉角
    public void Back_Angle_Turn_Clockwise(boolean run) { // direction: (true 正轉,false 反轉)
        if (run) {
            Angle_Back_SparkNeo.set(Constants.Climber.ANGLE_ENCODER_SPEED);
        } else {
            Angle_Back_SparkNeo.set(0);
        }
    }

    public void Back_Angle_Turn_Unlockwise(boolean run) { // direction: (true 正轉,false 反轉)
        if (run) {
            Angle_Back_SparkNeo.set( - Constants.Climber.ANGLE_ENCODER_SPEED);
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

}
