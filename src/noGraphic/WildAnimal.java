package noGraphic;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 29/05/2021.
 */
public class WildAnimal extends Animal {
    int cageNeeded;
    int price;
    int caged;

    public WildAnimal(int price,String name,int neededCage) {
        Random random=new Random();
        this.name=name;
        this.price = price;
        this.cageNeeded=neededCage;
        this.caged =neededCage;
        this.width=0; this.length=0;
        while (width<1 || length<1){
            this.length=random.nextInt(7);
            this.width=random.nextInt(7);
        }
        Manager.land.fields[length-1][width-1].animals.add(this);
    }

    public int getCaged() {
        return caged;
    }

    public void caged(ArrayList<WildAnimal> toRemove){
        caged--;
        if(caged<=0){
            CaughtAnimal caughtAnimal=new CaughtAnimal(this.length,this.width,price);
            Manager.land.fields[this.length-1][this.width-1].products.add(caughtAnimal);
            toRemove.add(this);
            //Manager.land.fields[this.length-1][this.width-1].animals.remove(this);
        }
    }
    public void delayCage(){
        if(this.caged<cageNeeded){
            this.caged++;
        }
    }
}
