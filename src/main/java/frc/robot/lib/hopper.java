package frc.robot.lib;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class Hopper {
    private CANSparkMax NEO_1;
    private CANSparkMax NEO_2;

    private RelativeEncoder Encoder_NEO_1;
    private RelativeEncoder Encoder_NEO_2;

    public void hopper_Setup_Spark() {
        NEO_1 = new CANSparkMax(Constants.HOPPER.HOPPER_NEO_1, MotorType.kBrushless);
        NEO_2 = new CANSparkMax(Constants.HOPPER.HOPPER_NEO_2, MotorType.kBrushless);
    }

    public void Encoder_Setup() {
        Encoder_NEO_1 = NEO_1.getEncoder();
        Encoder_NEO_2 = NEO_2.getEncoder();
    }

    public void Encoder_Set_Zero() {
        Encoder_NEO_1.setPosition(0);
        Encoder_NEO_2.setPosition(0);
    }

}