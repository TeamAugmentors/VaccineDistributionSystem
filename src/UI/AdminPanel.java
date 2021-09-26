/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.formdev.flatlaf.FlatDarkLaf;
import dbConnection.DBConnection;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lassassin
 */
public class AdminPanel extends javax.swing.JFrame {

    /**
     * Creates new form AdminPanel
     */
    //
    JLabel[] labels;
    JPanel[] panels;
    String[] columnNames;
    Object[][] objects;
    JFrame bigTableFrame = null;
    HashMap<JLabel, JPanel> map = new HashMap<>();
    HashMap<String, String[]> tableColumnMap = new HashMap<>();

    JCheckBox checkBoxArr[];
    String name = "";

    private void init() {

        //Make set
        makeLabels(labelHome, labelDatabase, labelModify, labelSql);
        makePanels(panelHome, panelDatabase, panelModify, panelSql);

        for (int i = 0; i < labels.length; i++) {
            map.put(labels[i], panels[i]);
        }

        //Get name and id
        labelClientId.setText("Connection secure. Client ID: " + DBConnection.clientId);
        labelName.setText("Logged in as " + name);
        try {
            //populate tables

            DatabaseMetaData metaData = DBConnection.getGlobalConnection().getMetaData();

            String[] types = {"TABLE"};
            ResultSet tables = metaData.getTables(null, null, "%", types);

            while (tables.next()) {
                if (!(tables.getString("TABLE_NAME").charAt(0) >= 'a')) {
                    boxTables.addItem(tables.getString("TABLE_NAME"));
                    ResultSet set = DBConnection.makeQuery("SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = N'" + tables.getString("TABLE_NAME") + "'");


                    ArrayList<String> str = new ArrayList<>();

                    while (set.next()) {
                        str.add(set.getString("COLUMN_NAME"));
                    }

                    String[] strArr = new String[str.size()];

                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = str.get(i);
                    }

                    tableColumnMap.put(tables.getString("TABLE_NAME"), strArr);
                }
            }
            generateColumnCheckboxes(tableColumnMap.get(boxTables.getItemAt(0)));
        } catch (SQLException ex) {
            System.out.println("ERROR " + ex.getMessage());
        }

