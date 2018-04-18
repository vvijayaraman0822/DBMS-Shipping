/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Jesse
 */
public class Part {
    private int PID;
    private String name;
    private String description;
    private int VID;
    
 public Part (int P, String n) {
     PID = P;
     name = n;
     description = "";
     VID = 0;
 }
 
 public Part (int P, String n, String d) {
     PID = P;
     name = n;
     description = d;
     VID = 0;
 }
 
 public Part (int P, String n, String d, int V) {
     PID = P;
     name = n;
     description = d;
     VID = V;
 }
 
 public int getPID () {
     return PID;
 }
 
 public void setPID(int P) {
     PID = P;
 }
 public String getname () {
     return name;
 }
 
 public void setname(String n) {
     name = n;
 }
 
 public String getdescription () {
     return description;
 }
 
 public void setPID(String d) {
     description = d;
 }
 
 public int getVID () {
     return VID;
 }
 
 public void setVID(int V) {
     VID = V;
 }
}
