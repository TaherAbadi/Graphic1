package sample;
import com.sun.javafx.scene.SceneHelper;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Pause {

    public void resume(){
        Main.pauseMenu.close();
    }

    public void exit(){
        Main.window.close();
        Main.pauseMenu.close();

    }

    public void mainMenu() throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        InputStream stream=new FileInputStream("F:\\image\\firstPage.jpg");
        javafx.scene.image.Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        Main.window.setScene(new Scene(root , 800 , 500));
        Main.window.setTitle("Farm Frenzy");
        Main.pauseMenu.close();
    }



}
