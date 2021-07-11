package noGraphic;
import java.time.temporal.ValueRange;

/**
 * Created by user on 29/05/2021.
 */
public class Turkey extends DomesticAnimal {
    final  static int PRICE=200;
    private final int TIME_TO_PRODUCE=3;
    static int turkeys=0;

    public Turkey() {
        super("Turkey"+ String.valueOf(turkeys+1));
        this.price=PRICE;
        this.produce=0;
        turkeys++;
    }

    public static boolean purchase(int coin) {
        if(coin>=PRICE) {
            Turkey newTurkey = new Turkey();
            Manager.coin-=PRICE;
            return true;
        }
        return false;
    }

    public void updateProduce(){
        this.produce++;
        if(this.produce==this.TIME_TO_PRODUCE){
            Feather feather=new Feather(this.length,this.width);
            Manager.land.fields[feather.x-1][feather.y-1].products.add(feather);
            this.produce=0;
        }

    }
}
