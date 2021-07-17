package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Clothes extends Product{
    public Clothes(int x , int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\cloth.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="Clothes";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=4;
        Price=100;
        TimeToDestruction=6;
    }
}
