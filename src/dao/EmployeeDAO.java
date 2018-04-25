/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import core.Employee;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author Cory Press
 */
public class EmployeeDAO {
    private DBConnection conn;
    
    public EmployeeDAO(DBConnection conn) {
        this.conn = conn;
    }
    
    public List<Employee> getAllEmployees() throws Exception{
        List<Employee> employees = new ArrayList();
        
        Statement statement = null;
        ResultSet results = null;
        
        try{
            statement = conn.createStatement();
            // Change actually commited by Luong
            results = statement.executeQuery("select * from employee");
              while(results.next()){
                Employee employee = convertToEmployee(results);
                employees.add(employee);
            }
            return employees;
        }
        finally{
            conn.close(statement, results);
        } 
    }
    
    public void addEmployee(Employee employee) throws Exception {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement("insert into employee values (?, ?, ?)");
            statement.setInt(1, employee.getEID());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.executeUpdate();
        } finally {
            conn.close(statement, null);
        }
    }
    
    public void updateEmployee(Employee employee)throws Exception{
       PreparedStatement statement = null;
       String comand = "update employee "                  
                  + "set first_name = ?,"
                  + "last_name = ?"
                  + "where EID = ?";

       try{
           statement = conn.prepareStatement(comand);

           statement.setString(1, employee.getFirstName());
           statement.setString(2, employee.getLastName());
           statement.setInt(3, employee.getEID());
           statement.execute();
       }
       finally{
           conn.close(statement, null);
       }
        
    }
    
    public void deleteEmployee(Employee employee) throws Exception{
        PreparedStatement statement = null;
        try{
            statement = conn.prepareStatement("delete from employee where EID = ?");
            statement.setInt(1,employee.getEID());
            statement.execute();
        }
        finally{
            conn.close(statement, null);
        }
    }
    
    private Employee convertToEmployee(ResultSet results) throws Exception{
        int employeeID = results.getInt("EID");
        String lname = results.getString("last_name");
        String fname = results.getString("first_name");
        
        return new Employee (employeeID, lname, fname);
    }
    
    
}
