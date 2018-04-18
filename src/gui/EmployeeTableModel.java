/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import core.Employee;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Jesse
 */
public class EmployeeTableModel extends AbstractTableModel{
    private static final int EID_COL = 0;
    private static final int FIRST_NAME_COL = 1;
    private static final int LAST_NAME_COL = 2;
    private String[] columnNames = {"EID", "first_name", "last_name"};
    private List<Employee> employees;
    
    public EmployeeTableModel(List<Employee> emps) {
        employees = emps;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount() {
        return employees.size();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Employee tempEmployee = employees.get(row);
        switch (col) {
            case EID_COL:
                return tempEmployee.getEID();
            case FIRST_NAME_COL:
                return tempEmployee.getFirstName();
            case LAST_NAME_COL:
                return tempEmployee.getLastName();
            default:
                return tempEmployee.getEID();
        }
    }
    
    public void setValueAt(Object val, int row, int col) {
        Employee tempEmployee = employees.get(row);
        switch (col) {
            case EID_COL:
                tempEmployee.setEID((int) val);
            case FIRST_NAME_COL:
                tempEmployee.setFirstName((String) val);
            case LAST_NAME_COL:
                tempEmployee.setLastName((String) val);
        }
    }
    
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}
