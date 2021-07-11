/**
 * Created by user on 31/05/2021.
 */
package noGraphic;
public class Egg extends Product{
    public Egg(int x , int y) {
        name="Egg";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=1;
        Price=15;
        TimeToDestruction=4;
    }


}
