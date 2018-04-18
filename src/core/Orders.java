/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Garrett Gulker
 */
public class Orders {
    private int OID;
    private String PID;
    private int EID;
    private int quantity;
    private String dateRecd;
    
    public Orders(){
        OID = 0;
        PID = " ";
        EID = 0;
        quantity = 0;
        dateRecd = " ";
    }
    
    public Orders(int o, String p, int e, int q, String d){
        OID = o;
        PID = p;
        EID = e;
        quantity = q;
        dateRecd = d;
    }
    
    public int getOID(){
        return OID;
    }
    public void setOID(int o){
        this.OID = o;
    }
    
    public String getPID(){
        return PID;
    }
    public void setPID(String p){
        this.PID = p;
    }
    
    public int getEID(){
        return EID;
    }
    public void setEID(int e){
        this.EID = e;
    }
    
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int q){
        this.quantity = q;
    }
    
    public String getDateRecd(){
        return dateRecd;
    }
    public void setDateRecd(String d){
        this.dateRecd = d;
    }
}
