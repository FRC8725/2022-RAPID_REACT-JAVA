package frc.robot.subsystem;

import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants;

public class Odometry {
    private AHRS gyro = new AHRS(I2C.Port.kMXP);
    DifferentialDriveOdometry m_odometry;

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
    /* 按下角度歸零 放在robot
    if (m_Joystick.getRawButton(8))
      Odometry.angle_to_zero(Odometry.get_position().getX(), Odometry.get_position().getY(), Odometry.m_angle);  
    */
}
