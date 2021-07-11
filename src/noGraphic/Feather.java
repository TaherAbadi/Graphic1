/**
 * Created by user on 31/05/2021.
 */
package noGraphic;
public class Feather extends Product {
    public Feather(int x, int y) {
        name="Feather";
        this.x = x;
        this.y = y;
        OnTheGround = true;
        InTheWarehouse = false;
        SpaceTaken = 1;
        Price = 20;
        TimeToDestruction = 4;
    }
}
