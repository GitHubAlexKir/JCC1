package Domains;

import java.io.File;

public class Image extends DrawingItem {
    private File file;
    private Point anchor;
    private double width;
    private double height;

    public Image(File file, Point anchor, double width, double height) {
        this.file = file;
        this.anchor = anchor;
        this.width = width;
        this.height = height;
    }

    public Point getAnchor() {
        return anchor;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return 0;
    }

    public double getHeight() {
        return 0;
    }

    @Override
    public String toString() {
        return "anchor X" + this.anchor.getX() + ", Y" + this.anchor.getY() +", file " + this.file;
    }

    @Override
    public int compare(DrawingItem o1, DrawingItem o2) {
        return Double.compare(o1.getAnchor().getX(), o2.getAnchor().getX());
    }
}