        boxTables.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                generateColumnCheckboxes(tableColumnMap.get(e.getItem().toString()));
            }
        });


        System.out.println(boxTables.getItemCount());
        System.out.println(boxTables1.getItemCount());

    }

    private void generateColumnCheckboxes(String[] colNames) {
        int checkboxNum = colNames.length;
        int row = 1;
        int col = checkboxNum;
        if (checkboxNum > 6) {
            row = 3;
            col = 3;
        } else if (checkboxNum > 3) {
            row = 2;
            col = 3;
        }
        GridLayout experimentLayout = new GridLayout(row, col);
        panelCheckbox.removeAll();
        panelCheckbox.setLayout(experimentLayout);
        checkBoxArr = new JCheckBox[checkboxNum];
        for (int i = 0; i < checkboxNum; i++) {
            JCheckBox checkBox = new JCheckBox(colNames[i], true);
            checkBox.setMinimumSize(checkBox.getPreferredSize());
            checkBoxArr[i] = checkBox;
            panelCheckbox.add(checkBox);
        }
        panelCheckbox.revalidate();
        panelCheckbox.repaint();
    }

    private void makeLabels(JLabel... labels) {
        this.labels = labels;
    }

    private void makePanels(JPanel... panels) {
        this.panels = panels;
    }

    private void attachPanel(JPanel currentPanel) {
        try {
            pane.remove(pane.getComponent(0));
        } catch (Exception ex) {

        }

        pane.add(currentPanel);

        pane.revalidate();
        pane.repaint();
    }

    public AdminPanel(String NAME) {
        name = NAME;
        FlatDarkLaf.setup();
        initComponents();
        init();
        attachPanel(map.get(labelHome));
        requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelClientId = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panelDatabase = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        boxTables = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        topSpinner = new javax.swing.JSpinner();
        executeButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        whereTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new JTable(){
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;//To change body of generated methods, choose Tools | Templates.
            }
        };
        panelCheckbox = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        panelModify = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        boxTables1 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonAddRow = new javax.swing.JButton();
        buttonAddColumn = new javax.swing.JButton();
        panelSql = new javax.swing.JPanel();
        indices = new javax.swing.JPanel();
        labelHome = new javax.swing.JLabel();
        labelDatabase = new javax.swing.JLabel();
        labelModify = new javax.swing.JLabel();
        labelSql = new javax.swing.JLabel();
        pane = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel1.setText("WELCOME");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("• Use the admin panel to get, update or delete entries\n• You can also register new admins through the registration\n");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Usage");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("• Candidates can register through the \"Register NID\" section\n• If they are valid, they can recieve vaccinations \n• Priority is determined by age\n• When the time comes, an SMS is sent to their mobile number\n• Candidates can see their position from the \"Check Position\"\n• Candidates who have recieved two doses can get their certificates\n   from the \"Get Certificate\" section.");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("How the System Works");

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("For more information, please visit");

        jLabel7.setForeground(new java.awt.Color(0, 139, 255));
        jLabel7.setText("https://surokkha.gov.bd/");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeToHand(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
        });

        labelClientId.setText("Connection secure. Client ID: ");

        labelName.setText("Logged in as: ");

        jLabel9.setText("Software version: 1.0.3v");

        jLabel10.setText("Beta Release");

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelClientId)
                            .addComponent(labelName)
                            .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                                    .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelHomeLayout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(144, 144, 144))
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(panelHomeLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelClientId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelName)
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        panelDatabase.setMaximumSize(new java.awt.Dimension(500, 598));
        panelDatabase.setMinimumSize(new java.awt.Dimension(500, 598));
        panelDatabase.setPreferredSize(new java.awt.Dimension(500, 598));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Get");

        boxTables.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Table");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Primary Table");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Parameters");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Select TOP");

        topSpinner.setModel(new javax.swing.SpinnerNumberModel(100, 0, 1000, 1));

        executeButton.setText("Execute");
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });

        jLabel15.setText("Columns");

        jLabel16.setText("Where");

        whereTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whereTextFieldActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        resultTable.setEditingColumn(0);
        resultTable.setEditingRow(0);
        jScrollPane1.setViewportView(resultTable);

        panelCheckbox.setLayout(new java.awt.GridLayout(3, 3));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/exit-top-right_1.png"))); // NOI18N
        jButton2.setAlignmentY(0.0F);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatabaseLayout = new javax.swing.GroupLayout(panelDatabase);
        panelDatabase.setLayout(panelDatabaseLayout);
        panelDatabaseLayout.setHorizontalGroup(
            panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatabaseLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(executeButton, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelDatabaseLayout.createSequentialGroup()
                            .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(40, 40, 40)))
                    .addGroup(panelDatabaseLayout.createSequentialGroup()
                        .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatabaseLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(whereTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addGroup(panelDatabaseLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel12)
                            .addGroup(panelDatabaseLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(topSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatabaseLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        panelDatabaseLayout.setVerticalGroup(
            panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatabaseLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(boxTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(21, 21, 21)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(topSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(whereTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(executeButton)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        panelModify.setMaximumSize(new java.awt.Dimension(500, 598));
        panelModify.setMinimumSize(new java.awt.Dimension(500, 598));
        panelModify.setPreferredSize(new java.awt.Dimension(500, 598));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Modify");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/exit-top-right_1.png"))); // NOI18N
        jButton4.setAlignmentY(0.0F);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        boxTables1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Table");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        buttonAddRow.setText("Add Row");
        buttonAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddRowActionPerformed(evt);
            }
        });

        buttonAddColumn.setText("Add Column");
        buttonAddColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddColumnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModifyLayout = new javax.swing.GroupLayout(panelModify);
        panelModify.setLayout(panelModifyLayout);
        panelModifyLayout.setHorizontalGroup(
            panelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(panelModifyLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxTables1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelModifyLayout.createSequentialGroup()
                        .addComponent(buttonAddRow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAddColumn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelModifyLayout.setVerticalGroup(
            panelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModifyLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(boxTables1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(panelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAddRow)
                        .addComponent(buttonAddColumn))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSqlLayout = new javax.swing.GroupLayout(panelSql);
        panelSql.setLayout(panelSqlLayout);
        panelSqlLayout.setHorizontalGroup(
            panelSqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelSqlLayout.setVerticalGroup(
            panelSqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        setIconImage((new ImageIcon("resources/UI/syringe.png")).getImage());
        setMinimumSize(new java.awt.Dimension(750, 700));
        setPreferredSize(new java.awt.Dimension(750, 700));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        indices.setBackground(new java.awt.Color(39, 41, 42));
        indices.setMinimumSize(new java.awt.Dimension(200, 500));
        indices.setPreferredSize(new java.awt.Dimension(200, 500));

        labelHome.setBackground(new java.awt.Color(2, 156, 216));
        labelHome.setForeground(new java.awt.Color(255, 255, 255));
        labelHome.setText("Home");
        labelHome.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelHome.setName("1"); // NOI18N
        labelHome.setOpaque(true);
        labelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeToHand(evt);
            }
        });

        labelDatabase.setText("Database");
        labelDatabase.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelDatabase.setName("2"); // NOI18N
        labelDatabase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeToHand(evt);
            }
        });

        labelModify.setText("Modify");
        labelModify.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelModify.setName("3"); // NOI18N
        labelModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeToHand(evt);
            }
        });

        labelSql.setText("Custom SQL Query");
        labelSql.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelSql.setName("3"); // NOI18N
        labelSql.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeToHand(evt);
            }
        });

        javax.swing.GroupLayout indicesLayout = new javax.swing.GroupLayout(indices);
        indices.setLayout(indicesLayout);
        indicesLayout.setHorizontalGroup(
            indicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indicesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(indicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelModify, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(labelDatabase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelSql, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addContainerGap())
        );
        indicesLayout.setVerticalGroup(
            indicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indicesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelModify, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSql, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(572, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(indices, gridBagConstraints);

        pane.setMinimumSize(new java.awt.Dimension(550, 500));
        pane.setPreferredSize(new java.awt.Dimension(550, 500));
        pane.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pane, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseClicked
        // TODO add your handling code here:
        JLabel currentLabel = (JLabel) evt.getComponent();
        currentLabel.setOpaque(true);

        //makes all the other labels grey
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] != currentLabel) {
                labels[i].setBackground(ColorEx.MY_DARK_GREY);
                labels[i].setForeground(ColorEx.MY_TEXT_GREY);
            }
        }

        attachPanel(map.get(currentLabel));

        currentLabel.setBackground(ColorEx.MY_BLUE);
        currentLabel.setForeground(Color.WHITE);
    }//GEN-LAST:event_labelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);

        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        // TODO add your handling code here:
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("https://surokkha.gov.bd/"));
            } catch (Exception ex) {
                Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel7MousePressed

    private void changeToHand(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeToHand
        // TODO add your handling code here:
        evt.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_changeToHand

    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed
        // TODO add your handling code here:
        String query = "SELECT TOP " + topSpinner.getValue() + " ";
        for (int i = 0; i < checkBoxArr.length; i++) {
            if (checkBoxArr[i].isSelected()) {
                query += checkBoxArr[i].getText();
                if (i < checkBoxArr.length - 1) {
                    query += ", ";
                }
            }
        }

        if (query.charAt(query.length() - 2) == ',') {
            query = String.copyValueOf(query.toCharArray(), 0, query.length() - 2);
        }

        query += " FROM " + boxTables.getSelectedItem().toString();

        //EXECUTE QUERY
        if (!whereTextField.getText().equals("")) {
            query += " WHERE " + whereTextField.getText();
        }

        try {
            ResultSet set = DBConnection.makeQuery(query);
            ResultSet set2 = DBConnection.makeQuery(query);
            int rowCount = set2.getRow();
            while (set2.next()) {
                rowCount++;
            }
            int colCount = set.getMetaData().getColumnCount();
            columnNames = new String[colCount];

            for (int i = 1; i <= colCount; i++) {
                columnNames[i - 1] = set.getMetaData().getColumnName(i);
            }

            makeColumn(resultTable, columnNames);
            objects = new Object[rowCount][colCount];

            int k = 0;
            while (set.next()) {
                //ADD INTO ROWS
                objects[k] = new Object[colCount];
                for (int i = 0; i < colCount; i++) {
                    objects[k][i] = set.getString(columnNames[i]);
                }

                DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
                model.addRow(objects[k]);
                k++;

            }

            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            TableModel tableModel = resultTable.getModel();

            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                resultTable.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_executeButtonActionPerformed

    void makeColumn(JTable table, String[] string) {

        DefaultTableModel tableModel = new DefaultTableModel();
        for (int i = 0; i < string.length; i++) {
            tableModel.addColumn(string[i]);
        }

        table.setModel(tableModel);
    }

    private void whereTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whereTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_whereTextFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (columnNames == null) {

        } else if (bigTableFrame == null) {

            JFrame jFrame = new JFrame();

            jFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
             
                    bigTableFrame = null;
                    e.getWindow().dispose();
                }
            });

            JPanel panel;
            jFrame.add(panel = new JPanel(new GridLayout(1, 1)));

            JTable newTable = new JTable() {
                @Override
                public boolean editCellAt(int row, int column, EventObject e) {
                    return false;//To change body of generated methods, choose Tools | Templates.
                }
            };

            makeColumn(newTable, columnNames);

            for (Object[] object : objects) {
                DefaultTableModel model = (DefaultTableModel) newTable.getModel();
                model.addRow(object);
            }

            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            TableModel tableModel = newTable.getModel();

            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                newTable.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }

            panel.add(new JScrollPane(newTable));

            jFrame.setResizable(true);
            jFrame.setLocationRelativeTo(null);
            jFrame.setIconImage(new ImageIcon("resources/UI/syringe.png").getImage());
            jFrame.setTitle("Results Table");
            jFrame.pack();
            jFrame.setVisible(true);

            bigTableFrame = jFrame;

        } else {
            bigTableFrame.requestFocus();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddRowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddRowActionPerformed

    private void buttonAddColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddColumnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAddColumnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        new AdminPanel("").setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTables;
    private javax.swing.JComboBox<String> boxTables1;
    private javax.swing.JButton buttonAddColumn;
    private javax.swing.JButton buttonAddRow;
    private javax.swing.JButton executeButton;
    private javax.swing.JPanel indices;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel labelClientId;
    private javax.swing.JLabel labelDatabase;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelModify;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelSql;
    private javax.swing.JPanel pane;
    private javax.swing.JPanel panelCheckbox;
    private javax.swing.JPanel panelDatabase;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelModify;
    private javax.swing.JPanel panelSql;
    private javax.swing.JTable resultTable;
    private javax.swing.JSpinner topSpinner;
    private javax.swing.JTextField whereTextField;
    // End of variables declaration//GEN-END:variables

}
