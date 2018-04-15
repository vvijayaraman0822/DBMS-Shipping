/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
/**
 *
 * @author downw
 */
public class RepairOrder 
{
    private int RID;
    private String dateRecd;
    private String dateShipped;
    private String shipType;
    private int CID;
    private int shipOut_CID;
    private int shipIn_CID;
    private int EID;   
    public RepairOrder()
    {
        RID = 0;
        dateRecd = "";
        dateShipped = "";
        shipType = "";
        CID = 0;
        shipOut_CID = 0;
        shipIn_CID = 0;
        EID = 0;
    }
    public RepairOrder(int r, String dr, String ds, String st, int c, int sc, int sc2, int e)
    {
        RID = r;
        dateRecd = dr;
        dateShipped = ds;
        shipType = st;
        CID = c;
        shipOut_CID = sc;
        shipIn_CID = sc2;
        EID = e;
    }
    public int getRID()
    {
        return RID;
    }
    public String getDateRecd()
    {
        return dateRecd;
    }
    public String getDateShipped()
    {
        return dateShipped;
    }
    public String getShipType()
    {
        return shipType;
    }
    public int getCID()
    {
        return CID;
    }
    public int getShipOut_CID()
    {
        return shipOut_CID;
    }
    public int getShipIn_CID(){
        return shipIn_CID;
    }
    public int getEID()
    {
        return EID;
    }
    public void setRID(int r)
    {
        this.RID = r;
    }
    public void setDateRecd(String dateR)
    {
        this.dateRecd = dateR;
    }
    public void setDateShipped(String dateS)
    {
        this.dateShipped = dateS;
    }
    public void setShiptType(String shipType)
    {
        this.shipType = shipType;
    }
    public void setCID(int cid)
    {
        this.CID = cid;
    }
    public void setShipout_CID(int shipCID)
    {
        this.shipOut_CID = shipCID;
    }
    public void setShipIn_CID(int shipCID2){
        this.shipIn_CID = shipCID2;
    }
    public void setEID(int EID)
    {
        this.EID = EID;
    }
}
