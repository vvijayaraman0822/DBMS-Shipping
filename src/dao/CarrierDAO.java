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
    
    private Carrier convertRowToCarrier(ResultSet rs) throws Exception {
        String name = rs.getString("name");
        String avail_ship_type = rs.getString("avail_ship_type");
        int CID = rs.getInt("CID");
        return new Carrier(CID, name, avail_ship_type);
    }
}
