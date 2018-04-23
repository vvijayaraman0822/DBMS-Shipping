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

/**
 *
 * @author Bob
 */
public class RepairOrderDAO {
    private DBConnection conn;
    
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
            stmt = conn.prepareStatement("insert into repair order values (?, ?, ?, ?, ?, ?, ?)");

//            stmt.setInt(1, repairOrder.shipOut_CID);
//            stmt.setInt(2, repairOrder.shipIn_CID);
//            stmt.setInt(3, repairOrder.EID);
//            stmt.setInt(4, repairOrder.RID);
//            stmt.setString(5, repairOrder.dateRecd);
//            stmt.setString(6, repairOrder.dateShipped);
//            stmt.setString(7, repairOrder.shipOutType);
            stmt.setInt(1, repairOrder.getRID());
            stmt.setString(2, repairOrder.getDateRecd());
            stmt.setString(3, repairOrder.getDateShipped());
            stmt.setString(4, repairOrder.getShipOutType());
            stmt.setInt(5, repairOrder.getShipOut_CID());
            stmt.setInt(6, repairOrder.getEID());
            stmt.setInt(7, repairOrder.getShipIn_CID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    public void deleteRepairOrder(RepairOrder repairOrder) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from repair order where RID = ?");
            //stmt.setInt(1, repairOrder.RID);
            stmt.setInt(1, repairOrder.getRID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    public void updateRepairOrder(RepairOrder repairOrder) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("update repair order set dataRecd = ?," 
                    + "dateShipped = ?,"
                    + "shipOutType = ?,"
                    + "shipOut_CID = ?,"
                    + "EID = ?,"
                    + "shipIn_CID = ?"
                    + "where RID = ?");
//            stmt.setInt(1, repairOrder.shipOut_CID);
//            stmt.setInt(2, repairOrder.shipIn_CID);
//            stmt.setInt(3, repairOrder.EID);
//            stmt.setInt(4, repairOrder.RID);
//            stmt.setString(5, repairOrder.dateRecd);
//            stmt.setString(6, repairOrder.dateShipped);
//            stmt.setString(7, repairOrder.shipOutType);
            stmt.setInt(1, repairOrder.getRID());
            stmt.setString(2, repairOrder.getDateRecd());
            stmt.setString(3, repairOrder.getDateShipped());
            stmt.setString(4, repairOrder.getShipOutType());
            stmt.setInt(5, repairOrder.getShipOut_CID());
            stmt.setInt(6, repairOrder.getEID());
            stmt.setInt(7, repairOrder.getShipIn_CID());
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
}