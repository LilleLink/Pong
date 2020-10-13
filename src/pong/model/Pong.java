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


    private int pointsLeft;
    private int pointsRight;
    private Ball b;
    private Paddle p1;
    private Paddle p2;
    private Floor f;
    private Ceiling c;

    public Pong(Ball b, Paddle p1, Paddle p2, Floor f, Ceiling c) {
        this.b = b;
        this.p1 = p1;
        this.p2 = p2;
        this.f = f;
        this.c = c;
    }

    // --------  Game Logic -------------

    private long timeForLastHit;         // To avoid multiple collisions

    public void update(long now) {
        b.move();
        p1.move();
        p2.move();
        if (ballEscaped(b)) {
            b = new Ball();
        }
        if (collision(c, b) || collision(f, b)){
            System.out.println("Ceiling: "+collision(c,b)+" | "+"Floor: "+collision(f,b));
            b.invertDy();
        }
        if (collision(p1,b) || collision(p2,b)) {
            b.invertDx();
        }

    }

    public boolean collision(IPositionable a, IPositionable b) {
        return a.getX() <= b.getX() + b.getWidth() && a.getX() + a.getWidth() >= b.getX()
                && a.getY() <= b.getY() + b.getHeight() && a.getY() + a.getHeight() >= b.getY();
    }

    private boolean ballEscaped(Ball b) {
        if (b.getX() < 0) { // Right wall
            pointsRight++;
            return true;
        } else if (b.getX()+b.getWidth() > GAME_WIDTH) { // Left wall
            pointsLeft++;
            return true;
        }
        return false;
    }

    // --- Used by GUI  ------------------------

    public List<IPositionable> getPositionables() {
        List<IPositionable> drawables = new ArrayList<>();
        drawables.add(p1);
        drawables.add(p2);
        drawables.add(b);
        drawables.add(f);
        drawables.add(c);
        return drawables;
    }

    public Paddle getP1() {
        return p1;
    }

    public Paddle getP2() {
        return p2;
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
