package noGraphic;
public class IceCream extends Product{
    public IceCream(int x , int y) {
        name="IceCream";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=4;
        Price=120;
        TimeToDestruction=6;
    }
}
