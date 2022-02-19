package frc.robot.commands;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;

public class ColorSensor {
    
    private final I2C.Port i2cport = I2C.Port.kOnboard;
    private final ColorSensorV3 ColorSensor = new ColorSensorV3(i2cport);
    Boolean Team_Color;
    
    public Color get_Color() {
    return ColorSensor.getColor();
    }

    public Color Ball_Color() {
        Color detected_Color = ColorSensor.getColor();
        return detected_Color;
    }
    
    
}
