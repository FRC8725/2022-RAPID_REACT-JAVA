// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

// Final Check: 03.03.2022

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Timer;

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
  private double JoystickRightValue; 
  private double JoystickLeftValue;
  Joystick m_Joystick = new Joystick(Constants.Joystick.JOYSTICK_A);
  boolean joy_blue_button;

  Test Test = new Test();
  ShootSub ShootSub = new ShootSub();
  Limelight Limelight = new Limelight();
  ClimbSub ClimbSub = new ClimbSub();

  double timer_temp = 0;

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
    ShootSub.Init();
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
    ShootSub.Disable_Intake();
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
    ShootSub.ShooterPeriodic();
  }

  @Override
  public void autonomousInit() {
    Robot_Pause();
    ShootSub.Enable_Intake();
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    timer_temp = Timer.getFPGATimestamp();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    if (Timer.getFPGATimestamp() - timer_temp < 2.45) {
      DriveSub.Move(-.3, -.3);
    } else {
      DriveSub.Drive_Stop();
      ShootSub.Shoot(true);
      SmartDashboard.putNumber("Shoot Speed", .7);
    }
  }

  @Override
  public void teleopInit() {
    Robot_Pause();
    DriveSub.Encoder_Zero();
    ShootSub.Enable_Intake();
    SmartDashboard.putNumber("Shoot Speed", Constants.Shooter.SPEED);
  }

  boolean close = false;

  @Override
  public void teleopPeriodic() {
    ShootSub.Shoot(m_Joystick.getRawButton(Constants.Joystick.SHOOT_BUTTON));
    if (m_Joystick.getRawButton(8)) {
      Limelight.aim_target();
      SmartDashboard.putNumber("Shoot Speed", 0.7);
    } else {
      SmartDashboard.putNumber("Shoot Speed", Constants.Shooter.SPEED);
      // FIXME: THIS IS NOT OK -- NoodlesK
      // ------------------------------------ 
      // if(m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS) == 0) JoystickRightValue = 0;
      // else if(m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS) == 1) JoystickRightValue = -1;
      // else if(m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS) == -1)  JoystickRightValue = 1;
      // else if(m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS) > 0)  JoystickRightValue = 0.465205 * Math.cosh(5.35477 * -m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS) - 2.8561) + 0.511502;  
      // else  -JoystickRightValue = 0.465205 * Math.cosh(5.35477 * -m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS) - 2.8561) + 0.511502;

      // if(m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS) == 0)  JoystickLeftValue = 0;
      // else if(m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS) == 1)  JoystickLeftValue = -1;
      // else if(m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS) == -1)   JoystickLeftValue = 1;
      // else if(m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS) > 0)   -JoystickLeftValue = 0.465205 * Math.cosh(5.35477 * -m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS) - 2.8561) + 0.511502;
      // else  JoystickLeftValue = 0.465205 * Math.cosh(5.35477 * -m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS) - 2.8561) + 0.511502;
      // DriveSub.Move(JoystickLeftValue, JoystickRightValue);
      // Result: 戰損版Falcon * 1
      DriveSub.Move(-m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS), -m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS));
      
    }
    ShootSub.Intake_Button(m_Joystick.getRawButton(Constants.Joystick.INTAKE_BUTTON));
    ShootSub.Throw_Others_Button(m_Joystick.getRawButton(Constants.Joystick.THROW_OTHERS_BUTTON));
    // if (m_Joystick.getRawButton(Constants.Joystick.RISE_BUTTON) == true
    //     && m_Joystick.getRawButton(Constants.Joystick.RELEASE_BUTTON) == false)
    //   ClimbSub.Rise_Winch();
    // else if (m_Joystick.getRawButton(Constants.Joystick.RISE_BUTTON) == false
    //     && m_Joystick.getRawButton(Constants.Joystick.RELEASE_BUTTON) == true)
    //   ClimbSub.Release_Winch();
    // else ClimbSub.stop();
    ShootSub.Shoot(m_Joystick.getRawButton(Constants.Joystick.SHOOT_BUTTON));
    if(m_Joystick.getRawButton(Constants.Joystick.STRAIGHT_BUTTON)) DriveSub.Move(0.7, 0.7);    
    if(m_Joystick.getRawButton(Constants.Joystick.SGRAIGHT_BACK_BUTTON)) DriveSub.Move(-0.7, -0.7);

  }

  @Override
  public void disabledInit() {
    Robot_Pause();
    ShootSub.Disable_Intake();
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
