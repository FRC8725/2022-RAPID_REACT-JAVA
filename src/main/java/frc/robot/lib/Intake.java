package frc.robot.lib;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

import frc.robot.Constants;

// 775 Red line
public class Intake {
    CANSparkMax Intake, Lift_Motor;
    Timer Intake_Time = new Timer();
    DigitalInput is_upper = new DigitalInput(Constants.Intake.LIFT_SWITCH);

    public Intake() {
        Intake = new CANSparkMax(Constants.Intake.INTAKE_MOTOR, MotorType.kBrushless);
        Lift_Motor = new CANSparkMax(Constants.Intake.LIFT_MOTOR, MotorType.kBrushed);
        Intake_Time.reset();
    }

    public void Run_Intake(double Intake_speed) {
        Intake.set(Intake_speed);
    }

    public boolean is_Lift = false;
    private double lift_time = 4;

    public void Intake_Lift(boolean Lift) {
        if (Lift || (0 < Intake_Time.get() && Intake_Time.get() < lift_time) && is_Lift == false && is_upper.get() == false) {
            Lift_Motor.set(-1);
            Intake_Time.start();
        } else if (Lift || (0 < Intake_Time.get() && Intake_Time.get() < lift_time) && is_Lift == true) {
            Lift_Motor.set(1);
            Intake_Time.start();
        } else if (Lift == false && Intake_Time.get() > lift_time) {
            Lift_Motor.set(0);
            Intake_Time.stop();
            Intake_Time.reset();
            is_Lift = !is_Lift;
        }
        SmartDashboard.putNumber("Intake_Time", Intake_Time.get());
    }

    public boolean get_is_upper() {
        return is_upper.get();
    }
}
