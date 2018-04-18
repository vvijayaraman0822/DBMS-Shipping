/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.List;
import core.Equipment;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Keona Rollerson
 */
public class EquipmentTableModel extends AbstractTableModel{
   private static final int SERIALNUM_COL = 0;
   private static final int ID_COL = 1;
   private static final int NAME_COL = 2;
   private String[] columnNames = {"SerialNum","ID","Name"};
   private List<Equipment> equipment;
   
   public EquipmentTableModel(List<Equipment> equip)
    {
        equipment = equip;
    }
    
   public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return equipment.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }
    
     public Object getValueAt(int row, int col) {
        Equipment tempEquipment = equipment.get(row);
        switch (col) {
            case SERIALNUM_COL:
                return tempEquipment.getSerialNum();
            case ID_COL:
                return tempEquipment.getID();
            case NAME_COL:
                return tempEquipment.getName();
            default:
                return tempEquipment.getSerialNum();
        }
    }
    
     public void setValueAt(Object val, int row, int col) {
            Equipment tempEquipment = equipment.get(row);
        switch (col) {
            case SERIALNUM_COL:
                tempEquipment.setSerialNum((String) val);
            case ID_COL:
                tempEquipment.setID(col);
            case NAME_COL:
                tempEquipment.setName((String) val);
        }
    }
     
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
}