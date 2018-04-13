/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
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
                Customer cust = convertRowToCustomer(rs);
                list.add(cust);
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
        int zip = rs.getInt("zip");
        String contact = rs.getString("contact");
        return new Customer(ID,name,address,city,state,zip,contact);
    }
    
    public void addCustomer(Customer customer) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into customer values (null, ?, ?, ?, ?, ?, ?,?)");
            stmt.setInt(1, customer.getID());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getCity());
            stmt.setString(5, customer.getState());
            stmt.setInt(6, customer.getZip());
            stmt.setString(7, customer.getContact());
            stmt.execute();
            } finally {
            conn.close(stmt, null);
            }
    }
    
    public void deleteCustomer(Customer customer) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from customer where ID = ?");
            stmt.setInt(1, customer.getID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    public void updateCustomer(Customer customer) throws Exception {
        PreparedStatement stmt = null;
        String sql = "update customer "
                + "set where ID = ?, "
                + "name = ?, "
                + "address = ?, "
                + "city = ?, "
                + "state = ?, "
                + "zip = ? "
                + "contact = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customer.getID());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getCity());
            stmt.setString(5, customer.getState());
            stmt.setInt(6, customer.getZip());
            stmt.setString(7, customer.getContact());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
}
