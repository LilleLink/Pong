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

    public Ball() { // Ball for generation in center of code
        super(Pong.GAME_CENTER_X-WIDTH/2, Pong.GAME_CENTER_Y-HEIGHT/2, 0,0);
        randSpeed();
    }

    // Randomizes an angle between 45 and -45.
    // Converts to raidans and separates vector into x and y composants.
    // x and y composants are the relative speeds needed to achieve the desired angle.
    private void randSpeed() {
        double vectorSpeed = 3.5;
        double angle = Math.toRadians(rand.nextInt(91)-45);
        int invert = rand.nextInt(2);
        setDy(Math.sin(angle)*vectorSpeed);
        setDx(Math.cos(angle)*vectorSpeed);
        if (invert == 1) {
            invertDx();
            invertDy();
        }
    }

    public void move() {
        setX(getX()+getDx());
        setY(getY()+getDy());
    }

    @Override
    public double getWidth() {
        return WIDTH;
    }

    @Override
    public double getHeight() {
        return HEIGHT;
    }

}
