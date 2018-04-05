/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.List;
import core.Carrier;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Travis Rowe
 */
public class CarrierTableModel extends AbstractTableModel{
    private static final int CID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int SHIP_COL = 2;
    private String[] columnNames = {"CID", "Name", "Ship"};
    private List<Carrier> carriers;
    
    public CarrierTableModel(List<Carrier> c) {
    	carriers = c;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return carriers.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Carrier tempCarrier = carriers.get(row);
        switch (col) {
            case CID_COL:
                return tempCarrier.getCID();
            case NAME_COL:
                return tempCarrier.getName();
            case SHIP_COL:
                return tempCarrier.getShipType();
            default:
                return tempCarrier.getName();
        }
    }
    
    public void setValueAt(Object val, int row, int col) {
        Carrier tempCarrier = carriers.get(row);
        switch (col) {
            case NAME_COL:
                tempCarrier.setName((String) val);
            case SHIP_COL:
                tempCarrier.setShipType((String) val);
            case CID_COL:
                tempCarrier.setCID(col);
        }
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}