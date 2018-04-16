/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import core.Vendor;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Cory Press
 */
public class VendorTableModel {
    private static final int VID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int CONTACT_COL = 2;
    private static final int ADDRESS_COL = 3;
    private static final int CITY_COL = 4;
    private static final int STATE_COL = 5;
    private static final int ZIP_COL = 6;
    
    private String[] columnNames = {"VID", "Name", "Contact", "Address", "City", "State", "ZIP"};
    private List<Vendor> vend;
    
    public VendorTableModel(List<Vendor> vends){
        vend = vends;
    }
    
    public int getColumnCount(){
        return columnNames.length;
    }
    
    public int getRowCount(){
        return vend.size();
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col){
        Vendor temp = vend.get(row);
        switch(col){
            case VID_COL:
                return temp.getVID();
            case NAME_COL:
                return temp.getName();
            case CONTACT_COL:
                return temp.getContact();
            case ADDRESS_COL:
                return temp.getAddress();
            case CITY_COL:
                return temp.getCity();
            case STATE_COL:
                return temp.getState();
            default:
                return temp.getZip();  
        }
    }
    
    public void setValueAt(Object val, int row, int col){
        Vendor temp = vend.get(row);
        switch(col){
            case VID_COL:
                temp.setVID((String) val);
            case NAME_COL:
                temp.setName((String) val);
            case CONTACT_COL:
                temp.setContact((String) val);
            case ADDRESS_COL:
                temp.setAddress((String) val);
            case CITY_COL:
                temp.setCity((String) val);
            case STATE_COL:
                temp.setState((String) val);
            default:
                temp.setZip((String) val);  
        }
    }
    
    public Class getColumnClass(int col){
        return getValueAt(0, col).getClass();
    }
    
}
