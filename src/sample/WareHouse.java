package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import noGraphic.Manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class WareHouse {

    public ImageView product1;
    public ImageView product2;
    public ImageView product3;
    public ImageView product4;
    public ImageView product5;
    public ImageView product6;
    public ImageView product7;
    public ImageView product8;
    public ImageView product9;
    public ImageView product10;
    public ImageView product11;
    public ImageView product12;
    public ImageView product13;
    InputStream stream=new FileInputStream("F:\\image\\Egg.png");
    Image EggImage=new Image(stream);

    int rows;
    public GridPane gridPane1;

    public WareHouse() throws FileNotFoundException {
    }


    public void display() throws IOException {
        rows=1;
        Stage window = new Stage();



        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("wareHouse");
        window.setMinWidth(800);
        Pane root = FXMLLoader.load(WareHouse.class.getResource("wareHouseScene.fxml"));

        if (Manager.wareHouse.getProductsStorage().get("Egg")>=0){
        product1.setImage(EggImage);
        }





        InputStream stream=new FileInputStream("F:\\image\\WareHouseBackGround.png");
        Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        window.setScene(new Scene(root, 900 , 500));
        window.showAndWait();

    }

}
