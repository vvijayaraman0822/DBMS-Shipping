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
/**
 * 
 * @author downw edits by Micahel Lewis on 4/18 
 */
//edited by Michael Lewis, Reason: VID and PID are varchar on database
//steps taken changed PID and VID to String from int
public class Part {
    private String PID;
    private String name;
    private String description;
    private String VID;
 //edited by Michael Lewis PID to string being passed in. VID to empty stringstring.   
 public Part (String P, String n) {
     PID = P;
     name = n;
     description = "";
     VID = "";
 }
 //see default constructor above.
 public Part (String P, String n, String d) {
     PID = P;
     name = n;
     description = d;
     VID = "";
 }
 //see previous constructors
 public Part (String P, String n, String d, String V) {
     PID = P;
     name = n;
     description = d;
     VID = V;
 }
 //edited by Michael Lewis, int to string.
 public String getPID () {
     return PID;
 }
 //edited by Michael Lewis, int to string.
 public void setPID(String P) {
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
 //setdescription was nameed setPID, edit by Michael Lewis
 public void setdescription(String d) {
     description = d;
 }
//edited by Michael Lewis, int to string. 
 public String getVID () {
     return VID;
 }
 //edited by Michael Lewis, int to string.
 public void setVID(String V) {
     VID = V;
 }
}
