/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import core.Customer;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yani.muskwe
 */
public class CustomerTableModel extends AbstractTableModel{
    private static final int ID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int ADDRESS_COL = 2;
    private static final int CITY_COL = 3;
    private static final int STATE_COL = 4;
    private static final int ZIP_COL = 5;
    private static final int CONTACT_COL = 6;
    private String[] columnNames = {"ID", "Name", "Address", "City", "State", "Zipcode", "Contact"};
    private List<Customer> customers;
    
    public CustomerTableModel(List<Customer> c) {
    	customers = c;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return customers.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Customer tempCustomer = customers.get(row);
        switch (col) {
            case ID_COL:
                return tempCustomer.getID();
            case NAME_COL:
                return tempCustomer.getName();
            case ADDRESS_COL:
                return tempCustomer.getAddress();
            case CITY_COL:
                return tempCustomer.getCity();
            case STATE_COL:
                return tempCustomer.getState();
            case ZIP_COL:
                return tempCustomer.getZip();
            case CONTACT_COL:
                return tempCustomer.getContact();
            default:
                return tempCustomer.getID();
        }
    }
    
    public void setValueAt(Object val, int row, int col) {
        Customer tempCustomer = customers.get(row);
        switch (col) {
            case ID_COL:
                tempCustomer.setID((int) val);
            case NAME_COL:
                tempCustomer.setName((String) val);
            case ADDRESS_COL:
                tempCustomer.setAddress((String) val);
            case CITY_COL:
                tempCustomer.setCity((String) val);
            case STATE_COL:
                tempCustomer.setState((String) val);
            case ZIP_COL:
                tempCustomer.setZip((String) val);
            case CONTACT_COL:
                tempCustomer.setContact((String) val);
        }
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}