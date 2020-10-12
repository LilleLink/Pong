package pong.model;


import pong.event.ModelEvent;
import pong.event.EventBus;

import java.util.ArrayList;
import java.util.List;

/*
 * Logic for the Pong Game
 * Model class representing the "whole" game
 * Nothing visual here
 *
 */
public class Pong {

    public static final double GAME_WIDTH = 600;
    public static final double GAME_HEIGHT = 400;
    public static final double BALL_SPEED_FACTOR = 1.02;
    public static final long HALF_SEC = 500_000_000;
    public static final double GAME_CENTER_X = GAME_WIDTH/2;
    public static final double GAME_CENTER_Y = GAME_HEIGHT/2;


    // TODO More attributes
    private int pointsLeft;
    private int pointsRight;
    private Ball b;
    private Paddle p1;
    private Paddle p2;

    // TODO Constructor

    public Pong(Ball b, Paddle p1, Paddle p2) {
        this.b = b;
        this.p1 = p1;
        this.p2 = p2;
    }

    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
        // TODO Gamelogic here
        b.move();
        if (ballEscaped(b)) {
            b = new Ball();
        }



    }

    private boolean ballEscaped(Ball b) {
        if (b.getX() < 0) { // Right wall
            pointsRight++;
            return true;
        } else if (b.getX()+b.getWidth() > GAME_WIDTH) { // Left wall
            pointsLeft++;
            return true;
        }
        else if (b.getY() < 0 || b.getY()+b.getHeight() > GAME_HEIGHT) { // Ceiling/Floor
            b.invertDy();
            return false; // Should just bounce
        }
        return false;
    }

    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> drawables = new ArrayList<>();
        // TODO
        drawables.add(p1);
        drawables.add(p2);
        drawables.add(b);
        return drawables;
    }

    public int getPointsLeft() {
        return pointsLeft;
    }

    public int getPointsRight() {
        return pointsRight;
    }

    public void setSpeedRightPaddle(double dy) {
        // TODO
    }

    public void setSpeedLeftPaddle(double dy) {
        // TODO
    }
}
