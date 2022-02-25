package frc.robot.lib;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsControlModule;

import frc.robot.Constants;

// 775 Red line
public class Intake_Pneumatic {
    CANSparkMax Intake_Motor, Lift_Motor;
    private PneumaticsControlModule PCM = new PneumaticsControlModule(Constants.Pneumatic.PCM_CAN);
    private DoubleSolenoid doubleSolenoid;

    public Intake_Pneumatic() {
        Intake_Motor = new CANSparkMax(Constants.Intake.INTAKE_MOTOR, MotorType.kBrushless);
        doubleSolenoid = PCM.makeDoubleSolenoid(Constants.Pneumatic.DOUBLESOLENOID_FORWARD_CHANNEL[0], Constants.Pneumatic.DOUBLESOLENOID_BACKWARD_CHANNEL[0]);
    }

    public void Disable_Compress() {
        PCM.disableCompressor();
    }

    public void Enable_Compress() {
        PCM.enableCompressorDigital();
    }

    private void Intake_Lift(boolean lift) {
        // if actually use this library, turn joystick to boolean.
        if (!lift) {
            doubleSolenoid.set(Value.kForward);
        } else {
            doubleSolenoid.set(Value.kReverse);
        }
    }

    public void Run_Intake(double intake_speed) {
        if (intake_speed == 0) Intake_Lift(true);
        else Intake_Lift(false);
        Intake_Motor.set(intake_speed);
    }

    public boolean get_Intake() {
        if (doubleSolenoid.get() == Value.kForward) return true;
        else return false;
    }
}
