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
import frc.robot.lib.Gyro;

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
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  Joystick m_Joystick = new Joystick(Constants.Joystick.JOYSTICK_A);
  Timer m_Timer = new Timer();

  DriveSub DriveSub = new DriveSub();
  Auto Auto = new Auto();
  Gyro Gyro = new Gyro();

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */

  private void Robot_Pause() {
    DriveSub.Drive_Stop();
    DriveSub.Encoder_Zero();
    Gyro.zero_Yaw();
  }

  @Override
  public void robotInit() {
    Robot_Pause();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Yaw", Gyro.get_Yaw());
    SmartDashboard.putNumber("Time", m_Timer.get());
  }

  double startTime;

  @Override
  public void autonomousInit() {
    Robot_Pause();
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    m_Timer.reset();
    Auto.setup_Direction_PID();
  }

  @Override
  public void autonomousPeriodic() {
    double yaw = Gyro.get_Yaw(), pid;
    Auto.Direction_PID_setsetpoint(90);
    if (!Auto.is_Direction(2)) {
      pid = Auto.Direction_PID(yaw);
      m_Timer.stop();
      SmartDashboard.putNumber("PID", pid);
      DriveSub.Move(pid / 180, -pid / 180);
    } else {
      m_Timer.start();
    }

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
    DriveSub.Move(-m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS),
        -m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS));
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
