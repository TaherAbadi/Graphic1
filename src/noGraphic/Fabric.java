package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Fabric extends Product{
    public Fabric(int x , int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\fabric.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="Fabric";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=2;
        Price=50;
        TimeToDestruction=5;
    }
}
