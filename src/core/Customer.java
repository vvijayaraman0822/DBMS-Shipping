/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Mack
 */
public class Customer {
    
    private int ID;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String contact;
    
    public Customer() {
        ID = -1;
        name = "";
        address = "";
        city = "";
        state = "";
        zip = "";
        contact = "";
        
    }
    
    public Customer(int i, String x, String y, String z, String s, String j, String p){
        ID = i;
        name = x;
        address = y;
        city = z;
        state = s;
        zip = j;
        contact = p;
    }
    
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getCity(){
        return city;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getState(){
        return state;
    }
    
    public void setState(String state){
        this.state = state;
    }
    
    public String getZip(){
        return zip;
    }
    
    public void setZip(String zip){
        this.zip = zip;
    }
    
    public String getContact(){
        return contact;
    }
    
    public void setContact(String contact){
        this.contact = contact;
    } 
}
