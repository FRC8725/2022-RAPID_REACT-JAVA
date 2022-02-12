// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.subsystem.*;
import frc.robot.lib.Climber;

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
  boolean joy_blue_button;

  DriveSub DriveSub = new DriveSub();
  Climber Climber = new Climber();

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */

  private void Robot_Pause() {
    DriveSub.Drive_Stop();
    DriveSub.Encoder_Zero();
  }

  @Override
  public void robotInit() {
    Robot_Pause();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    joy_blue_button = m_Joystick.getRawButton(Constants.Joystick.CLIMBER_WINTH_BUTTON);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and
   * test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different
   * autonomous modes using the dashboard. The sendable chooser code works with
   * the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
   * chooser code and
   * uncomment the getString line to get the auto name from the text box below the
   * Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure
   * below with additional strings. If using the SendableChooser make sure to add
   * them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    Robot_Pause();
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  @Override
  public void teleopInit() {
    DriveSub.Encoder_Zero();

    Robot_Pause();
  }


  @Override
  public void teleopPeriodic() {
    DriveSub.Move(m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS),
        m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS));
    
    Climber.print_Encoders();
    
    // Climber 前伸縮
    if (m_Joystick.getRawButton(Constants.Joystick.CLIMBER_FRONT_UP_BUTTON)) {
        Climber.Front_Winch_Turn_Up(true);
        Climber.Front_Winch_Turn_Down(false);
    } else if (m_Joystick.getRawButton(Constants.Joystick.CLIMBER_FRONT_DOWN_BUTTON)) {
        Climber.Front_Winch_Turn_Up(false);  
        Climber.Front_Winch_Turn_Down(true);
    } else {
        Climber.Front_Winch_Turn_Up(false); 
        Climber.Front_Winch_Turn_Down(false);
    }
    
    // Climber 後伸縮
    if (m_Joystick.getRawButton(Constants.Joystick.CLIMBER_BACK_UP_BUTTON)) {
        Climber.Back_Winch_Turn_Up(true);
        Climber.Back_Winch_Turn_Down(false);
    } else if (m_Joystick.getRawButton(Constants.Joystick.CLIMBER_BACK_DOWN_BUTTON)) {
        Climber.Back_Winch_Turn_Up(false);
        Climber.Back_Winch_Turn_Down(true);
    } else {
      Climber.Back_Winch_Turn_Up(false);
      Climber.Back_Winch_Turn_Down(false);
    }

    // Climber 轉角度
    if (m_Joystick.getPOV(Constants.Joystick.CLIMBER_ANGLE_POV) == 90) { // 右側
      Climber.Back_Angle_Turn_Clockwise(true);
      Climber.Back_Angle_Turn_Unlockwise(false);
    } else if (m_Joystick.getPOV(Constants.Joystick.CLIMBER_ANGLE_POV) == 270) { // 左側
      Climber.Back_Angle_Turn_Clockwise(false);
      Climber.Back_Angle_Turn_Unlockwise(true);
    } else if (m_Joystick.getPOV(Constants.Joystick.CLIMBER_ANGLE_POV) == -1) {
      Climber.Back_Angle_Turn_Clockwise(false);
      Climber.Back_Angle_Turn_Unlockwise(false);
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
  }
}
