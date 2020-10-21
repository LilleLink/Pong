package pong.model;

public abstract class AbstractPositionable implements IPositionable{
    private double x;
    private double y;

    public AbstractPositionable(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move() {}

    @Override
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
