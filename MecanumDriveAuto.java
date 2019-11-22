
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "ChrisAuto", group = "team")
public class MecanumAuto extends LinearOpMode{
    public DcMotor frontrightmotor;
    public DcMotor frontleftmotor;
    public DcMotor backrightmotor;
    public DcMotor backleftmotor;
    @Override
    public void runOpMode(){
        frontleftmotor = hardwareMap.get(DcMotor.class, "frontleft");
        frontrightmotor = hardwareMap.get(DcMotor.class, "frontright");
        backleftmotor = hardwareMap.get(DcMotor.class, "backleft");
        backrightmotor = hardwareMap.get(DcMotor.class, "backright");
        frontleftmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backleftmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontrightmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backrightmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        while(!isStarted()){
            //nothing just to wait for it to actually start
        }
        moveToVector(90, 1/2, 0, 1000);
        stopping();
        moveToVector(0,1/2,0, 1000);
        stopping();
        // add grabing platform here
        moveToVector(180, 2, 0, 1000);
        stopping();
        moveToVector(-90,1/2, 0, 2000,);
        stopping();
        moveToVector(0,1/2,0, 1000);
        stopping();
        moveToVector(-90,1/2,0, 1000);
        stopping();
        moveToVector(0,1/2,0, 1000);
        stopping();
        moveToVector(180,1/2,0, 1000);
        stopping();
        moveToVector(90,1/2,0, 1000);
        stopping();
        moveToVector(180,1/2,0, 1000);
        stopping();
        moveToVector(90,1/2,0, 2000);
        stopping();
    }
    //Blue Foundation + stone
    /**
     moveToVector(90, 1/2, 0, 1000);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     // add grabing platform here
     moveToVector(180, 2, 0, 1000);
     stopping();
     moveToVector(-90,1/2, 0, 2000,);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     moveToVector(-90,1/2,0, 1000);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     moveToVector(180,1/2,0, 1000);
     stopping();
     moveToVector(90,1/2,0, 1000);
     stopping();
     moveToVector(180,1/2,0, 1000);
     stopping();
     moveToVector(90,1/2,0, 2000);
     stopping();
     */
    //Red Foundation noStone
    /**
     moveToVector(90, 1/2, 0, 1000);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     // add grabing platform here
     moveToVector(180, 2, 0, 1000);
     stopping();
     moveToVector(-90,1/2, 0, 1000,);
     stopping();
     moveToVector(-90,1/2, 0, 1000,);
     stopping();
     */
    //Red Foundation + stone
    /**
     moveToVector(90, 1/2, 0, 1000);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     // add grabing platform here
     moveToVector(180, 2, 0, 1000);
     stopping();
     moveToVector(-90,1/2, 0, 2000,);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     moveToVector(-90,1/2,0, 1000);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     moveToVector(180,1/2,0, 1000);
     stopping();
     moveToVector(90,1/2,0, 1000);
     stopping();
     moveToVector(180,1/2,0, 1000);
     stopping();
     moveToVector(90,1/2,0, 2000);
     stopping();
     */
    //Red Foundation noStone
    /**
     moveToVector(90, 1/2, 0, 1000);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     // add grabing platform here
     moveToVector(180, 2, 0, 1000);
     stopping();
     moveToVector(-90,1/2, 0, 2000,);
     stopping();
     */
    //blue Foundation noStone
    /**
     moveToVector(-90, 1/2, 0, 1000);
     stopping();
     moveToVector(0,1/2,0, 1000);
     stopping();
     // add grabing platform here
     moveToVector(180, 2, 0, 1000);
     stopping();
     moveToVector(90,1/2, 0, 2000,);
     stopping();
     */

    public void Drive(double fleft,double bleft, double fright, double bright)
    {
        frontleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleftmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backrightmotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontleftmotor.setPower(fleft);
        backleftmotor.setPower(bleft);
        frontrightmotor.setPower(fright);
        backrightmotor.setPower(bright);
    }
    public void stopping()
    {
        moveToVector(0,0,0, 0, 300);
    }
    public void moveToVector(double vectorX,double vectorY, double power, double rotation, int sleep)
    {
        frontleftmotor.setTargetPosition(sleep);
        backleftmotor.setTargetPosition(sleep);
        frontrightmotor.setTargetPosition(sleep);
        backrightmotor.setTargetPosition(sleep);
        double angle = Math.atan2(vectorY, -vectorX) - Math.PI /4;
        Drive(  power *Math.cos(angle) - rotation,
                power *Math.sin(angle) - rotation,
                power *Math.sin(angle) + rotation,
                power *Math.cos(angle) + rotation);
    }
}
