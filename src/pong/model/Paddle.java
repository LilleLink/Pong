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

    public Paddle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveDown() {
        this.y += PADDLE_SPEED;
    }

    public void moveUp() {
        this.y -= PADDLE_SPEED;
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
