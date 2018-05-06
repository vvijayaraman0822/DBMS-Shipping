/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 * *
 *@author Keona.Rollerson
 */
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import core.Equipment;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class EquipmentDAO {
    private DBConnection conn;
    
    public EquipmentDAO(DBConnection conn) {
        this.conn = conn;
    }
    
    public List<Equipment> getallEquipment() throws Exception {
    List<Equipment> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from equipment");
            while (rs.next()) {
                Equipment fund = convertRowToEquipment(rs);
                list.add(fund);
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
        
    }
    
    private Equipment convertRowToEquipment(ResultSet rs) throws Exception {
        String serialNum = rs.getString("serialNum");
        String ID = rs.getString("ID");
        String _name = rs.getString("name");
        return new Equipment(serialNum,ID,_name);
    }
    
    public void addEquipment(Equipment equip) throws Exception{
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into equipment values(?, ?, ?)");
            stmt.setString(1, equip.getSerialNum());
            stmt.setString(3, equip.getID());
            stmt.setString(2, equip.getName());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
     
    public void deleteEquipment(Equipment equip) throws Exception{
        
        String remove = "delete from equipment where serialNum = ?";
        PreparedStatement stmt = null;
        String serNum = equip.getSerialNum();
        try {
            stmt=conn.prepareStatement(remove);
            stmt.setString(1,serNum );
            stmt.executeUpdate();
        }
        finally {
            conn.close(stmt, null);
        }
    }
    
    public void updateEquipment(Equipment equip) throws Exception{
        PreparedStatement stmt = null;
        String update = "update equipment " 
                + "SET name = ?, "
                + "ID = ? "
                + "where serialNum = ?";
        try {
            stmt = conn.prepareStatement(update);
            stmt.setString(3, equip.getSerialNum());
            stmt.setString(2, equip.getID());
            stmt.setString(1, equip.getName());
            stmt.execute();
        }
        finally {
            conn.close(stmt, null);
        }
    }
    // By Jesse Houk
    // Returns a list of all Serial Numbers of the Customers' Equipment
    public List comboValues() {
        List eqList = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from equipment");
            while (rs.next()) {
                eqList.add(rs.getString("serialNum"));
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving Equipment Serial Numbers: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return eqList;
    }
}
