package pong.model;

import static pong.model.Pong.*;

public class Floor implements IPositionable {

    public static double x = GAME_HEIGHT;
    public static double y = 0;
    public static double width = GAME_WIDTH;
    public static double height = 0;


    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }
}
