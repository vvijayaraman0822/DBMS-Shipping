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
            stmt.setInt(1, repairOrder.getShipOut_CID());
            stmt.setInt(2, repairOrder.getShipIn_CID());
            stmt.setInt(3, repairOrder.getEID());
            stmt.setInt(4, repairOrder.getRID());
            stmt.setString(5, repairOrder.getDateRecd());
            stmt.setString(6, repairOrder.getDateShipped());
            stmt.setString(7, repairOrder.getShipType());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    public void deleteRepairOrder(RepairOrder repairOrder) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from repair order where RID = ?");
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
            stmt.setInt(1, repairOrder.getShipOut_CID());
            stmt.setInt(2, repairOrder.getShipIn_CID());
            stmt.setInt(3, repairOrder.getEID());
            stmt.setInt(4, repairOrder.getRID());
            stmt.setString(5, repairOrder.getDateRecd());
            stmt.setString(6, repairOrder.getDateShipped());
            stmt.setString(7, repairOrder.getShipType());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    private RepairOrder convertRowToRepairOrder(ResultSet rs) throws Exception {
        String dateRecd = rs.getString("dateRecd");
        String dateShipped = rs.getString("dateShipped");
        String shipType = rs.getString("shipType");
        int shipOut_CID = rs.getInt("shipOut_CID");
        int EID = rs.getInt("EID");
        int shipIn_CID = rs.getInt("shipIn_CID");
        int RID = rs.getInt("RID");
        return new RepairOrder();
    }
}