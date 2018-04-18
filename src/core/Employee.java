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
public class Employee {
    
    private int EID;
    private String last_name;
    private String first_name;
    
    public Employee (){
        EID = 0;
        last_name = " ";
        first_name = " ";
    }
    public Employee (int e, String ln, String fn) {
        EID = e;
        last_name = ln;
        first_name = fn;
    }
    
     public int getEID(){
        return EID;
    }
    public void setEID(int e){
        this.EID = e;
    }
        
     public String getLastName(){
        return last_name;  
    }
    public void setLastName(String ln){
        this.last_name = ln;
    }

    public String getFirstName(){
        return first_name;
    }
    public void setFirstName(String fn){
        this.first_name = fn;
    }
    
}
