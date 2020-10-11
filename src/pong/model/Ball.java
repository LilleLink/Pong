package pong.model;

import java.util.Random;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball implements IPositionable {

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;

    private static Random rand = new Random();
    private double x,y;    //Positions
    private double dx, dy;  //Velocities

    public Ball(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
        this.dx = rand.nextDouble()+0.5;
        this.dy = rand.nextDouble()+0.5;
    }

    public void move() {
        this.x += dx;
        this.y += dy;
    }

    public void invertVx() {
        this.dx *= -1;
    }

    public void invertVy() {
        this.dy *= -1;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGHT;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
