package noGraphic;
import javax.swing.text.Element;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import sample.AnimalAnim;
import sample.Main;

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
        AnimalAnim animalAnim=new AnimalAnim(this);
        Main.animalAnims.add(animalAnim);
    }

    public int getCaged() {
        return caged;
    }

    public void caged(ArrayList<WildAnimal> toRemove){
        caged--;
        if(caged<=0){
            InputStream stream=null;
            if(this instanceof Lion){
                try {
                    stream=new FileInputStream("F:\\image\\CagedLion.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if(this instanceof Bear){
                try {
                    stream=new FileInputStream("F:\\image\\CagedGrizzly.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                //todo
            }
            Image image=new Image(stream);
            CaughtAnimal caughtAnimal=new CaughtAnimal(this.length,this.width,price,image);
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
