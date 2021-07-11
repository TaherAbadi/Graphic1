package noGraphic;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 31/05/2021.
 */
public class WareHouse {
   // protected static int Capacity=30;
    private final int CAPACITY=30;
    private int capacity;
    private HashMap< String, Integer > productsStorage = new HashMap<String, Integer>();
    private ArrayList<Product> productArrayList=new ArrayList <Product>();




    public WareHouse() {
        this.capacity = CAPACITY;
        this.productsStorage.put("Egg",0);
        this.productsStorage.put("Milk",0);
        this.productsStorage.put("Feather",0);
        this.productsStorage.put("Flour",0);
        this.productsStorage.put("Fabric",0);
        this.productsStorage.put("BoxedMilk",0);
        this.productsStorage.put("Bread",0);
        this.productsStorage.put("Clothes",0);
        this.productsStorage.put("IceCream",0);
        this.productsStorage.put("Lion",0);
        this.productsStorage.put("Bear",0);
        this.productsStorage.put("Tiger",0);

    }

    public boolean AddProduct(String product ){
        if (product.equalsIgnoreCase("Egg")) {
            if (this.capacity - 1 >= 0) {
                productsStorage.replace("Egg",productsStorage.get("Egg")+1);
                capacity--;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("Feather")){
            if (capacity - 1 >= 0){
                productsStorage.replace("Feather",productsStorage.get("Feather")+1);
                capacity--;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("Milk")) {
            if (capacity - 1 >= 0) {
                productsStorage.replace("Milk", productsStorage.get("Milk") + 1);
                capacity--;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("Flour")){
            if (capacity - 2 >= 0) {
                productsStorage.replace("Flour",productsStorage.get("Flour")+1);
                capacity-=2;
                return true;
            }
        }

        else if (product.equalsIgnoreCase("Fabric")){
            if (capacity - 2 >= 0) {
                productsStorage.replace("Fabric", productsStorage.get("Fabric") + 1);
                capacity-=2;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("BoxedMilk")){
            if (capacity - 2 >= 0) {
                productsStorage.replace("BoxedMilk",productsStorage.get("BoxedMilk")+1);
                capacity-=2;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("Bread")){
            if (capacity - 4 >= 0) {
                productsStorage.replace("Bread",productsStorage.get("Bread")+1);
                capacity-=4;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("Clothes")){
            if (capacity - 4 >= 0) {
                productsStorage.replace("Clothes", productsStorage.get("Clothes") + 1);
                capacity-=4;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("IceCream")){
            if (capacity - 4 >= 0) {
                productsStorage.replace("IceCream",productsStorage.get("IceCream")+1);
                capacity-=4;
                return true;
            }
            return false;
        }

        else if (product.equalsIgnoreCase("Bear")){
            if (capacity - 15 >= 0) {
                productsStorage.replace("Bear",productsStorage.get("Bear")+1);
                capacity-=15;
                return true;
            }
            return false;
        }
        else if (product.equalsIgnoreCase("Lion")){
            if (capacity - 15 >= 0) {
                productsStorage.replace("Lion",productsStorage.get("Lion")+1);
                capacity-=15;
                return true;
            }
            return false;
        }else if (product.equalsIgnoreCase("Tiger")){
            if (capacity - 15 >= 0) {
                productsStorage.replace("Tiger",productsStorage.get("Tiger")+1);
                capacity-=15;
                return true;
            }
            return false;
        }
        return false;
    }






    public void TakeProduct(String product){
        if (productsStorage.get(product)>=1) {
            if (product.equalsIgnoreCase("Egg")) {
                productsStorage.replace("Egg", productsStorage.get("Egg") - 1);
                capacity++;
            } else if (product.equalsIgnoreCase("Feather")) {
                productsStorage.replace("Feather", productsStorage.get("Feather") - 1);
                capacity++;
            } else if (product.equalsIgnoreCase("Milk")) {
                productsStorage.replace("Milk", productsStorage.get("Milk") - 1);
                capacity++;
            } else if (product.equalsIgnoreCase("Flour")) {
                productsStorage.replace("Flour", productsStorage.get("Flour") - 1);
                capacity += 2;
            } else if (product.equalsIgnoreCase("Fabric")) {
                productsStorage.replace("Fabric", productsStorage.get("Fabric") - 1);
                capacity += 2;
            } else if (product.equalsIgnoreCase("BoxedMilk")) {
                productsStorage.replace("BoxedMilk", productsStorage.get("BoxedMilk") - 1);
                capacity += 2;
            } else if (product.equalsIgnoreCase("Bread")) {
                productsStorage.replace("Bread", productsStorage.get("Bread") - 1);
                capacity += 4;
            } else if (product.equalsIgnoreCase("Clothes")) {
                productsStorage.replace("Clothes", productsStorage.get("Clothes") - 1);
                capacity += 4;
            } else if (product.equalsIgnoreCase("IceCream")) {
                productsStorage.replace("IceCream", productsStorage.get("IceCream") - 1);
                capacity += 4;
            }
        }
    }

    public int NumberOfProducts(String product){
        return productsStorage.get(product);

    }

    public void ProductNumberChanger(String product , int number){
        productsStorage.put(product , productsStorage.get(product)-number);
    }

    public HashMap <String, Integer> getProductsStorage() {
        return productsStorage;
    }
}
