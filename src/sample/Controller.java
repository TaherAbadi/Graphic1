package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import noGraphic.Manager;

import java.io.IOException;

public class Controller {
    public void signUp() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signUpScene.fxml"));
        Main.window.setScene(new Scene(root , 800 , 495));
    }


    public void logIn(){
        System.out.println("log in pressed ...");
    }
    public void setting(){
        System.out.println("setting pressed ...");
    }


}
