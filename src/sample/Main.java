package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    static Stage window;
    public static ArrayList<AnimalAnim> animalAnims=new ArrayList<AnimalAnim>();
    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        InputStream stream=new FileInputStream("F:\\image\\firstPage.jpg");
        Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        window.setScene(new Scene(root , 800 , 500));
        window.setTitle("Farm Frenzy");
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
