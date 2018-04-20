/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.List;
import core.Part;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author downw
 */
public class PartsTableModel extends AbstractTableModel
{
    private static final int PID_COL = 0;
    private static final int NAME_COL = 1;
    private static final int DESCRIPTION_COL = 2;
    private static final int VID_COL = 3;
    private String[] columnNames = {"PID", "Name", "Description", "VID"};
    private List<Part> part;
    
    public PartsTableModel(List<Part> parts) 
    {
        part = parts;
    }
    
    public int getColumnCount() 
    {
        return columnNames.length;
    }
    
    public int getRowCount() 
    {
        return part.size();
    }
    
    public String getColumnName(int col) 
    {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) 
    {
        Part tempPart = part.get(row);
        switch (col) {
            case PID_COL:
                return tempPart.getPID();
            case NAME_COL:
                return tempPart.getname();
            case DESCRIPTION_COL:
                return tempPart.getdescription();
            default:
                return tempPart.getVID();
        }
    }
    
    public Class getColumnClass(int col) 
    {
        return getValueAt(0, col).getClass();
    }
}
