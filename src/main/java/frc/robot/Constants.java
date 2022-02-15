// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// All of the speed is set as default speed
public final class Constants {

    public final class Driver {
        // CAN
        public final static String MOTOR_TYPE = "Spark"; // CAN or PWM or Spark
        public final static int LEFT_FRONT_MOTOR = 1;
        public final static int LEFT_BACK_MOTOR = 2;
        public final static int RIGHT_FRONT_MOTOR = 3;
        public final static int RIGHT_BACK_MOTOR = 4;

        // Value
        public final static double SPEED = .7;
        public final static double ENCODER_PULSE = 526.;
        public final static double MOTOR_PERIMETER = 4.;
    }

    public static final class Shooter {
        // CAN
        public final static int LEFT_SHOOT_MOTOR[] = { 5 };
        public final static int RIGHT_SHOOT_MOTOR[] = { 6 };
        public final static int LID_MOTOR = 8;

        // Riser_Ultrasonic
        public final static int ULTRASONIC = 0;

        // Value
        public final static double SPEED = .4; // default speed

        // PID
        public final static double LID_kp = 0.042;
        public final static double LID_ki = 0;
        public final static double LID_iLimit = 0;
        public final static double LID_kd = 0;

        // Rise
        public final static int RISER_MOTOR = 7;
        public final static double RISE_SPEED = .2;
    }

    public static final class Intake {
        // CAN
        public final static int LIFT_MOTOR = 12;
        public final static int INTAKE_MOTOR = 13;
        public final static double INTAKE_SPEED = .7;
        // DIO
        public final static int LIFT_SWITCH = 0;
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

        public final static int OPEN_LID = 1;
        public final static int CLOSE_LID = 3;
        public final static int INTAKE_BUTTON = 5;
        public final static int SHOOT_BUTTON = 6;
        public final static int HELF_SPEED_BUTTON = 7;
    }

    public static final class Test {
        // Motors
        public final static int MOTOR = 10;
        public final static double MOTOR_SPEED = .1;
        // Joystick
        public final static int SPIN_BUTTON = 5;
        // Encoder
        public final static int ENCODER[] = { 2, 3 };
    }

    public final class DataSheet {
        // Motors
        public final static int TALONFX_ENCODER_UNITS = 2048;
        public final static int CIMCODER_PPR = 20;
        public final static double PG_ENCODER_PPR = 7.;
        public final static int REDLINE_ENCODER_CPR = 1024;
    }

    public final static class Climber {

        // Encoder 值
        public final static int WINCH_FRONT_ENCODER_VICTORPG = 6; // 絞盤馬達 (前) ENCODER DIO 6 & 7
        public final static int WINCH_BACK_ENCODER_VICTORPG = 8; // 絞盤馬達 (後) ENCODER  DIO 8 & 9

        public final static int ANGLE_BACK_SPARKNEO = 11; // 後邊轉角馬達

        public final static int WINCH_FRONT_VICTORPG = 9; // 絞盤馬達 (前)
        public final static int WINCH_BACK_VICTORPG = 10; // 絞盤馬達 (後)

        public final static double ANGLE_SPEED = 1; // Angle Encoder 增加量
        public final static double WINCH_SPEED = 1; // Winch Encoder 增加量
    }
}