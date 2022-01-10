package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.lib.Drive;
import frc.robot.Constants;

public class DriveSub extends SubsystemBase {
    static MotorControllerGroup m_Driver[];
    static Encoder m_DriverEncoder[];
    static double Move_Speed = Constants.Driver.SPEED;

    Drive Drive = new Drive();

    public void Move_Set() {
        m_Driver = Drive.Drive_Setup(Constants.Driver.MOTOR_TYPE);
        m_DriverEncoder = Drive.Encoder_Setup();
    }

    public void Move(double LSpeed, double RSpeed) {
        m_Driver[0].set(LSpeed * Move_Speed);
        m_Driver[1].set(RSpeed * Move_Speed);
    }

    public void Encoder_Zero() {
        m_DriverEncoder[0].reset();
        m_DriverEncoder[1].reset();
    }

    public void Driver_Stop() {
        m_Driver[0].set(0);
        m_Driver[1].set(0);
    }
}
