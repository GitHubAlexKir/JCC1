package Domains;

public class Oval extends DrawingItem {
    private Point anchor;
    private double width;
    private double height;
    private double weight;

    public Oval(Color color, Point anchor, double width, double height, double weight)
    {
        this.color = color;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public Point getAnchor() {
        return anchor;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    @Override
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "anchor X" + this.anchor.getX() + ", Y" + this.anchor.getY() +", Color " + getColor() +  ", Width " + getWidth() + ", Height " + getHeight();
    }

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Double.compare(o1.getAnchor().getX(), o2.getAnchor().getX());
    }
}