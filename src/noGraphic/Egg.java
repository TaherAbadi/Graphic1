/**
 * Created by user on 31/05/2021.
 */
package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Egg extends Product{
    public Egg(int x , int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\egg.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="Egg";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=1;
        Price=15;
        TimeToDestruction=4;
    }


}
