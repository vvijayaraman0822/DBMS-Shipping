/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import core.Contains;
import javax.swing.JOptionPane;

/**
 *
 * @author Mack
 */
public class ContainsDAO {
    private DBConnection conn;
    
    public ContainsDAO(DBConnection conn){
        this.conn = conn;
    }
    
    public List<Contains> getAllContains() throws Exception {
        List<Contains> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from contains");
            while (rs.next()) {
                Contains con = convertRowToContains(rs);
                list.add(con);  
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
    }
    
    private Contains convertRowToContains(ResultSet rs) throws Exception {
        int RID = rs.getInt("RID");
        String serialNUM = rs.getString("serialNUM");
        return new Contains(RID, serialNUM);
    }
    
    public void addContains(Contains contains) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into contains values (null, ?)");
            stmt.setInt(1, contains.getRID());
            stmt.setString(2, contains.getSerialNum());
            stmt.execute();
            } finally {
            conn.close(stmt, null);
            }
    }
    
    public void deleteContains(Contains contains) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from customer where RID = ?");
            stmt.setInt(1, contains.getRID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    public void updateContains(Contains contains) throws Exception {
        PreparedStatement stmt = null;
        String sql = "update contains "
                + "set where RID = ?, "
                + "serialNUM = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,contains.getRID());
            stmt.setString(2, contains.getSerialNum());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    // By Jesse Houk
    // Returns the Contains tuples associated with a particular RID in a result 
    // set
    public ResultSet getContains(Integer RID) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("select * from" +
                " contains natural join equipment where RID = ?");
            stmt.setInt(1, RID);
            rs = stmt.executeQuery();
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving Part Names: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
}