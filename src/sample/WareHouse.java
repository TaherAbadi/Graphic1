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
    public Label EggCounter= new Label("mmd");
    public Text EggNumber = new Text();

    int rows;
    public GridPane gridPane1 = new GridPane();

    public WareHouse() throws FileNotFoundException {
    }


    public void display() throws IOException {
        rows=1;
        Stage window = new Stage();



        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("wareHouse");
        window.setMinWidth(800);
        Pane root = FXMLLoader.load(WareHouse.class.getResource("wareHouseScene.fxml"));

        EggNumber.setText("mmd");


        InputStream stream=new FileInputStream("F:\\image\\WareHouseBackGround.png");
        Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        window.setScene(new Scene(root, 900 , 500));
        window.showAndWait();

    }

    public void sellEgg() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Egg")>0){
         Manager.wareHouse.TakeProduct("Egg");
         Manager.loadTruck("Egg");
         this.display();
        }
    }

    public void sellFeather() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Feather")>0){
            Manager.wareHouse.TakeProduct("Feather");
            Manager.loadTruck("Feather");
            this.display();
        }
    }

    public void sellMilk() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Milk")>0){
            Manager.wareHouse.TakeProduct("Milk");
            Manager.loadTruck("Milk");
            this.display();
        }
    }

    public void sellFlour() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Flour")>0){
            Manager.wareHouse.TakeProduct("Flour");
            Manager.loadTruck("Flour");
            this.display();
        }
    }

    public void sellFabric() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Fabric")>0){
            Manager.wareHouse.TakeProduct("Fabric");
            Manager.loadTruck("Fabric");
            this.display();
        }
    }

    public void sellBoxedMilk() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("BoxedMilk")>0){
            Manager.wareHouse.TakeProduct("BoxedMilk");
            Manager.loadTruck("BoxedMilk");
            this.display();
        }
    }

    public void sellBread() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Bread")>0){
            Manager.wareHouse.TakeProduct("Bread");
            Manager.loadTruck("Bread");
            this.display();
        }
    }

    public void sellClothes() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Clothes")>0){
            Manager.wareHouse.TakeProduct("Clothes");
            Manager.loadTruck("Clothes");
            this.display();
        }
    }

    public void sellIceCream() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("IceCream")>0){
            Manager.wareHouse.TakeProduct("IceCream");
            Manager.loadTruck("IceCream");
            this.display();
        }
    }

}
