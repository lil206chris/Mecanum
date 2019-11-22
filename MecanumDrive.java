package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "MecanumDriveChris", group = "test")
public class MecanumDriveChris extends OpMode {
    public DcMotor frontrightmotor;
    public DcMotor frontleftmotor;
    public DcMotor backrightmotor;
    public DcMotor backleftmotor;
    public DcMotor pick;
    public DcMotor elevator1;
    public Servo pickServo1;
    public Servo pickServo2;
    public boolean pickUp;

    @Override
    public void start(){ super.start();}

    @Override
    public void init() {
        pickServo1 = hardwareMap.get(Servo.class, "pickServo1");
        pickServo2 = hardwareMap.get(Servo.class, "pickServo2");
        frontleftmotor = hardwareMap.get(DcMotor.class, "frontleft");
        frontrightmotor = hardwareMap.get(DcMotor.class, "frontright");
        backleftmotor = hardwareMap.get(DcMotor.class, "backleft");
        backrightmotor = hardwareMap.get(DcMotor.class, "backright");
        pick = hardwareMap.get(DcMotor.class, "pick");
        elevator1 = hardwareMap.get(DcMotor.class, "elevator");
        frontleftmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backleftmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontrightmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backrightmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        pick.setDirection(DcMotorSimple.Direction.REVERSE);
        pickServo1.setDirection(Servo.Direction.REVERSE);
        pickServo2.setDirection(Servo.Direction.FORWARD;
        elevator1.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void elevator(double power)
    {
        elevator1.setPower(power);
    }
    public void Drive(double fleft,double bleft, double fright, double bright)
    {
        frontleftmotor.setPower(fleft);
        backleftmotor.setPower(bleft);
        frontrightmotor.setPower(fright);
        backrightmotor.setPower(bright);
    }
    @Override
    public void loop()
    {
        double leftStickY = Range.clip(gamepad1.left_stick_y, -1, 1);
        double leftStickX = Range.clip(gamepad1.left_stick_x, -1, 1);
        double hypo = Math.hypot(leftStickX, leftStickY);
        double roAngle = Math.atan2(leftStickY, -leftStickX) - Math.PI /4;
        double rightStickX = Range.clip(gamepad1.right_stick_x, -1, 1);
        Drive(  hypo * Math.cos(roAngle) - rightStickX,
                hypo * Math.sin(roAngle) - rightStickX,
                hypo * Math.sin(roAngle) + rightStickX,
                hypo * Math.cos(roAngle) + rightStickX);


        if(gamepad2.y)
        {
            pickServo1.setPosition(0);
            //pickServo2.setPosition(0);
        }
        if(gamepad2.x)
        {
            pickServo1.setPosition(.5);
            //pickServo2.setPosition(0);
        }



        if(gamepad2.a)
        {
            pick.setPower(1);
        }
        else if (gamepad2.b){
            pick.setPower(-1);
        }
        else{
            pick.setPower(0);
        }


        double g2LeftStickY = Range.clip(gamepad2.left_stick_y, -1, 1);
        elevator(g2LeftStickY);

    }
    public void stop()
    {
        super.stop();
        frontleftmotor.setPower(0);
        frontrightmotor.setPower(0);
        backleftmotor.setPower(0);
        backrightmotor.setPower(0);
    }
}
