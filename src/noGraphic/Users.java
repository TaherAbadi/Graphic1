package noGraphic;

public class Users {
    private String userName;
    private String passWord;
    private int maxLevel=0;
    private int savedCoins=0;

    public int getMaxLevel() {
        return maxLevel;
    }

    public void addMaxLevel() {
        this.maxLevel++;
    }



    public Users(String userName, String passWord , int maxLevel) {
        this.userName = userName;
        this.passWord = passWord;
        this.maxLevel = maxLevel;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void addToSavedCoins(int savedCoins){
        this.savedCoins+=savedCoins;
    }
}
