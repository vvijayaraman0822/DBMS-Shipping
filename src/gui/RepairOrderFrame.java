/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.List;
import core.RepairOrder;
import core.Carrier;
import core.Employee;
import core.Equipment;
import core.Contains;
import dao.RepairOrderDAO;
import dao.EmployeeDAO;
import dao.DBConnection;
import dao.CarrierDAO;
import dao.EquipmentDAO;
import dao.ContainsDAO;
import gui.ContainsTableModel;

// **** //
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import java.util.ArrayList;


//Clorissa Callender
   
import java.text.SimpleDateFormat;
import java.util.Date;
// **** //

/**
 *
 * @author Jesse Houk
 */
public class RepairOrderFrame extends javax.swing.JFrame {
    private DBConnection conn;
    private RepairOrderDAO RODAO;
    private EmployeeDAO EDAO;
    private CarrierDAO CDAO;
    private EquipmentDAO EqDAO;
    private ContainsDAO CoDAO;
    private List<RepairOrder> repairOrders;
    private List EIDList;
    private List CIDList;
    private List shipTypeList;
    private List equipmentList;
    private List containsList;
    private ContainsTableModel cmodel;
    RepairOrderTableModel model;
    //Clorissa Callender
    
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    /**
     * Creates new form RepairOrderFrame
     */
    public RepairOrderFrame(DBConnection myConn) {
        initComponents();
        shipTypeComboBox.addItem("");
        shipOut_CIDComboBox.addItem("");
        shipIn_CIDComboBox.addItem("");
        receivingEIDComboBox.addItem("");
        SN1ComboBox.addItem("");
        SN2ComboBox.addItem("");
        SN3ComboBox.addItem("");
        SN4ComboBox.addItem("");
        workEID1ComboBox.addItem("");
        workEID2ComboBox.addItem("");
        workEID3ComboBox.addItem("");
        workEID4ComboBox.addItem("");
        this.reset();
        
        conn = myConn;
        RODAO = new RepairOrderDAO(conn);
        EDAO = new EmployeeDAO(conn);
        CDAO = new CarrierDAO(conn);
        EqDAO = new EquipmentDAO(conn);
        CoDAO = new ContainsDAO(conn);
        
        dateRecdTextField.setText(formatter.format(date));

        // enable column sorting on any attribute in the table
        // follows from https://github.com/LegendaryZReborn/4123-DatabaseManagement/blob/master/Donation%20Tracker/src/gui/FundFrame.java
        TableRepairOrders.setAutoCreateRowSorter(true);
        try {
            repairOrders = RODAO.getAllRepairOrders();

        }
        catch(Exception ex) {
            Logger.getLogger(RepairOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error setting up table connection: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        model = new RepairOrderTableModel(repairOrders);
        TableRepairOrders.setModel(model);
        try {
            shipTypeList = RODAO.getAllShipTypes();
//            for(int i = 0; i < shipTypeList.size(); i++)
//                shipTypeComboBox.addItem(shipTypeList.get(i).toString());
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retrieving ship types: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            CIDList = CDAO.getAllCIDs();
            for(int i = 0; i < CIDList.size(); i++) {
                shipIn_CIDComboBox.addItem(CIDList.get(i).toString());
                shipOut_CIDComboBox.addItem(CIDList.get(i).toString());
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retrieveing shipping CIDs: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            EIDList = EDAO.comboValues();
            for(int i = 0; i < EIDList.size(); i++) {
                receivingEIDComboBox.addItem(EIDList.get(i).toString());
                workEID1ComboBox.addItem(EIDList.get(i).toString());
                workEID2ComboBox.addItem(EIDList.get(i).toString());
                workEID3ComboBox.addItem(EIDList.get(i).toString());
                workEID4ComboBox.addItem(EIDList.get(i).toString());
                
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retrieving EIDs: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            equipmentList = EqDAO.comboValues();
            for(int i = 0; i < equipmentList.size(); i++) {
                SN1ComboBox.addItem(equipmentList.get(i).toString());
                SN2ComboBox.addItem(equipmentList.get(i).toString());
                SN3ComboBox.addItem(equipmentList.get(i).toString());
                SN4ComboBox.addItem(equipmentList.get(i).toString());
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retrieving Parts: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            containsList = CoDAO.getAllContains();
            cmodel = new ContainsTableModel(containsList);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retrieving Repair Order Parts (contains): " + ex, "Error", JOptionPane.ERROR_MESSAGE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TableRepairOrders = new javax.swing.JTable();
        receivingEIDLabel = new javax.swing.JLabel();
        CIDLabel = new javax.swing.JLabel();
        shipOut_CIDLabel = new javax.swing.JLabel();
        shipOutTypeLabel = new javax.swing.JLabel();
        dateShippedLabel = new javax.swing.JLabel();
        dateRecdLabel = new javax.swing.JLabel();
        SerialNum1Label = new javax.swing.JLabel();
        SerialNum2Label = new javax.swing.JLabel();
        SerialNum3Label = new javax.swing.JLabel();
        SerialNum4Label = new javax.swing.JLabel();
        workingEID1Label = new javax.swing.JLabel();
        workingEID2Label = new javax.swing.JLabel();
        workingEID3Label = new javax.swing.JLabel();
        workingEID4Label = new javax.swing.JLabel();
        dateShippedTextField = new javax.swing.JTextField();
        dateRecdTextField = new javax.swing.JTextField();
        ROAddButton = new javax.swing.JButton();
        ROUpdateButton = new javax.swing.JButton();
        RORemoveButton = new javax.swing.JButton();
        ROResetButton = new javax.swing.JButton();
        receivingEIDComboBox = new javax.swing.JComboBox<>();
        shipIn_CIDComboBox = new javax.swing.JComboBox<>();
        shipOut_CIDComboBox = new javax.swing.JComboBox<>();
        shipTypeComboBox = new javax.swing.JComboBox<>();
        SN1ComboBox = new javax.swing.JComboBox<>();
        SN2ComboBox = new javax.swing.JComboBox<>();
        SN3ComboBox = new javax.swing.JComboBox<>();
        SN4ComboBox = new javax.swing.JComboBox<>();
        workEID1ComboBox = new javax.swing.JComboBox<>();
        workEID2ComboBox = new javax.swing.JComboBox<>();
        workEID3ComboBox = new javax.swing.JComboBox<>();
        workEID4ComboBox = new javax.swing.JComboBox<>();
        SN1FormattedTextField = new javax.swing.JFormattedTextField();
        SN2FormattedTextField = new javax.swing.JFormattedTextField();
        SN3FormattedTextField = new javax.swing.JFormattedTextField();
        SN4FormattedTextField = new javax.swing.JFormattedTextField();
        RIDLabel = new javax.swing.JLabel();
        RIDTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableRepairOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Repair Order ID", "Date Received", "Date Shipped", "Carrier Delivery Type", "Outbound CID", "EID", "Inbound CID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableRepairOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableRepairOrdersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableRepairOrders);

        receivingEIDLabel.setText("EID received by:");

        CIDLabel.setText("CID arrived by:");

        shipOut_CIDLabel.setText("CID sent by:");

        shipOutTypeLabel.setText("Ship type:");

        dateShippedLabel.setText("Date shipped:");

        dateRecdLabel.setText("Date received:");

        SerialNum1Label.setText("Part 1 SN:");

        SerialNum2Label.setText("Part 2 SN:");

        SerialNum3Label.setText("Part 3 SN:");

        SerialNum4Label.setText("Part 4 SN:");

        workingEID1Label.setText("EID 1 repairing:");

        workingEID2Label.setText("EID 2 repairing:");

        workingEID3Label.setText("EID 3 repairing:");

        workingEID4Label.setText("EID 4 repairing:");

        dateShippedTextField.setText("Date Repair Order Shipped");
        dateShippedTextField.setNextFocusableComponent(shipTypeComboBox);
        dateShippedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateShippedTextFieldActionPerformed(evt);
            }
        });

        dateRecdTextField.setText("Date Repair Order Received");
        dateRecdTextField.setNextFocusableComponent(dateShippedTextField);

        ROAddButton.setText("Add");
        ROAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ROAddButtonMouseClicked(evt);
            }
        });

