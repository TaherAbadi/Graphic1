package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class IceCream extends Product{
    public IceCream(int x , int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\iceCream.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="IceCream";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=4;
        Price=120;
        TimeToDestruction=6;
    }
}
