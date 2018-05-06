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
/**
 * 
 * @author downw edits by Micahel Lewis on 4/18 
 */

public class PartDAO {
    private DBConnection conn;
    
    public PartDAO(DBConnection conn){
        this.conn = conn;
    }
    
    public List<Part> getAllPart() throws Exception{
        List<Part> list = new ArrayList<>();
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
//edit by Michael Lewis to fix PID to String From int
    public void deletePart(Part part)throws Exception{
        String sql ="delete from part where PID = ?";
        PreparedStatement stmt = null;
        String id = part.getPID();
        try{
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,id );
            stmt.executeUpdate();
        }
        finally{
            conn.close(stmt, null);  
        } 
        
    }
  //edit by Michael Lewis to fix PID and VID to strings instead of ints as they
  //are varchars in database, cascading issue from part.java
    public void updatePart(Part part)throws Exception{
       PreparedStatement stmt = null;
       String sql = "update part "
                  + "set name = ?, "
                  + "description = ?, "
                  + "VID = ? "
                  + "where PID = ?";
       try{
           stmt = conn.prepareStatement(sql);
           stmt.setString(1, part.getname());
           stmt.setString(2, part.getdescription());
           stmt.setString(3, part.getVID());
           stmt.setString(4, part.getPID());
           stmt.execute();
       }
       finally{
           conn.close(stmt, null);
       }
        
    }
  //edit by Michael Lewis to fix PID and VID to strings instead of ints as they
  //are varchars in database, cascading issue from part.java   
    public void addPart(Part part)throws Exception{
        PreparedStatement stmt = null;
        try{
            stmt = conn.prepareStatement("insert into part values(?,?,?,?)");
            stmt.setString(1, part.getPID());
            stmt.setString(2, part.getname());
            stmt.setString(3, part.getdescription());
            stmt.setString(4, part.getVID());
            stmt.execute();
        }
        finally{
            conn.close(stmt, null);   
        }
    }
    
  //edit by Michael Lewis to fix PID and VID to strings instead of ints as they
  //are varchars in database, cascading issue from part.java
    private Part convertRowToPart(ResultSet rs) throws Exception{
        String pid = rs.getString("PID");
        String name = rs.getString("name");
        String desc = rs.getString("description");
        String vid = rs.getString("VID");
        return new Part (pid, name, desc, vid);
    }
        public List comboValues () throws Exception{
            List list = new ArrayList<>();
            String pid;
            Statement statement;
            ResultSet resultSet;
            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from part");
              while(resultSet.next()){
                pid = resultSet.getString("PID");
                list.add(pid);
              }
        return list;
    }
       
    
}
