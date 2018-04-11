/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import core.Part;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
//import core.Carrier;

/**
 *
 * @author drew
 */
public class PartDAO {
    private DBConnection conn;
    
    public PartDAO(DBConnection conn){
        this.conn = conn;
    }
    
    public List<Part> getAllPart() throws Exception{
        List<Part> list = new ArrayList();
        Statement statement = null;
        ResultSet resultSet = null;
          
        try{
            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from part");
              while(resultSet.next()){
                Part part = convertRowToPart(resultSet);
                list.add(part);
            }
            return list;
        }
        finally{
            conn.close(statement, resultSet);
        }
    }
    
    public void updatePart(Part part)throws Exception{
       PreparedStatement stmt = null;
       String sql = "update part"
                  + "set PID = ?,"
                  + "set name = ?,"
                  + "set description = ?,"
                  + "set VID = ?";
       try{
           stmt = conn.prepareStatement(sql);
           stmt.setInt(1, part.getPID());
           stmt.setString(2, part.getname());
           stmt.setString(3,part.getdescription());
           stmt.setInt(4, part.getVID());
           stmt.execute();
       }
       finally{
           conn.close(stmt, null);
       }
        
    }
    
    public void addPart(Part part)throws Exception{
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareStatement("insert into part values(?,?,?,?)");
            stmt.setInt(1, part.getPID());
            stmt.setString(2, part.getname());
            stmt.setString(3, part.getdescription());
            stmt.setInt(4, part.getVID());
            stmt.execute();
        }
        finally{
            conn.close(stmt, null);   
        }
    }
    
  
    private Part convertRowToPart(ResultSet rs) throws Exception{
        int pid = rs.getInt("PID");
        String name = rs.getString("name");
        String desc = rs.getString("description");
        int vid = rs.getInt("VID");
        return new Part (pid, name, desc, vid);
    }
}
