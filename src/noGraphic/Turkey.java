package noGraphic;
import javafx.scene.image.Image;
import sample.AnimalAnim;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.temporal.ValueRange;

/**
 * Created by user on 29/05/2021.
 */
public class Turkey extends DomesticAnimal {
    final  static int PRICE=200;
    private final int TIME_TO_PRODUCE=3;
    static int turkeys=0;

    public Turkey() throws FileNotFoundException {
        super("Turkey"+ String.valueOf(turkeys+1));
        InputStream stream=new FileInputStream("F:\\image\\turkey.png");
        Image image=new Image(stream);
        this.setImage(image);
        this.setFitHeight(60);
        this.setFitWidth(60);
        this.price=PRICE;
        this.produce=0;
        turkeys++;
    }

    public static boolean purchase(int coin) {
        if(coin>=PRICE) {
            try {
                Turkey newTurkey = new Turkey();
                AnimalAnim animalAnim=new AnimalAnim(newTurkey);
                Main.animalAnims.add(animalAnim);
            }
            catch (Exception FileNotFoundException ){

            }

            Manager.coin-=PRICE;
            return true;
        }
        return false;
    }

    public void updateProduce(){
        this.produce++;
        if(this.produce==this.TIME_TO_PRODUCE){
            Feather feather= null;
            try {
                feather = new Feather(this.length,this.width);
                Manager.land.fields[feather.x-1][feather.y-1].products.add(feather);
                this.produce=0;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
}
