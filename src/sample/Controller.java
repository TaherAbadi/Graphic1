package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class Controller {
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
    public Button logInButton;
    public Button signUpButton;
    public Text coin;
    public Text time;
    public Button wareHouse;

    @FXML
    javafx.scene.control.TextField usernameTextField;
    @FXML
    TextField passwordTextField;

    public void mainMenuScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Main.window.setScene(new Scene(root, 800 , 500));

    }

    public void signUpScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signUpScene.fxml"));
        Main.window.setScene(new Scene(root , 800 , 500));
    }

    public void logInScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("logInScene.fxml"));
        Main.window.setScene(new Scene(root , 800 , 500));
    }

    public void signUp() throws IOException {
        if (!Manager.isUser(usernameTextField.getText())) {
            Manager.addUser(usernameTextField.getText(),passwordTextField.getText());
            ReadWriteFile.WriteLogger(true,usernameTextField.getText()+" signed up");

            Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
            Main.window.setScene(new Scene(root , 800 , 500));
        }
        else {
        AlertBox.display("ERROR",usernameTextField.getText() + " Already signed up!");
            ReadWriteFile.WriteLogger(false,usernameTextField.getText() + " Already signed up!");
        }
    }

    public void logIn() throws IOException {
        if (Manager.isUser(usernameTextField.getText())){
            if (Manager.isPass(usernameTextField.getText(),passwordTextField.getText())){
            ReadWriteFile.WriteLogger(true,usernameTextField.getText()+" logged in!");
            int level;
            level=LevelTakerBox.display();
            if(Manager.level(level)){
                ReadWriteFile.WriteLogger(true,"level "+ level +" started");
                //pass to game
                Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
                Main.window.setScene(new Scene(root , 800 , 500));
            }
            else{
                AlertBox.display("Error" , "level "+ level +" is not available!");
                ReadWriteFile.WriteLogger(false,"level "+ level +" is not available!");
            }
            }
            else{
                AlertBox.display("ERROR","Wrong password!");
                ReadWriteFile.WriteLogger(false,"Wrong password!");
            }
        }
        else {
            AlertBox.display("ERROR",usernameTextField.getText() + " doesn't have an account");
            ReadWriteFile.WriteLogger(false,"There isn`t any user with this username!");
        }
    }


    public void setting(){
        System.out.println("setting pressed ...");
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
    public void buildCookieBakery(){
        if(!Manager.buildWorkShop("CookieBakery"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else
            bCookieBakery.setDisable(true);
    }
    public void buildBoxedMilk(){
        if(!Manager.buildWorkShop("BoxedMilk"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else
            bBoxedMilk.setDisable(true);
    }
    public void buildIceCreamFactory(){
        if(!Manager.buildWorkShop("IceCreamFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
        else
            bIceCreamFactory.setDisable(true);
    }
    public void buildFeatherFactory(){
        if(!Manager.buildWorkShop("FeatherFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
        bFeatherFactory.setDisable(true);
    }
    public void buildTailoringFactory(){
        if(!Manager.buildWorkShop("TailoringFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
        bTailoringFactory.setDisable(true);
    }
    public void buyHen(){
        Manager.buyAnimal("Hen");
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
       coin.setText("coin:"+String.valueOf(Manager.coin));
       time.setText("time:"+String.valueOf(Manager.time));
       if(temp==1){
           //todo goldMedal
       }
       else if(temp==-1){
           //todo silverMedal
       }
    }
    public void openWareHouse(){
        System.out.println("");
        //todo
    }







}
