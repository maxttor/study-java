package com.company;

import java.math.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(-5,10, Direction.DOWN);
        moveRobot2(robot, 10, -20);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        private int x;
        private int y;
        private Direction dir;

        Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        Direction getDirection() {return dir;}

        int getX() {return x;}

        int getY() {return y;}

        void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    private static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getDirection() == Direction.UP && toY < robot.getY() ||
                robot.getDirection() == Direction.DOWN && toY > robot.getY()) {
            robot.turnLeft();
            robot.turnLeft();
        } else if (robot.getDirection() == Direction.LEFT && toY < robot.getY() ||
                robot.getDirection() == Direction.RIGHT && toY > robot.getY()) {
            robot.turnLeft();
        } else if (robot.getDirection() == Direction.RIGHT && toY < robot.getY() ||
                robot.getDirection() == Direction.LEFT && toY > robot.getY()) {
            robot.turnRight();
        }

        while (Math.abs(robot.getY() - toY) > 0) {
            robot.stepForward();
        }

        if (robot.getDirection() == Direction.RIGHT && toX < robot.getX() ||
                robot.getDirection() == Direction.LEFT && toX > robot.getX()) {
            robot.turnLeft();
            robot.turnLeft();
        } else if (robot.getDirection() == Direction.UP && toX < robot.getX() ||
                robot.getDirection() == Direction.DOWN && toX > robot.getX()) {
            robot.turnLeft();
        } else if (robot.getDirection() == Direction.DOWN && toX < robot.getX() ||
                robot.getDirection() == Direction.UP && toX > robot.getX()) {
            robot.turnRight();
        }

        while (Math.abs(robot.getX() - toX) > 0) {
            robot.stepForward();
        }
    }

    public static void moveRobot2(Robot robot, int toX, int toY) {
        Direction newDirection = (robot.getX() < toX) ? Direction.RIGHT : Direction.LEFT;
        while (robot.getDirection() != newDirection) {
            robot.turnLeft();
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }
        newDirection = (robot.getY() < toY) ? Direction.UP : Direction.DOWN;
        while (robot.getDirection() != newDirection) {
            robot.turnLeft();
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }
}
