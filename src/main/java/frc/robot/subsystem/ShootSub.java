package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.lib.Intake;
import frc.robot.lib.Shooter;
import frc.robot.lib.ColorSensor;
import frc.robot.Constants;

public class ShootSub {
    Intake Intake = new Intake();
    Shooter Shooter = new Shooter();
    ColorSensor ColorSensor = new ColorSensor();

    public ShootSub() {
        SmartDashboard.putNumber("Rise Speed", Constants.Shooter.RISE_SPEED);
        SmartDashboard.putNumber("Intake Speed", Constants.Intake.INTAKE_SPEED);
        SmartDashboard.putNumber("Shoot Speed", Constants.Shooter.SPEED);
        SmartDashboard.putNumber("Lid_kp", Constants.Shooter.LID_kp);
        SmartDashboard.putNumber("Lid_ki", Constants.Shooter.LID_ki);
        SmartDashboard.putNumber("Lid_iLimit", Constants.Shooter.LID_iLimit);
        SmartDashboard.putNumber("Lid_kd", Constants.Shooter.LID_kd);
        if (Intake.get_is_upper() == false) {
            Intake_Lift(true);
        }
    }

    public void Intake(boolean run) {
        if (run) { // Intake down
            Intake.Run_Intake(SmartDashboard.getNumber("Intake Speed", Constants.Intake.INTAKE_SPEED));
        } else {
            Intake.Run_Intake(0);
        }
    }

    public void Intake_Lift(boolean Lift) {
        Intake.Intake_Lift(Lift);
    }

    public void Shoot(boolean shoot) {
        if (shoot) {
            Shooter.Run(SmartDashboard.getNumber("Rise Speed", Constants.Shooter.RISE_SPEED));
            Shooter.Shoot(SmartDashboard.getNumber("Shoot Speed", Constants.Shooter.SPEED));
        } else {
            if (ColorSensor.get_Color().blue > .3 || ColorSensor.get_Color().red > .3) {
                Shooter.Run(0);
            } else {
                Shooter.Run(SmartDashboard.getNumber("Rise Speed", Constants.Shooter.RISE_SPEED));
            }
            Shooter.Shoot(0);
        }
        SmartDashboard.putNumber("Blue", ColorSensor.get_Color().blue);
        SmartDashboard.putNumber("Red", ColorSensor.get_Color().red);
    }

    public void Init() {
        Intake.Run_Intake(0);
        Shooter.Shoot(0);
        Shooter.Run(0);
    }

}
