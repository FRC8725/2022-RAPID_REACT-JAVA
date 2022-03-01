package frc.robot.subsystem;

import frc.robot.lib.Pneumatic;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;

public class ClimbSub {
    Pneumatic Pneumatic;
    VictorSPX Climb_Motor = new VictorSPX(Constants.Climber.CLIMBER_MOTOR);

    public void Rise_Winch() {
        Climb_Motor.set(ControlMode.PercentOutput, 1);
    }

    public void Release_Winch() {
        Climb_Motor.set(ControlMode.PercentOutput, -1);
    }

    public void stop () {
        Climb_Motor.set(ControlMode.PercentOutput, 0);
    }

}
