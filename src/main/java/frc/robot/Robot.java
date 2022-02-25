// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.cameraserver.CameraServer;

import frc.robot.subsystem.*;
import frc.robot.lib.Test;
import frc.robot.lib.Limelight;

// import frc.robot.lib.ColorSensor;

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
  private final SendableChooser<Boolean> m_Chooser_Color = new SendableChooser<>();

  Joystick m_Joystick = new Joystick(Constants.Joystick.JOYSTICK_A);
  boolean joy_blue_button;

  Test Test = new Test();
  ShootSub ShootSub = new ShootSub();
  Limelight Limelight = new Limelight();
  ClimbSub ClimbSub = new ClimbSub();

  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */

  private void Robot_Pause() {
    DriveSub.Drive_Stop();
    DriveSub.Encoder_Zero();
    Test.Motor_Stop();
    Test.Zero_Encoder();
    ClimbSub.stop();
  }

  @Override
  public void robotInit() {
    Robot_Pause();
    CameraServer.startAutomaticCapture();
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    m_Chooser_Color.setDefaultOption("Blue", true);
    m_Chooser_Color.addOption("Red", false);
    SmartDashboard.putData("Team_Color", m_Chooser_Color);
    SmartDashboard.putData("Auto choices", m_chooser);
    ShootSub.Init();
    DriveSub.Init();
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
    ShootSub.IntakePeriodic();
  }

  @Override
  public void autonomousInit() {
    Robot_Pause();
    ShootSub.Enable_Intake();
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
    Robot_Pause();
    DriveSub.Encoder_Zero();
    ShootSub.Enable_Intake();
    ClimbSub.init();
  }

  boolean close = false;

  @Override
  public void teleopPeriodic() {
    ShootSub.Shoot(m_Joystick.getRawButton(Constants.Joystick.SHOOT_BUTTON));
    if (m_Joystick.getRawButton(8)) {
      Limelight.update();
    } else {
      DriveSub.Move(-m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS),
          -m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS),
          m_Joystick.getRawButton(Constants.Joystick.HELF_SPEED_BUTTON));
    }
    ShootSub.Intake_Button(m_Joystick.getRawButton(Constants.Joystick.INTAKE_BUTTON));
  }

  @Override
  public void disabledInit() {
    Robot_Pause();
    ShootSub.Init();
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
    Robot_Pause();
    ShootSub.Enable_Intake();
  }

  @Override
  public void testPeriodic() {
    Test.Motor_Spin(m_Joystick.getRawButton(Constants.Test.SPIN_BUTTON));
    SmartDashboard.putNumber("TestEncoder", Test.get_Encoder());
    SmartDashboard.putBoolean("Button", m_Joystick.getRawButton(Constants.Test.SPIN_BUTTON));
  }

}