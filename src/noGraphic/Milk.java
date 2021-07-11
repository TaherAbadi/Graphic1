/**
 * Created by user on 31/05/2021.
 */
package noGraphic;
public class Milk extends Product {
    public Milk(int x , int y) {
        name="Milk";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=1;
        Price=25;
        TimeToDestruction=4;
    }



}
