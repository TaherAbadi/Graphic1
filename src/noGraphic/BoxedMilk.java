package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BoxedMilk extends Product{
    public BoxedMilk(int x , int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\boxed.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="BoxedMilk";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=2;
        Price=60;
        TimeToDestruction=5;
    }
}
