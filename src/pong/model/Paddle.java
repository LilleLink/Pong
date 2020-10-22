package pong.model;

import com.sun.webkit.graphics.WCImageDecoder;

import static pong.model.Pong.GAME_HEIGHT;

/*
 * A Paddle for the Pong game
 * A model class
 *
 */
public class Paddle extends AbstractPositionable {

    public static final double PADDLE_WIDTH = 10;
    public static final double PADDLE_HEIGHT = 60;
    public static final double PADDLE_SPEED = 5;
    private boolean isMovingUp;
    private boolean isMovingDown;

    public Paddle(double x, double y, double dx, double dy) {
        super(x,y,dx,dy);
    }

    @Override
    public void move() {
        if (isMovingDown) {
            this.setY(getY()+PADDLE_SPEED);
        } else if (isMovingUp) {
            this.setY(getY()-PADDLE_SPEED);
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

    @Override
    public double getWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public double getHeight() {
        return PADDLE_HEIGHT;
    }

}
