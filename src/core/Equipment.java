package core;


/**
 *
 * @author Holden.Hall
 */



public class Equipment {
    private String serialNum;
    private String ID;
    private String name;


    public Equipment() {
        serialNum = "";
        ID = "";
        name = "";
    }

    public Equipment(String s, String i, String n) {
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}