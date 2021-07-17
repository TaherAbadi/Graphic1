package noGraphic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by user on 30/05/2021.
 */
public class Lion extends WildAnimal {
    static int lions=0;
    public Lion() throws FileNotFoundException {
        super(300,"Lion"+lions,3);
        InputStream stream=new FileInputStream("F:\\image\\lion1.png");
        Image image=new Image(stream);
        this.setImage(image);
        this.setFitHeight(60);
        this.setFitWidth(60);
        lions++;
    }
    public static void produce(){
        try {
            Lion lion=new Lion();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        super.move(1);
    }

}
