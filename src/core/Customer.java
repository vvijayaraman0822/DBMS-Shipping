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
    private int zip;
    private String contact;
    
    public Customer() {
        ID = -1;
        name = "";
        address = "";
        city = "";
        zip = -1;
        contact = "";
        
    }
    
    public Customer(int i, String x, String y, String z, int j, String p){
        ID = i;
        name = x;
        address = y;
        city = z;
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
    
    public int getZip(){
        return zip;
    }
    
    public void setZip(int zip){
        this.zip = zip;
    }
    
    public String getContact(){
        return contact;
    }
    
    public void setContact(String contact){
        this.contact = contact;
    }
    
    
            
    
    
}
