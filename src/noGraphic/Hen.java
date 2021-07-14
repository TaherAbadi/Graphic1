/**
 * Created by user on 29/05/2021.
 */
package noGraphic;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.image.Image;

public class Hen extends DomesticAnimal {
    static final int PRICE=100;
    private final int TIME_TO_PRODUCE=2;
    static int hens=0;


    public Hen() {
        super("Hen"+String.valueOf(hens+1));
        Image image=new Image("../sample/image/hen.png");
        this.setImage(image);
        this.price=PRICE;
        this.produce=0;
        hens++;
    }

    public  static boolean purchase(int coin) {
        //System.out.println(coin);
        if(coin>=PRICE){
            //System.out.println("+");
            Hen newHen=new Hen();
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
