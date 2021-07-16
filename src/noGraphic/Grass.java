package noGraphic;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by user on 29/05/2021.
 */
public class Grass extends ImageView {
    public Grass(double x,double y) throws FileNotFoundException {
        try {
            InputStream stream=new FileInputStream("F:\\image\\grass.jpg");
            Image image=new Image(stream);
            this.setImage(image);
            this.setFitHeight(20);
            this.setFitWidth(20);
            this.setX(x);
            this.setY(y);
        }
        catch (Exception FileNotFoundException){

        }

    }
    public boolean eat(ArrayList<Animal> animals){
        ArrayList<DomesticAnimal> domesticAnimals=new ArrayList <DomesticAnimal>();
        if(animals.size()>0){
            for (Animal animal:animals) {
                if(animal instanceof  DomesticAnimal)
                    domesticAnimals.add((DomesticAnimal) animal);
            }
            int[] ages=new int[animals.size()];
            int j=0;
            for (DomesticAnimal domesticAnimal:domesticAnimals) {
                if (domesticAnimal.getAge() <= 50) {
                    ages[j] = domesticAnimal.getAge();
                    j++;
                }
            }
            Arrays.sort(ages);
            for (DomesticAnimal domesticAnim:domesticAnimals) {
                if(domesticAnim.getAge()==ages[0]){
                    domesticAnim.setAge(100);
                    return true;
                }
            }
        }
        return false;
    }
}
