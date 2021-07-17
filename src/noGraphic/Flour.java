package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Flour extends Product{
    public Flour(int x , int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\eggPowder.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="Flour";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=2;
        Price=40;
        TimeToDestruction=5;
    }

}
