/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author samuel.mullins
 */
public class Vendor {
    private String VID;
    private String name;
    private String contact;
    private String address;
    private String city;
    private String state;
    private String zip;
    
    public Vendor(){
        VID = "";
        name = "";
        contact = "";
        address = "";
        city = "";
        state = "";
        zip = "";
    }
    
    public Vendor(String v, String n, String p, String a, String c, String s, String z){
        VID = v;
        name = n;
        contact = p;
        address = a;
        city = c;
        state = s;
        zip = z;
    }
    
    public String getName(){
        return name;  
    }
    public void setName(String n){
        this.name = n;
    }
    public String getVID(){
        return VID;
    }
    public void setVID(String v){
        this.VID = v;
    }
    public String getContact(){
        return contact;
    }
    public void setContact(String p){
        this.contact = p;
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
    public void setCity(String c){
        this.city = c;
    }
    public String getState(){
        return state;
    }
    public void setState(String s){
        this.state = s;
    }
    public String getZip(){
        return zip;
    }
    public void setZip(String z){
        this.zip = z;
    }
    
}
