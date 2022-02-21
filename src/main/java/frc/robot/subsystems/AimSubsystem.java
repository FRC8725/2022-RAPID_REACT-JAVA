package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.Constants;

public class AimSubsystem extends CommandBase{
    double tx, SteeringAdjust, ts, LastError, ta, ty, distance, Kp, Kd;
    boolean tv;
    DriveSubsystem DriveSubsystem;
    public AimSubsystem(DriveSubsystem DriveSubsystem){
        SteeringAdjust = 0;
        LastError = 0;
        this.DriveSubsystem = DriveSubsystem;
    }

    public void Aim(){
        update();
        double kp = SmartDashboard.getNumber("limelight kp", .0);
        double kd = SmartDashboard.getNumber("limelight kd", .0);
        double dt = tx - LastError;
        LastError = tx;

        if (tx < -0.1 || tx > .1) {
            SteeringAdjust = kp * tx + kd * dt;
            double left = Math.max(Math.min(SteeringAdjust, 1), -1);
            double right = Math.max(Math.min(-SteeringAdjust, 1), -1);
            DriveSubsystem.tankDrive(left, right);
        } else if (tx == .0) {
            DriveSubsystem.tankDrive(.5, -.5);
        }
    }

    public void update() {
        tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(-1);
        tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getBoolean(false);
        ts = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(.0);
        ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(.0);
        ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(.0);
        SmartDashboard.putNumber("limelight speed", SteeringAdjust);
        SmartDashboard.putNumber("limelight tx", tx);
        calcV();

    }

    public void calcV() {
        if (ty == 0){
            distance = 0;
            return;
        }
        distance = Math.tan(Constants.Limelight.PRESETA + ty)/Constants.Limelight.HEIGH_DIFF;
        SmartDashboard.putNumber("Distance", distance);
    }

    @Override
    public void initialize(){
        SmartDashboard.putNumber("Limelight_Kp", .03);
        SmartDashboard.putNumber("Limelight_Kd", .08);
    }





}
