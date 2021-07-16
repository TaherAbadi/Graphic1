package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import noGraphic.Manager;
import noGraphic.Animal;
import noGraphic.Land;
import noGraphic.Field;

import noGraphic.ReadWriteFile;

import java.io.IOException;

public class GameControll {
    final static String ERROR="Incorrect command!";
    public Button bEggPowderPlant;
    public Button EggPowderPlant;
    public Button CookieBakery;
    public Button bCookieBakery;
    public Button bTailoringFactory;
    public Button TailoringFactory;
    public Button bBoxedMilk;
    public Button BoxedMilk;
    public Button bIceCreamFactory;
    public Button IceCreamFactory;
    public Button bFeatherFactory;
    public Button FeatherFactory;
    public Text coin;
    public Text time;
    public Button wareHouse;

    @FXML
    public Pane land;

    public Pane Ground;
    public static Pane rootGame;



    public void initialize(){
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:Manager.land.fields[i][j].animals) {
                    land.getChildren().add(animal);
                }
            }
        }
    }

    public void workEggPowderFac(){
        if(! Manager.work("EggPowderPlant"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void workCookieBakery(){
        if(! Manager.work("CookieBakery"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void workBoxedMilk(){
        if(! Manager.work("BoxedMilk"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void workIceCreamFactory(){
        if(! Manager.work("IceCreamFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void workFeatherFactory(){
        if(! Manager.work("FeatherFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void workTailoringFactory(){
        if(! Manager.work("TailoringFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void well(){
        if(Manager.drainge()==false){
            ReadWriteFile.WriteLogger(false,"The water buket is full!");
        }
        else
            ReadWriteFile.WriteLogger(true,"Drainaged successfully");
    }
    public void buildEggPowderPlant(){
        if(!Manager.buildWorkShop("EggPowderPlant"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else{
            bEggPowderPlant.setDisable(true);
            EggPowderPlant.setDisable(false);
        }
    }
    public void buildCookieBakery(){
        if(!Manager.buildWorkShop("CookieBakery"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else {
            bCookieBakery.setDisable(true);
            CookieBakery.setDisable(false);
        }
    }
    public void buildBoxedMilk(){
        if(!Manager.buildWorkShop("BoxedMilk"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else {
            bBoxedMilk.setDisable(true);
            BoxedMilk.setDisable(false);
        }
    }
    public void buildIceCreamFactory(){
        if(!Manager.buildWorkShop("IceCreamFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else {
            bIceCreamFactory.setDisable(true);
            IceCreamFactory.setDisable(false);
        }
    }
    public void buildFeatherFactory(){
        if(!Manager.buildWorkShop("FeatherFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else {
            bFeatherFactory.setDisable(true);
            FeatherFactory.setDisable(false);
        }
    }
    public void buildTailoringFactory(){
        if(!Manager.buildWorkShop("TailoringFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else {
            bTailoringFactory.setDisable(true);
            TailoringFactory.setDisable(false);
        }
    }
    public void buyHen(){
        Manager.buyAnimal("Hen");
        //System.out.println("buy hen");
    }
    public void buyTurkey(){
        Manager.buyAnimal("Turkey");
    }
    public void buyBuffalo(){
        Manager.buyAnimal("Buffalo");
    }
    public void buyCat(){
        Manager.buyAnimal("Cat");
    }
    public void buyDog(){
        Manager.buyAnimal("Dog");
    }
    public void turn(){
        int temp= Manager.update(1);
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:Manager.land.fields[i][j].animals) {
                    AnimalAnim animalAnim=new AnimalAnim(animal);
                    animalAnim.play();
                }
            }
        }
        initialize();
        coin.setText("coin:"+String.valueOf(Manager.coin));
        time.setText("time:"+String.valueOf(Manager.time));
        for (AnimalAnim animation:Main.animalAnims) {
            animation.play();
        }
        if(temp==1){
            //todo goldMedal
        }
        else if(temp==-1){
            //todo silverMedal
        }
    }
    public void openWareHouse() throws IOException {
        // WareHouse.display();
    }




}
