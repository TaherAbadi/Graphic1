package sample;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import noGraphic.Land;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;
import noGraphic.Animal;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



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
    public Pane land;
    public Pane Ground;
    public static Pane rootGame;

    @FXML
    javafx.scene.control.TextField usernameTextField;
    @FXML
    TextField passwordTextField;

    public void mainMenuScene() throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        InputStream stream=new FileInputStream("F:\\image\\firstPage.jpg");
        Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        Main.window.setScene(new Scene(root , 800 , 500));
        Main.window.setTitle("Farm Frenzy");

    }

    public void signUpScene() throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("signUpScene.fxml"));
        InputStream stream=new FileInputStream("F:\\image\\login.jpg");
        Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        Main.window.setScene(new Scene(root , 800 , 500));
    }

    public void logInScene() throws IOException {
        Pane root = FXMLLoader.load(getClass().getResource("logInScene.fxml"));
        InputStream stream=new FileInputStream("F:\\image\\login.jpg");
        Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        Main.window.setScene(new Scene(root , 800 , 500));
    }

    public void signUp() throws IOException {
        if (!Manager.isUser(usernameTextField.getText())) {
            Manager.addUser(usernameTextField.getText(),passwordTextField.getText());
            ReadWriteFile.WriteLogger(true,usernameTextField.getText()+" signed up");
            rootGame = FXMLLoader.load(getClass().getResource("game.fxml"));
            InputStream stream=new FileInputStream("F:\\image\\back1.png");
            Image image=new Image(stream);
            ImageView imageView=new ImageView();
            imageView.setImage(image);
            rootGame.getChildren().add(0,imageView);
            Main.window.setScene(new Scene(rootGame , 800 , 600));
            Main.window.show();
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
                rootGame = FXMLLoader.load(getClass().getResource("game.fxml"));
                InputStream stream=new FileInputStream("F:\\image\\back1.png");
                Image image=new Image(stream);
                ImageView imageView=new ImageView();
                imageView.setImage(image);
                rootGame.getChildren().add(0,imageView);
                Main.window.setScene(new Scene(rootGame , 800 , 600));

                EventHandler<MouseEvent> eventHandler=new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        //Manager.plantGrass(mouseEvent.getX(),mouseEvent.getY());
                        System.out.println(mouseEvent.getX()+mouseEvent.getY());
                        //TODO
                    }
                };
                //land.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
                Main.window.show();
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
       coin.setText("coin:"+String.valueOf(Manager.coin));
       time.setText("time:"+String.valueOf(Manager.time));
        for (AnimalAnim animation:Main.animalAnims) {
            //System.out.println("NNN");
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
        WareHouse wareHouse = new WareHouse();
        //wareHouse.display();
    }







}
