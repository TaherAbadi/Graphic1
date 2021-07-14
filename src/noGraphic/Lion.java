package noGraphic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Created by user on 30/05/2021.
 */
public class Lion extends WildAnimal {
    static int lions=0;
    public Lion() {
        super(300,"Lion"+lions,3);
        Image image=new Image("../sample/image/lion.png");
        this.setImage(image);
        lions++;
    }
    public static void produce(){
        Lion lion=new Lion();
    }

    public void move(){
        super.move(1);
    }

}
