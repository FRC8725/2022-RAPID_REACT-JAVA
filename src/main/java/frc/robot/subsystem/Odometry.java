package frc.robot.subsystem;

import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.util.Units;
// PID
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;



import frc.robot.Constants;

public class Odometry {
    private AHRS gyro = new AHRS(I2C.Port.kMXP);

    DifferentialDriveOdometry m_odometry;
    PIDController PID;

    double x = 0;
    double y = 0;
    double angle = 0; 
    double m_distance = 0; // mid distance

    public Odometry(int now_player) {
        // 1, 2, 3 is B1 B2 B3 
        // 4, 5, 6 is R1 R2 R3
        m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(gyro.getAngle()), new Pose2d(0, -3, new Rotation2d()));
    }
    
    public void init() {
        gyro.zeroYaw();
        m_odometry.resetPosition(new Pose2d(0, -3, new Rotation2d()), Rotation2d.fromDegrees(gyro.getAngle()));
    }
    
    public void zeroYaw() {
        gyro.zeroYaw();
    }

    public void update(double position[]) {    
        double left_encoder = Units.inchesToMeters(position[0] / Constants.DataSheet.BASE_GEARBOX_RATIO * Math.PI * Constants.DataSheet.HIGRIPWHEEL_R);
        double right_encoder = Units.inchesToMeters(position[1] / Constants.DataSheet.BASE_GEARBOX_RATIO * Math.PI * Constants.DataSheet.HIGRIPWHEEL_R);
        m_odometry.update(Rotation2d.fromDegrees(gyro.getAngle()), left_encoder, right_encoder);
        x = get_position().getX();
        y = get_position().getY(); 
        angle = get_position().getRotation().getDegrees();
        m_distance = Math.sqrt(Math.pow(get_position().getX(), 2) + Math.pow(get_position().getY(), 2));
    }

    public void angle_to_zero(double x, double y, double angle) {
        gyro.zeroYaw();
    }

    public Pose2d get_position() {
        return m_odometry.getPoseMeters();
    }

    public double m_distance() { // distance
        return m_distance;
    }

    public double m_angle() { // angle
        return angle;
    }
    
    // PID angle
    double angle_kp = 0, angle_ki = 0, angle_kd = 0, angle_min = 0, angle_max = 0;
    double setpoint = 0;

    public Odometry() {
        SmartDashboard.putNumber("angle_kp", angle_kp);
        SmartDashboard.putNumber("angle_ki", angle_ki);
        SmartDashboard.putNumber("angle_kd", angle_kd);
        SmartDashboard.putNumber("angle_min", angle_min);
        SmartDashboard.putNumber("angle_max", angle_max);
    }

    public void setup_Angle_PID() {
        angle_kp = SmartDashboard.getNumber("Angle_kp", 0);
        angle_ki = SmartDashboard.getNumber("Angle_ki", 0);
        angle_kd = SmartDashboard.getNumber("Angle_kd", 0);
        angle_max = SmartDashboard.getNumber("Angle_max", 0);
        angle_min = SmartDashboard.getNumber("Angle_min", 0);
        PID = new PIDController(angle_kp, angle_ki, angle_kd);
        PID.setIntegratorRange(angle_min, angle_max);
    }

    public void Angle_PID_setsetpoint(double _setpoint) {
        PID.setSetpoint(_setpoint);
        setpoint = _setpoint;
    }

    double Angle_lasttime = 0, Angle_error = 0, Angle_lasterror = 0, Angle_errorSum = 0, Angle_errorRate = 0, Angle_dt;

    public double Angle_PID(double measurement) {
        Angle_error = setpoint - measurement;
        Angle_dt = Timer.getFPGATimestamp() - Angle_lasttime;
        Angle_errorSum += Angle_error * Angle_dt;
        Angle_errorRate = (Angle_error - Angle_lasterror) * Angle_dt;
        double Angle_pspeed = angle_kp * Angle_error;
        double Angle_ispeed = angle_ki * Angle_errorSum;
        double Angle_dspeed = angle_kd * Angle_errorRate;
        Angle_lasttime = Timer.getFPGATimestamp();
        SmartDashboard.putNumber("Angle_pspd", Angle_pspeed);
        SmartDashboard.putNumber("Angle_ispd", Angle_ispeed);
        SmartDashboard.putNumber("Angle_dspd", Angle_dspeed);
        if (angle_min > Angle_ispeed || Angle_ispeed > angle_max) Angle_ispeed = 0;
        return Angle_pspeed + Angle_ispeed + Angle_dspeed;
    }

    public boolean is_Angle(double positionTolerance) {
        PID.setTolerance(positionTolerance);
        return PID.atSetpoint();
    }
    
}