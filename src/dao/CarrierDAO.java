/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import core.Carrier;
import java.sql.PreparedStatement;

/**
 *
 * @author ramona.wuthrich
 */
public class CarrierDAO {
     private DBConnection conn;

    public CarrierDAO(DBConnection conn) {
        this.conn = conn;
    }

    public List<Carrier> getAllCarriers() throws Exception {
        List<Carrier> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from carrier");
            while (rs.next()) {
                Carrier fund = convertRowToCarrier(rs);
                list.add(fund);
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
    }
    

    public void addCarrier(Carrier carrier) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into carrier values (?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, carrier.getCID());
            stmt.setString(2, carrier.getName());
            stmt.setString(3, carrier.getShipType1());
            stmt.setString(4, carrier.getShipType2());
            stmt.setString(5, carrier.getShipType3());
            stmt.setString(6, carrier.getShipType4());
        } finally {
            conn.close(stmt, null);
        }
    }

    public void deleteCarrier(Carrier carrier) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from carrier where ID = ?");
            stmt.setInt(1, carrier.getCID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }

    public void updateCarrier(Carrier carrier) throws Exception {
        PreparedStatement stmt = null;
        String sql = "update carrier "
                + "set CID ?, "
                + "name = ?, "
                + "ship_red = ?, "
                + "ship_blue = ?, "
                + "ship_ground = ?, "
                + "walk_in = ? ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carrier.getCID());
            stmt.setString(2, carrier.getName());
            stmt.setString(3, carrier.getShipType1());
            stmt.setString(4, carrier.getShipType2());
            stmt.setString(5, carrier.getShipType3());
            stmt.setString(6, carrier.getShipType4());
            
        } finally {
            conn.close(stmt, null);
        }
    }
    
    private Carrier convertRowToCarrier(ResultSet rs) throws Exception {
        String name = rs.getString("name");
        String avail_ship_type = rs.getString("avail_ship_type");
        int CID = rs.getInt("CID");
        return new Carrier();
    }
}
