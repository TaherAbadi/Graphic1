package noGraphic;
import java.io.FileNotFoundException;
import java.util.Random;

public class FeatherFactory extends  WorkShop{
    public FeatherFactory() {
        super(250, 5,  1,"FeatherFactory");
    }
    public boolean produce(){
        return super.produce("Feather");
    }
    public void update(){
        if(this.isWorking==true) {
            this.progress += 1;
            if (progress >= this.timeToProduce){
                this.isWorking=false;
                Random random=new Random();
                Fabric newFabric= null;
                try {
                    newFabric = new Fabric(random.nextInt(6)+1 , random.nextInt(6)+1);
                    Manager.land.fields[newFabric.x-1][newFabric.y-1].products.add(newFabric);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
