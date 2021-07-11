package noGraphic;
import java.util.Random;

public class IceCreamFactory extends WorkShop {
    public IceCreamFactory() {
        super(550, 7,1,"IceCreamFactory");
    }

    public boolean produce(){
        return super.produce("BoxedMilk");
    }
    public void update(){
        if(this.isWorking==true) {
            this.progress += 1;
            if (progress >= this.timeToProduce){
                this.isWorking=false;
                Random random=new Random();
                IceCream newIceCream=new IceCream(random.nextInt(6)+1 , random.nextInt(6)+1);
                Manager.land.fields[newIceCream.x-1][newIceCream.y-1].products.add(newIceCream);
            }
        }
    }
}
