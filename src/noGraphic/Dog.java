package noGraphic;
import javafx.scene.image.ImageView;
import sample.AnimalAnim;
import sample.Main;

import noGraphic.ReadWriteFile;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

    public Dog() throws FileNotFoundException {
        InputStream stream=new FileInputStream("F:\\image\\dog1.png");
        Image image=new Image(stream);
        this.setImage(image);
        this.name="Dog"+ String.valueOf(numberOfDogs+1);
        numberOfDogs++;
        Random random=new Random();
        this.width=0; this.length=0;
        while (this.width<1 || this.length<1){
            this.length=random.nextInt(7);
            this.width=random.nextInt(7);
        }
        AnimalAnim animalAnim=new AnimalAnim(this);
        Main.animalAnims.add(animalAnim);
    }

    public static boolean purchase(int coin) {
        if(coin>=PRICE){
            try {
                Dog dog=new Dog();
                numberOfDogs++;
                Manager.land.fields[dog.length-1][dog.width-1].animals.add(dog);
                Manager.coin-=PRICE;
            }
            catch (Exception FileNotFoundException  ){

            }

            return true;
        }
        return false;
    }
}
