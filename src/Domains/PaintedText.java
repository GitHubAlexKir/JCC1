package Domains;

public class PaintedText extends DrawingItem{
    private String content;
    private String fontName;
    private Point anchor;
    private double width;
    private double height;

    public PaintedText(String content, String fontName, Point anchor, double width, double height) {
        this.content = content;
        this.fontName = fontName;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public String getContent() {
        return content;
    }

    public Point getAnchor() {
        return anchor;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "anchor X" + this.anchor.getX() + ", Y" + this.anchor.getY() +", content " + this.content + ", fontName " + this.fontName;
    }

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Double.compare(o1.getAnchor().getX(), o2.getAnchor().getX());
    }
}
