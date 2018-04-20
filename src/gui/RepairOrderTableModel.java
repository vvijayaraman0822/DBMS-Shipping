/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.util.*;
import core.RepairOrder;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Bob
 */
public class RepairOrderTableModel extends AbstractTableModel{
    private static final int RID_COL = 0;
    private static final int dateRecd_COL = 2;
    private static final int dateShipped_COL = 3;
    private static final int shipOutType_COL = 4;
    private static final int shipOut_CID_COL = 5;
    private static final int shipIn_CID_COL = 7;
    private static final int EID_COL = 6;  
    private String[] columnNames = {"RID", "dateRecd", "dateShipped",
        "shipOutType", "shipOut_CID", "EID", "shipIn_CID"};
    private List<RepairOrder> repairOrder;
    
    public RepairOrderTableModel(List<RepairOrder> rpo){
        repairOrder = rpo;
    }
    
    public int getColumnCount(){
        return columnNames.length;
    }
    
    public int getRowCount() {
        return repairOrder.size();
    }
    
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col){
        RepairOrder tempOrder = repairOrder.get(row);
        switch (col) {
            case RID_COL:
                return tempOrder.getRID();
            case dateRecd_COL:
                return tempOrder.getDateRecd();
            case dateShipped_COL:
                return tempOrder.getDateShipped();
            case shipOutType_COL:
                return tempOrder.getShipOutType();
            case shipOut_CID_COL:
                return tempOrder.getShipOut_CID();
            case EID_COL:
                return tempOrder.getEID();
            case shipIn_CID_COL:
                return tempOrder.getShipIn_CID();
            default:
                return tempOrder.getRID();
        }
    }
    
    public void setValueAt(Object val, int row, int col) {
        RepairOrder tempOrder = repairOrder.get(row);
        switch (col) {
            case RID_COL:
                tempOrder.setRID((int) val);
            case dateRecd_COL:
                tempOrder.setDateRecd((String) val);
            case dateShipped_COL:
                tempOrder.setDateShipped((String) val);
            case shipOutType_COL:
                tempOrder.setShipOutType((String) val);
            case shipOut_CID_COL:
                tempOrder.setShipOut_CID((int) val);
            case EID_COL:
                tempOrder.setEID((int) val);
            case shipIn_CID_COL:
                tempOrder.setShipIn_CID((int) val);
            default:
                tempOrder.setRID((int) val);
        }
    }
    
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}
