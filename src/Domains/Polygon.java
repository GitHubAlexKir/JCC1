package Domains;


public class Polygon extends DrawingItem
{
    private final Point[] vertices;
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
        return vertices[0];
    }

    public double getWidth() {
        return 0;
    }

    public double getHeight() {
        return 0;
    }

    @Override
    public String toString() {
        return "anchor X" + this.vertices[0].getX() + ", Y" + this.vertices[0].getY() + ", Weight " + this.weight;
    }

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Double.compare(o1.getAnchor().getX(), o2.getAnchor().getX());
    }
}
