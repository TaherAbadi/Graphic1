package noGraphic;
import java.io.FileNotFoundException;
import java.util.Random;

public class TailoringFactory extends  WorkShop{
    public TailoringFactory() {
        super(400, 6, 1,"TailoringFactory");
    }

   /* public void BuildTailoringFactory(){
        if (this.level==0){
            this.level=1;
            this.TimeToProduce=6;
            this.BuildingCost=400;
            this.Material="Fabric";
            this.Product="Clothes";

        }else {
            //TailoringFactory already exists
            //TODO
        }
    }*/
    public boolean produce(){
        return super.produce("Fabric");
    }
    public void update(){
        if(this.isWorking==true) {
            this.progress += 1;
            if (progress >= this.timeToProduce){
                this.isWorking=false;
                Random random=new Random();
                Clothes newClothes= null;
                try {
                    newClothes = new Clothes(random.nextInt(6)+1 , random.nextInt(6)+1);
                    Manager.land.fields[newClothes.x-1][newClothes.y-1].products.add(newClothes);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
