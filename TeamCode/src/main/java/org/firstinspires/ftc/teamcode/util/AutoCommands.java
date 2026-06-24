package org.firstinspires.ftc.teamcode.util;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SleepAction;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.BrainSTEMRobot;

public class AutoCommands {
    BrainSTEMRobot robot;
    Telemetry telemetry;

    public AutoCommands(BrainSTEMRobot robot, Telemetry telemetry) {
        this.robot = robot;
        this.telemetry = telemetry;
    }

    public Action driveRobot(double power, double time) {
        return packet -> {
            robot.drive.setDTMotorPowers(power, power, power, power);
            new SleepAction(time);
            robot.drive.stop();
            return false;
        };
    }

    public Action turnRobotRight(double power, double time) {
        return packet -> {
            robot.drive.setDTMotorPowers(power, -power, power, -power);
            new SleepAction(time);
            robot.drive.stop();
            return false;
        };
    }

    public Action turnRobotLeft(double power, double time) {
        return packet -> {
            robot.drive.setDTMotorPowers(-power, power, -power, power);
            new SleepAction(time);
            robot.drive.stop();
            return false;
        };
    }
}