package noGraphic;
public abstract class WorkShop {
        protected int buildingCost;
        protected int timeToProduce;
        protected boolean isWorking;
        protected int progress;

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel() {
        this.level = 1;
    }

    protected String name;
        protected int level=0;

        public WorkShop(int buildingCost, int timeToProduce, int level,String name) {
                this.buildingCost = buildingCost;
                this.timeToProduce = timeToProduce;
                this.name=name;
                this.level = 0;
                isWorking=false;
                progress=0;
        }

       public static boolean produce(WorkShop workShop){
                if(workShop instanceof CookieBakery){
                       return  ((CookieBakery) workShop).produce();
                }
                else if(workShop instanceof  MilkBoxing){
                        return ((MilkBoxing) workShop).produce();
                }
                else if(workShop instanceof  FeatherFactory){
                        return ((FeatherFactory) workShop).produce();
                }
                else if(workShop instanceof  IceCreamFactory){
                    return ((IceCreamFactory) workShop).produce();
                }
                else if(workShop instanceof  EggPowderPlant){
                    return ((EggPowderPlant) workShop).produce();
                }
                else if(workShop instanceof  TailoringFactory){
                    return ((TailoringFactory) workShop).produce();
                }
        return false;
        }
        public boolean produce(String product) {
            if(Manager.wareHouse.NumberOfProducts(product)>=1){
                Manager.wareHouse.ProductNumberChanger(product , 1);
                this.isWorking=true;
                return true;
            }
            else {
                return false;
                //TODO
            }
        }

    public boolean isWorking() {
        return isWorking;
    }
}
