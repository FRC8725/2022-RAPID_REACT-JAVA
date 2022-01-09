// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

    public final class Driver {
        // CAN
        public final static String MOTOR_PORT_TYPE = "CAN"; //CAN or PWM
        public final static int LEFT_FRONT_MOTOR = 0;
        public final static int LEFT_BACK_MOTOR = 1;
        public final static int RIGHT_FRONT_MOTOR = 2;
        public final static int RIGHT_BACK_MOTOR = 3;
        // DIO
        public final static int LEFT_ENCODER = 0; // DIO 0 & 1
        public final static int RIGHT_ENCODER = 2; // DIO 2 & 3
        // Value
        public final static double SPEED = .7;
        public final static double ENCODER_PULSE = 526.;
        public final static double MOTOR_PERIMETER = 4.;
    }

    public static final class Shooter {
        // CAN
        public final static int LEFT_SHOOT_MOTOR[] = { 4 };
        public final static int RIGHT_SHOOT_MOTOR[] = { 5 };
        public final static int TEST_SPARK[] = { 6 };
        // Value
        public final static double SPEED = .3;
    }

    public final static class Pneumatic {
        public final static int COMPRESSOR = 0;
        //PCM PWM
        public final static int DOUBLESOLENOID_FORWARD_CHANNEL[] = { 0, 2 };
        public final static int DOUBLESOLENOID_BACKWARD_CHANNEL[] = { 1, 3 };
        // Analog
        public final static int SENSOR_SCALE = 250;
        public final static int SENSOR_OFFSET = -25;
        public final static int SENSOR_A = 0;
        // PCM CAN
        public final static int PCM_CAN = 6;
    }

    public final class Joystick {
        public final static int JOYSTICK_A = 0;

        public final static int SHOOT_BUTTON = 6;
        public final static int RELEASE_PRESSURE_BUTTON = 5;
    }

    public final class DataSheet {
        public final static int TALONFX_ENCODER_UNITS = 2048;
    }

}
