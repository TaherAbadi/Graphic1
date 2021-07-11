package noGraphic;
public class Clothes extends Product{
    public Clothes(int x , int y) {
        name="Clothes";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=4;
        Price=100;
        TimeToDestruction=6;
    }
}
