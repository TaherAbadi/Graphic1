package noGraphic;
public class Fabric extends Product{
    public Fabric(int x , int y) {
        name="Fabric";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=2;
        Price=50;
        TimeToDestruction=5;
    }
}
