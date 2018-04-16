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
 * @author Buddy Smith
 */
public class CarrierTableModel extends AbstractTableModel{
    private static final int CID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int SHIP_RED = 2;
    private static final int SHIP_BLUE = 3;
    private static final int SHIP_GROUND = 4;
    private static final int WALK_IN = 5;
    private final String[] columnNames = 
        {"CID", "Name", "Ship_Red","Ship_Blue","Ship_ground","Walk_in"};
    private List<Carrier> carriers;
    
    public CarrierTableModel(List<Carrier> c) {
    	carriers = c;
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return carriers.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
 
    @Override
    public Object getValueAt(int row, int col) {
        Carrier tempCarrier = carriers.get(row);
        switch (col) {
            case CID_COL:
                return tempCarrier.getCID();
            case NAME_COL:
                return tempCarrier.getName();
            case SHIP_RED:
                return tempCarrier.getShipType1();
            case SHIP_BLUE:
                return tempCarrier.getShipType2();
            case SHIP_GROUND:
                return tempCarrier.getShipType3();
            case WALK_IN:
                return tempCarrier.getShipType4();
            default:
                return tempCarrier.getName();
        }
    }
    
    
    @Override
    public void setValueAt(Object val, int row, int col) {
        Carrier tempCarrier = carriers.get(row);
        switch (col) {
            case NAME_COL:
                tempCarrier.setName((String) val);
            case SHIP_RED:
                tempCarrier.setShipType1((String) val);
            case SHIP_BLUE:
                tempCarrier.setShipType2((String) val);
            case SHIP_GROUND:
                tempCarrier.setShipType3((String) val);
            case WALK_IN:
                tempCarrier.setShipType4((String) val);
            case CID_COL:
                tempCarrier.setCID((int) val);
                
        }
    }
    
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}