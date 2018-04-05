/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ramona.wuthrich
 */
package dao;

import java.sql.*;

public class DBConnection {
    private Connection conn;
    private String username;
    private String password;
    private String dbURL;

    public DBConnection() {
        username = "echo";
        password = "steakfingers";
        dbURL = "jdbc:mysql://" + "174.138.42.206" + "/" + "echo";
    }
    
    public DBConnection(String user, String pass, String address, String Database) {
        username = user;
        password = pass;
        dbURL = "jdbc:mysql://" + address + "/" + Database;
    }

    public void Open() throws Exception {
        conn = DriverManager.getConnection(dbURL, username, password);
        System.out.println("Opened DB Connection");
    }

    public void Close() throws Exception {
        if (conn != null) {
            conn.close();
            System.out.println("Closed DB Connection");
        }
    }

    public Connection getConnection() {
        return conn;
    }

    Statement createStatement() throws Exception {
        return conn.createStatement();
    }

    PreparedStatement prepareStatement(String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    void close(Statement stmt, ResultSet rs) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
    }
}
