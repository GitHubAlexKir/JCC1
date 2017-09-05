package Controllers;

import Domains.*;
import drawing.javafx.IPaintable;
import drawing.javafx.JavaFXPaintable;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;

public class Controller {
    @FXML
    private RadioButton OvalBtn;
    @FXML
    private RadioButton ImageBtn;
    @FXML
    private RadioButton PaintedTextBtn;
    @FXML
    private RadioButton PolygonBtn;
    @FXML
    private GridPane PaintingGrid;
    private String selectedDrawingItem;
    @FXML
    private Canvas drawingCanvas;
    IPaintable paint;
    Drawing drawing = new Drawing("drawing") ;
    public Controller() {

        week1Testcode();
    }

    @FXML
    private void week1Testcode() {

         drawing = new Drawing("drawing");
        Oval oval = new Oval(Color.BLACK, new Point(70, 70), 30, 40, 5);
        System.out.println("Oval: " + oval.toString());
        drawing.addItem(oval);
        Point[] points = {new Point(300, 240), new Point(150, 100), new Point(200, 300),new Point(247, 145)};
        Polygon pol = new Polygon(points, 6);
        System.out.println("Polygon: " + pol.toString());
        drawing.addItem(pol);
        PaintedText paintedText = new PaintedText("word", "Comic Sans", new Point(10, 10), 200, 20);
        System.out.println("PaintedText: " + paintedText.toString());
        drawing.addItem(paintedText);
        File createdFile = null;
        try {
            createdFile = File.createTempFile("file", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image(createdFile, new Point(4, 4), 3, 3);
        System.out.println("Image: " + image.toString());
        drawing.addItem(image);
        File temp = null;
        try {
            temp = File.createTempFile("temp-file-name", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = drawing.getItems().indexOf(image);
        image.setFile(temp);
        System.out.println("edited image, new file = " + image.getFile());
        drawing.editItem(index, image);
        System.out.println();
        System.out.println("Unsorted list");
        for (DrawingItem s : drawing.getItems()) {
            System.out.println(s.toString());
        }
        drawing.getItems().sort(DrawingItem.drawingItemComparator);
        System.out.println();
        System.out.println("Sorted list");
        for (DrawingItem s : drawing.getItems()) {
            System.out.println(s.toString());
        }
    }
    @FXML
    private  void mouseClick()
    {

    }
    @FXML
    private  void painting()
    {
        this.paint = new JavaFXPaintable(this.drawingCanvas);
        drawing.paintUsing(paint);
    }
    @FXML
    private void DrawingItemSelected()
    {
        if (this.ImageBtn.isSelected() == true)
        {
            System.out.println("Image");
            this.selectedDrawingItem = "image";
            //drawing.addItem(new Image());

        }
        if (this.OvalBtn.isSelected() == true)
        {
            System.out.println("Oval");
            this.selectedDrawingItem = "Oval";
            this.paint = new JavaFXPaintable(this.drawingCanvas);

        }
        if (this.PaintedTextBtn.isSelected() == true)
        {
            System.out.println("PaintedText");
            this.selectedDrawingItem = "PaintedText";
        }
        if (this.PolygonBtn.isSelected() == true)
        {
            System.out.println("Polygon");
            this.selectedDrawingItem = "Polygon";
        }
    }
}
