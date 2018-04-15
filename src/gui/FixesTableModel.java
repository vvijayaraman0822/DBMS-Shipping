/*
 * Table model for Fixes
 */
package gui;
import java.util.List;
import core.Fixes;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jay
 */
public class FixesTableModel extends AbstractTableModel{
    private static final int EID_COL = 0;
    private static final int RID_COL = 1;
    private String[] columnNames = {"EID", "RID"};
    private List<Fixes> fix;
    
    public FixesTableModel(List<Fixes> f) {
    	fix = f;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return fix.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Object getValueAt(int row, int col) {
        Fixes tempFixes = fix.get(row);
        switch (col) {
            case EID_COL:
                return tempFixes.getEID();
            case RID_COL:
                return tempFixes.getRID();
            default:
                return tempFixes.getRID();
        }
    }
    
    public void setValueAt(int row, int col) {
        Fixes tempFixes = fix.get(row);
        switch (col) {
            case EID_COL:
                tempFixes.setEID(col);
            case RID_COL:
                tempFixes.setRID(col);
        }
    }
    
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
