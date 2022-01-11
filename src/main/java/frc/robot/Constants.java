// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {

    public final class Driver {
        // CAN
        public final static String MOTOR_TYPE = "Spark"; // CAN or PWM or Spark
        public final static int LEFT_FRONT_MOTOR = 1;
        public final static int LEFT_BACK_MOTOR = 2;
        public final static int RIGHT_FRONT_MOTOR = 3;
        public final static int RIGHT_BACK_MOTOR = 4;
        // DIO
        public final static int LEFT_ENCODER = 1; // DIO 1 & 2
        public final static int RIGHT_ENCODER = 3; // DIO 3 & 4
        // Value
        public final static double SPEED = .7;
        public final static double ENCODER_PULSE = 526.;
        public final static double MOTOR_PERIMETER = 4.;
    }

    public static final class Shooter {
        // CAN
        public final static int LEFT_SHOOT_MOTOR[] = { 5 };
        public final static int RIGHT_SHOOT_MOTOR[] = { 6 };
        public final static int TEST_SPARK[] = { 7 };
        // Value
        public final static double SPEED = .3;
    }

    public final static class Pneumatic {
        public final static int COMPRESSOR = 0;
        // PCM PWM
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

        public final static int LEFT_MOTOR_AXIS = 1;
        public final static int RIGHT_MOTOR_AXIS = 3;

        public final static int SHOOT_BUTTON = 6;
        public final static int RELEASE_PRESSURE_BUTTON = 5;
    }

    public final class Test {
        public final static int MOTOR = 10;
        public final static double MOTOR_SPEED = .1;
    }

    public final class DataSheet {
        public final static int TALONFX_ENCODER_UNITS = 2048;
    }

}
