package noGraphic;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 29/05/2021.
 */
public class Dog extends Animal {
    static int numberOfDogs=0;
    private  static final int PRICE=100;
    public ArrayList<Animal> attack(){
        ArrayList<Animal> toRemove = new ArrayList<>();
        boolean attack=false;
        for (Animal animal:Manager.land.fields[this.length-1][this.width-1].animals) {
            if(animal instanceof WildAnimal){
                toRemove.add(animal);
                attack=true;
            }
        }
        if(attack) toRemove.add(this);
        return toRemove;
    }
    public static boolean purchase(int coin) {
        if(coin>=PRICE){
            Dog dog=new Dog();
            dog.name="Dog"+ String.valueOf(numberOfDogs+1);
            numberOfDogs++;
            Random random=new Random();
            dog.width=0; dog.length=0;
            while (dog.width<1 || dog.length<1){
                dog.length=random.nextInt(7);
                dog.width=random.nextInt(7);
            }
            Manager.land.fields[dog.length-1][dog.width-1].animals.add(dog);
            Manager.coin-=PRICE;
            return true;
        }
        return false;
    }
}
