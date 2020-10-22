package pong.model;

public abstract class AbstractPositionable implements IPositionable{
    private double x;
    private double y;
    private double dx;
    private double dy;

    public AbstractPositionable(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    // Custom methods

    public void move() {
        x += dx;
        y += dy;
    }

    public void invertDx() {
        this.dx *= -1;
    }

    public void invertDy() {
        this.dy *= -1;
    }

    // Getters and setters

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

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
