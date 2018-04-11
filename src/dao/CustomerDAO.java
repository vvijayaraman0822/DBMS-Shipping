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
import core.Customer;
/**
 *
 * @author Domonkos
 */
public class CustomerDAO {
     private DBConnection conn;

    public CustomerDAO(DBConnection conn) {
        this.conn = conn;
    }

    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from customer");
            while (rs.next()) {
                Customer fund = convertRowToCustomer(rs);
                list.add(fund);
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
    }
    
    private Customer convertRowToCustomer(ResultSet rs) throws Exception {
        int ID = rs.getInt("ID");
        String name = rs.getString("name");
        String address = rs.getString("address");
        String city = rs.getString("city");
        String state = rs.getString("state");
        String zip = rs.getString("zip");
        String contact = rs.getString("contact");
        return new Customer();
    }
}
