package noGraphic;
import javax.sound.midi.Soundbank;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 31/05/2021.
 */
public class InputProcessor {
    final static String ERROR="Incorrect command!";
    static Pattern startPattern=Pattern.compile("START\\s*(\\d+)");
    static Pattern buyPattern=Pattern.compile("BUY\\s*([a-zA-z]+)");
    static Pattern pickUpPattern=Pattern.compile("PICKUP\\s*([1-6])\\s*([1-6])");
    static Pattern plantPattern=Pattern.compile("PLANT\\s*([1-6])\\s*([1-6])");
    static Pattern workPattern=Pattern.compile("WORK\\s*([a-zA-Z]+)");
    static Pattern cagePattern=Pattern.compile("cage\\s*([1-6])\\s*([1-6])");
    static Pattern turnPattern=Pattern.compile("turn\\s*(\\d+)");
    static Pattern truckLoadPattern=Pattern.compile("TRUCK\\s*LOAD\\s([a-zA-z]+)");
    static Pattern truckUnLoadPattern=Pattern.compile("TRUCK\\s*UNLOAD\\s([a-zA-z]+)");
    static  Pattern truckGo=Pattern.compile("Truck\\s*go");
    static Pattern build=Pattern.compile("Build\\s*([a-zA-Z]+)");
    public static void getInput(){
        while (true){
            boolean in=false;
            Scanner scanner=new Scanner(System.in);
            String command=scanner.nextLine();
            if(command.equalsIgnoreCase("SIGN UP")){
                System.out.println("user name:");
                command=scanner.nextLine();
                if(!Manager.isUser(command)){
                    System.out.println("password:");
                    String pass=scanner.nextLine();
                    Manager.addUser(command,pass);
                    ReadWriteFile.WriteLogger(true,command+" signed up");
                    in=true;
                }
                else
                    ReadWriteFile.WriteLogger(false,"Already signed up!");
            }
            else if(command.equalsIgnoreCase("LOG IN")){
                System.out.println("user name:");
                command=scanner.nextLine();
                if(Manager.isUser(command)){
                    System.out.println("password:");
                    String pass=scanner.nextLine();
                    if(Manager.isPass(command,pass)){
                        ReadWriteFile.WriteLogger(true,command+" logged in!");
                        in=true;
                    }
                    else
                        ReadWriteFile.WriteLogger(false,"Wrong password!");
                }
                else  ReadWriteFile.WriteLogger(false,"There isn`t any user with this username!");
            }
            else ReadWriteFile.WriteLogger(false,ERROR);
            while (in){
                command=scanner.nextLine();
                if(command.equals("LOG OUT")){
                    in=false;
                }
                else if(command.equals("SETTING")){
                    //TODO
                }
                else if (command.startsWith("START")){
                    Matcher matcher=startPattern.matcher(command);
                    while (matcher.find() && in){
                        if(Manager.level(Integer.parseInt(matcher.group(1)))){
                            ReadWriteFile.WriteLogger(true,"level "+matcher.group(1)+" started");
                           gameInput(scanner);
                        }
                        else
                            ReadWriteFile.WriteLogger(false,"level "+matcher.group(1)+" is not available!");
                    }
                }
                else ReadWriteFile.WriteLogger(false,ERROR);

            }
        }
    }
    public static  void gameInput(Scanner scanner){
        //System.out.println("+");
        Matcher matcher ,matcher1,matcher2,matcher3,matcher4,matcher5,matcher6,matcher7,matcher8,matcher9;
        boolean win=false;
        while ( !win){
         String command=scanner.nextLine();
         matcher=buyPattern.matcher(command);matcher1=pickUpPattern.matcher(command);
         matcher2=plantPattern.matcher(command);matcher3=workPattern.matcher(command);
         matcher4=cagePattern.matcher(command);matcher5=turnPattern.matcher(command);
         matcher6=truckLoadPattern.matcher(command);matcher7=truckUnLoadPattern.matcher(command);
         matcher8=truckGo.matcher(command); matcher9=build.matcher(command);
         if(matcher.find()){
             Manager.buyAnimal(matcher.group(1));
         }
         else if(matcher1.find()){
             int temp=Manager.pickUp(Integer.parseInt(matcher1.group(1)),Integer.parseInt(matcher1.group(2)));
             if(temp==2) ReadWriteFile.WriteLogger(false,"Not enough capacity in the warehouse");
             else if(temp==1) ReadWriteFile.WriteLogger(true,"added !");
             else if(temp==3) ReadWriteFile.WriteLogger(false,"no product here!");
         }
         else if(command.equals("WELL")){
             if(Manager.drainge()==false){
                 ReadWriteFile.WriteLogger(false,"The water buket is full!");
             }
             else
                 ReadWriteFile.WriteLogger(true,"Drainaged successfully");
         }
         else if(matcher2.find()){
             if(Manager.plantGrass(Integer.parseInt(matcher2.group(1)),Integer.parseInt(matcher2.group(2))))
                 ReadWriteFile.WriteLogger(true,"planted grass in"+matcher2.group(1)+" "+matcher2.group(2));
             else
                 ReadWriteFile.WriteLogger(false,"not enough water!");
         }
         else if(matcher3.find()){
            if(! Manager.work(matcher3.group(1)))
                ReadWriteFile.WriteLogger(false,ERROR);
         }
         else if(matcher4.find()){
             Manager.cage(Integer.parseInt(matcher4.group(1)),Integer.parseInt(matcher4.group(2)));
         }
         else if(matcher5.find()){
             int temp= Manager.update(Integer.parseInt(matcher5.group(1)));
            if(temp==1){
                win=true;
                System.out.println("win!");

            }
            else if(temp==-1) {
                //TODO
            }
         }
         else if(matcher6.find()){
             Manager.loadTruck(matcher6.group(1));
         }
         else if(matcher7.find()){
             Manager.unloadTruck(matcher7.group(1));
         }
         else if(matcher8.find()){
             if(Manager.truckGo())
                 ReadWriteFile.WriteLogger(true,"truck started to go!");
             else
                 ReadWriteFile.WriteLogger(false,"planted grass in"+"truck is empty!");

         }
         else if(command.equals("inquiry")){
             Manager.inquiry();
         }
         else if(matcher9.find()){
             if(!Manager.buildWorkShop(matcher9.group(1)))
                 ReadWriteFile.WriteLogger(false,ERROR);
         }

         else
             ReadWriteFile.WriteLogger(false,ERROR);
        }
    }

}
