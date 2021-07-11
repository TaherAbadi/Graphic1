package noGraphic;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by user on 29/05/2021.
 */
public class Grass {
    public Grass() {
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
