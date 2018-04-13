package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import core.Fixes;
/**
 *
 * @author Clorissa
 */
public class FixesDAO {
    private DBConnection conn;
    
    public FixesDAO(DBConnection conn) {
        this.conn = conn;
    }


    public List<Fixes> getAllFixes() throws Exception {
        List<Fixes> list = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from fixes");
            while (rs.next()) {
                Fixes fix = convertRowToFixes(rs);
                list.add(fix);
            }
            return list;
        } finally {
            conn.close(stmt, rs);
        }
    }
    
    private Fixes convertRowToFixes(ResultSet rs) throws Exception {
        int EID = rs.getInt("EID");
        int RID = rs.getInt ("RID");
        return new Fixes(EID,RID);
    }
    
    public void addFixes(Fixes fix) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("insert into customer values (?,?)");
            stmt.setInt(1, fix.EID);
            stmt.setInt(2, fix.RID);
            stmt.execute();
            } finally {
            conn.close(stmt, null);
            }
    }
    
    public void deleteFixes(Fixes fix ) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("delete from fixes where EID = ?");
            stmt.setInt(1, fix.EID);
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
    
    public void updateFixesCustomer customer) throws Exception {
        PreparedStatement stmt = null;
        String sql = "update fixes "
                + "set where ID = ?, "
                + "name = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, fix.EID);
            stmt.setInt(2, fix.RID);
            stmt.execute();
        } finally {
            conn.close(stmt, null);
        }
    }
}