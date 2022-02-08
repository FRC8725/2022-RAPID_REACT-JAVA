package frc.robot.subsystem;

import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants;

public class Odometry {
    public AHRS ahrs;
    DifferentialDriveOdometry m_odometry;

    double x = 0;
    double y = 0;
    double angle = 0;
    double distance = 0;
    double begin_angle;

    public Odometry() {
        // 1, 2, 3 is B1 B2 B3
        // 4, 5, 6 is R1 R2 R3
        ahrs = new AHRS(SPI.Port.kMXP);
        m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(ahrs.getAngle()),
                new Pose2d(0, -3, new Rotation2d()));

    }

    public void init() {
        ahrs.reset();
        m_odometry.resetPosition(new Pose2d(0, -3, new Rotation2d()),
                Rotation2d.fromDegrees(ahrs.getAngle() - begin_angle));
    }

    public void update() {
        var position = DriveSub.get_Position();
        double left_encoder = Units.inchesToMeters(
                position[0] / Constants.DataSheet.BASE_GEARBOX_RATIO * Math.PI * Constants.DataSheet.HIGRIPWHEEL_R);
        double right_encoder = Units.inchesToMeters(
                position[1] / Constants.DataSheet.BASE_GEARBOX_RATIO * Math.PI * Constants.DataSheet.HIGRIPWHEEL_R);
        m_odometry.update(Rotation2d.fromDegrees(ahrs.getAngle()), left_encoder, right_encoder);
        x = get_position().getX();
        y = get_position().getY();
        angle = get_position().getRotation().getDegrees();
        distance = Math.sqrt(Math.pow(get_position().getX(), 2) + Math.pow(get_position().getY(), 2));
        SmartDashboard.putNumber("Gyro", ahrs.getAngle());
        SmartDashboard.putNumber("Begin", begin_angle);
    }

    private Pose2d get_position() {
        return m_odometry.getPoseMeters();
    }

    public double get_distance() { // distance
        return distance;
    }

    public double get_angle() { // angle
        return angle;
    }
    /*
     * 按下角度歸零 放在robot的
     * if (m_Joystick.getRawButton(8))
     * Odometry.angle_to_zero(Odometry.get_position().getX(),
     * Odometry.get_position().getY(), Odometry.m_angle);
     */
}
