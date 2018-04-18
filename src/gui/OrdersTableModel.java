/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import core.Orders;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Vasudev Vijayaraman
 */
public class OrdersTableModel extends AbstractTableModel{
    private static final int OID_COL = 0;
    private static final int PID_COL = 1;
    private static final int EID_COL = 2;
    private static final int QUANTITY_COL = 3;
    private static final int DATERECD_COL = 4;
    private String[] columnNames = {"OID", "PID", "EID", "quantity", "dateRecd"};
    private List<Orders> orders;
    
    public OrdersTableModel(List<Orders> ords) {
        orders = ords;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount() {
        return orders.size();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Orders tempOrders = orders.get(row);
        switch (col) {
            case OID_COL:
                return tempOrders.getOID();
            case PID_COL:
                return tempOrders.getPID();
            case EID_COL:
                return tempOrders.getEID();
            case QUANTITY_COL:
                return tempOrders.getQuantity();
            case DATERECD_COL:
                return tempOrders.getDateRecd();
            default:
                return tempOrders.getOID();
        }
    }
    
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}
