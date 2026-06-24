package org.firstinspires.ftc.teamcode.opModes;

import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.util.AutoCommands;
import org.firstinspires.ftc.teamcode.BrainSTEMRobot;

@Autonomous (name = "Simple Auto")
public class SimpleAuto extends LinearOpMode {

    private BrainSTEMRobot robot;

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