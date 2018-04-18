package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import core.Orders;

/**
 *
 * @author Holden.Hall
 */
public class OrdersDAO {
    private DBConnection conn;

    public OrdersDAO(DBConnection conn){
        this.conn = conn;
    }

    public List<Orders> getAllOrders() throws Exception {
        List<Orders> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from orders");
            while (rs.next()) {
                Orders con = convertRowToOrders(rs);
                list.add(con);
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
    }

    private Orders convertRowToOrders(ResultSet rs) throws Exception {
        int OID = rs.getInt("OID");
        String PID = rs.getString("PID");
        int EID = rs.getInt("EID");
        int quantity= rs.getInt("quantity");
        String dateRecd =rs.getString("dateRecd");

        return new Orders(OID,PID,EID,quantity,dateRecd);
    }

    public void addOrders(Orders orders) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into orders values (null, ?,?,?,?,?)");
            stmt.setInt(1, orders.getOID());
            stmt.setString(2, orders.getPID());
            stmt.setInt(3, orders.getEID());
            stmt.setInt(4, orders.getQuantity());
            stmt.setString(5, orders.getDateRecd());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }

    public void deleteOrders(Orders orders) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from customer where OID = ?");
            stmt.setInt(1, orders.getOID());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }

    public void updateOrders(Orders orders) throws Exception {
        PreparedStatement stmt = null;
        String sql = "update orders "
                + "set where OID = ?, "
                + "PID = ?, "
                + "EID = ?, "
                + "quantity = ?, "
                + "dateRecd = ?, ";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orders.getOID());
            stmt.setString(2, orders.getPID());
            stmt.setInt(3, orders.getEID());
            stmt.setInt(4, orders.getQuantity());
            stmt.setString(5, orders.getDateRecd());
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
}
