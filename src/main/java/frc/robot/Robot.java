// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystem.*;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  Joystick m_Joystick = new Joystick(Constants.Joystick.JOYSTICK_A);
  Timer m_Timer = new Timer();

  DriveSub DriveSub = new DriveSub();
  Pathwave Pathwave = new Pathwave();
  Auto Auto = new Auto();
  AutoShoot AutoShoot = new AutoShoot();
  Odometry Odometry;
  int nply = 0;

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */

  private void Robot_Pause() {
    DriveSub.Drive_Stop();
    DriveSub.Encoder_Zero();
  }

  private void Pathwave() {
    Pathwave();
  }

  @Override
  public void robotInit() {
    Robot_Pause();
    Pathwave();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    SmartDashboard.putNumber("Distance setpoint", 10);
    SmartDashboard.putNumber("NowPlaying", nply);
    Odometry = new Odometry();
    Odometry.init();
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Time", m_Timer.get());
    SmartDashboard.putNumber("Distance", DriveSub.get_Staight());
    Odometry.update();
    SmartDashboard.putNumber("m_angle", Odometry.get_angle());
    SmartDashboard.putNumber("m_distance", Odometry.get_distance());
  }

  double startTime;

  @Override
  public void autonomousInit() {
    Robot_Pause();
    Odometry.init();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    m_Timer.reset();
    Auto.setup_Distance_PID();
    Auto.Action();
  }

  double distance, pid, setpoint;

  @Override
  public void autonomousPeriodic() {
    // PID Test
    // setpoint = SmartDashboard.getNumber("Distance setpoint", 10);
    // Auto.Distance_PID_setsetpoint(setpoint);
    // pid = Auto.Distance_PID(DriveSub.get_Staight());
    // SmartDashboard.putNumber("PID", pid);
    // DriveSub.Move(pid, pid);
    //
    // ---------------------------------------------------------- //
    //
    // if (Math.abs(Gyro.get_Yaw()) > Constants.Auto.kangle && Gyro.get_Yaw()>1) {
    // SmartDashboard.putNumber("status", 1);
    // } else {
    // SmartDashboard.putNumber("status", 0);
    // if (time - startTime < 30) {
    // DriveSub.Move(.3, .3);
    // } else {
    // DriveSub.Move(0, 0);
    // }
    // }
  }

  @Override
  public void teleopInit() {
    DriveSub.Encoder_Zero();
    Robot_Pause();
  }

  @Override
  public void teleopPeriodic() {
    if (m_Joystick.getRawButton(Constants.Joystick.AIM_BUTTON)) {
      AutoShoot.Aim(Odometry.get_angle());
    } else {
      DriveSub.Move(-m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS),
        -m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS));
    }
  }

  @Override
  public void disabledInit() {
    Robot_Pause();
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
    Robot_Pause();
  }

  @Override
  public void testPeriodic() {
    if (m_Joystick.getRawButton(4))
      DriveSub.Move(-.5, .5);
    else
      DriveSub.Drive_Stop();
  }
}