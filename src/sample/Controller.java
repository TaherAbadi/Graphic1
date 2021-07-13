package sample;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
        }
        else {
        AlertBox.display("ERROR","Already signed up!");
        }
    }

    public void logIn() throws IOException {
        if (Manager.isUser(usernameTextField.getText())){
            if (Manager.isPass(usernameTextField.getText(),passwordTextField.getText())){
            ReadWriteFile.WriteLogger(true,usernameTextField.getText()+" logged in!");
            Manager.level(LevelTakerBox.display());
            }
            else
                AlertBox.display("ERROR","Wrong password!");
        }
        else {
            AlertBox.display("ERROR",usernameTextField.getText() + " doesn't have an account");
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
    }
    public void buildBoxedMilk(){
        if(!Manager.buildWorkShop("BoxedMilk"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void buildIceCreamFactory(){
        if(!Manager.buildWorkShop("IceCreamFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void buildFeatherFactory(){
        if(!Manager.buildWorkShop("FeatherFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
    public void buildTailoringFactory(){
        if(!Manager.buildWorkShop("TailoringFactory"))
            ReadWriteFile.WriteLogger(false,ERROR);
    }
}
