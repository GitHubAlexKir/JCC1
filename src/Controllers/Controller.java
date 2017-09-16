package Controllers;

import Domains.*;
import Repositories.DatabaseMediator;
import Repositories.PersistencyMediator;
import Repositories.SerializationMediator;
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
    private Drawing drawing;
    public Controller() {

        week1Testcode();
    }
    @FXML
    private void saveDrawingDB() throws Exception {
        SerializationMediator save = new DatabaseMediator();
        save.save(drawing);
    }
    @FXML
    private void loadDrawingDB() throws Exception {
        SerializationMediator load = new DatabaseMediator();
        this.drawing = load.load("drawing");
        painting();
    }
    @FXML
    private void saveDrawingF() throws Exception {
        SerializationMediator save = new PersistencyMediator();
        save.save(drawing);
    }
    @FXML
    private void loadDrawingF() throws Exception {
        SerializationMediator load = new PersistencyMediator();
        this.drawing = load.load("drawing");
        painting();
    }
    @FXML
    private void week1Testcode() {

        drawing = new Drawing("drawing");
        Oval oval = new Oval(Color.BLACK, new Point(70, 70), 30, 40, 5);
        drawing.addItem(oval);
        Point[] points = {new Point(300, 240), new Point(150, 100), new Point(200, 300),new Point(247, 145)};
        Polygon pol = new Polygon(points, 6);
        drawing.addItem(pol);
        PaintedText paintedText = new PaintedText("word", "Comic Sans", new Point(10, 10), 200, 20);
        drawing.addItem(paintedText);
        File createdFile = null;
        try {
            createdFile = File.createTempFile("file", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image(createdFile, new Point(350, 40), 30, 30);
       // drawing.addItem(image);
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
            drawing.addItem(new Oval(Color.BLACK, new Point(90, 90), 20, 20, 10));
            painting();
        }
        if (this.PaintedTextBtn.isSelected())
        {
            //System.out.println("PaintedText");
            drawing.addItem(new PaintedText("TESTING WEEK 3", "Comic Sans", new Point(50, 50), 200, 20));
            painting();
        }
        if (this.PolygonBtn.isSelected())
        {
           // System.out.println("Polygon");
            drawing.addItem(new Oval(Color.BLACK, new Point(130, 90), 40, 20, 10));
            painting();
        }
    }
}
