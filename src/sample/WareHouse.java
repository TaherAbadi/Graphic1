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
    public Text HenNumber;
    public Text BufalloNumber;
    public Text OstrichNumber;
    public Text LionNumber;
    public Text BearNumber;


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
        LionNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Lion"));
        BearNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Bear"));
        //IceCreamNumber.setText("* " + Manager.wareHouse.NumberOfProducts("IceCream"));
        HenNumber.setText("* " + Manager.animals.get("Hen"));
        System.out.println(Manager.animals.get("Hen"));
        OstrichNumber.setText("* " + Manager.animals.get("Turkey"));
        BufalloNumber.setText("* " + Manager.animals.get("Buffalo"));
    }


    public void sellEgg() throws IOException {
         Manager.loadTruck("Egg");
         EggNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Egg"));

    }

    public void sellFeather() throws IOException {
            Manager.loadTruck("Feather");
            FeatherNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Feather"));

    }

    public void sellMilk() throws IOException {
            Manager.loadTruck("Milk");
            MilkNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Milk"));

    }

    public void sellFlour() throws IOException {
            Manager.loadTruck("Flour");
            FlourNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Flour"));

    }

    public void sellFabric() throws IOException {
            Manager.loadTruck("Fabric");
            FabricNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Fabric"));
    }

    public void sellBoxedMilk() throws IOException {
            Manager.loadTruck("BoxedMilk");
            BoxedMilkNumber.setText("* " + Manager.wareHouse.NumberOfProducts("BoxedMilk"));
    }

    public void sellBread() throws IOException {
            Manager.loadTruck("Bread");
            BreadNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Bread"));

    }

    public void sellClothes() throws IOException {
            Manager.loadTruck("Clothes");
            ClothesNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Clothes"));

    }

    public void sellIceCream() throws IOException {
            Manager.loadTruck("IceCream");
            IceCreamNumber.setText("* " + Manager.wareHouse.NumberOfProducts("IceCream"));
    }

    public void sellHen(){
        if(Manager.animals.get("Hen")>0){


        }
    }










    public void sellLion(){
            Manager.loadTruck("Lion");
            EggNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Lion"));

    }

    public void sellBear(){
            Manager.loadTruck("Bear");
            EggNumber.setText("* " + Manager.wareHouse.NumberOfProducts("Bear"));

    }

    public void truckGo(){
        Manager.truckGo();
    }

    public void unloadTruck(){




    }


}
