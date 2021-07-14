package sample;
import com.sun.javafx.scene.SceneHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

public class LevelTakerBox {


    public Label alertBoxText;

    public static int display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Level");
        window.setMinWidth(250);


        Label label = new Label("choose a level");
        TextField textField = new TextField();
        Button closeButton = new Button("confirm");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,textField,closeButton);
        layout.setAlignment(Pos.CENTER);


        window.setScene(new Scene(layout, 250 , 150));
        window.showAndWait();
        return Integer.parseInt(textField.getText());

    }


}
