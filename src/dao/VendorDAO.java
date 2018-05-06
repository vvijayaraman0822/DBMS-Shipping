/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import core.Vendor;

/**
 *
 * @author Vasudev Vijayaraman
 */
public class VendorDAO {
     private DBConnection conn;

    public VendorDAO(DBConnection conn) {
        this.conn = conn;
    }

    public List<Vendor> getAllVendors() throws Exception {
        List<Vendor> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from vendor");
            while (rs.next()) {
                Vendor vend = convertRowToVendor(rs);
                list.add(vend);
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
    }
    
    public void updateVendor(Vendor vend)throws Exception{
       PreparedStatement stmt = null;
       String sql = "update vendor "
                  + "SET name = ?, "
                  + "contact = ?, "
                  + "address = ?, "
                  + "city = ?, "
                  + "state = ?, "
                  + "zip = ? "
                  + "where VID = ?";
       try{
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, vend.getName());
           stmt.setString(2,vend.getContact());
           stmt.setString(3, vend.getAddress());
           stmt.setString(4, vend.getCity());
           stmt.setString(5, vend.getState());
           stmt.setString(6, vend.getZip());
           stmt.setString(7, vend.getVID());
           stmt.execute();
       }
       finally{
           conn.close(stmt, null);
       }
        
    }
    
    public void addVendor(Vendor vend)throws Exception{
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareStatement("insert into vendor values(?,?,?,?,?,?,?)");
            stmt.setString(1, vend.getVID());
            stmt.setString(2, vend.getName());
            stmt.setString(3,vend.getContact());
            stmt.setString(4, vend.getAddress());
            stmt.setString(5, vend.getCity());
            stmt.setString(6, vend.getState());
            stmt.setString(7, vend.getZip());
            stmt.execute();
        }
        finally{
            conn.close(stmt, null);   
        }
    }    
        public void deleteVendor(Vendor vend)throws Exception{
        String sql ="delete from vendor where VID = ?";
        PreparedStatement stmt = null;
        String id = vend.getVID();
        try{
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,id );
            stmt.executeUpdate();
        }
        finally{
            conn.close(stmt, null);  
        } 
    }
    
    
    private Vendor convertRowToVendor(ResultSet rs) throws Exception {
        String VID = rs.getString("VID");
        String name = rs.getString("name");
        String contact = rs.getString("contact");
        String address = rs.getString("address");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String zip = rs.getString("zip");
        return new Vendor(VID, name, contact, address, city, state, zip);
    }
    
    //added by Cory Press for partFrame    
    public List getAllVID() throws Exception {
        Statement stmt = null;
        ResultSet rs = null;
        List VIDs = new ArrayList<>();
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select VID from vendor");
        while (rs.next()) {
            VIDs.add(rs.getString("VID"));
        }
        conn.close(stmt, rs);
        return VIDs;
    }
}
