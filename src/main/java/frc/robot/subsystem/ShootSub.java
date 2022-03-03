package frc.robot.subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.lib.Intake_Pneumatic;
import frc.robot.lib.Shooter;
import frc.robot.lib.ColorSensor;
import frc.robot.Constants;

public class ShootSub {
    Intake_Pneumatic Intake = new Intake_Pneumatic();
    Shooter Shooter = new Shooter();
    ColorSensor ColorSensor = new ColorSensor();
    Boolean run_intake = false;
    boolean enable_throw = true;
    Timer m_timer = new Timer();
    boolean team_color = true; // default: blue
    boolean ball_color = true; // default: blue

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
            m_timer.stop();
            m_timer.reset();
        } else if (!press) {
            second_loop = false;
        }
        SmartDashboard.putBoolean("Intake", run_intake);

    }

    boolean second_loop2 = false;

    public void Throw_Others_Button(boolean press) {
        if (press && !second_loop2) {
            enable_throw = !enable_throw;
            second_loop2 = true;
            m_timer.stop();
            m_timer.reset();
        } else if (!press) {
            second_loop2 = false;
        }
        SmartDashboard.putBoolean("Throw", enable_throw);

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
        if(DriverStation.getAlliance() == Alliance.Blue) team_color = true;
        else team_color = false;
    }

    public void Shoot(boolean shoot) {
        double timeset = .18, reverse_time = .1;
        if (shoot) {
            Shooter.Run(SmartDashboard.getNumber("Rise Speed", 0));
            m_timer.stop();
            m_timer.reset();
        } else {
            if (ColorSensor.get_Color().blue > .33 || ColorSensor.get_Color().red > .33) {
                m_timer.start();
                if (ColorSensor.get_Color().blue > .33) ball_color = true;
                else ball_color = false;
            }
            if ((ColorSensor.get_Color().blue > .33 || ColorSensor.get_Color().red > .33) && m_timer.get() >= timeset) Shooter.Run(0);
            else if (m_timer.get() >= timeset - reverse_time && m_timer.get() < timeset) Shooter.Run(-.5);
            else Shooter.Run(SmartDashboard.getNumber("Rise Speed", 0));
            if (((!team_color && ball_color) || (team_color && !ball_color)) && m_timer.get() > 0 && enable_throw) {
                Shooter.Run(-1);
                Timer.delay(.7);
                m_timer.stop();
                m_timer.reset();
            }
        }
        SmartDashboard.putNumber("Shoot Timer", m_timer.get());
        SmartDashboard.putNumber("Blue", ColorSensor.get_Color().blue);
        SmartDashboard.putNumber("Red", ColorSensor.get_Color().red);
    }

    public void Init() {
        Shooter.Shoot(0);
        Shooter.Run(0);
        m_timer.reset();
    }

    public void Disable_Intake() {
        Intake.Disable_Compress();
        run_intake = false;
    }

    public void Enable_Intake() {
        Intake.Enable_Compress();
        run_intake = true;
    }

}
