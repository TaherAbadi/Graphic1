/**
 * Created by user on 29/05/2021.
 */
package noGraphic;

import javafx.scene.image.ImageView;

public class Product extends ImageView {
    protected String name;
    protected int TimeToDestruction;
    protected int SpaceTaken;
    protected int Price;
    protected boolean OnTheGround;
    protected boolean InTheWarehouse;
    protected int x;
    protected int y;

    public void imageLoc(){
        this.setFitWidth(30);
        this.setFitHeight(30);
        this.setX(((x-1)*61)+30);
        this.setY(((y-1)*50)+25);
    }

    public void setOnTheGround(boolean onTheGround) {
        OnTheGround = onTheGround;
    }

    public void setInTheWarehouse(boolean inTheWarehouse) {
        InTheWarehouse = inTheWarehouse;
    }
    public void grab(){
        this.x=-1;
        this.y=-1;
        this.InTheWarehouse=true;
        this.OnTheGround=false;
    }
    public String type(){
        if(this instanceof Milk)
            return "Milk";
        else if(this instanceof Egg)
            return "Egg";
        else if(this instanceof Feather)
            return "Feather";
        else if(this instanceof BoxedMilk)
            return "BoxedMilk";
        else if(this instanceof Flour)
            return "Flour";
        else if(this instanceof Fabric)
            return "Fabric";
        else if(this instanceof IceCream)
            return "IceCream";
        else if(this instanceof Bread)
            return "Bread";
        else if(this instanceof Clothes)
            return "Clothes";
        else if(this instanceof CaughtAnimal){
            if(this.Price==300)
                return "Lion";
            else if(this.Price==400)
                return "Bear";
            else if(this.Price==500)
                return "Tiger";
            else return "";
        }
        else return "";
        //TODO
    }



}
