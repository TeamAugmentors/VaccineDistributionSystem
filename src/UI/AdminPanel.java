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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
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
    ArrayList<String> columnNames;
    ArrayList<String> dashboardColName;

    Object[][] objects;
    JFrame bigTableFrame = null;

    String databaseQuery = null;
    String dashBoardQuery = null;

    HashMap<JLabel, JPanel> map = new HashMap<>();

    HashMap<String, ArrayList<String>> tableColumnMap = new HashMap<>();

    JCheckBox checkBoxArr[];
    String name = "";

    ResultSet currentResultSet;

    private void init() {

        //Make set
        makeLabels(labelHome, labelDashboard, labelDatabase, labelSql);
        makePanels(panelHome, panelDashboard, panelDatabase, panelSql);

        panelEditorPane.setVisible(false);

        //table stuff
        resultTable.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                // your code goes here, whatever you want to do when something changes in the table
            }
        });

        for (int i = 0; i < labels.length; i++) {
            map.put(labels[i], panels[i]);
        }

        //Get name and id
        labelClientId.setText("Connection secure. Client ID: " + DBConnection.clientId);
        labelName.setText("Logged in as " + name);
        executeTableQuery();

        boxTables.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {

                generateColumnCheckboxes(tableColumnMap.get(e.getItem().toString()));
                executeButtonActionPerformed(null);
            }
        });

        System.out.println(boxTables.getItemCount());

    }

    private void executeTableQuery() {
        try {
            //populate tables
            DatabaseMetaData metaData = DBConnection.getGlobalConnection().getMetaData();

            String[] types = {"TABLE"};
            ResultSet tables = metaData.getTables(null, null, "%", types);
            boxTables.removeAllItems();
            while (tables.next()) {
                if (!(tables.getString("TABLE_NAME").charAt(0) >= 'a')) {

                    boxTables.addItem(tables.getString("TABLE_NAME"));
                    ResultSet set = DBConnection.makeQuery("SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = N'" + tables.getString("TABLE_NAME") + "'");

                    ArrayList<String> str = new ArrayList<>();

                    while (set.next()) {
                        str.add(set.getString("COLUMN_NAME"));
                    }

                    tableColumnMap.put(tables.getString("TABLE_NAME"), str);
                    generateColumnCheckboxes(tableColumnMap.get(boxTables.getSelectedItem().toString()));
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR " + ex.getMessage());
        }
    }

    private void generateColumnCheckboxes(ArrayList<String> colNames) {
        int checkboxNum = colNames.size();
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
            JCheckBox checkBox = new JCheckBox(colNames.get(i), true);
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
        panelDashboard = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDashboardTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        vaccineLeft = new javax.swing.JLabel();
        vaccineAdministered = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        vaccineRegister = new javax.swing.JLabel();
        firstDoseNo = new javax.swing.JLabel();
        firstDoseNo1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
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

        };
        panelCheckbox = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        buttonAddRow = new javax.swing.JButton();
        buttonAddColumn = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDeleteColumn = new javax.swing.JButton();
        buttonDeleteRow = new javax.swing.JButton();
        panelSql = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        buttonUploadFile = new javax.swing.JButton();
        panelEditorPane = new javax.swing.JPanel();
        labelFileName = new javax.swing.JLabel();
        buttonExecuteSelectedText = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        indices = new javax.swing.JPanel();
        labelHome = new javax.swing.JLabel();
        labelDashboard = new javax.swing.JLabel();
        labelDatabase = new javax.swing.JLabel();
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

        panelDashboard.setMaximumSize(new java.awt.Dimension(500, 598));
        panelDashboard.setMinimumSize(new java.awt.Dimension(500, 598));
        panelDashboard.setPreferredSize(new java.awt.Dimension(500, 598));
        panelDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDashboardMouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/exit-top-right_1.png"))); // NOI18N
        jButton4.setAlignmentY(0.0F);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jDashboardTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jDashboardTable);

        jLabel3.setText("Vaccine left:");

        jLabel18.setText("Vaccine administered:");

        vaccineLeft.setText("1");

        vaccineAdministered.setText("1");

        jLabel14.setText("Registered for vaccine  :");

        jLabel17.setText("First Dose given             :");

        vaccineRegister.setText("1");

        firstDoseNo.setText("1");

        firstDoseNo1.setText("1");

        jLabel19.setText("Total vaccine required  :");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Currently Registered:");

        jButton5.setText("Show");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDashboardLayout = new javax.swing.GroupLayout(panelDashboard);
        panelDashboard.setLayout(panelDashboardLayout);
        panelDashboardLayout.setHorizontalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDashboardLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(vaccineRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDashboardLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(firstDoseNo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDashboardLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vaccineLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(firstDoseNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(24, 24, 24)
                        .addComponent(vaccineAdministered, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDashboardLayout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDashboardLayout.setVerticalGroup(
            panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDashboardLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(vaccineRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(firstDoseNo))
                .addGap(18, 18, 18)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(firstDoseNo1)
                    .addComponent(jLabel18)
                    .addComponent(vaccineAdministered)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vaccineLeft))
                .addGap(27, 27, 27)
                .addGroup(panelDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(24, 24, 24))
        );

        panelDatabase.setMaximumSize(new java.awt.Dimension(550, 700));
        panelDatabase.setMinimumSize(new java.awt.Dimension(550, 700));
        panelDatabase.setPreferredSize(new java.awt.Dimension(550, 700));

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

        buttonAddRow.setText("+ Row");
        buttonAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddRowActionPerformed(evt);
            }
        });

        buttonAddColumn.setText("+ Column");
        buttonAddColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddColumnActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDeleteColumn.setText("- Column");
        buttonDeleteColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteColumnActionPerformed(evt);
            }
        });

        buttonDeleteRow.setText("- Row");
        buttonDeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatabaseLayout = new javax.swing.GroupLayout(panelDatabase);
        panelDatabase.setLayout(panelDatabaseLayout);
        panelDatabaseLayout.setHorizontalGroup(
            panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatabaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatabaseLayout.createSequentialGroup()
                        .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatabaseLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDatabaseLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(executeButton)
                                    .addComponent(whereTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panelDatabaseLayout.createSequentialGroup()
                        .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonUpdate)
                                .addGroup(panelDatabaseLayout.createSequentialGroup()
                                    .addComponent(buttonAddRow)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonDeleteRow)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonAddColumn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonDeleteColumn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        panelDatabaseLayout.setVerticalGroup(
            panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatabaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(boxTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(topSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatabaseLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15))
                    .addGroup(panelDatabaseLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(whereTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(executeButton)
                .addGap(1, 1, 1)
                .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDatabaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonAddRow)
                        .addComponent(buttonAddColumn)
                        .addComponent(buttonDeleteColumn)
                        .addComponent(buttonDeleteRow)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonUpdate)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        panelSql.setMaximumSize(new java.awt.Dimension(550, 700));
        panelSql.setMinimumSize(new java.awt.Dimension(550, 700));
        panelSql.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel21.setText("Execute a Custom SQL Query");
        panelSql.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        panelSql.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 68, 538, -1));

        jButton3.setText("Execute");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelSql.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 102, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("OR");
        panelSql.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 130, -1, -1));

        jLabel25.setText("________________________________________________");
        panelSql.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, -1, -1));

        jLabel24.setText("________________________________________________");
        panelSql.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 130, -1, -1));

        buttonUploadFile.setText("Upload an .sql file");
        buttonUploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUploadFileActionPerformed(evt);
            }
        });
        panelSql.add(buttonUploadFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 167, -1, -1));

        panelEditorPane.setMaximumSize(new java.awt.Dimension(538, 479));
        panelEditorPane.setMinimumSize(new java.awt.Dimension(538, 479));
        panelEditorPane.setPreferredSize(new java.awt.Dimension(127, 479));

        labelFileName.setText("jLabel23");

        buttonExecuteSelectedText.setText("▶");
        buttonExecuteSelectedText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExecuteSelectedTextActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jEditorPane1);

        javax.swing.GroupLayout panelEditorPaneLayout = new javax.swing.GroupLayout(panelEditorPane);
        panelEditorPane.setLayout(panelEditorPaneLayout);
        panelEditorPaneLayout.setHorizontalGroup(
            panelEditorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(panelEditorPaneLayout.createSequentialGroup()
                        .addComponent(labelFileName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonExecuteSelectedText)))
                .addContainerGap())
        );
        panelEditorPaneLayout.setVerticalGroup(
            panelEditorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditorPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditorPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFileName)
                    .addComponent(buttonExecuteSelectedText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panelSql.add(panelEditorPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 195, 540, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Panel");
        setIconImage((new ImageIcon("resources/UI/syringe.png")).getImage());
        setMinimumSize(new java.awt.Dimension(800, 700));
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
                none(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changeToHand(evt);
            }
        });

        labelDashboard.setText("Dashboard");
        labelDashboard.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        labelDashboard.setName("3"); // NOI18N
        labelDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                none(evt);
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
                none(evt);
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
                none(evt);
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
                    .addComponent(labelDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
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
                .addComponent(labelDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSql, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(372, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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

    private void none(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
        if (evt.getComponent() == labelDashboard) {
            addDashoardData();
        }
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

        refresh();

    }//GEN-LAST:event_none


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
        databaseQuery = query;
        try {
            ResultSet set = DBConnection.makeQuery(query);
            ResultSet set2 = DBConnection.makeQuery(query);

            int rowCount = set2.getRow();
            while (set2.next()) {
                rowCount++;
            }

            int colCount = set.getMetaData().getColumnCount();

            columnNames = new ArrayList<>();

            for (int i = 1; i <= colCount; i++) {
                columnNames.add(set.getMetaData().getColumnName(i));
                if (set.getMetaData().isAutoIncrement(i)) {

                }
            }

            makeColumn(resultTable, columnNames);
            objects = new Object[rowCount][colCount];

            int k = 0;
            while (set.next()) {

                //ADD INTO ROWS
                objects[k] = new Object[colCount];
                for (int i = 0; i < colCount; i++) {
                    objects[k][i] = set.getString(columnNames.get(i));
                }

                getDefaultTableModel(resultTable).addRow(objects[k]);
                k++;

            }

            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            TableModel tableModel = resultTable.getModel();

            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
                resultTable.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }

            currentResultSet = set;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_executeButtonActionPerformed

    void makeColumn(JTable table, ArrayList<String> string) {

        DefaultTableModel tableModel = new DefaultTableModel();
        for (int i = 0; i < string.size(); i++) {
            tableModel.addColumn(string.get(i));
        }

        table.setModel(tableModel);
    }

    private void whereTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whereTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_whereTextFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            makeNewTableAndShow(databaseQuery);
        } catch (SQLException ex) {
            System.out.println("Error in Database big table");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            makeNewTableAndShow(dashBoardQuery);
        } catch (SQLException ex) {
            System.out.println("Error in Dashboard big table");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    DefaultTableModel getDefaultTableModel(JTable table) {
        return (DefaultTableModel) table.getModel();
    }

    private void buttonAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddRowActionPerformed
        // TODO add your handling code here:.
        String table = boxTables.getSelectedItem().toString();

        int colCount = resultTable.getColumnCount();
        JTextField[] fields = new JTextField[colCount];
        String[] labels = new String[colCount];

        Object[] objects = new Object[colCount * 2];
        for (int i = 0, j = 0; i < objects.length - 1; i += 2, j++) {
            labels[j] = tableColumnMap.get(boxTables.getSelectedItem().toString()).get(j);
            objects[i] = labels[j];
            try {
                if (currentResultSet.getMetaData().isAutoIncrement(j + 1)) {
                    fields[j] = new JTextField("AUTO INCREMENTED PRIMARY KEY");
                    fields[j].setEnabled(false);

                    objects[i + 1] = fields[j];

                } else if (currentResultSet.getMetaData().isNullable(j + 1) == 1) {
                    //NULLABLE
                    fields[j] = new JTextField();
                    objects[i] += " @NULLABLE";
                    labels[j] += " @NULLABLE";
                    objects[i + 1] = fields[j];
                } else {
                    fields[j] = new JTextField();
                    objects[i + 1] = fields[j];
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

        int option = JOptionPane.showConfirmDialog(null, objects, "Insert", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {

            String insertQuery = "INSERT INTO " + table + " (";

            for (int i = 0; i < labels.length; i++) {
                if (!fields[i].getText().equals("")) {
                    insertQuery += labels[i].split(" ")[0] + ",";
                }
            }

            insertQuery = String.copyValueOf(insertQuery.toCharArray(), 0, insertQuery.length() - 1);
            insertQuery += ") VALUES (";

            for (int i = 0; i < fields.length; i++) {
                if (fields[i].isEnabled() && !"".equals(fields[i].getText())) {
                    insertQuery += "'" + fields[i].getText() + "',";
                }
            }

            if (insertQuery.charAt(insertQuery.length() - 1) == ',') {
                insertQuery = String.copyValueOf(insertQuery.toCharArray(), 0, insertQuery.length() - 1);
            }

            insertQuery += ")";

            try {
                System.out.println(insertQuery);
                DBConnection.makeQuery(insertQuery);
            } catch (SQLException ex) {
                if (ex.getErrorCode() != 0) {
                    JOptionPane.showMessageDialog(this, "Error! " + ex.getMessage());
                } else {
                    JOptionPane.showMessageDialog(this, "Successfully added!");
                    refresh();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please insert all fields!");
        }
    }//GEN-LAST:event_buttonAddRowActionPerformed

    private boolean isNotEmpty(JTextField... textFields) {
        for (int i = 0; i < textFields.length; i++) {
            if (textFields[i].getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void buttonAddColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddColumnActionPerformed
        // TODO add your handling code here:
        String table = boxTables.getSelectedItem().toString();
        String input = JOptionPane.showInputDialog(this, "Enter Column Name and type\nSeperated by a comma ','");

        try {
            if (input.split(",").length == 2) {
                String colName = input.split(",")[0];
                String type = input.split(",")[1];

                String updateQuery = "ALTER TABLE " + table + " ADD " + colName + " " + type;

                try {
                    DBConnection.makeQuery(updateQuery);

                } catch (SQLException e) {
                    if (e.getErrorCode() != 0) {
                        JOptionPane.showMessageDialog(this, "Error! " + e.getMessage());
                    } else {
                        JOptionPane.showMessageDialog(this, "Successfully added!");

                        refresh();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Invalid input!");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_buttonAddColumnActionPerformed

    private void refresh() {
        String item = boxTables.getSelectedItem().toString();
        executeTableQuery();
        boxTables.setSelectedItem(item);
        executeButtonActionPerformed(null);
    }

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteColumnActionPerformed
        // TODO add your handling code here:
        String table = boxTables.getSelectedItem().toString();
        String input = JOptionPane.showInputDialog(this, "Enter Column Name\n(Case Sensitive)");

        String updateQuery = "ALTER TABLE " + table + " DROP COLUMN " + input;

        try {
            DBConnection.makeQuery(updateQuery);

        } catch (SQLException e) {
            if (e.getErrorCode() != 0) {
                JOptionPane.showMessageDialog(this, "Error! " + e.getMessage());
            } else {
                JOptionPane.showMessageDialog(this, "Successfully deleted!");

                refresh();
            }
        }
    }//GEN-LAST:event_buttonDeleteColumnActionPerformed

    private void buttonDeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteRowActionPerformed
        // TODO add your handling code here:

        try {
            String table = boxTables.getSelectedItem().toString();
            int columnCount = resultTable.getColumnCount();
            String[] colName = new String[columnCount];
            String[] data = new String[columnCount];
            String deleteQuery = "DELETE FROM " + table + " WHERE ";
            int j = 0;

            for (int i = 0; i < columnCount; i++) {
                if (resultTable.getModel().getValueAt(resultTable.getSelectedRow(), i) != null) {
                    colName[j] = tableColumnMap.get(table).get(i);
                    data[j] = resultTable.getModel().getValueAt(resultTable.getSelectedRow(), i).toString();
                    j++;
                }
            }

            for (int i = 0; i < j; i++) {
                if (i < j - 1) {
                    deleteQuery += colName[i] + "='" + data[i] + "' AND ";
                } else {
                    deleteQuery += colName[i] + "='" + data[i] + "'";
                }
            }

            try {
                DBConnection.makeQuery(deleteQuery);

            } catch (SQLException e) {
                if (e.getErrorCode() != 0) {
                    JOptionPane.showMessageDialog(this, "Error! " + e.getMessage() + "--->" + deleteQuery);
                } else {
                    if (boxTables.getSelectedItem().toString().equals("PERSON_NID") || boxTables.getSelectedItem().toString().equals("PERSON_BIRTH_C")) {
                        deleteFromVaccine(data[0]);
                        deleteFromCovidAffected(data[0]);
                    }
                    JOptionPane.showMessageDialog(this, "Successfully deleted!");
                    refresh();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_buttonDeleteRowActionPerformed

    private void deleteFromVaccine(String identifier) {
        String query = "DELETE FROM VACCINE WHERE Identifier = '" + identifier + "'";
        try {
            DBConnection.makeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Something went wrong");
        }
    }

    private void deleteFromCovidAffected(String identifier) {
        String query = "DELETE FROM COVID_AFFECTED WHERE Identifier = '" + identifier + "'";
        try {
            DBConnection.makeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Something went wrong");
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void buttonUploadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUploadFileActionPerformed
        // TODO add your handling code here:

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "sql", "SQL", "txt");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            BufferedReader reader;
            StringBuilder sb = new StringBuilder();
            try {
                reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                String line = reader.readLine();
                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = reader.readLine();
                }
                jEditorPane1.setText(sb.toString());

                panelEditorPane.setVisible(true);
                labelFileName.setText(chooser.getSelectedFile().getName());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_buttonUploadFileActionPerformed

    private void buttonExecuteSelectedTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExecuteSelectedTextActionPerformed
        // TODO add your handling code here:
        boolean success = false;
        if (!jEditorPane1.getSelectedText().trim().equals("")) {
            try {
                String query = jEditorPane1.getSelectedText().trim();
                makeNewTableAndShow(query);

            } catch (SQLException ex) {
                if (ex.getErrorCode() == 0) {
                    JOptionPane.showMessageDialog(this, "Query successful!");
                    success = true;
                } else {
                    JOptionPane.showMessageDialog(this, "ERROR! " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_buttonExecuteSelectedTextActionPerformed

    void makeNewTableAndShow(String query) throws SQLException {
        ResultSet resultSet = DBConnection.makeQuery(query);
        ResultSet rowCountingSet = DBConnection.makeQuery(query);
        int rowCount = 0;
        while (rowCountingSet.next()) {
            rowCount++;
        }

        ResultSetMetaData metaData = resultSet.getMetaData();
        ArrayList<String> columnNames = new ArrayList<>();
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i + 1));
        }

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

        Object[][] objects = new Object[rowCount][columnNames.size()];

        int k = 0;
        while (resultSet.next()) {

            //ADD INTO ROWS
            objects[k] = new Object[columnNames.size()];
            for (int i = 0; i < columnNames.size(); i++) {
                objects[k][i] = resultSet.getString(columnNames.get(i));
            }

            getDefaultTableModel(newTable).addRow(objects[k]);
            k++;

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
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (!jTextField1.getText().equals(""))
        try {
            makeNewTableAndShow(jTextField1.getText().trim());
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 0) {
                JOptionPane.showMessageDialog(this, "Query successful!");
            } else {
                JOptionPane.showMessageDialog(this, "ERROR! " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        addDashoardData();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void panelDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDashboardMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelDashboardMouseClicked

    private void addDashoardData() {
        int registered = 0;
        int firstDoseGiven = 0;
        int secondDoseGiven = 0;
        try {
            String query = "SELECT p.Identifier, p.Age, p.City, p.Area, v.First_Dose_Date, v.Second_Dose_Date "
                    + "FROM VACCINE v JOIN (SELECT Birth_Registration_Number AS 'Identifier' , Birth_Date, Mobile_Number, City, Area, Ward_Number, Age "
                    + "FROM PERSON_BIRTH_C UNION SELECT NID AS 'Identifier', Birth_Date, Mobile_Number, City, Area, Ward_Number, Age FROM PERSON_NID) p "
                    + "ON (v.Identifier = p.Identifier) order by p.Age desc, v.First_Dose_Date asc";
            dashBoardQuery = query;
            ResultSet set = DBConnection.makeQuery(query);

            int colCount = set.getMetaData().getColumnCount();

            dashboardColName = new ArrayList<>();
            dashboardColName.add("Serial");
            for (int i = 1; i <= colCount; i++) {
                dashboardColName.add(set.getMetaData().getColumnName(i));
            }
            dashboardColName.add("Center");
            makeColumn(jDashboardTable, dashboardColName);

            while (set.next()) {
                if (set.getString(dashboardColName.get(5)) == null) {
                    firstDoseGiven++;
                }
                if (set.getString(dashboardColName.get(6)) == null) {
                    secondDoseGiven++;
                }
                if (set.getString(dashboardColName.get(5)) != null && set.getString(dashboardColName.get(6)) != null) {
                    continue;
                }
                ArrayList<Object> temp = new ArrayList<>();
//                Resultset set = DBConnection.makeQuery("SELECT Serial as 'Serial' FROM Covid_Affected");
                temp.add(registered + 1);
                for (int i = 1; i <= colCount; i++) {

                    temp.add(set.getString(dashboardColName.get(i)));
                }
                //Get the city name
                String center = getCenter(set.getString(dashboardColName.get(3)));
                temp.add(center);
                getDefaultTableModel(jDashboardTable).addRow(temp.toArray());
                registered++;
            }
        } catch (SQLException ex) {
            System.out.println("Something wrong");
        }
        firstDoseNo1.setText(String.valueOf(firstDoseGiven + secondDoseGiven));
        vaccineRegister.setText(String.valueOf(registered));
        firstDoseNo.setText(String.valueOf(registered - firstDoseGiven));
        updateAmountLeft();
        updateAmountAdministered();
    }

    private void updateAmountLeft() {
        String query = "SELECT SUM(Amount_Left) AS Amount_Left FROM STORAGE";
        try {
            ResultSet set = DBConnection.makeQuery(query);
            if (set.next()) {
                vaccineLeft.setText(String.valueOf(set.getInt("Amount_Left")));
//                System.out.println(set.getString("Amount_Left"));
            } else {
                System.out.println("Unavailable");
            }
        } catch (SQLException ex) {
            System.out.println("Error in faching amount left info");
        }
    }

    private void updateAmountAdministered() {
        String query = "SELECT SUM(Amount_Administered) AS Amount_Administered FROM STORAGE";
        try {
            ResultSet set = DBConnection.makeQuery(query);
            if (set.next()) {
                vaccineAdministered.setText(String.valueOf(set.getInt("Amount_Administered")));
//                System.out.println(set.getString("Amount_Administered"));
            } else {
                System.out.println("Unavailable");
            }
        } catch (SQLException ex) {
            System.out.println("Error in faching amount administered info");
        }
    }

    private String getCenter(String city) {
        String query = "SELECT Institute_Name FROM VACCINATION_CENTER WHERE Center_ID = "
                + "ANY(SELECT Center_ID FROM STORAGE WHERE Amount_Left = ANY(SELECT MAX(Amount_Left) "
                + "FROM (SELECT v.*, s.Amount_Left "
                + "FROM STORAGE s JOIN (SELECT * FROM VACCINATION_CENTER WHERE City = "
                + "ANY((SELECT City FROM PERSON_BIRTH_C UNION SELECT City FROM PERSON_NID) INTERSECT SELECT city FROM VACCINATION_CENTER)) v "
                + "ON v.Center_ID = s.Center_ID) VS GROUP BY City HAVING City = '" + city + "'))";
//        System.out.println(query);
        try {
            ResultSet set = DBConnection.makeQuery(query);
            if (set.next()) {
                return set.getString("Institute_Name");
            }
        } catch (SQLException ex) {
            System.out.println("Error in faching center info");
        }
        return "N/A";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        new DBConnection().getConnection();
        new AdminPanel("").setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTables;
    private javax.swing.JButton buttonAddColumn;
    private javax.swing.JButton buttonAddRow;
    private javax.swing.JButton buttonDeleteColumn;
    private javax.swing.JButton buttonDeleteRow;
    private javax.swing.JButton buttonExecuteSelectedText;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JButton buttonUploadFile;
    private javax.swing.JButton executeButton;
    private javax.swing.JLabel firstDoseNo;
    private javax.swing.JLabel firstDoseNo1;
    private javax.swing.JPanel indices;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JTable jDashboardTable;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelClientId;
    private javax.swing.JLabel labelDashboard;
    private javax.swing.JLabel labelDatabase;
    private javax.swing.JLabel labelFileName;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelSql;
    private javax.swing.JPanel pane;
    private javax.swing.JPanel panelCheckbox;
    private javax.swing.JPanel panelDashboard;
    private javax.swing.JPanel panelDatabase;
    private javax.swing.JPanel panelEditorPane;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelSql;
    private javax.swing.JTable resultTable;
    private javax.swing.JSpinner topSpinner;
    private javax.swing.JLabel vaccineAdministered;
    private javax.swing.JLabel vaccineLeft;
    private javax.swing.JLabel vaccineRegister;
    private javax.swing.JTextField whereTextField;
    // End of variables declaration//GEN-END:variables

}
