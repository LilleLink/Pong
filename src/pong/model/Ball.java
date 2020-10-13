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

    public Ball(double x, double y, double dx, double dy) { // For testing purposes only
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public Ball() { // Ball for generation in center of code
        this.x = Pong.GAME_CENTER_X-this.getWidth()/2;
        this.y = Pong.GAME_CENTER_Y-this.getHeight()/2;
        randSpeed();
    }

    // Randomizes an angle between 45 and -45.
    // Converts to raidans and separates vector into x and y composants.
    // x and y composants are the relative speeds needed to achieve the desired angle.
    private void randSpeed() {
        double vectorSpeed = 4;
        double angle = Math.toRadians(rand.nextInt(91)-45);
        int invert = rand.nextInt(2);
        dy = Math.sin(angle)*vectorSpeed;
        dx = Math.cos(angle)*vectorSpeed;
        if (invert == 1) {
            dx *= -1;
            dy *= -1;
        }
    }

    public boolean isMovingRight() {
        if (dx > 0)
            return true;
        return false;
    }

    public boolean isMovingLeft() {
        if (dx < 0)
            return true;
        return false;
    }

    public void move() {
        this.x += dx;
        this.y += dy;
    }

    public void invertDx() {
        this.dx *= -1;
    }

    public void invertDy() {
        this.dy *= -1;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
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

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }
}
