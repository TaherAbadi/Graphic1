/**
 * Created by user on 31/05/2021.
 */
package noGraphic;
public class CaughtAnimal extends Product {
    CaughtAnimal(int x,int y,int price) {
        name="CaughtAnimal";
        this.x=x;
        this.y=y;
        OnTheGround=true;
        InTheWarehouse=false;
        SpaceTaken=15;
        this.Price=price;
        TimeToDestruction=5;
    }

}
