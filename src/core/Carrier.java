/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author ramona.wuthrich
 */


public class Carrier {

    private int CID;
    private String name;
    private String avail_ship_type;
    
    public Carrier(){
        CID = 0;
        name = "";
        avail_ship_type = "";
    }
    
     public Carrier(int c, String n, String s){
        CID = c;
        name = n;
        avail_ship_type = s;
    }
     
     public String getName(){
        return name;  
    }
    public void setName(String name){
        this.name = name;
    }
    public int getCID(){
        return CID;
    }
    public void setCID(int c){
        this.CID = c;
    }
    
    public String getShipType(){
        return avail_ship_type;  
    }
    public void setShipType(String s){
        this.avail_ship_type = s;
    }
    
    
}
