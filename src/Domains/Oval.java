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

    public Point getAnchor()
    {
        return anchor;
    }

    public double getWidth()
    {
        return  width;
    }

    public double getHeight()
    {
        return  height;
    }

    @Override
    public String toString() {
        return "Color " + getColor() + ", anchor X" + getAnchor().getX() + ", Y" + getAnchor().getY() + ", Width " + getWidth() + ", Height " + getHeight();
    }
}