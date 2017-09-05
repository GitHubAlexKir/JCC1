package Domains;


import java.util.Comparator;

public abstract class DrawingItem implements Comparator<DrawingItem> {

    Color color;

    protected abstract Point getAnchor();

    public abstract double getWidth();

    public abstract double getHeight();

    public void setColor(Color color) {
        this.color = color;
    }

    Color getColor() {
        return color;
    }
    public static final Comparator<DrawingItem> drawingItemComparator = Comparator.comparingDouble(o -> o.getAnchor().getX());
}

