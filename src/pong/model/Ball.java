package pong.model;

import java.util.Random;

/*
 * A Ball for the Pong game
 * A model class
 */
public class Ball extends AbstractPositionable {

    public static final double WIDTH = 40;
    public static final double HEIGHT = 40;

    private static Random rand = new Random();
    private double dx, dy;  //Velocities

    public Ball() { // Ball for generation in center of code
        super(Pong.GAME_CENTER_X-WIDTH/2, Pong.GAME_CENTER_Y-HEIGHT/2);
        randSpeed();
    }

    // Randomizes an angle between 45 and -45.
    // Converts to raidans and separates vector into x and y composants.
    // x and y composants are the relative speeds needed to achieve the desired angle.
    private void randSpeed() {
        double vectorSpeed = 3.5;
        double angle = Math.toRadians(rand.nextInt(91)-45);
        int invert = rand.nextInt(2);
        dy = Math.sin(angle)*vectorSpeed;
        dx = Math.cos(angle)*vectorSpeed;
        if (invert == 1) {
            dx *= -1;
            dy *= -1;
        }
    }

    public void move() {
        setX(getX()+getDx());
        setY(getY()+getDy());
    }

    public void invertDx() {
        this.dx *= -1;
    }

    public void invertDy() {
        this.dy *= -1;
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGHT;
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
