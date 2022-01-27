package frc.robot.subsystem;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.lib.Drive;
import frc.robot.Constants;

public class DriveSub extends SubsystemBase {
    static MotorControllerGroup m_Driver[];
    static double Move_Speed = Constants.Driver.SPEED;

    Drive Drive = new Drive("Spark");

    public DriveSub() {
        SmartDashboard.putNumber("Drive Speed", Move_Speed);
    }

    public void Move(double LSpeed, double RSpeed, boolean helf) {
        Move_Speed = SmartDashboard.getNumber("Drive Speed", Move_Speed);
        if (helf) Move_Speed *= 0.5;
        Drive.Motor_Run(LSpeed * Move_Speed, RSpeed * Move_Speed);
    }

    public void Encoder_Zero() {
        Drive.Encoder_Zero();
    }

    public void Drive_Stop() {
        Drive.Motor_Run(0, 0);
    }
}
