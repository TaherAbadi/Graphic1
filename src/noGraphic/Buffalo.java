/**
 * Created by user on 29/05/2021.
 */
package noGraphic;

import javafx.scene.image.Image;
import sample.AnimalAnim;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Buffalo extends DomesticAnimal {
    final static int PRICE=400;
    private final int TIME_TO_PRODUCE=5;
    static  int buffalos=0;

    public Buffalo() throws FileNotFoundException {
        super("Buffalo"+String.valueOf(buffalos+1));
        InputStream stream=new FileInputStream("F:\\image\\cow1.png");
        Image image=new Image(stream);
        this.setImage(image);
        this.setFitHeight(60);
        this.setFitWidth(60);
        this.price=PRICE;
        this.produce=0;
        buffalos++;
    }

    public static boolean purchase(int coin) {
        if(coin>=PRICE){
            try {
                Buffalo newBuffalo=new Buffalo();
                AnimalAnim animalAnim=new AnimalAnim(newBuffalo);
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
            Milk milk= null;
            try {
                milk = new Milk(this.length,this.width);
                Manager.land.fields[milk.x - 1][milk.y - 1].products.add(milk);
                this.produce=0;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }
}
