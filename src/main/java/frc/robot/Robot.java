// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {


  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private final SendableChooser<Boolean> m_Chooser_Color = new SendableChooser<>();
  //private final SlewRateLimiter speed = new SlewRateLimiter(0);
  //private final SlewRateLimiter rotation = new SlewRateLimiter(0);

  private Command m_Command;
  DriveSubsystem m_DriveSubsystem = new DriveSubsystem();
  ShooterSubsystem ShooterSubsystem = new ShooterSubsystem();
  Limelight Limelight = new Limelight();
  DriveSubsystem DriveSub = new DriveSubsystem();
  Joystick m_Joystick = new Joystick(Constants.Joystick.JOYSTICK_A);
  JoystickButton halfSpeed = new JoystickButton(m_Joystick, 7);

  private void Robot_Pause() {
    m_DriveSubsystem.Stop();
    m_DriveSubsystem.Encoder_Zero();
    ShooterSubsystem.Init();
  }

  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
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
    SmartDashboard.putNumber("Drive Speed", Constants.Driver.SPEED);
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    ShooterSubsystem.Shoot(m_Joystick.getRawButton(Constants.Joystick.SHOOT_BUTTON));
    if (m_Joystick.getRawButton(8)) {
      Limelight.update();
    } else {
      
      halfSpeed.whenPressed(() -> DriveSub.setMaxOutput(0.5)).whenReleased(() -> DriveSub.setMaxOutput(1.));
      DriveSub.tankDrive(-m_Joystick.getRawAxis(Constants.Joystick.LEFT_MOTOR_AXIS),
      -m_Joystick.getRawAxis(Constants.Joystick.RIGHT_MOTOR_AXIS));
    }
    ShooterSubsystem.Intake(m_Joystick.getRawButton(Constants.Joystick.INTAKE_BUTTON));

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {
    
  }

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
