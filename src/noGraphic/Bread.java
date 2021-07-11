package noGraphic;
public class Bread extends Product{
    public Bread(int x , int y) {
        name="Bread";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=4;
        Price=80;
        TimeToDestruction=6;
    }
}
