/**
 * Created by user on 29/05/2021.
 */
package noGraphic;
public class Well {
    private int waterLevel;
    private int WATER_LEVEL=5;
    private int WATER_TIME=3;
    public boolean drainage(){
        if (this.waterLevel<5){
            this.waterLevel=WATER_LEVEL;
            return  true;
        }
        return false;
    }
    public boolean useWater(){
        if(this.waterLevel>0){
            this.waterLevel-=1;
            return true;
        }
        else return false;
    }


}
