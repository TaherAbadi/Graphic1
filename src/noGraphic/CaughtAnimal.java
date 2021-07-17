/**
 * Created by user on 31/05/2021.
 */
package noGraphic;

import javafx.scene.image.Image;

public class CaughtAnimal extends Product {
    CaughtAnimal(int x, int y, int price, Image image) {
        this.setImage(image);
        name="CaughtAnimal";
        this.x=x;
        this.y=y;
        this.imageLoc();
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=15;
        this.Price=price;
        TimeToDestruction=5;
    }

}
