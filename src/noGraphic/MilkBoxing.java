package noGraphic;
import java.util.Random;

public class MilkBoxing extends WorkShop{


    public MilkBoxing() {
        super(550, 7,1,"MilkBoxing");
    }


    public boolean produce(){
        return super.produce("Milk");

    }

    public void update(){
        if(this.isWorking==true) {
            this.progress += 1;
            if (progress >= this.timeToProduce){
                this.isWorking=false;
                Random random=new Random();
                BoxedMilk newBoxedMilk=new BoxedMilk(random.nextInt(6)+1 , random.nextInt(6)+1);
                Manager.land.fields[newBoxedMilk.x-1][newBoxedMilk.y-1].products.add(newBoxedMilk);
            }
        }
    }
}
