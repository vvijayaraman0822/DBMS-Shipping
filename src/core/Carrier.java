/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author ramona.wuthrich
 * 
 */


public class Carrier {

    private int CID;
    private String name;
    private String ship_red;
    private String ship_blue;
    private String ship_ground;
    private String walk_in;
    
    public Carrier(){
        CID = 0;
        name = "";
        ship_red = "";
        ship_blue = "";
        ship_ground = "";
        walk_in = "";
    }
    
     public Carrier(int c, String n, String r, String b, String g, String w){
        CID = c;
        name = n;
        ship_red = r;
        ship_blue = b;
        ship_ground = g;
        walk_in = w;
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
    
    public String getShipType1(){
        return ship_red;  
    }
    public void setShipType1(String r){
        this.ship_red = r;
    }
    public String getShipType2(){
        return ship_blue;  
    }
    public void setShipType2(String b){
        this.ship_blue = b;
    }
        public String getShipType3(){
        return ship_ground;  
    }
    public void setShipType3(String g){
        this.ship_ground = g;
    }
        public String getShipType4(){
        return walk_in;  
    }
    public void setShipType4(String w){
        this.walk_in = w;
    }
}
