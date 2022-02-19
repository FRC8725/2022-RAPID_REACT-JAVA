package frc.robot.subsystems;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.ColorSensor;
import frc.robot.Constants;

public class ShooterSubsystem {
    IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();
    ShooterCommand ShootCommand = new ShooterCommand();
    ColorSensor ColorSensor = new ColorSensor();

    public ShooterSubsystem() {
        SmartDashboard.putNumber("Rise Speed", Constants.Shooter.RISE_SPEED);
        SmartDashboard.putNumber("Intake Speed", Constants.Intake.INTAKE_SPEED);
        SmartDashboard.putNumber("Shoot Speed", Constants.Shooter.SPEED);
        SmartDashboard.putNumber("Lid_kp", Constants.Shooter.LID_kp);
        SmartDashboard.putNumber("Lid_ki", Constants.Shooter.LID_ki);
        SmartDashboard.putNumber("Lid_iLimit", Constants.Shooter.LID_iLimit);
        SmartDashboard.putNumber("Lid_kd", Constants.Shooter.LID_kd);
        if (IntakeSubsystem.get_is_upper() == false) {
            Intake_Lift(true);
        }
    }

    public void Intake(boolean run) {
        if (run) { // Intake down
            IntakeSubsystem.Run_Intake(SmartDashboard.getNumber("Intake Speed", Constants.Intake.INTAKE_SPEED));
        } else {
            IntakeSubsystem.Run_Intake(0);
        }
    }

    public void Intake_Lift(boolean Lift) {
        IntakeSubsystem.Intake_Lift(Lift);
    }

    public void Shoot(boolean shoot) {
        if (shoot) {
            ShootCommand.Run(SmartDashboard.getNumber("Rise Speed", 0));
            ShootCommand.Shoot(SmartDashboard.getNumber("Shoot Speed", 0));
        } else {
            if (ColorSensor.get_Color().blue > .3 || ColorSensor.get_Color().red > .3) {
                ShootCommand.Run(0);
            } else {
                ShootCommand.Run(SmartDashboard.getNumber("Rise Speed", 0));
            }
            ShootCommand.Shoot(0);
        }
        SmartDashboard.putNumber("Blue", ColorSensor.get_Color().blue);
        SmartDashboard.putNumber("Red", ColorSensor.get_Color().red);
    }

    public void Init() {
        IntakeSubsystem.Run_Intake(0);
        ShootCommand.Shoot(0);
        ShootCommand.Run(0);
    }
}
