package noGraphic;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by user on 30/05/2021.
 */
public class Tiger extends WildAnimal {
    static int tigers=0;
    public Tiger() throws FileNotFoundException {
        super(500,"Tiger"+tigers,4);
        InputStream stream=new FileInputStream("F:\\image\\tiger.jpg");
        Image image=new Image(stream);
        this.setImage(image);
        this.setFitHeight(30);
        this.setFitWidth(30);
        tigers++;
    }
    public static void produce(){
        try {
            Tiger tiger=new Tiger();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        super.move(1);
        super.move(1);
    }

}
