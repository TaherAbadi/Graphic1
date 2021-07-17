package noGraphic;
import java.io.FileNotFoundException;
import java.util.Random;


public class CookieBakery extends WorkShop{
    public CookieBakery() {
        super(250, 5, 1,"CookieBakery");
    }

   /* public void BuildCookieBakery(){
        if (this.level==0){
            this.level=1;
            this.TimeToProduce=5;
            this.BuildingCost=250;
            this.Material="Flour";
            this.Product="Bread";

        }else {
            //CookieBakery already exists
            //TODO
        }
    }*/

    public boolean produce(){
        return super.produce("Flour");
    }
    public void update(){
        if(this.isWorking) {
            this.progress += 1;
            if (progress >= this.timeToProduce){
                this.isWorking=false;
                Random random=new Random();
                Bread newBread= null;
                try {
                    newBread = new Bread(random.nextInt(6)+1 , random.nextInt(6)+1);
                    Manager.land.fields[newBread.x-1][newBread.y-1].products.add(newBread);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
