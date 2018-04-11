/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Jay
 */
public class Fixes {
    private int EID;
    private int RID;
    
    public Fixes(){
        EID = 0;
        RID = 0;
    }
    
    public Fixes(int E, int R){
        EID = E;
        RID = R;
    }
    
    public int getEID(){
        return EID;  
    }
    public void setEID(int E){
        this.EID = E;
    }
    public int getRID(){
        return RID;
    }
    public void setRID(int R){
        this.RID = R;
    }
    
    
}
