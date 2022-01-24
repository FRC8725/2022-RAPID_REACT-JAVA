package frc.robot.lib;

import edu.wpi.first.wpilibj.I2C;

import com.kauailabs.navx.frc.AHRS;

public class Gyro {
    private AHRS gyro = new AHRS(I2C.Port.kMXP);

    public void zero_Yaw() {
        gyro.zeroYaw();
    }

    public double get_Yaw() { // z-axis of the bot
        return gyro.getYaw();
    }
}
