package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class WareHouse {


    public static void display() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("warehouse");


        Parent root = FXMLLoader.load(WareHouse.class.getResource("wareHouseScene.fxml"));
        window.setScene(new Scene(root , 800 , 500));
        window.showAndWait();
    }

}
