/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import core.Contains;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Clorissa
 */
public class ContainsTableModel extends AbstractTableModel{
    private static final int RID_COL = 0;
    private static final int SERIALNUM_COL = 1;
    private String[] columnNames = {"RID", "Serial_Number"};
    private List<Contains> contains;
    
    public ContainsTableModel(List<Contains> cons) {
        contains = cons;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount() {
        return contains.size();
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Contains tempCon = contains.get(row);
        switch (col) {
            case RID_COL:
                return tempCon.getRID();
            case SERIALNUM_COL:
                return tempCon.getSerialNum();
           
            default:
                return tempCon.getRID();
        }
    }
    
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}