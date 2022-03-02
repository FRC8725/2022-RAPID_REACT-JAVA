package frc.robot.lib;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.Constants;

// 775 Red line
public class Intake_Pneumatic {
    TalonFX Intake_Motor, Lift_Motor;
    private PneumaticsControlModule PCM = new PneumaticsControlModule(Constants.Pneumatic.PCM_CAN);
    private DoubleSolenoid doubleSolenoid;
    Timer intake_timer = new Timer();

    public Intake_Pneumatic() {
        Intake_Motor = new TalonFX(Constants.Intake.INTAKE_MOTOR);
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
        if (intake_speed == 0) {
            Intake_Lift(true);
            intake_timer.stop();
            intake_timer.reset();
        } else {
            Intake_Lift(false);
            intake_timer.start();
        }
        if (intake_timer.get() > 0.8) Intake_Motor.set(ControlMode.PercentOutput, intake_speed);
        else Intake_Motor.set(ControlMode.PercentOutput, 0);
    }

    public boolean get_Intake() {
        if (doubleSolenoid.get() == Value.kForward) return true;
        else return false;
    }
}
