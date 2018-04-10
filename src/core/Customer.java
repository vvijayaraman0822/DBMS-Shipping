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
public class Customer {
    
    private int ID;
    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String contact;
    
    public Customer(){
        ID = 0;
        name = "";
        address = "";
        city = "";
        state = "";
        zip = 0;
        contact = "";
    }
    
     public Customer(int i, String n, String a, String c, String s, int z, String o){
        ID = i;
        name = n;
        address = a;
        city = c;
        state = s;
        zip = z;
        contact = o;
    }
     
    public int getID(){
        return ID;
    }
    public void setID(int c){
        this.ID = c;
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
    public void setAddress(String a){
        this.address = a;
    }
    
    public String getCity(){
        return city;
    }
    public void setCity(String a){
        this.city = a;    
    }
    
    public String getState(){
        return state;
    }
    public void setState(String a){
        this.state = a;
    }
    
    public int getZip(){
        return zip;
    }
    public void setZip(int c){
        this.zip = c;
    }

    public String getContact(){
        return contact;
    }
    public void setContact(String a){
        this.contact = a;
    }
}
