package noGraphic;

import javafx.scene.image.Image;

/**
 * Created by user on 30/05/2021.
 */
public class Bear extends WildAnimal {
    static int bears=0;
    public Bear() {
        super(400,"Bear"+bears,4);
        Image image=new Image("F:\\image\\bear.png");
        this.setImage(image);
        bears++;
    }
    public static void produce(){
        Bear bear=new Bear();
    }
    public void move(){
        super.move(1);
    }

}
