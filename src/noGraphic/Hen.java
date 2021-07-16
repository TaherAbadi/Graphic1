/**
 * Created by user on 29/05/2021.
 */
package noGraphic;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.Image;
import java.io.FileInputStream;

import sample.AnimalAnim;
import sample.Controller;
import sample.Main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Hen extends DomesticAnimal {
    static final int PRICE=100;
    private final int TIME_TO_PRODUCE=2;
    static int hens=0;


    public Hen() throws FileNotFoundException {
        super("Hen"+String.valueOf(hens+1));
        InputStream stream=new FileInputStream("F:\\image\\hen.png");
        Image image=new Image(stream);
        this.setImage(image);
        this.setFitHeight(30);
        this.setFitWidth(30);
        this.price=PRICE;
        this.produce=0;
        hens++;
        //System.out.println("buy");

    }

    public  static boolean purchase(int coin) {
        //System.out.println(coin);
        if(coin>=PRICE){
            //System.out.println("+");
            try {
                Hen newHen=new Hen();
                AnimalAnim animalAnim=new AnimalAnim(newHen);
                Main.animalAnims.add(animalAnim);
            }
            catch (Exception FileNotFoundException){

            }

            Manager.coin-=PRICE;
            return true;
        }
        return false;
    }
    public void updateProduce(){
        this.produce++;
        if(this.produce==this.TIME_TO_PRODUCE){
            Egg egg=new Egg(this.length,this.width);
            Manager.land.fields[egg.x-1][egg.y-1].products.add(egg);
            this.produce=0;
        }

    }
}
