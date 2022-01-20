package frc.robot.lib;

import org.opencv.videoio.VideoCapture;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

public class Camara {

    private VideoCapture capture = new VideoCapture(1);
    private Mat image = new Mat();

    public void get_camera() {
        capture.read(image);
        HighGui.imshow("Something??", image);
        HighGui.waitKey();
    }
}
