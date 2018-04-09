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
    private int shipout_CID;
    private int EID;   
    public RepairOrder()
    {
        RID = 0;
        dateRecd = "";
        dateShipped = "";
        shipType = "";
        CID = 0;
        shipout_CID = 0;
        EID = 0;
    }
    public RepairOrder(int r, String dr, String ds, String st, int c, int sc, int e)
    {
        RID = r;
        dateRecd = dr;
        dateShipped = ds;
        shipType = st;
        CID = c;
        shipout_CID = sc;
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
    public int getShipout_CID()
    {
        return shipout_CID;
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
        this.shipout_CID = shipCID;
    }
    public void setEID(int EID)
    {
        this.EID = EID;
    }
}
