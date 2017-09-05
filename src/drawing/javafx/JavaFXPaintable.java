package drawing.javafx;

import Domains.*;
import drawing.javafx.IPaintable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.image.Image;

public class JavaFXPaintable implements IPaintable {
    private final GraphicsContext gc;
    public JavaFXPaintable(Canvas canvas) {
        gc = canvas.getGraphicsContext2D();

    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }


    @Override
    public void paint(Oval oval) {
        gc.fillOval(oval.getAnchor().getX(),oval.getAnchor().getY(),oval.getWidth(),oval.getHeight());
    }

    @Override
    public void paint(Polygon polygon) {
        int i = polygon.getVertices().length;
        double[] X = new double[i];
        double[] Y =  new double[i];
        i = 0;
        for (Point p:polygon.getVertices()
             ) {
            X[i] = p.getX();
            Y[i] = p.getY();
            i++;
        }
        gc.fillPolygon(X,Y,polygon.getVertices().length);
    }

    @Override
    public void paint(PaintedText text) {
        gc.fillText(text.getContent(),text.getAnchor().getX(),text.getAnchor().getY());
    }

    @Override
    public void paint(Domains.Image image) {
        gc.drawImage(new Image(String.valueOf(image.getFile())),image.getAnchor().getX(),image.getAnchor().getY());
    }
}
