package noGraphic;

import java.util.ArrayList;

/**
 * Created by user on 29/05/2021.
 */
public class Field {
    ArrayList<Animal> animals;
    ArrayList<Grass> grasses;
    ArrayList <Product> products;
    public Field() {
        animals =new ArrayList <Animal>();
        products=new ArrayList <Product>();
        grasses=new ArrayList <Grass>();
    }
    public boolean plantGrass(){
        if(Manager.well.useWater()){
            Grass grass=new Grass();
            this.grasses.add(grass);
            return true;
        }
        return false;
    }
    public boolean eatGrass(){
        if(!this.grasses.isEmpty()){
            if(this.grasses.get(0).eat((animals))){
                this.grasses.remove(0);
                return true;
            }
            return false;
        }
        return false;
    }
    public void collectProduct(){
        for (Animal animal:animals) {
            if(animal instanceof Cat){
                ((Cat) animal).collect();
            }
        }
    }
    public void attackWilds(){
        ArrayList<Animal> toRemove = new ArrayList<>();
        for (Animal animal:animals) {
            if(animal instanceof Dog){
                toRemove=((Dog) animal).attack();
            }
        }
        animals.removeAll(toRemove);
    }
    public void wildsAttack(){
        ArrayList<Animal> toRemoveAnimal = new ArrayList<>();
        for (Animal animal:animals) {
            if(animal instanceof WildAnimal){
                for (Animal notWildAnimal:animals) {
                    if(!(notWildAnimal instanceof WildAnimal)){
                    toRemoveAnimal.add(notWildAnimal);
                    }

                }
                products.clear();
            }
        }
        animals.removeAll(toRemoveAnimal);


    }
    public void produce(){
        for (Animal animal:animals) {
            if(animal instanceof Hen){
                ((Hen) animal).updateProduce();
            }
            else if(animal instanceof Buffalo){
                ((Buffalo) animal).updateProduce();
            }
            else if(animal instanceof Turkey){
                ((Turkey) animal).updateProduce();
            }
        }
    }



}
