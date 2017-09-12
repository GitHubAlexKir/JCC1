package Controllers;

import Domains.*;
import Repositories.DatabaseMediator;
import Repositories.SerializationMediator;
import Repositories.testingDB;
import drawing.javafx.IPaintable;
import drawing.javafx.JavaFXPaintable;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;

public class Controller {
    public ToggleGroup DrawingItemRadioBtn;
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
    @FXML
    private Canvas drawingCanvas;
    private IPaintable paint;
    private Drawing drawing = new Drawing("drawing") ;
    public Controller() {

        week1Testcode();
    }
    @FXML
    private void saveDrawingDB() throws Exception {
        SerializationMediator test = new DatabaseMediator();
        Drawing testing5 = test.load("drawing");
        System.out.println(testing5.toString());
        for (DrawingItem t:testing5.getItems()
             ) { System.out.println(t.toString());

        }
    }
    @FXML
    private void week1Testcode() {

         drawing = new Drawing("drawing");
        Oval oval = new Oval(Color.BLACK, new Point(70, 70), 30, 40, 5);
        //System.out.println("Oval: " + oval.toString());
        drawing.addItem(oval);
        Point[] points = {new Point(300, 240), new Point(150, 100), new Point(200, 300),new Point(247, 145)};
        Polygon pol = new Polygon(points, 6);
        //System.out.println("Polygon: " + pol.toString());
        drawing.addItem(pol);
        PaintedText paintedText = new PaintedText("word", "Comic Sans", new Point(10, 10), 200, 20);
        //System.out.println("PaintedText: " + paintedText.toString());
        drawing.addItem(paintedText);
        File createdFile = null;
        try {
            createdFile = File.createTempFile("file", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image(createdFile, new Point(350, 40), 30, 30);
        //System.out.println("Image: " + image.toString());
        drawing.addItem(image);
        int index = drawing.getItems().indexOf(image);
        image.setFile(new File("Domains/testing.jpg"));
        //System.out.println("edited image, new file = " + image.getFile());
        drawing.editItem(index, image);
        //System.out.println();
       // System.out.println("Unsorted list");
        for (DrawingItem s : drawing.getItems()) {
            //System.out.println(s.toString());
        }
        drawing.getItems().sort(DrawingItem.drawingItemComparator);
        //System.out.println();
        //System.out.println("Sorted list");
        for (DrawingItem s : drawing.getItems()) {
            //System.out.println(s.toString());
        }
    }

    @FXML
    private void painting()
    {
        this.paint = new JavaFXPaintable(this.drawingCanvas);
        drawing.paintUsing(paint);
    }
    @FXML
    private void DrawingItemSelected()
    {
        String selectedDrawingItem;
        if (this.ImageBtn.isSelected())
        {
            //System.out.println("Image");
            //drawing.addItem(new Image());

        }
        if (this.OvalBtn.isSelected())
        {
            //System.out.println("Oval");
            this.paint = new JavaFXPaintable(this.drawingCanvas);

        }
        if (this.PaintedTextBtn.isSelected())
        {
            //System.out.println("PaintedText");
        }
        if (this.PolygonBtn.isSelected())
        {
           // System.out.println("Polygon");
        }
    }
}
