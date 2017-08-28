package sample;

import Entities.Color;
import Entities.DrawingItem;
import Entities.Oval;
import Entities.Point;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Oval oval = new Oval(Color.BLACK, new Point(1,2),3,4,5);
        System.out.println("Oval: " + oval.toString());
       //System.out.println("testing123");
        //launch(args);
    }
}
