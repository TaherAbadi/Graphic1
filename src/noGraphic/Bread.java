package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Bread extends Product{
    public Bread(int x , int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\cookie.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="Bread";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=4;
        Price=80;
        TimeToDestruction=6;
    }
}
