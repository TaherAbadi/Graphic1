package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import noGraphic.Manager;
import noGraphic.Animal;
import noGraphic.Grass;
import noGraphic.Product;

import noGraphic.ReadWriteFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

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
    public ImageView well;
    public ImageView ware;
    public Text missionAnim;
    public Text missionPro;
    public Button winningButton;
    public ImageView winningImage;
    public Text winningText;
    public ImageView henProducer;


    public void initialize(){
        updateLand();
        wellClick();
        mouseClick();
        wareClick();
        henProduceClick();
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
    public void drainge(){
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
        if(!Manager.buildWorkShop("MilkBoxing"))
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
       updateLand();
        //System.out.println("buy hen");
    }
    public void buyTurkey(){
        Manager.buyAnimal("Turkey");
        updateLand();
    }
    public void buyBuffalo(){
        Manager.buyAnimal("Buffalo");
        updateLand();
    }
    public void buyCat(){
        Manager.buyAnimal("Cat");
        updateLand();
    }
    public void buyDog(){
        Manager.buyAnimal("Dog");
        updateLand();
    }
    public void turn() throws IOException {
        int temp= Manager.update(1);
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:Manager.land.fields[i][j].animals) {
                    AnimalAnim animalAnim=new AnimalAnim(animal);
                    animalAnim.play();
                }
            }
        }
        updateLand();
        printMissions();
        for (AnimalAnim animation:Main.animalAnims) {
            animation.play();
        }
        showWinStatus(temp);

    }
    public void openWareHouse() throws IOException {
        WareHouse wareHouse = new WareHouse();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("wareHouse");
        window.setMinWidth(800);
        Pane root = FXMLLoader.load(WareHouse.class.getResource("wareHouseScene.fxml"));
        InputStream stream=new FileInputStream("F:\\image\\WareHouseBackGround.png");
        Image image=new Image(stream);
        ImageView imageView=new ImageView();
        imageView.setImage(image);
        root.getChildren().add(0,imageView);
        window.setScene(new Scene(root, 900 , 500));
        window.showAndWait();
    }
    public void mouseClick(){
        EventHandler<MouseEvent> eventHandler=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(!Manager.cage((int)mouseEvent.getX()/61,(int)mouseEvent.getY()/50)){
                    int temp=Manager.pickUp(((int)mouseEvent.getX()/61)+1,((int)mouseEvent.getY()/52)+1);
                    if(temp==2){
                        //TODO full warehouse
                    }
                    else if(temp==3){
                        Manager.plantGrass(mouseEvent.getX(),mouseEvent.getY());
                    }
                }
                updateLand();
            }
        } ;
        land.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
    }

    public void wellClick(){
        EventHandler<MouseEvent> eventHandler=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                drainge();
            }
        };
        well.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
    }

    public void wareClick(){
        EventHandler<MouseEvent> eventHandler=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    openWareHouse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        ware.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
    }
    public void henProduceClick(){
        EventHandler<MouseEvent> eventHandler=new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Manager.henProducer();
                System.out.println("+");
            }
        };
        henProducer.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);

    }
    public void updateLand(){
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:Manager.land.fields[i][j].animals) {
                    if(!land.getChildren().contains(animal))
                        land.getChildren().add(animal);
                }
                for (Grass grass:Manager.land.fields[i][j].grasses) {
                    if(!land.getChildren().contains(grass))
                        land.getChildren().add(grass);
                }
                for (Product product:Manager.land.fields[i][j].products) {
                    if(!land.getChildren().contains(product))
                        land.getChildren().add(product);
                }

            }
        }
        ArrayList<Node> toRemove=new ArrayList<Node>();
        for (Node imageview:land.getChildren()) {
           if(imageview instanceof Animal){
               boolean b=false;
               for (int i = 0; i <6 ; i++) {
                   for (int j = 0; j < 6; j++) {
                       if(Manager.land.fields[i][j].animals.contains(imageview))
                           b=true;
                   }
               }
               if(b==false)
                   toRemove.add(imageview);
           }
            if(imageview instanceof Grass){
                boolean b=false;
                for (int i = 0; i <6 ; i++) {
                    for (int j = 0; j < 6; j++) {
                        if(Manager.land.fields[i][j].grasses.contains(imageview))
                            b=true;
                    }
                }
                if(b==false)
                    toRemove.add(imageview);
            }
            if(imageview instanceof Product){
                boolean b=false;
                for (int i = 0; i <6 ; i++) {
                    for (int j = 0; j < 6; j++) {
                        if(Manager.land.fields[i][j].products.contains(imageview))
                            b=true;
                    }
                }
                if(b==false)
                    toRemove.add(imageview);
            }

        }
        land.getChildren().removeAll(toRemove);

    }
    public void printMissions(){
        String missA="";
        for (String animal:Manager.missionAnimal.keySet()) {
            if(Manager.missionAnimal.get(animal)!=0){
                missA+=animal+":";
                for (String animalAvailable:Manager.animals.keySet()) {
                    if(animal.equalsIgnoreCase(animalAvailable))
                       missA+=Manager.animals.get(animalAvailable);
                }
                missA+="/"+Manager.missionAnimal.get(animal)+"\n";
            }
        }
        String missPro="";
        for (String product:Manager.missionProduct.keySet()) {
            if(Manager.missionProduct.get(product)!=0){
                missPro+=product+":";
                for (String productAvailable:Manager.wareHouse.getProductsStorage().keySet()) {
                    if (productAvailable.equalsIgnoreCase(product)){
                        missPro+=Manager.wareHouse.getProductsStorage().get(productAvailable);
                    }
                }
                missPro+="/"+Manager.missionProduct.get(product)+"\n";
            }
        }
        missionAnim.setText(missA);
        missionPro.setText(missPro);
        coin.setText(String.valueOf(Manager.coin)+"/"+Manager.missionCoin);
        time.setText("time:"+String.valueOf(Manager.time));
    }

    /*public int missionWon(){
        boolean allDone=true;
        for (String animal:Manager.missionAnimal.keySet()) {
            if(Manager.missionAnimal.get(animal)!=0){
                for (String animalAvailable:Manager.animals.keySet()) {
                    if(animal.equalsIgnoreCase(animalAvailable) && Manager.animals.get(animal)<Manager.missionAnimal.get(animal))
                       allDone=false;
                }
            }
        }

        for (String product:Manager.missionProduct.keySet()) {
            if(Manager.missionProduct.get(product)!=0){
                for (String productAvailable:Manager.wareHouse.getProductsStorage().keySet()) {
                    if (productAvailable.equalsIgnoreCase(product) && Manager.wareHouse.NumberOfProducts(product)<Manager.missionProduct.get(product))
                        allDone=false;
                }
            }
        }

        if (allDone){
            if (Manager.time<=Manager.goldTime)
            return 2;
            else
                return 1;
        }
        return 0;
    }*/

    public void showWinStatus(int missionWon) throws IOException {
        if (missionWon!=0){
            System.out.println(missionWon);
        }
        else if (missionWon==0)
        System.out.println("hechi");
    }
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

}
