package frc.robot.subsystem;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.lib.Drive;
import frc.robot.Constants;



public class DriveSub{

    MotorControllerGroup m_Driver[];
    static final double Move_Speed = Constants.Driver.SPEED;

    private static Drive Drive = new Drive("Spark");

    public void Move(double LSpeed, double RSpeed) {
        Drive.Motor_Run(LSpeed * Move_Speed, RSpeed * Move_Speed);
    }

    public void Encoder_Zero() {
        Drive.Encoder_Zero();
    }

    public void Drive_Stop() {
        Drive.Motor_Run(0, 0);
    }

    public static double[] get_Position() {
        return Drive.get_Position();
    }

    public double get_Staight() {
        double position[] = Drive.get_Position();
        double distance = Units.inchesToMeters(position[0] / Constants.DataSheet.BASE_GEARBOX_RATIO * Math.PI * Constants.DataSheet.HIGRIPWHEEL_R);
        return distance;
    }

    
}
