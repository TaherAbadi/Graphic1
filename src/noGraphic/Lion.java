package noGraphic;
/**
 * Created by user on 30/05/2021.
 */
public class Lion extends WildAnimal {
    static int lions=0;
    public Lion() {
        super(300,"Lion"+lions,3);
        lions++;
    }
    public static void produce(){
        Lion lion=new Lion();
    }

    public void move(){
        super.move(1);
    }

}
