// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.AutoPath.BlueBackward1;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.FollowTrajectory;

public class RobotContainer {
  VictorSPX ClimberMotor = new VictorSPX(Constants.Climber.WINCH_VICTORPG);
  TalonFX ShooterLeftMotor = new TalonFX(Constants.Shooter.LEFT_SHOOT_MOTOR[0]);
  TalonFX ShooterRightMotor = new TalonFX(Constants.Shooter.RIGHT_SHOOT_MOTOR[0]);
  CANSparkMax IntakeMotor = new CANSparkMax(Constants.Intake.INTAKE_MOTOR, MotorType.kBrushless);
  CANSparkMax LeftFrontMotor = new CANSparkMax(Constants.Driver.LEFT_FRONT_MOTOR, MotorType.kBrushless);
  CANSparkMax LeftBackMotor = new CANSparkMax(Constants.Driver.LEFT_BACK_MOTOR, MotorType.kBrushless);
  CANSparkMax RightFrontMotor = new CANSparkMax(Constants.Driver.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
  CANSparkMax RightBackMotor = new CANSparkMax(Constants.Driver.RIGHT_BACK_MOTOR, MotorType.kBrushless);
  MotorControllerGroup LeftMotor = new MotorControllerGroup(LeftFrontMotor, LeftBackMotor);
  MotorControllerGroup RightMotor = new MotorControllerGroup(RightFrontMotor, RightBackMotor);
  DifferentialDrive Drive = new DifferentialDrive(LeftMotor, RightMotor);
  AHRS Gyro = new AHRS(Port.kMXP);
  DifferentialDriveOdometry Odometry;
  RelativeEncoder RightEncoder = RightFrontMotor.getEncoder();
  RelativeEncoder LeftEncoder = LeftFrontMotor.getEncoder();
  DriveSubsystem DriveSubsystem;
  BlueBackward1 blueBackward1;


  
  public RobotContainer() {
    
    configureButtonBindings();
  }

 
  private void configureButtonBindings() {
    Joystick Joystick = new Joystick(0);
    JoystickButton Pneumatics_Push = new JoystickButton(Joystick, 1);
    JoystickButton PG_Down = new JoystickButton(Joystick, 2);
    JoystickButton Pneumatics_Pull = new JoystickButton(Joystick, 3);
    JoystickButton PG_Up = new JoystickButton(Joystick, 4);
    JoystickButton IntakeButton = new JoystickButton(Joystick, 5);
    JoystickButton ShooterButton = new JoystickButton(Joystick, 6);
    JoystickButton HalfSpeed = new JoystickButton(Joystick, 7);
    JoystickButton LimlighButton = new JoystickButton(Joystick, 8);

    HalfSpeed.whenHeld(new InstantCommand(() -> DriveSubsystem.setMaxOutput(.5)));
    
  }
  
 
  public Command getAutonomousCommand() { 
    Trajectory Trajectory = new Trajectory();
    return new SequentialCommandGroup(
      new InstantCommand(() -> DriveSubsystem.resetOdometry(new Pose2d(0, 0, new Rotation2d(0)))),
      new ParallelCommandGroup(
        new InstantCommand(() -> FollowTrajectory( ))
        //new IntakeSubsystem(IntakeMotor)
      )
      
    );
  }
}
