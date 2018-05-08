/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.util.*;
import core.Equipment;
import dao.EquipmentDAO;
import dao.DBConnection;
import javax.swing.JOptionPane;
/**
 *
 * @author Bob
 */
public class EquipmentFrame extends javax.swing.JFrame {

    private DBConnection conn;
    private EquipmentDAO EDAO;
    private List<Equipment> equipment;
    EquipmentTableModel model;
    /**
     * Creates new form EquipmentTable
     */
    public EquipmentFrame(DBConnection myConn) {
        initComponents();       
        this.conn = myConn;
        EDAO = new EquipmentDAO(this.conn);        
        EquipmentTable.setAutoCreateRowSorter(true);
        
        try {
            equipment = EDAO.getallEquipment();
            model = new EquipmentTableModel(equipment);
            EquipmentTable.setModel(model);

        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Error 2: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EquipmentTable = new javax.swing.JTable();
        serNumField = new javax.swing.JTextField();
        IDField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("EquipmentTable");

        jScrollPane1.setToolTipText("");

        EquipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "SerialNum", "ID", "Name"
            }
        ));
        EquipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EquipmentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(EquipmentTable);

        serNumField.setNextFocusableComponent(IDField);

        IDField.setNextFocusableComponent(nameField);

        nameField.setNextFocusableComponent(addButton);

        jLabel2.setText("SerialNum:");

        jLabel3.setText("ID:");

        jLabel4.setText("Name:");

        addButton.setText("Add");
        addButton.setNextFocusableComponent(deleteButton);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.setNextFocusableComponent(updateButton);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.setNextFocusableComponent(resetButton);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateButton)))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serNumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(addButton)
                    .addComponent(deleteButton)
                    .addComponent(updateButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String serialNum, name, ID;
        serialNum = serNumField.getText();
        ID = IDField.getText();
        name = nameField.getText();
        
        Equipment oldEquipment = new Equipment(serialNum, ID, name);
        
        try{
            EDAO.deleteEquipment(oldEquipment);
            //refresh table after adding new tuple
            equipment = EDAO.getallEquipment();
        }
        catch(Exception exc){
            JOptionPane.showMessageDialog(this, "Error: there was a problem deleting this equipment");
        }  
             
        model = new EquipmentTableModel(equipment);
        EquipmentTable.setModel(model);
        addButton.setEnabled(true);
        
        serNumField.setText("");
        IDField.setText("");
        nameField.setText("");
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void EquipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EquipmentTableMouseClicked
        int selectedRowIndex = EquipmentTable.getSelectedRow();
        int selectedRowModel = EquipmentTable.convertRowIndexToModel(selectedRowIndex);
        serNumField.setText(EquipmentTable.getValueAt(selectedRowModel,0).toString());
        IDField.setText(EquipmentTable.getValueAt(selectedRowModel,1).toString());
        nameField.setText(EquipmentTable.getValueAt(selectedRowModel,2).toString());
        
        addButton.setEnabled((false));
    }//GEN-LAST:event_EquipmentTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String serialNum, name, ID;
        
        serialNum = serNumField.getText();
        ID = IDField.getText();
        name = nameField.getText();
        
        Equipment newEquipment = new Equipment(serialNum, ID, name);
        
        try{
            EDAO.addEquipment(newEquipment);
            //refresh table after adding new tuple
            equipment = EDAO.getallEquipment();
        }
        catch(Exception exc){
           JOptionPane.showMessageDialog(this, "There was an error adding this equipment please make sure you're entered information is matching"
                   + "                   this example:\n SerialNum: 1231 (must be unique),\n ID:12312,\n name: Screwdriver)");
        }
        
        model = new EquipmentTableModel(equipment);
        EquipmentTable.setModel(model);
        
        serNumField.setText("");
        IDField.setText("");
        nameField.setText("");
    }//GEN-LAST:event_addButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String serialNum, ID, name;
        serialNum = serNumField.getText();
        ID = IDField.getText();
        name = nameField.getText();
        
        Equipment updatedEquipment = new Equipment(serialNum, ID, name);
        
        try{
            EDAO.updateEquipment(updatedEquipment);
            //refresh table after adding new tuple
            equipment = EDAO.getallEquipment();
        }
        catch(Exception exc){
             JOptionPane.showMessageDialog(this, "There was an error updating this vendor please make sure you're entered information is matching  \n this example:"
                     + "\n Serial Num: 12314 (must be unique) \n ID: 1231 (must belong to an customer), name: Screwdriver");
        }
        
        model = new EquipmentTableModel(equipment);
        EquipmentTable.setModel(model);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        serNumField.setText("");
        IDField.setText("");
        nameField.setText("");
        addButton.setEnabled(true);
    }//GEN-LAST:event_resetButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipmentFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable EquipmentTable;
    private javax.swing.JTextField IDField;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextField serNumField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
