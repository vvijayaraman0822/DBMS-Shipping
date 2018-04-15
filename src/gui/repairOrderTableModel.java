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
public class repairOrderTableModel extends AbstractTableModel{
    private static final int RID_COL = 0;
    private static final int dateRecd_COL = 7;
    private static final int dateShipped_COL = 6;
    private static final int shipType_COL = 5;
    private static final int CID_COL = 2;
    private static final int shipOut_CID_COL = 4;
    private static final int shipIn_CID_COL = 3;
    private static final int EID_COL = 1;  
    private String[] columnNames = {"RID", "EID", "CID", "ShipIn CID",
        "ShipOut CID", "shipType", "dateShipped", "dateRecd"};
    private List<RepairOrder> repairOrder;
    
    public repairOrderTableModel(List<RepairOrder> rpo){
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
            case EID_COL:
                return tempOrder.getEID();
            case CID_COL:
                return tempOrder.getCID();
            case shipType_COL:
                return tempOrder.getShipType();
            case shipIn_CID_COL:
                return tempOrder.getShipIn_CID();
            case shipOut_CID_COL:
                return tempOrder.getShipOut_CID();
            case dateShipped_COL:
                return tempOrder.getDateShipped();
            case dateRecd_COL:
                return tempOrder.getDateRecd();
            default:
                return tempOrder.getEID() + " " + tempOrder.getRID();
        }
    }
    
    public void setValueAt(Object val, int row, int col) {
        RepairOrder tempOrder = repairOrder.get(row);
        switch (col) {
            case EID_COL:
                tempOrder.setEID((int) val);
            case dateRecd_COL:
                tempOrder.setDateRecd((String) val);
            case CID_COL:
                tempOrder.setCID((int) val);
            case RID_COL:
                tempOrder.setRID((int) val);
            case dateShipped_COL:
                tempOrder.setDateShipped((String) val);
            case shipIn_CID_COL:
                tempOrder.setShipIn_CID((int) val);
            case shipOut_CID_COL:
                tempOrder.setShipOut_CID((int) val);
            case shipType_COL:
                tempOrder.setShipType((String) val);
        }
    }
    
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}