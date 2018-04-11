/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Luong
 */
public class Contains {
    private int RID;
    private String serialNUM;
    
    public Contains(){
    RID = 0;
    serialNUM = "";
    }
    
    public Contains(int r, String s){
    RID = r;
    serialNUM = s;
    }
    
    public String getSerialNum(){
        return serialNUM;  
    }
    public void setName(String serialNum){
        this.serialNUM = serialNum;
    }
    public int getRID(){
        return RID;
    }
    public void setCID(int c){
        this.RID = c;
    }    
}

