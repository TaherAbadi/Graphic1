package noGraphic;
public class Flour extends Product{
    public Flour(int x , int y) {
        name="Flour";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=2;
        Price=40;
        TimeToDestruction=5;
    }

}
