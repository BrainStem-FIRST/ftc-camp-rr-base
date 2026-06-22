package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Auto")
public class Auto extends LinearOpMode {

    private BrainSTEMRobot robot;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new BrainSTEMRobot(this.hardwareMap, this.telemetry, this);
        AutoCommands autoCommands = new AutoCommands(robot, telemetry);

        waitForStart();

        Actions.runBlocking(
            new SequentialAction(
                autoCommands.driveRobot(0.5, 1),
                autoCommands.turnRobotLeft(0.3, 0.5)
            )
        );
    }
}