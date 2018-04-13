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
            results = statement.executeQuery("select * from employees");
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
    
    public void addEmployee(int eID, String ln, String fn) throws Exception {
        PreparedStatement statement = null;

        try {
            statement = conn.prepareStatement("insert into employee values (?, ?, ?)");
            statement.setInt(1, eID);
            statement.setString(2, ln);
            statement.setString(3, fn);
            statement.executeUpdate();
        } finally {
            conn.close(statement, null);
        }
    }
    
    public void updateEmployee(Employee employee)throws Exception{
       PreparedStatement statement = null;
       String comand = "update employee"
                  + "set EID = ?,"
                  + "set last_name = ?,"
                  + "set first_name = ?,";
       try{
           statement = conn.prepareStatement(comand);
           statement.setInt(1, employee.getEID());
           statement.setString(2, employee.getLastName());
           statement.setString(3, employee.getFirstName());
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
