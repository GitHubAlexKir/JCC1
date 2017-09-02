package Main;

import Domains.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Drawing drawing = new Drawing("drawing");
        Oval oval = new Oval(Color.BLACK, new Point(7,7),3,4,5);
        System.out.println("Oval: " + oval.toString());
        drawing.addItem(oval);
        Point[] points = { new Point(2,2), new Point(3,2), new Point(2,3)};
        Polygon pol = new Polygon(points,6);
        System.out.println("Polygon: " + pol.toString());
        drawing.addItem(pol);
        PaintedText paintedText = new PaintedText("word","Comic Sans",new Point(1,1),2,2);
        System.out.println("PaintedText: " + paintedText.toString());
        drawing.addItem(paintedText);
        File createdFile = null;
        try {
             createdFile = File.createTempFile("file", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image(createdFile, new Point(4,4),3,3);
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
        drawing.editItem(index,image);
        System.out.println();
        System.out.println("Unsorted list");
        for (DrawingItem s : drawing.getItems())
        {
            System.out.println(s.toString());
        }
        drawing.getItems().sort(DrawingItem.drawingItemComparator);
        System.out.println();
        System.out.println("Sorted list");
        for (DrawingItem s : drawing.getItems())
        {
            System.out.println(s.toString());
        }
        //launch(args);
    }
}
