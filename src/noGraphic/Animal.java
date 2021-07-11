package noGraphic;
import java.util.Random;

/**
 * Created by user on 29/05/2021.
 */
public class Animal {
    int width;
    int length;
    String name;

    public String getName() {
        return name;
    }

    public void move(int a){
        if(this.width==1||this.width==6||this.length==1||this.length==6){
            Random random=new Random();
            if(this.width==1&&this.length==1) {
                if(random.nextBoolean())
                    this.width+=a;
                else
                    this.length+=a;
            }
            else if(this.width==1&&this.length==6) {
                if(random.nextBoolean())
                    this.width+=a;
                else
                    this.length-=a;
            }
            else if(this.width==6&&this.length==1) {
                if(random.nextBoolean())
                    this.width-=a;
                else
                    this.length+=a;
            }
            else if(this.width==6&&this.length==6) {
                if(random.nextBoolean())
                    this.width-=a;
                else
                    this.length-=a;
            }
            else if(this.width==1&&this.length!=1&&this.length!=6){
                int temp=random.nextInt(3)+1;
                if(temp==3)
                    this.width+=a;
                else if(temp==2)
                    this.length+=a;
                else
                    this.length-=a;
            }
            else if(this.width==6&&this.length!=1&&this.length!=6){
                int temp=random.nextInt(3)+1;
                if(temp==3)
                    this.width-=a;
                else if(temp==2)
                    this.length+=a;
                else
                    this.length-=a;
            }
            else if(this.length==1&&this.width!=1&&this.width!=6){
                int temp=random.nextInt(3)+1;
                if(temp==3)
                    this.length+=a;
                else if(temp==2)
                    this.width+=a;
                else
                    this.width-=a;
            }
            else if(this.length==6&&this.width!=1&&this.width!=6){
                int temp=random.nextInt(3)+1;
                if(temp==3)
                    this.length-=a;
                else if(temp==2)
                    this.width+=a;
                else
                    this.width-=a;
            }
        }
        else {
            Random random=new Random();
            int temp=random.nextInt(4)+1;
            switch (temp){
                case 1:
                    this.length-=a;
                    break;
                case 2:
                    this.length+=a;
                    break;
                case 3:
                    this.width-=a;
                    break;
                case 4:
                    this.width+=a;
                    break;
            }
        }
    }
}
