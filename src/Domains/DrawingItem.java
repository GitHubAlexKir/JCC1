package Domains;


public abstract class DrawingItem {

    public Color color;

    public abstract Point getAnchor();

    public abstract double getWidth();

    public abstract double getHeight();

    public void setColor(Color color)
    {
        this.color = color;
    }
    public Color getColor()
    {
        return color;
    }

}
