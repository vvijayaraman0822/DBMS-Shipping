package core;


/**
 *
 * @author Holden.Hall
 */



public class Equipment {
    private String serialNum;
    private int ID;
    private String name;


    public Equipment() {
        serialNum = "";
        ID = -1;
        name = "";
    }

    public Equipment(String s, int i, String n) {
        serialNum = s;
        ID = i;
        name = n;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}