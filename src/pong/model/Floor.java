package pong.model;

import static pong.model.Pong.*;

public class Floor implements IPositionable {

    public static double x = 0;
    public static double y = GAME_HEIGHT;
    public static double width = GAME_WIDTH;
    public static double height = 10;

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