        ROUpdateButton.setText("Update");
        ROUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ROUpdateButtonActionPerformed(evt);
            }
        });

        RORemoveButton.setText("Remove");
        RORemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RORemoveButtonActionPerformed(evt);
            }
        });

        ROResetButton.setText("Reset");
        ROResetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ROResetButtonMouseClicked(evt);
            }
        });


        shipTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ground", "Blue", "Brown", "Red" }));

        receivingEIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "empty" }));
        receivingEIDComboBox.setNextFocusableComponent(shipIn_CIDComboBox);

        shipIn_CIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "empty" }));
        shipIn_CIDComboBox.setNextFocusableComponent(SN1ComboBox);

        shipOut_CIDComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "empty" }));
        shipOut_CIDComboBox.setNextFocusableComponent(receivingEIDComboBox);

        //shipTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "empty", "Ground", "Blue", "Brown", "Red" }));
        shipTypeComboBox.setNextFocusableComponent(shipOut_CIDComboBox);

        SN1ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SN1ComboBox.setNextFocusableComponent(SN1FormattedTextField);

        SN2ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SN2ComboBox.setNextFocusableComponent(SN2FormattedTextField);

        SN3ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SN3ComboBox.setNextFocusableComponent(SN3FormattedTextField);

        SN4ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SN4ComboBox.setNextFocusableComponent(SN4FormattedTextField);

        workEID1ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        workEID1ComboBox.setNextFocusableComponent(workEID2ComboBox);

        workEID2ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        workEID2ComboBox.setNextFocusableComponent(workEID3ComboBox);

        workEID3ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        workEID3ComboBox.setName(""); // NOI18N
        workEID3ComboBox.setNextFocusableComponent(workEID4ComboBox);

        workEID4ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SN1FormattedTextField.setText("Part 1 Name");
        SN1FormattedTextField.setNextFocusableComponent(SN2ComboBox);

        SN2FormattedTextField.setText("Part 2 Name");
        SN2FormattedTextField.setNextFocusableComponent(SN3ComboBox);

        SN3FormattedTextField.setText("Part 3 Name");
        SN3FormattedTextField.setNextFocusableComponent(SN4ComboBox);

        SN4FormattedTextField.setText("Part 4 Name");
        SN4FormattedTextField.setNextFocusableComponent(workEID1ComboBox);

        SN4FormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SN4FormattedTextFieldActionPerformed(evt);
            }
        });

        RIDLabel.setText("RID:");

        RIDTextField.setText("Order Repair ID");

        RIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RIDTextFieldActionPerformed(evt);
            }
        });

        RIDTextField.setNextFocusableComponent(dateRecdTextField);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 618, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shipOut_CIDLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shipOutTypeLabel)
                            .addComponent(dateShippedLabel)
                            .addComponent(RIDLabel)
                            .addComponent(receivingEIDLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ROAddButton)
                                        .addComponent(CIDLabel))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(dateRecdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(RIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dateShippedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(shipTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(shipOut_CIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(receivingEIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(shipIn_CIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(78, 78, 78)
                                            .addComponent(ROUpdateButton))))
                                .addComponent(dateRecdLabel, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RORemoveButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(SerialNum1Label)
                                .addComponent(SerialNum2Label)
                                .addComponent(SerialNum3Label)
                                .addComponent(SerialNum4Label))
                            .addComponent(workingEID1Label)
                            .addComponent(workingEID2Label)
                            .addComponent(workingEID3Label)
                            .addComponent(workingEID4Label))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(ROResetButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(workEID3ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workEID4ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workEID2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workEID1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN4ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN3ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SN1FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN2FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN3FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN4FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RIDLabel)
                    .addComponent(RIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SerialNum1Label)
                    .addComponent(SN1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SN1FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SN2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SN2FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SerialNum2Label)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateRecdLabel)
                        .addComponent(dateRecdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SerialNum3Label)
                    .addComponent(SN3FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SN3ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateShippedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateShippedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SN4ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SN4FormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SerialNum4Label)
                                .addComponent(shipOutTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(shipOut_CIDLabel)
                            .addComponent(shipOut_CIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workingEID1Label)
                            .addComponent(workEID1ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(receivingEIDLabel)
                            .addComponent(receivingEIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workingEID2Label)
                            .addComponent(workEID2ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(shipTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(shipIn_CIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CIDLabel))
                    .addComponent(workingEID3Label)
                    .addComponent(workEID3ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(workingEID4Label)
                    .addComponent(workEID4ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ROAddButton)
                        .addComponent(ROUpdateButton)
                        .addComponent(RORemoveButton))
                    .addComponent(ROResetButton))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateShippedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateShippedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateShippedTextFieldActionPerformed

    private void SN4FormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SN4FormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SN4FormattedTextFieldActionPerformed
    

//////    shipTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GG2220", "RE1410", "WG3100", "WG3720", "WR0103" }));

    private void TableRepairOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableRepairOrdersMouseClicked
  //FIRST:event_TableRepairOrdersMouseClicked
        // TODO add your handling code here:
        this.reset();
        int rowIndex = TableRepairOrders.getSelectedRow();
        int rowModel = TableRepairOrders.convertRowIndexToModel(rowIndex);
        // get the value of RID
        Object tableVal = TableRepairOrders.getValueAt(rowIndex, 0);
        RIDTextField.setText(tableVal.toString());
        // get the values of the Serial number(s) associated with the RID
        ResultSet contains = CoDAO.getContains(Integer.parseInt(tableVal.toString()));
        ResultSet employee = EDAO.getEmployees(Integer.parseInt(tableVal.toString()));
        List partNamesInROList = new ArrayList<>();
        List partSNsInROList = new ArrayList<>();
        List ROEIDs = new ArrayList<>();
        try {
            while (contains.next()) {
                partNamesInROList.add(contains.getString("name"));
                partSNsInROList.add(contains.getString("serialNum"));
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error retrieving Part Name (3)"
                + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            for (int i = 1; i <= partNamesInROList.size(); i++) {
                switch (i) {
                    case 1:
                        SN1FormattedTextField.setText(partNamesInROList.get(i - 1).toString());
                        SN1ComboBox.setSelectedItem(partSNsInROList.get(i - 1).toString());
                        break;
                    case 2:
                        SN2FormattedTextField.setText(partNamesInROList.get(i - 1).toString());
                        SN2ComboBox.setSelectedItem(partSNsInROList.get(i - 1).toString());
                        break;
                    case 3:
                        SN3FormattedTextField.setText(partNamesInROList.get(i - 1).toString());
                        SN3ComboBox.setSelectedItem(partSNsInROList.get(i - 1).toString());
                        break;
                    case 4:
                        SN4FormattedTextField.setText(partNamesInROList.get(i - 1).toString());
                        SN4ComboBox.setSelectedItem(partSNsInROList.get(i - 1).toString());
                        break;
                    default:
                        SN1FormattedTextField.setText(partNamesInROList.get(i - 1).toString());
                        SN1ComboBox.setSelectedItem(partSNsInROList.get(i - 1).toString());
                }
            }
        }
        catch (Exception ex) { 
            
        }
        try {
            while (employee.next()) {
                ROEIDs.add(employee.getString("EID"));
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error retrieving EID (2)"
                + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            for (int i = 1; i <= ROEIDs.size(); i++) {
                switch (i) {
                    case 1:
                        workEID1ComboBox.setSelectedItem(ROEIDs.get(i - 1).toString());
                        break;
                    case 2:
                        workEID2ComboBox.setSelectedItem(ROEIDs.get(i - 1).toString());
                        break;
                    case 3:
                        workEID3ComboBox.setSelectedItem(ROEIDs.get(i - 1).toString());
                        break;
                    case 4:
                        workEID4ComboBox.setSelectedItem(ROEIDs.get(i - 1).toString());
                        break;
                    default:
                        workEID1ComboBox.setSelectedItem(ROEIDs.get(i - 1).toString());
                }
            }
        }
        catch (Exception ex) {
            
        }
        dateRecdTextField.setText(TableRepairOrders.getValueAt(rowIndex, 1).toString());
        // get the value of dateShipped
        tableVal = TableRepairOrders.getValueAt(rowIndex, 2);
        if (tableVal == null) {
            dateShippedTextField.setText("");
        }
        else {
            dateShippedTextField.setText(tableVal.toString());
        }
        // get the value of shipOutType
        tableVal = TableRepairOrders.getValueAt(rowIndex, 3);
	if (tableVal == null) {
            shipTypeComboBox.setSelectedItem("");
        }
        else {
            // convert the first character of shipOutType to a capital value
            String temp = 
                Character.toString(Character.toUpperCase(tableVal.toString().substring(0).charAt(0))) 
                + tableVal.toString().substring(1, tableVal.toString().length());
            shipTypeComboBox.setSelectedItem(temp);
        }
        // get value of shipOut_CID
        tableVal = TableRepairOrders.getValueAt(rowIndex, 4);
	if (Integer.parseInt(tableVal.toString()) == 0) {
            shipOut_CIDComboBox.setSelectedItem("");
        }
        else {
            shipOut_CIDComboBox.setSelectedItem(tableVal.toString());
        }
        receivingEIDComboBox.setSelectedItem(TableRepairOrders.getValueAt(rowIndex, 5).toString());
        // get value of shipIn_CID
        tableVal = TableRepairOrders.getValueAt(rowIndex, 6);
	if (Integer.parseInt(tableVal.toString()) == 0) {
            shipIn_CIDComboBox.setSelectedItem("");
        }
        else {
            shipIn_CIDComboBox.setSelectedItem(tableVal.toString());
        }
        
        ROAddButton.setEnabled(false);
		
        DocumentListener dl = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {warn(e);}
            public void insertUpdate(DocumentEvent e) {warn(e);}
            public void removeUpdate(DocumentEvent e) {warn(e);}
            private void warn(DocumentEvent e) {
                DocumentEvent.EventType type = e.getType();
                if (type.equals(DocumentEvent.EventType.CHANGE)) {
                    ROAddButton.setEnabled(true);
                }
            }
        };
        RIDTextField.getDocument().addDocumentListener(dl);
    }//GEN-LAST:event_TableRepairOrdersMouseClicked

    private void ROResetButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ROResetButtonMouseClicked
        // TODO add your handling code here:
        reset();
        ROAddButton.setEnabled(true);
    }//GEN-LAST:event_ROResetButtonMouseClicked

    private void RORemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RORemoveButtonActionPerformed
    
      try{
           RODAO.deleteRepairOrder(Integer.parseInt(RIDTextField.getText().toString()));
           repairOrders = RODAO.getAllRepairOrders();
           model = new RepairOrderTableModel(repairOrders);
           TableRepairOrders.setModel(model);
           JOptionPane.showMessageDialog(this,"Repair Order was deleted!");

       }catch(Exception exc){
           String error ="";
           if(exc.getMessage().contains("for key 'PRIMARY'"))
               error="Repair ID not found!\n";
            System.out.println("A Problem occured while deleting a Repair Order: " + exc);
            JOptionPane.showMessageDialog(this,"Repair Order was not deleted!"
                                                +error);

       }
      
        
    }//GEN-LAST:event_RORemoveButtonActionPerformed
 
    private void ROAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ROAddButtonMouseClicked
        // TODO add your handling code here:
        if(
            receivingEIDComboBox.getSelectedItem().toString().isEmpty() ||    
            RIDTextField.getText().toString().isEmpty() ||
            dateRecdTextField.getText().toString().isEmpty()
          )
        {
            JOptionPane.showMessageDialog(this,"Please Include all mandatory values\n"
                                             + "Date Received\n"
                                             + "RID\n"
                                             + "EID Received by\n");
        }
        else{
              //use regex to check for date format of two date fields
              String dateRecdRegex = dateRecdTextField.getText().toString();
              String dateShipRegex = "";
              // Check dateRecdRegex for correct date format
              if(!(dateRecdRegex.matches("\\d{4}-\\d{2}-\\d{2}")))
              {
                  JOptionPane.showMessageDialog(this,"Please enter dateRecieved in the format:"
                                                    +"\n\"YYYY-MM-DD\"");
                  return;
              }
              // Assign dateShipRegex if not null, then check value for date format
              if(!(dateShippedTextField.getText().toString().isEmpty())){
                   dateShipRegex = dateShippedTextField.getText().toString();
                   if(!(dateShipRegex.matches("\\d{4}-\\d{2}-\\d{2}")) && 
                        !(dateShipRegex == "")){
                       JOptionPane.showMessageDialog(this,"Please enter dateShipped in the format:"
                                                    +"\n\"YYYY-MM-DD\"");
                            return;   
                   }
              }
        
        String temp = shipOut_CIDComboBox.getSelectedItem().toString();
        int soid = 0;
        if(!temp.isEmpty())
            soid = Integer.parseInt(shipOut_CIDComboBox.getSelectedItem().toString());   
        int rid = Integer.parseInt(RIDTextField.getText().toString());
        String dr = dateRecdTextField.getText().toString();
        String ds = dateShippedTextField.getText().toString();
        String temp2 = shipTypeComboBox.getSelectedItem().toString();
        String stype = "";
        if(!temp2.isEmpty())
            stype = shipTypeComboBox.getSelectedItem().toString();
        int eid = Integer.parseInt(receivingEIDComboBox.getSelectedItem().toString());
        String temp3 = shipIn_CIDComboBox.getSelectedItem().toString();
        int siid = 0;
        if(!temp3.isEmpty())
            siid = Integer.parseInt(shipIn_CIDComboBox.getSelectedItem().toString());
        RepairOrder addOrder = new RepairOrder(rid, dr, ds, stype, soid, eid, siid);
             
        System.out.println(addOrder.getDateShipped());
        System.out.println(addOrder.getShipOutType());
        System.out.println(addOrder.getShipOut_CID());
        System.out.println(addOrder.getEID());
        System.out.println(addOrder.getShipIn_CID());
        System.out.println(addOrder.getRID());

       try{    
           RODAO.addRepairOrder(addOrder);
           repairOrders = RODAO.getAllRepairOrders();
           model = new RepairOrderTableModel(repairOrders);
           TableRepairOrders.setModel(model);
           JOptionPane.showMessageDialog(this,"Repair Orderd added!");
           reset();
       }catch(Exception exc){
            System.out.println("A Problem occured while adding a Repair Order: " + exc);
            JOptionPane.showMessageDialog(this,"Repair Order was not added!");
      
    }//GEN-LAST:event_ROAddButtonMouseClicked
    }
    }
    
    private void ROUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ROUpdateButtonActionPerformed
        if(
            receivingEIDComboBox.getSelectedItem().toString().isEmpty() ||    
            RIDTextField.getText().toString().isEmpty() ||
            dateRecdTextField.getText().toString().isEmpty()
          )
        {
            JOptionPane.showMessageDialog(this,"Please Include all mandatory values\n"
                                             + "Date Received\n"
                                             + "RID\n"
                                             + "EID Received by\n");
        }
         else{
              //use regex to check for date format of two date fields
              String dateRecdRegex = dateRecdTextField.getText().toString();
              String dateShipRegex = "";
              // Check dateRecdRegex for correct date format
              if(!(dateRecdRegex.matches("\\d{4}-\\d{2}-\\d{2}")))
              {
                  JOptionPane.showMessageDialog(this,"Please enter dateRecieved in the format:"
                                                    +"\n\"YYYY-MM-DD\"");
                  return;
              }
              // Assign dateShipRegex if not null, then check value for date format
              if(!(dateShippedTextField.getText().toString() == "")){
                   dateShipRegex = dateShippedTextField.getText().toString();
                   if(!(dateShipRegex.matches("\\d{4}-\\d{2}-\\d{2}"))){
                       JOptionPane.showMessageDialog(this,"Please enter dateShipped in the format:"
                                                    +"\n\"YYYY-MM-DD\"");
                            return;   
                   }
              }
              //regexp for dateRecd
              String temp = shipOut_CIDComboBox.getSelectedItem().toString();
                int soid = 0;
                if(!temp.isEmpty())
                    soid = Integer.parseInt(shipOut_CIDComboBox.getSelectedItem().toString());
                int rid = Integer.parseInt(RIDTextField.getText().toString());
                String dr = dateRecdTextField.getText().toString();
                String ds = dateShippedTextField.getText().toString();
                String temp2 = shipTypeComboBox.getSelectedItem().toString();
                String stype = "";
                if(!temp2.isEmpty())
                    stype = shipTypeComboBox.getSelectedItem().toString();
                int eid = Integer.parseInt(receivingEIDComboBox.getSelectedItem().toString());
                String temp3 = shipIn_CIDComboBox.getSelectedItem().toString();
                int siid = 0;
                if(!temp3.isEmpty())
                    siid = Integer.parseInt(shipIn_CIDComboBox.getSelectedItem().toString());

                RepairOrder addOrder = new RepairOrder(rid, dr, ds, stype, soid, eid, siid);

                try{
                    RODAO.updateRepairOrder(addOrder);
                    repairOrders = RODAO.getAllRepairOrders();
                    model = new RepairOrderTableModel(repairOrders);
                    TableRepairOrders.setModel(model);
                    JOptionPane.showMessageDialog(this, "Repair Order was updated");
                }
                catch(Exception exc){
                    System.out.println("A Problem occured while updating a Repair Order: " + exc);
                    JOptionPane.showMessageDialog(this,"Repair Order was not updated!");
                }
    }
        
    }//GEN-LAST:event_ROUpdateButtonActionPerformed

    private void RIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RIDTextFieldActionPerformed
    
    private void reset(){
       RIDTextField.setText("");
       receivingEIDComboBox.setSelectedItem("");
       shipIn_CIDComboBox.setSelectedItem("");
       shipOut_CIDComboBox.setSelectedItem("");
       shipTypeComboBox.setSelectedItem("");
       dateShippedTextField.setText("");
       dateRecdTextField.setText(formatter.format(date));
       SN1ComboBox.setSelectedItem("");
       SN1FormattedTextField.setText("");
       SN2ComboBox.setSelectedItem("");
       SN3ComboBox.setSelectedItem("");
       SN4ComboBox.setSelectedItem("");
       workEID1ComboBox.setSelectedItem("");
       workEID2ComboBox.setSelectedItem("");
       workEID3ComboBox.setSelectedItem("");
       workEID4ComboBox.setSelectedItem("");
       SN2FormattedTextField.setText("");
       SN3FormattedTextField.setText("");
       SN4FormattedTextField.setText("");
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
            java.util.logging.Logger.getLogger(RepairOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepairOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepairOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepairOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepairOrderFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CIDLabel;
    private javax.swing.JLabel RIDLabel;
    private javax.swing.JTextField RIDTextField;
    private javax.swing.JButton ROAddButton;
    private javax.swing.JButton RORemoveButton;
    private javax.swing.JButton ROResetButton;
    private javax.swing.JButton ROUpdateButton;
    private javax.swing.JComboBox<String> SN1ComboBox;
    private javax.swing.JFormattedTextField SN1FormattedTextField;
    private javax.swing.JComboBox<String> SN2ComboBox;
    private javax.swing.JFormattedTextField SN2FormattedTextField;
    private javax.swing.JComboBox<String> SN3ComboBox;
    private javax.swing.JFormattedTextField SN3FormattedTextField;
    private javax.swing.JComboBox<String> SN4ComboBox;
    private javax.swing.JFormattedTextField SN4FormattedTextField;
    private javax.swing.JLabel SerialNum1Label;
    private javax.swing.JLabel SerialNum2Label;
    private javax.swing.JLabel SerialNum3Label;
    private javax.swing.JLabel SerialNum4Label;
    private javax.swing.JTable TableRepairOrders;
    private javax.swing.JLabel dateRecdLabel;
    private javax.swing.JTextField dateRecdTextField;
    private javax.swing.JLabel dateShippedLabel;
    private javax.swing.JTextField dateShippedTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> receivingEIDComboBox;
    private javax.swing.JLabel receivingEIDLabel;
    private javax.swing.JComboBox<String> shipIn_CIDComboBox;
    private javax.swing.JLabel shipOutTypeLabel;
    private javax.swing.JComboBox<String> shipOut_CIDComboBox;
    private javax.swing.JLabel shipOut_CIDLabel;
    private javax.swing.JComboBox<String> shipTypeComboBox;
    private javax.swing.JComboBox<String> workEID1ComboBox;
    private javax.swing.JComboBox<String> workEID2ComboBox;
    private javax.swing.JComboBox<String> workEID3ComboBox;
    private javax.swing.JComboBox<String> workEID4ComboBox;
    private javax.swing.JLabel workingEID1Label;
    private javax.swing.JLabel workingEID2Label;
    private javax.swing.JLabel workingEID3Label;
    private javax.swing.JLabel workingEID4Label;
    // End of variables declaration//GEN-END:variables
}
