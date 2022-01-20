package frc.robot.lib;

import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;


public class Climber {
    private CANSparkMax SparkMax_1;
    private CANSparkMax SparkMax_2;

    private CANSparkMax NEO_1;
    private CANSparkMax NEO_2;
    private CANSparkMax NEO_3;
    private CANSparkMax NEO_4;

    private RelativeEncoder Encoder_SparkMax_1;
    private RelativeEncoder Encoder_SparkMax_2;

    private RelativeEncoder Encoder_NEO_1;
    private RelativeEncoder Encoder_NEO_2;
    private RelativeEncoder Encoder_NEO_3;
    private RelativeEncoder Encoder_NEO_4;


    public void Climber_Setup_Spark() {
        SparkMax_1 = new CANSparkMax(Constants.Climber.CLIMBER_SPARKMAX_0, MotorType.kBrushed);
        SparkMax_2 = new CANSparkMax(Constants.Climber.CLIMBER_SPARKMAX_1, MotorType.kBrushed);

        NEO_1 = new CANSparkMax(Constants.Climber.CLIMBER_NEO_0, MotorType.kBrushless);
        NEO_2 = new CANSparkMax(Constants.Climber.CLIMBER_NEO_1, MotorType.kBrushless);
        NEO_3 = new CANSparkMax(Constants.Climber.CLIMBER_NEO_2, MotorType.kBrushless);
        NEO_4 = new CANSparkMax(Constants.Climber.CLIMBER_NEO_3, MotorType.kBrushless);
    }

    public void Encoder_Setup() {
        Encoder_SparkMax_1 = SparkMax_1.getEncoder();
        Encoder_SparkMax_2 = SparkMax_2.getEncoder();

        Encoder_NEO_1 = NEO_1.getEncoder();
        Encoder_NEO_2 = NEO_2.getEncoder();
        Encoder_NEO_3 = NEO_3.getEncoder();
        Encoder_NEO_4 = NEO_4.getEncoder();

    }

    public void Encoder_Zero() {
        Encoder_SparkMax_1.setPosition(0);
        Encoder_SparkMax_2.setPosition(0);

        Encoder_NEO_1.setPosition(0);
        Encoder_NEO_2.setPosition(0);
        Encoder_NEO_3.setPosition(0);
        Encoder_NEO_4.setPosition(0);
    }

}
