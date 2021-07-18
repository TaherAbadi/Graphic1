package noGraphic;
import java.util.HashMap;

public class Truck {
    private int capacity;
    private final int CAPACITY=15;
    private boolean isOnWay;
    private int onWay;
    private final int TIME_NEEDED=10;
    private HashMap< String, Integer > productsLoaded = new HashMap<String, Integer>();
    private HashMap< String, Integer > animalsLoaded = new HashMap<String, Integer>();

    public int getCapacity() {
        return capacity;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public boolean isOnWay(){
        return isOnWay;
    }
    public Truck() {
        onWay=0;
        isOnWay=false;
        this.capacity = CAPACITY;
        this.productsLoaded.put("Egg",0);
        this.productsLoaded.put("Milk",0);
        this.productsLoaded.put("Feather",0);
        this.productsLoaded.put("Flour",0);
        this.productsLoaded.put("Fabric",0);
        this.productsLoaded.put("BoxedMilk",0);
        this.productsLoaded.put("Bread",0);
        this.productsLoaded.put("Clothes",0);
        this.productsLoaded.put("IceCream",0);
        this.productsLoaded.put("Lion",0);
        this.productsLoaded.put("Bear",0);
        this.productsLoaded.put("Tiger",0);
        this.animalsLoaded.put("Hen",0);
        this.animalsLoaded.put("Turkey",0);
        this.animalsLoaded.put("Buffalo",0);
        this.animalsLoaded.put("Dog",0);
        this.animalsLoaded.put("Cat",0);
    }

    public void truckLoadProduct(String product){
        if (!isOnWay) {
            if (Manager.wareHouse.NumberOfProducts(product)>0){
                if (product.equalsIgnoreCase("Egg")){
                    if (capacity - 1 >= 0){
                        System.out.println("Egg loaded");
                        productsLoaded.replace("Egg",productsLoaded.get("Egg")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added egg to the truck");

                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                         }
                }

                else if (product.equalsIgnoreCase("Feather")){
                    if (capacity - 1 >= 0){
                        productsLoaded.replace("Feather",productsLoaded.get("Feather")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added feather to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }

                else if (product.equalsIgnoreCase("Milk")) {
                    if (capacity - 1 >= 0) {
                        productsLoaded.replace("Milk", productsLoaded.get("Milk") + 1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added milk to the truck");
                    }
                    else {
                        ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }

                else if (product.equalsIgnoreCase("Flour")){
                    if (capacity - 2 >= 0) {
                        productsLoaded.replace("Flour",productsLoaded.get("Flour")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=2;
                        ReadWriteFile.WriteLogger(true,"added flour to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }

                else if (product.equalsIgnoreCase("Fabric")){
                    if (capacity - 2 >= 0) {
                        productsLoaded.replace("Fabric", productsLoaded.get("Fabric") + 1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=2;
                        ReadWriteFile.WriteLogger(true,"added fabric to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }

                else if (product.equalsIgnoreCase("BoxedMilk")){
                    if (capacity - 2 >= 0) {
                        productsLoaded.replace("BoxedMilk",productsLoaded.get("BoxedMilk")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=2;
                        ReadWriteFile.WriteLogger(true,"added boxedMilk to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }

                else if (product.equalsIgnoreCase("Bread")){
                    if (capacity - 4 >= 0) {
                        productsLoaded.replace("Bread",productsLoaded.get("Bread")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=4;
                        ReadWriteFile.WriteLogger(true,"added bread to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }

                else if (product.equalsIgnoreCase("Clothes")){
                    if (capacity - 4 >= 0) {
                        productsLoaded.replace("Clothes", productsLoaded.get("Clothes") + 1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=4;
                        ReadWriteFile.WriteLogger(true,"added clothes to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }

                else if (product.equalsIgnoreCase("IceCream")){
                    if (capacity - 4 >= 0) {
                        productsLoaded.replace("IceCream",productsLoaded.get("IceCream")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=4;
                        ReadWriteFile.WriteLogger(true,"added icecream to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }
                else if (product.equalsIgnoreCase("Lion")) {
                    if (capacity - 15 >= 0) {
                        productsLoaded.replace("Lion",productsLoaded.get("Lion")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=15;
                        ReadWriteFile.WriteLogger(true,"added caged lion to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }
                else if (product.equalsIgnoreCase("Bear")) {
                    if (capacity - 15 >= 0) {
                        productsLoaded.replace("Bear",productsLoaded.get("Bear")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=15;
                        ReadWriteFile.WriteLogger(true,"added caged bear to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck ");
                    }
                }
                else if (product.equalsIgnoreCase("Tiger")) {
                    if (capacity - 15 >= 0) {
                        productsLoaded.replace("Tiger",productsLoaded.get("Tiger")+1);
                        Manager.wareHouse.TakeProduct(product);
                        capacity-=15;
                        ReadWriteFile.WriteLogger(true,"added caged tiger to the truck");
                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck  ");
                    }
                }
            }

            else{
                ReadWriteFile.WriteLogger(false,"there isn`t any"+product+"in the warehouse");
            }
        }
        else {
            ReadWriteFile.WriteLogger(false,"the truck is on way");
        }

    }

    public void truckLoadAnimal(String animal) {
        if (!isOnWay) {
            if (Manager.animals.get(animal) > 0) {
                if (animal.equalsIgnoreCase("Hen")){
                    if (capacity - 1 >= 0){
                        animalsLoaded.replace("Hen",animalsLoaded.get("Hen")+1);
                        Manager.animals.put("Hen",Manager.animals.get("Hen")-1);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added Hen to the truck");

                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }
                if (animal.equalsIgnoreCase("Turkey")){
                    if (capacity - 1 >= 0){
                        animalsLoaded.replace("Turkey",animalsLoaded.get("Turkey")+1);
                        Manager.animals.put("Turkey",Manager.animals.get("Turkey")-1);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added Turkey to the truck");

                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }
                if (animal.equalsIgnoreCase("Buffalo")){
                    if (capacity - 1 >= 0){
                        animalsLoaded.replace("Buffalo",animalsLoaded.get("Buffalo")+1);
                        Manager.animals.put("Buffalo",Manager.animals.get("Buffalo")-1);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added Buffalo to the truck");

                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }
                if (animal.equalsIgnoreCase("Cat")){
                    if (capacity - 1 >= 0){
                        animalsLoaded.replace("Cat",animalsLoaded.get("Cat")+1);
                        Manager.animals.put("Cat",Manager.animals.get("Cat")-1);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added Cat to the truck");

                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }
                if (animal.equalsIgnoreCase("Dog")){
                    if (capacity - 1 >= 0){
                        animalsLoaded.replace("Dog",animalsLoaded.get("Dog")+1);
                        Manager.animals.put("Dog",Manager.animals.get("Dog")-1);
                        capacity--;
                        ReadWriteFile.WriteLogger(true,"added Dog to the truck");

                    }
                    else{ReadWriteFile.WriteLogger(false,"not enough capacity in the truck");
                    }
                }
            }
        }
    }
    public void truckUnloadProduct(String product) {
        if (isOnWay !=false) {
            if (productsLoaded.get(product) - 1 >= 0) {
                System.out.println("egg unloaded");
                if (product.equalsIgnoreCase("Egg")) {
                    productsLoaded.replace("Egg", productsLoaded.get("Egg") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity++;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("Feather")) {

                    productsLoaded.replace("Feather", productsLoaded.get("Feather") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity++;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("Milk")) {

                    productsLoaded.replace("Milk", productsLoaded.get("Milk") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity++;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);

                } else if (product.equalsIgnoreCase("Flour")) {
                    productsLoaded.replace("Flour", productsLoaded.get("Flour") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 2;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("Fabric")) {

                    productsLoaded.replace("Fabric", productsLoaded.get("Fabric") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 2;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("BoxedMilk")) {

                    productsLoaded.replace("BoxedMilk", productsLoaded.get("BoxedMilk") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 2;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("Bread")) {

                    productsLoaded.replace("Bread", productsLoaded.get("Bread") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 4;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("Clothes")) {

                    productsLoaded.replace("Clothes", productsLoaded.get("Clothes") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 4;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("IceCream")) {

                    productsLoaded.replace("IceCream", productsLoaded.get("IceCream") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 4;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                } else if (product.equalsIgnoreCase("Lion")) {
                    productsLoaded.replace("Lion", productsLoaded.get("Lion") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 15;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                }
                else if (product.equalsIgnoreCase("Bear")) {
                    productsLoaded.replace("Bear", productsLoaded.get("Bear") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 15;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                }
                else if (product.equalsIgnoreCase("Tiger")) {
                    productsLoaded.replace("Tiger", productsLoaded.get("Tiger") - 1);
                    Manager.wareHouse.AddProduct(product);
                    capacity += 15;
                    ReadWriteFile.WriteLogger(true,"unloaded"+product);
                }

            }
            else {
                ReadWriteFile.WriteLogger(false,"there isn`t any"+product+"in the truck");
            }
        }
        else {
            ReadWriteFile.WriteLogger(false,"the truck is on way");
        }
    }
    public int updateTruck(){
        if(this.isOnWay){
            this.onWay++;
        }
        if(this.onWay==10){
            this.isOnWay=false;
            onWay=0;
            int coin=0;
            for (String product:productsLoaded.keySet()) {
                if(product.equalsIgnoreCase("Hen")){
                    Manager.land.sellHen();
                }
                else if(product.equalsIgnoreCase("Turkey")){
                    Manager.land.sellTurkey();
                }
                else if (product.equalsIgnoreCase("Buffalo")){
                    Manager.land.sellBuffalo();
                }
                coin+=productsLoaded.get(product)*productPrice(product);
                productsLoaded.put(product,0);
            }
            return coin;
        }
        else return 0;
    }

    public  boolean go(){
        if(capacity<CAPACITY){

            isOnWay=true;
            onWay=1;
            return true;
        }
        return false;
    }
    public static int productPrice(String name){
        if(name.equals("Egg")){
            return 15;
        }
        else if(name.equals("Feather")){
            return 20;
        }
        else if(name.equals("Milk")){
            return 25;

        } else if(name.equals("Flour")){
            return 40;

        } else if(name.equals("Fabric")){
            return 50;

        } else if(name.equals("BoxedMilk")){
            return 60;

        }else if(name.equals("Bread")){
            return 80;

        }else if(name.equals("Clothes")){
            return 100;

        }else if(name.equals("IceCream")){
            return 150;
        }else if(name.equals("Lion")){
            return 300;

        }
        else if(name.equals("Bear")){
            return 300;

        }else if(name.equals("Tiger")){
            return 300;

        }
        return 0;
    }

}



