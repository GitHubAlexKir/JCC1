package Controllers;

import Domains.*;
import javafx.fxml.FXML;
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
    private void week1Testcode() {

        Drawing drawing = new Drawing("drawing");
        Oval oval = new Oval(Color.BLACK, new Point(7, 7), 3, 4, 5);
        System.out.println("Oval: " + oval.toString());
        drawing.addItem(oval);
        Point[] points = {new Point(2, 2), new Point(3, 2), new Point(2, 3)};
        Polygon pol = new Polygon(points, 6);
        System.out.println("Polygon: " + pol.toString());
        drawing.addItem(pol);
        PaintedText paintedText = new PaintedText("word", "Comic Sans", new Point(1, 1), 2, 2);
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
    private void DrawingItemSelected()
    {
        if (this.ImageBtn.isSelected() == true)
        {
            System.out.println("Image");
            this.selectedDrawingItem = "image";
        }
        if (this.OvalBtn.isSelected() == true)
        {
            System.out.println("Oval");
            this.selectedDrawingItem = "Oval";
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
