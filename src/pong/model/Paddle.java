package pong.model;

import com.sun.webkit.graphics.WCImageDecoder;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 *
 */
public class Paddle implements IPositionable{

    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 60;
    public static final double PADDLE_SPEED = 5;

    private double x,y;    //Positions
    private boolean isMovingUp;
    private boolean isMovingDown;

    public Paddle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (isMovingDown) {
            y += PADDLE_SPEED;
        } else if (isMovingUp) {
            y -= PADDLE_SPEED;
        }
    }

    public void stop() {
        isMovingUp = false;
        isMovingDown = false;
    }

    public void setMovingUp(boolean movingUp) {
        isMovingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        isMovingDown = movingDown;
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
        return PADDLE_WIDTH;
    }

    @Override
    public double getHeight() {
        return PADDLE_HEIGHT;
    }

    public void setY(int y) {
        this.y = y;
    }
}
