package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.lib.Intake_Pneumatic;
import frc.robot.lib.Shooter;
import frc.robot.lib.ColorSensor;
import frc.robot.Constants;

public class ShootSub {
    Intake_Pneumatic Intake = new Intake_Pneumatic();
    Shooter Shooter = new Shooter();
    ColorSensor ColorSensor = new ColorSensor();
    Boolean run_intake = false;

    public ShootSub() {
        SmartDashboard.putNumber("Rise Speed", Constants.Shooter.RISE_SPEED);
        SmartDashboard.putNumber("Intake Speed", Constants.Intake.INTAKE_SPEED);
        SmartDashboard.putNumber("Shoot Speed", Constants.Shooter.SPEED);
        SmartDashboard.putNumber("Lid_kp", Constants.Shooter.LID_kp);
        SmartDashboard.putNumber("Lid_ki", Constants.Shooter.LID_ki);
        SmartDashboard.putNumber("Lid_iLimit", Constants.Shooter.LID_iLimit);
        SmartDashboard.putNumber("Lid_kd", Constants.Shooter.LID_kd);
    }

    boolean second_loop = false;

    public void Intake_Button (boolean press) {
        if (press && !second_loop) {
            run_intake = !run_intake;
            second_loop = true;
        } else if (!press) {
            second_loop = false;
        }
        SmartDashboard.putBoolean("Intake", run_intake);

    }

    public void IntakePeriodic() {
        if (run_intake) { // Intake down
            Intake.Run_Intake(SmartDashboard.getNumber("Intake Speed", Constants.Intake.INTAKE_SPEED));
        } else {
            Intake.Run_Intake(0);
        }
    }
    
    public void ShooterPeriodic() {
        Shooter.Shoot(SmartDashboard.getNumber("Shoot Speed", 0));
    }

    public void Shoot(boolean shoot) {
        if (shoot) {
            Shooter.Run(SmartDashboard.getNumber("Rise Speed", 0));
        } else {
            if (ColorSensor.get_Color().blue > .3 || ColorSensor.get_Color().red > .3) {
                Shooter.Run(0);
            } else {
                Shooter.Run(SmartDashboard.getNumber("Rise Speed", 0));
            }
        }
        SmartDashboard.putNumber("Blue", ColorSensor.get_Color().blue);
        SmartDashboard.putNumber("Red", ColorSensor.get_Color().red);
    }

    public void Init() {
        Intake.Disable_Compress();
        run_intake = false;
        Shooter.Shoot(0);
        Shooter.Run(0);
    }

    public void Enable_Intake() {
        Intake.Enable_Compress();
        run_intake = true;
    }

}
