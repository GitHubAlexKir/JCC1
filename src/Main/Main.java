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
        Drawing drawing = new Drawing("tekening");
        System.out.println("Created drawing named: " + drawing.getName());
        Oval oval = new Oval(Color.BLACK, new Point(1,2),3,4,5);
        System.out.println("Oval: " + oval.toString());
        drawing.addItem(oval);
        System.out.println("Added Oval");
        Polygon pol = new Polygon(new Point[5],6);
        System.out.println("Polygon: " + pol.toString());
        drawing.addItem(pol);
        System.out.println("Added Polygon");
        PaintedText paintedText = new PaintedText("woord","Comic Sans",new Point(1,4),2,2);
        System.out.println("PaintedText: " + paintedText.toString());
        drawing.addItem(paintedText);
        System.out.println("Added PaintedText");
        Image image = new Image(null, new Point(5,5),3,3);
        System.out.println("Image: " + image.toString());
        drawing.addItem(image);
        System.out.println("Added Image");
        File temp = null;
        try {
            temp = File.createTempFile("temp-file-name", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int index = drawing.getItems().indexOf(image);
        System.out.println("index of image = " + index);
        image.setFile(temp);
        System.out.println("edited file, new file = " + image.getFile());
        drawing.editItem(index,image);
        System.out.println("Image changed in tekening");
        //launch(args);
    }
}
