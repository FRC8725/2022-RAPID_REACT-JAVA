package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;

public class ColorSensor {
    private final ColorSensorV3 ColorSensor = new ColorSensorV3(I2C.Port.kOnboard);

    public ColorSensor(){
        if(DriverStation.getAlliance() == Alliance.Red){

        }
        else if(DriverStation.getAlliance() == Alliance.Blue){

        }
        else{
            
        }
    }
    
    public Color get_Color() {
        return ColorSensor.getColor();
    }

    public Color Ball_Color() {
        return ColorSensor.getColor();
    }
    
    
}
