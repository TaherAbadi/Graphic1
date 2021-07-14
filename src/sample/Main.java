package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window.setTitle("Farm Frenzy");
        window.setScene(new Scene(root, 800 , 500));
        window.show();
    }
    public void play(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        window.setTitle("Farm Frenzy");
        window.setScene(new Scene(root, 800 , 500));
        boolean win=false, lose=false;
        window.show();

    }



}
