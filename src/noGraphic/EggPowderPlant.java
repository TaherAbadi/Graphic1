package noGraphic;
import java.io.FileNotFoundException;
import java.util.Random;

public class EggPowderPlant extends WorkShop{
    public EggPowderPlant() {
        super(150, 4, 1,"EggPowderPlant");
    }
    public boolean produce(){
        return super.produce("Egg");}
    public void update(){
        if(this.isWorking) {
            this.progress += 1;
            if (progress >= this.timeToProduce){
                this.isWorking=false;
                Random random=new Random();
                Flour newFlour= null;
                try {
                    newFlour = new Flour(random.nextInt(6)+1 , random.nextInt(6)+1);
                    Manager.land.fields[newFlour.x-1][newFlour.y-1].products.add(newFlour);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                // System.out.println("+");

            }
        }
    }


}
