/**
 * Created by user on 29/05/2021.
 */
package noGraphic;

import javafx.scene.image.Image;

public class Buffalo extends DomesticAnimal {
    final static int PRICE=400;
    private final int TIME_TO_PRODUCE=5;
    static  int buffalos=0;

    public Buffalo() {
        super("Buffalo"+String.valueOf(buffalos+1));
        Image image=new Image("../sample/image/cow.png");
        this.setImage(image);
        this.price=PRICE;
        this.produce=0;
        buffalos++;
    }

    public static boolean purchase(int coin) {
        if(coin>=PRICE){
         Buffalo newBuffalo=new Buffalo();
            Manager.coin-=PRICE;
            return true;
        }
        return false;
    }
    public void updateProduce(){
        this.produce++;
        if(this.produce==this.TIME_TO_PRODUCE){
            Milk milk=new Milk(this.length,this.width);
            Manager.land.fields[milk.x - 1][milk.y - 1].products.add(milk);
            this.produce=0;
        }

    }
}
