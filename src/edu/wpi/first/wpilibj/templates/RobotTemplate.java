package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
public class RobotTemplate extends SimpleRobot {
    //Variable declaration zone
    
    //Controls
    Joystick leftstick;
    Joystick rightstick;
    //Motors and drive train
    RobotDrive drive;
    Jaguar feeler1;
    Jaguar feeler2;
    double feelerspeed;
    //Pneumatics
    DoubleSolenoid ds1;
    DoubleSolenoid ds2;
    public void robotInit() {
        System.out.println("Robot Initialization");
        //Controls
        leftstick = new Joystick(1);
        rightstick = new Joystick(2);
        //Motors and drive train
        feeler1 = new Jaguar(0); //Feeler1 - fix placeholder when completed
        feeler2 = new Jaguar(0); //Feeler2 - fix placeholder when completed
        drive = new RobotDrive(1,2,3,4);
        double feelerSpeed = leftstick.getThrottle();
        //Pneumatics
        ds1 = new DoubleSolenoid(0,0); // Fill in placeholder
        ds2 = new DoubleSolenoid(0,0); // Fill in placeholder
        ds1.set(DoubleSolenoid.Value.kOff); //Set them to neutral
        ds2.set(DoubleSolenoid.Value.kOff);
    }
    public void autonomous() {
    
    }
    public void operatorControl() {
        System.out.println("Entering Teleop");
        while(isOperatorControl() && isEnabled()) {
            drive.tankDrive(leftstick, rightstick);
            pneumaticsControl();
        }
    }
    
    public void pneumaticsControl() {
        if (rightstick.getRawButton(4)) {
            ds1.set(DoubleSolenoid.Value.kReverse);
            ds2.set(DoubleSolenoid.Value.kReverse);
        }
        if (rightstick.getRawButton(5)) {
            ds1.set(DoubleSolenoid.Value.kForward);
            ds2.set(DoubleSolenoid.Value.kForward);
        }
        if (rightstick.getRawButton(3)) {
            ds1.set(DoubleSolenoid.Value.kOff);
            ds2.set(DoubleSolenoid.Value.kOff);
        }        
    }
    public void feelControl() {
        if (leftstick.getRawButton(3)) {
            feeler1.set(feelerspeed);
            feeler2.set(feelerspeed);
        }
        else {
            feeler1.set(0.0);
            feeler2.set(0.0);
        }
    }
}