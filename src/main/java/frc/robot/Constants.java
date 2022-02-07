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

        public final static int CLIMBER_WINTH_BUTTON = 1;

    }

    public final class Test {
        // Motors
        public final static int MOTOR = 10;
        public final static double MOTOR_SPEED = .5;
        // Joystick
        public final static int SPIN_BUTTON = 5;
    }

    public final class DataSheet { // @@
        public final static int TALONFX_ENCODER_UNITS = 2048;
        public final static double PG_ENCODER_PPR = 7.;
    }

    public final static class Climber {

        // Encoder 值
        public final static int WINCH_FRONT_ENCODER_VICTORPG = 6; // 絞盤馬達 (前) ENCODER DIO 6 & 7
        public final static int WINCH_BACK_ENCODER_VICTORPG = 8; // 絞盤馬達 (後) ENCODER  DIO 8 & 9

        // public final static int HOOK_FRONT_SPARKNEO = 1; // 前鉤子(高度控制)
        // public final static int HOOK_BACK_SPARKNEO = 2; // 後鉤子(高度控制)
        public final static int ANGLE_FRONT_SPARKNEO = 11; // 前邊轉角馬達
        public final static int ANGLE_BACK_SPARKNEO = 12; // 後邊轉角馬達

        public final static int WINCH_FRONT_VICTORPG = 9; // 絞盤馬達 (前)
        public final static int WINCH_BACK_VICTORPG = 10; // 絞盤馬達 (後)


        public final static double ANGLE_ENCODER_SPEED = .3; // Angle Encoder 增加量
        public final static double WINCH_ENCODER_SPEED = .3; // Winch Encoder 增加量


        // ANGLE_FRONT_SPARKNEO PID 常數
        public final static double ANGLE_FRONT_SPARKNEO_KP = 0;
        public final static double ANGLE_FRONT_SPARKNEO_KI = 0;
        public final static double ANGLE_FRONT_SPARKNEO_KD = 0;
        public final static double ANGLE_FRONT_SPARKNEO_HIGH_I_MIN = 0.5;
        public final static double ANGLE_FRONT_SPARKNEO_HIGH_I_MAX = 0.7;
        public final static double ANGLE_FRONT_SPARKNEO_LOW_I_MIN = -0.1;
        public final static double ANGLE_FRONT_SPARKNEO_LOW_I_MAX = 0.1;
        public final static double ANGLE_FRONT_SPARKNEO_HIGH_SETPOINT = 0.6;
        public final static double ANGLE_FRONT_SPARKNEO_LOW_SETPOINT = 0;

        // ANGLE_BACK_SPARKNEO PID 常數
        public final static double ANGLE_BACK_SPARKNEO_KP = 0;
        public final static double ANGLE_BACK_SPARKNEO_KI = 0;
        public final static double ANGLE_BACK_SPARKNEO_KD = 0;
        public final static double ANGLE_BACK_SPARKNEO_HIGH_I_MIN = 0.5;
        public final static double ANGLE_BACK_SPARKNEO_HIGH_I_MAX = 0.7;
        public final static double ANGLE_BACK_SPARKNEO_LOW_I_MIN = -0.1;
        public final static double ANGLE_BACK_SPARKNEO_LOW_I_MAX = 0.1;
        public final static double ANGLE_BACK_SPARKNEO_HIGH_SETPOINT = 0.6;
        public final static double ANGLE_BACK_SPARKNEO_LOW_SETPOINT = 0;

        // WINCH_BACK_VICTORPG PID 常數
        public final static double WINCH_BACK_VICTORPG_KP = 0;
        public final static double WINCH_BACK_VICTORPG_KI = 0;
        public final static double WINCH_BACK_VICTORPG_KD = 0;
        public final static double WINCH_BACK_VICTORPG_HIGH_I_MIN = 0.5;
        public final static double WINCH_BACK_VICTORPG_HIGH_I_MAX = 0.7;
        public final static double WINCH_BACK_VICTORPG_LOW_I_MIN = -0.1;
        public final static double WINCH_BACK_VICTORPG_LOW_I_MAX = 0.1;
        public final static double WINCH_BACK_VICTORPG_HIGH_SETPOINT = 0.6;
        public final static double WINCH_BACK_VICTORPG_LOW_SETPOINT = 0;
    }

}
