package noGraphic;
import java.awt.*;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import noGraphic.Manager;
import noGraphic.ReadWriteFile;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import sample.AnimalAnim;
import sample.Main;

import javax.swing.text.Element;


/**
 * Created by user on 29/05/2021.
 */
public class DomesticAnimal extends Animal implements Purchasable {
    protected int age;
    protected int produce;
    protected int price;



    public DomesticAnimal(String name) {
        this.name=name;
        Random random=new Random();
        this.age = 100;
        this.width=0; this.length=0;

            this.length=random.nextInt(6)+1;
            this.width=random.nextInt(6)+1;

        Manager.land.fields[length-1][width-1].animals.add(this);
        AnimalAnim animalAnim=new AnimalAnim(this);
        Main.animalAnims.add(animalAnim);

    }

    public int getAge() {
        return age;
    }
    public void reduceLife(){
        age-=10;
        //age-=0.1*age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void moveDomestic(){
        String s= Manager.nearestGrass(this.length,this.width);
        int x=Integer.parseInt(s.substring(0,1)) , y=Integer.parseInt(s.substring(1));
        if (x!=0 && y!=0){
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


}
