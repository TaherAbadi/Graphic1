package noGraphic;
import java.util.ArrayList;

/**
 * Created by user on 29/05/2021.
 */
public class Land {
    public Field[][] fields=new Field[6][6];

    public Land() {
        this.fields=new Field[6][6];
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                fields[i][j]=new Field();
            }
        }
    }
    public void updateLand(){
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                fields[i][j].attackWilds();
                fields[i][j].wildsAttack();
                fields[i][j].collectProduct();
                fields[i][j].eatGrass();
                fields[i][j].produce();
                ArrayList<Animal> toRemove=new ArrayList <Animal>();
                for (Animal animal:fields[i][j].animals) {
                    if(animal instanceof Cat)
                        ((Cat) animal).moveCat();
                    else if(animal instanceof DomesticAnimal){
                        ((DomesticAnimal) animal).moveDomestic();
                        ((DomesticAnimal) animal).reduceLife();
                        if(((DomesticAnimal) animal).getAge()<=0)
                            toRemove.add(animal);
                    }
                    else
                        animal.move(1);
                }
                for (Animal animal:fields[i][j].animals){
                    if(animal instanceof WildAnimal)
                        ((WildAnimal) animal).delayCage();
                }
                fields[i][j].animals.removeAll(toRemove);

            }
        }
        updateFieldOfAnimal();
    }
    public void updateFieldOfAnimal(){
        ArrayList<Animal> toRemove=new ArrayList <Animal>();

        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:fields[i][j].animals) {
                    if(animal.length-1!=i || animal.width-1!=j){
                        fields[animal.length-1][animal.width-1].animals.add(animal);
                        toRemove.add(animal);
                    }
                }
                fields[i][j].animals.removeAll(toRemove);
                toRemove.clear();
            }
        }
    }
    public void sellHen(){
        ArrayList<Animal> animalha=new ArrayList<Animal>();
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:fields[i][j].animals) {
                    if(animal instanceof  Hen)
                        animalha.add(animal);
                }
                if(!animalha.isEmpty()) {
                    fields[i][j].animals.remove(animalha.get(0));
                    return;
                }
            }
        }
    }
    public void sellBuffalo(){
        ArrayList<Animal> animalha=new ArrayList<Animal>();
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:fields[i][j].animals) {
                    if(animal instanceof  Buffalo)
                        animalha.add(animal);
                }
                if(!animalha.isEmpty()) {
                    fields[i][j].animals.remove(animalha.get(0));
                    return;
                }
            }
        }
    }
    public void sellTurkey(){
        ArrayList<Animal> animalha=new ArrayList<Animal>();
        for (int i = 0; i <6 ; i++) {
            for (int j = 0; j <6 ; j++) {
                for (Animal animal:fields[i][j].animals) {
                    if(animal instanceof  Turkey)
                        animalha.add(animal);
                }
                if(!animalha.isEmpty()) {
                    fields[i][j].animals.remove(animalha.get(0));
                    return;
                }
            }
        }
    }

}
