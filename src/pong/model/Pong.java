package pong.model;


import javafx.animation.AnimationTimer;
import javafx.concurrent.Task;
import jdk.jfr.Event;
import pong.event.ModelEvent;
import pong.event.EventBus;
import pong.view.PongMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
    private Timer timer;

    private int pointsLeft;
    private int pointsRight;
    private Ball b;
    private Paddle p1;
    private Paddle p2;
    private Floor f;
    private Ceiling c;
    public static boolean collisionPossible = true;

    public Pong(Ball b, Paddle p1, Paddle p2, Floor f, Ceiling c) {
        this.b = b;
        this.p1 = p1;
        this.p2 = p2;
        this.f = f;
        this.c = c;
        timer = new Timer();
        timer.schedule(new task(), 500);
    }

    // --------  Game Logic -------------

    public void update(long now) {
        b.move();
        p1.move();
        p2.move();
        if (ballEscaped(b)) {
            b = new Ball();
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.NEW_BALL));
        }


        if (collision(c, b) || collision(f, b)){
            b.invertDy();
            EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BALL_HIT_WALL_CEILING));
        }

        //TODO GENERIC FUNCTIONAL DECOMPOSITION
        if (collision(p1, c)) {
            p1.stop();
            pValidPos(p1, c);
        } else if (collision(p1, f)) {
            p1.stop();
            pValidPos(p1, f);
        }

        if (collision(p2, c)) {
            p2.stop();
            pValidPos(p2, c);
        } else if (collision(p2, f)) {
            p2.stop();
            pValidPos(p2, f);
        }

        //TODO REMOVE REDUNDANCY
        if (collisionPossible) {
            if (collision(p1, b)) {
                b.invertDx();

                // Control supercolission, if not, speedfactor
                if (superCollision(p1, b)) {
                    b.setDx(b.getDx()*1.5);
                    b.setDy(b.getDy()*1.5);
                } else {
                    b.setDx(b.getDx()*BALL_SPEED_FACTOR);
                    b.setDy(b.getDy()*BALL_SPEED_FACTOR);
                }

                EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BALL_HIT_PADDLE));
                collisionPossible = false;
                timer.schedule(new task(), 500);
            } else if (collision(p2, b)) {
                b.invertDx();

                // Control supercolission, if not, speedfactor
                if (superCollision(p2, b)) {
                    b.setDx(b.getDx()*1.5);
                    b.setDy(b.getDy()*1.5);
                } else {
                    b.setDx(b.getDx()*BALL_SPEED_FACTOR);
                    b.setDy(b.getDy()*BALL_SPEED_FACTOR);
                }

                EventBus.INSTANCE.publish(new ModelEvent(ModelEvent.Type.BALL_HIT_PADDLE));
                collisionPossible = false;
                timer.schedule(new task(), 500);
            }
        }


    }

    private void pValidPos(Paddle p, Ceiling c) {
        p.setY(c.getY()+c.getHeight());
    }

    private void pValidPos(Paddle p, Floor f) {
        p.setY(f.getY()-p.getHeight());
    }

    private boolean superCollision(Paddle p, Ball b) {
        return Math.abs((p.getY() + p.getHeight() / 2) - (b.getY() + b.getHeight() / 2)) < 10;
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
    }

    public void setSpeedLeftPaddle(double dy) {
    }

    public static void setCollisionPossible() {
        collisionPossible = true;
    }
}

class task extends TimerTask {
    @Override
    public void run() {
        Pong.setCollisionPossible();
    }
}