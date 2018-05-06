/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.*;
import java.util.List;
import core.Part;
import core.Vendor;
import dao.PartDAO;
import dao.VendorDAO;
import dao.DBConnection;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author downw
 */
public class PartFrame extends javax.swing.JFrame {
    private DBConnection conn;
    private PartDAO PartDAO;
    private VendorDAO VDAO;
    private List<Part> parts;
    private List VIDList;
    PartsTableModel model;
    /**
     * Creates new form PartFrame
     */
    public PartFrame(DBConnection myConn) {
        initComponents();
        this.conn = myConn;
        PartDAO = new PartDAO(this.conn);
        VDAO = new VendorDAO(this.conn);
        try{
            parts = PartDAO.getAllPart();
        }
        catch(Exception ex){
            System.out.println("Error populating Part table.");
        }
        PartsTableModel model = new PartsTableModel(parts);
        partTable.setModel(model);
        try {
            VIDList = VDAO.getAllVID();
            for(int i = 0; i < VIDList.size(); i++) {
                jVIDCombo.addItem(VIDList.get(i).toString());
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error setting up shipping CIDs: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
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

        PIDTextField = new javax.swing.JTextField();
        jPIDTextField = new javax.swing.JTextField();
        jNameTextField = new javax.swing.JTextField();
        jDescriptionTextField = new javax.swing.JTextField();
        jVIDCombo = new javax.swing.JComboBox<>();
        jNameLabel = new javax.swing.JLabel();
        jPIDLabel = new javax.swing.JLabel();
        jVIDLabel = new javax.swing.JLabel();
        jDescriptionLabel = new javax.swing.JLabel();
        jButtonInsert = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        partTable = new javax.swing.JTable();
        jButtonReset = new javax.swing.JButton();

        PIDTextField.setText("P");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNameTextFieldActionPerformed(evt);
            }
        });

        jNameLabel.setText("Name");

        jPIDLabel.setText("Product ID");

        jVIDLabel.setText("Vendor ID");

        jDescriptionLabel.setText("Description");

        jButtonInsert.setText("Add");

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        partTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Name", "Description", "Vendor ID"
            }
        ));
        partTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                partTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(partTable);

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jVIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jVIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonInsert)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonUpdate)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonReset)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsert)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonReset))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDescriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jVIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jVIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNameTextFieldActionPerformed

    private void partTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_partTableMouseClicked
        int selectedRowIndex = partTable.getSelectedRow();
        int selectedRowModel = partTable.convertRowIndexToModel(selectedRowIndex);     
        jPIDTextField.setText(partTable.getValueAt(selectedRowModel, 0).toString());
        jNameTextField.setText(partTable.getValueAt(selectedRowModel, 1).toString());
        jDescriptionTextField.setText(partTable.getValueAt(selectedRowModel, 2).toString());
        if (partTable.getValueAt(selectedRowModel, 3).equals(0)) {
            jVIDCombo.setSelectedItem("empty");
        }
        else {
            jVIDCombo.setSelectedItem(partTable.getValueAt(selectedRowModel, 3).toString());
        }
        jButtonInsert.setEnabled(false);       
    }//GEN-LAST:event_partTableMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
         try{
            if(inDatabase(jPIDTextField.getText()) == false){
                String notInDatabase = "";
                notInDatabase += "Error: The Part ID you have entered is not in the Table.\n";
                notInDatabase += "Please make sure the Part ID you have entered is an ID listed ";
                notInDatabase += "in the table.\n";
                JOptionPane.showMessageDialog(this, notInDatabase, "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Part part = new Part(jPIDTextField.getText(), jNameTextField.getText(), jDescriptionTextField.getText(),
                    jVIDCombo.getSelectedItem().toString());
                int ans = JOptionPane.showConfirmDialog(null,"Are you sure you want to update this Part?","Update",JOptionPane.YES_NO_OPTION);
                if(ans == 0){
                    PartDAO.updatePart(part);
                    parts = PartDAO.getAllPart();
                    model = new PartsTableModel(parts);
                    partTable.setModel(model);
                    JOptionPane.showMessageDialog(this,"Part updated!");
                    System.out.println("Part updated!");
                }
            }    
        }
        catch(Exception exc){
            System.out.println("A Problem occured while deleting a Part: " + exc);
            JOptionPane.showMessageDialog(this,"A problem ocurred while trying to delete a Part!");
        }
        resetTextFields();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try{
            if(inDatabase(jPIDTextField.getText()) == false){
                String notInDatabase = "";
                notInDatabase += "Error: The Part ID you have entered is not in the Table.\n";
                notInDatabase += "Please make sure the Part ID you have entered is an ID listed ";
                notInDatabase += "in the table.\n";
                JOptionPane.showMessageDialog(this, notInDatabase, "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Part part = new Part(jPIDTextField.getText(), jNameTextField.getText(), jDescriptionTextField.getText(),
                    jVIDCombo.getSelectedItem().toString());
                int ans = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this Part?","Delete",JOptionPane.YES_NO_OPTION);
                if(ans ==0){
                    PartDAO.deletePart(part);
                    parts = PartDAO.getAllPart();
                    model = new PartsTableModel(parts);
                    partTable.setModel(model);
                    JOptionPane.showMessageDialog(this,"Part deleted!");
                    System.out.println("Part deleted!");
                }
            } 
        } 
        catch(Exception exc){
            System.out.println("A Problem occured while deleting a Part: " + exc);
            JOptionPane.showMessageDialog(this,"A problem ocurred while trying to delete a Part!");
        }
        resetTextFields();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        resetTextFields();
    }//GEN-LAST:event_jButtonResetActionPerformed
    
    private boolean inDatabase(String id){
         try{
            List<Part> list = PartDAO.getAllPart();
            int size = list.size();
            for(int i =0; i < size; i++){
                 Part part = list.get(i);
                if(part.getPID().equals(id)){
                    return true;
                }
            }
         }
         catch(Exception exc){
             System.out.println("A Problem occured while checking the table: " + exc);
         }
         return false;
     }
    
    private void resetTextFields(){
        jPIDTextField.setText("");
        jNameTextField.setText("");
        jDescriptionTextField.setText("");
        jVIDCombo.setSelectedItem(null);
        jButtonInsert.setEnabled(true);
    }
    
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
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PIDTextField;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jDescriptionLabel;
    private javax.swing.JTextField jDescriptionTextField;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jNameLabel;
    private javax.swing.JTextField jNameTextField;
    private javax.swing.JLabel jPIDLabel;
    private javax.swing.JTextField jPIDTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jVIDCombo;
    private javax.swing.JLabel jVIDLabel;
    private javax.swing.JTable partTable;
    // End of variables declaration//GEN-END:variables

    
}
