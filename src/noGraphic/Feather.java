/**
 * Created by user on 31/05/2021.
 */
package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Feather extends Product {
    public Feather(int x, int y) throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\feather.png");
        Image image=new Image(stream);
        this.setImage(image);
        name="Feather";
        this.x = x;
        this.y = y;
        this.imageLoc();
        OnTheGround = true;
        InTheWarehouse = false;
        SpaceTaken = 1;
        Price = 20;
        TimeToDestruction = 4;
    }
}
