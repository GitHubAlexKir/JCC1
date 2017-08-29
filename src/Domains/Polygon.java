package Domains;

public class Polygon extends DrawingItem
{
    private Point[] vertices;
    private double weight;

    public Polygon(Point[] vertices, double weight)
    {
        this.vertices = vertices;
        this.weight = weight;
    }

    public Point[] getVertices() {
        return vertices;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Point getAnchor() {
        return null;
    }

    public double getWidth() {
        return 0;
    }

    public double getHeight() {
        return 0;
    }

    @Override
    public String toString() {
        return "Weight " + this.weight;
    }
}
