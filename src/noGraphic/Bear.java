package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by user on 30/05/2021.
 */
public class Bear extends WildAnimal {
    static int bears=0;
    public Bear() throws FileNotFoundException {
        super(400,"Bear"+bears,4);
        InputStream stream=new FileInputStream("F:\\image\\bear.png");
        Image image=new Image(stream);
        this.setImage(image);
        this.setFitHeight(60);
        this.setFitWidth(60);
        bears++;
    }
    public static void produce(){
        try {
            Bear bear=new Bear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void move(){
        super.move(1);
    }

}
