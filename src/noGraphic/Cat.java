package noGraphic;
import java.util.Random;

/**
 * Created by user on 29/05/2021.
 */
public class Cat extends Animal {
    private static final int PRICE=150;
    static int numberOfCats=0;
    public Cat() {
    }

    public void collect(){
       Manager.pickUp(this.length,this.width);
    }
    public void moveCat() {
        String s = Manager.nearestProduct(this.length, this.width);
        int x = Integer.parseInt(s.substring(0, 1)), y = Integer.parseInt(s.substring(1));
        if (x != 0 && y != 0) {
            if (this.length > x) {
                this.length--;
            } else if (this.length < x) {
                this.length++;
            } else {
                if (this.width < y) {
                    this.width++;
                } else if (this.length > y) {
                    this.width--;
                }
            }
        }
        else
            super.move(1);
    }
    public static boolean purchase(int coin) {
        if(coin>=PRICE){
            Cat cat=new Cat();
            cat.name="Cat"+ String.valueOf(numberOfCats);
            numberOfCats++;
            Random random=new Random();
            cat.width=0; cat.length=0;
            while (cat.width<1 || cat.length<1){
                cat.length=random.nextInt(7);
                cat.width=random.nextInt(7);
            }
            Manager.land.fields[cat.length-1][cat.width-1].animals.add(cat);
            Manager.coin-=PRICE;
            //Manager.land.fields[cat.length][cat.width].animals.add(cat);
            return true;
        }
        return false;
    }
}
