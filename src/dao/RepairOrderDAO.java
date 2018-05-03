/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import core.RepairOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.String;

/**
 *
 * @author Bob
 */
public class RepairOrderDAO {
    private DBConnection conn;
    private java.util.Date date;
    public RepairOrderDAO(DBConnection conn) {
        this.conn = conn;
    }
    
    public List<RepairOrder> getAllRepairOrders() throws Exception {
        List<RepairOrder> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from repairOrder");
            while (rs.next()) {
                RepairOrder fund = convertRowToRepairOrder(rs);
                list.add(fund);
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
    }
    
    public void addRepairOrder(RepairOrder repairOrder) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into repairOrder values (?, ?, ?, ?, ?, ?, ?)");

//            stmt.setInt(1, repairOrder.shipOut_CID);
//            stmt.setInt(2, repairOrder.shipIn_CID);
//            stmt.setInt(3, repairOrder.EID);
//            stmt.setInt(4, repairOrder.RID);
//            stmt.setString(5, repairOrder.dateRecd);
//            stmt.setString(6, repairOrder.dateShipped);
//            stmt.setString(7, repairOrder.shipOutType);
            stmt.setInt(1, repairOrder.getRID());
            stmt.setString(2, repairOrder.getDateRecd());
            if(repairOrder.getDateShipped() != null && !repairOrder.getDateShipped().isEmpty())
                  stmt.setString(3, repairOrder.getDateShipped());
            else
                stmt.setNull(3, java.sql.Types.DATE);
            if(repairOrder.getShipOutType() != null && !repairOrder.getShipOutType().isEmpty())
                stmt.setString(4, repairOrder.getShipOutType().toString());
            else
                stmt.setNull(4, java.sql.Types.VARCHAR);
            if(repairOrder.getShipIn_CID() != 0)
                stmt.setInt(7, repairOrder.getShipIn_CID());
            else
                stmt.setNull(7, java.sql.Types.INTEGER);
            if(repairOrder.getShipOut_CID() != 0)
                stmt.setInt(5, repairOrder.getShipOut_CID());
            else
                stmt.setNull(5, java.sql.Types.INTEGER);
            stmt.setInt(6, repairOrder.getEID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    //changed passed value to int to simplify deletion  Buddy
    public void deleteRepairOrder(int rid) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from repairOrder where RID = ?");
            //stmt.setInt(1, repairOrder.RID);
            stmt.setInt(1, rid);
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    public void updateRepairOrder(RepairOrder repairOrder) throws Exception {
       
        PreparedStatement stmt = null;
        String sql ="update repairOrder set dateRecd = ?,"
                    + " dateShipped = ?,"
                    + " shipOutType = ?,"
                    + " shipOut_CID = ?,"
                    + " EID = ?,"
                    + " shipIn_CID = ?"
                    + " where RID = ?";
        
        try {

            stmt = conn.prepareStatement(sql);
            //dateRecd has been validated already
            //check date shipped in case of null
            stmt.setInt(7, repairOrder.getRID());
            stmt.setString(1, repairOrder.getDateRecd());
            if(repairOrder.getDateShipped() != null && !repairOrder.getDateShipped().isEmpty())
                  stmt.setString(2, repairOrder.getDateShipped());
            else
                stmt.setNull(2, java.sql.Types.DATE);
            if(repairOrder.getShipOutType() != null && !repairOrder.getShipOutType().isEmpty())
                stmt.setString(3, repairOrder.getShipOutType().toString());
            else
                stmt.setNull(3, java.sql.Types.VARCHAR);
            if(repairOrder.getShipIn_CID() != 0)
                stmt.setInt(6, repairOrder.getShipIn_CID());
            else
                stmt.setNull(6, java.sql.Types.INTEGER);
            if(repairOrder.getShipOut_CID() != 0)
                stmt.setInt(4, repairOrder.getShipOut_CID());
            else
                stmt.setNull(4, java.sql.Types.INTEGER);
            stmt.setInt(5, repairOrder.getEID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    private RepairOrder convertRowToRepairOrder(ResultSet rs) throws Exception {
        int RID = rs.getInt("RID");
        String dateRecd = rs.getString("dateRecd");
        String dateShipped = rs.getString("dateShipped");
        String shipOutType = rs.getString("shipOutType");
        int shipOut_CID = rs.getInt("ShipOut_CID");
        int EID = rs.getInt("EID");
        int shipIn_CID = rs.getInt("ShipIn_CID");
//        String shipOutType = rs.getString("shipOutType");
//        int shipOut_CID = rs.getInt("shipOut_CID");
//        int EID = rs.getInt("EID");
//        int shipIn_CID = rs.getInt("shipIn_CID");
        return new RepairOrder(RID, dateRecd, dateShipped, shipOutType, shipOut_CID, EID, shipIn_CID);
    }
    
    // Added by Jesse Houk for access to attribute data for RepairOrderFrame
    public List getAllShipTypes() throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select `COLUMN_NAME` FROM `INFORMATION_SCHEMA`.`COLUMNS`"
            + " WHERE `TABLE_SCHEMA`='echo' AND `TABLE_NAME`='carrier' AND " +
            "(COLUMN_NAME like 'ship%' OR COLUMN_NAME = 'walk_in')";
        List shipTypes = new ArrayList<>();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        //rs.beforeFirst();
        while (rs.next()) {
            shipTypes.add(rs.getString("COLUMN_NAME"));
        }
        conn.close(stmt, rs);
        return shipTypes;
    }
    
    public List getAllRIDs() throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        List RIDs = new ArrayList<>();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select RID from repairOrder");
        while (rs.next()) {
            RIDs.add(rs.getString("RID"));
        }
        conn.close(stmt, rs);
        return RIDs;
    }
}