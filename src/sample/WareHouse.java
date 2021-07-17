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
import noGraphic.Milk;

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
    public Text EggNumber;
    public Text FeatherNumber;
    public Text ClothesNumber;
    public Text BreadNumber;
    public Text BoxedMilkNumber;
    public Text FabricNumber;
    public Text FlourNumber;
    public Text MilkNumber;
    public Text IceCreamNumber;


    int rows;
    public GridPane gridPane1 = new GridPane();

    public WareHouse() throws FileNotFoundException {
    }

    public void initialize(){
        EggNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Egg"));
        FeatherNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Feather"));
        ClothesNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Clothes"));
        BreadNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Bread"));
        BoxedMilkNumber.setText("* " + Manager.wareHouse.NumberOfProducts("BoxedMilk"));
        FabricNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Fabric"));
        FlourNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Flour"));
        MilkNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Milk"));
        IceCreamNumber.setText("* " + Manager.wareHouse.NumberOfProducts("IceCream"));
    }


    public void sellEgg() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Egg")>0){
         Manager.wareHouse.TakeProduct("Egg");
         Manager.loadTruck("Egg");
         EggNumber.setText("+ " + Manager.wareHouse.NumberOfProducts("Egg"));
        }
    }

    public void sellFeather() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Feather")>0){
            Manager.wareHouse.TakeProduct("Feather");
            Manager.loadTruck("Feather");
            FeatherNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Feather"));
        }
    }

    public void sellMilk() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Milk")>0){
            Manager.wareHouse.TakeProduct("Milk");
            Manager.loadTruck("Milk");
            MilkNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Milk"));
        }
    }

    public void sellFlour() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Flour")>0){
            Manager.wareHouse.TakeProduct("Flour");
            Manager.loadTruck("Flour");
            FlourNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Flour"));
        }
    }

    public void sellFabric() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Fabric")>0){
            Manager.wareHouse.TakeProduct("Fabric");
            Manager.loadTruck("Fabric");
            FabricNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Fabric"));
        }
    }

    public void sellBoxedMilk() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("BoxedMilk")>0){
            Manager.wareHouse.TakeProduct("BoxedMilk");
            Manager.loadTruck("BoxedMilk");
            BoxedMilkNumber.setText("* " + Manager.wareHouse.NumberOfProducts("BoxedMilk"));
        }
    }

    public void sellBread() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Bread")>0){
            Manager.wareHouse.TakeProduct("Bread");
            Manager.loadTruck("Bread");
            BreadNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Bread"));
        }
    }

    public void sellClothes() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("Clothes")>0){
            Manager.wareHouse.TakeProduct("Clothes");
            Manager.loadTruck("Clothes");
            ClothesNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Clothes"));
        }
    }

    public void sellIceCream() throws IOException {
        if(Manager.wareHouse.NumberOfProducts("IceCream")>0){
            Manager.wareHouse.TakeProduct("IceCream");
            Manager.loadTruck("IceCream");
            IceCreamNumber.setText("* " + Manager.wareHouse.NumberOfProducts("IceCream"));
        }
    }

}
