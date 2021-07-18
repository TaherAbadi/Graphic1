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
    public Button BoxedMilk;
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
        InputStream stream=new FileInputStream("F:\\image\\menu-back.png");
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








}
