package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TeleOp Tutorial", group = "Tutorials")
public class TeleOpTutorial extends LinearOpMode {
    private DcMotor motorLeft;
    private DcMotor motorRight;
    private Servo armServo;

    private static final double ARM_RETRACTED_POSITION = 0.2;
    private static final double ARM_EXTENDED_POSITION = 0.8;

    @Override
    public void runOpMode() throws InterruptedException {
        motorLeft = hardwareMap.dcMotor.get("motorLeft");
        motorRight = hardwareMap.dcMotor.get("motorRight");


        motorLeft.setDirection(DcMotor.Direction.REVERSE);

        armServo = hardwareMap.servo.get("clawArm");
        armServo.setPosition(ARM_RETRACTED_POSITION);

        waitForStart();

        while(opModeIsActive()){
            motorLeft.setPower(-gamepad1.left_stick_y);
            motorRight.setPower(-gamepad1.right_stick_y);

            if(gamepad2.a){
                armServo.setPosition(ARM_EXTENDED_POSITION);
            }

            if(gamepad2.b){
                armServo.setPosition(ARM_RETRACTED_POSITION);
            }
            idle();
        }
    }
}
