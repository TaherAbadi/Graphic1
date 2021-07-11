package noGraphic;

public class BoxedMilk extends Product{
    public BoxedMilk(int x , int y) {
        name="BoxedMilk";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=2;
        Price=60;
        TimeToDestruction=5;
    }
}
