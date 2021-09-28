/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.formdev.flatlaf.FlatDarkLaf;
import dbConnection.DBConnection;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lassassin
 */
public class RegisterForm extends javax.swing.JFrame {

    private JPanel panels[];
    private int state = -1;

    String nextButtonText;

    private HashMap<String, String[]> cityAreaMap = new HashMap<>();

    JPanel[] getPanelsArray(JPanel... panels) {
        return panels;
    }

    /**
     * Creates new form RegisterNIDFrame
     */
    private void init() {
        backButton.setEnabled(false);
        nextButton.setEnabled(false);

        nextButtonText = nextButton.getText();

        panels = getPanelsArray(panelWelcome, panelCovid, panelForm);

        jRadioButton3.setActionCommand("PERSON_NID");
        jRadioButton4.setActionCommand("PERSON_BIRTH_C");

        jRadioButton1.setActionCommand("YES");
        jRadioButton2.setActionCommand("NO");

        jRadioButton5.setActionCommand("NO");
        jRadioButton6.setActionCommand("YES");

        panelCure.setVisible(false);

        labelCured.setVisible(false);

        // I am gonna populate month date and year
        int startingYear = 2021;

        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                monthDropDown.addItem("0" + i);
            } else {
                monthDropDown.addItem("" + i);
            }
        }

        for (int i = 1; i <= 121; i++) {
            yearDropDown.addItem("" + (startingYear - i));
        }

        setDayDropDown(Integer.parseInt(monthDropDown.getSelectedItem().toString()));

        yearDropDown.setMaximumRowCount(7);
        monthDropDown.setMaximumRowCount(7);
        dayDropDown.setMaximumRowCount(7);

        cityDropDown.setMaximumRowCount(10);
        locationDropDown.setMaximumRowCount(10);

        setAge(Integer.parseInt(yearDropDown.getSelectedItem().toString()));

        monthDropDown.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                setDayDropDown(Integer.parseInt(e.getItem().toString()));
            }

        });

        yearDropDown.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                setAge(Integer.parseInt(e.getItem().toString()));
            }
        });

        //Populating City and Location Dropdowns
        try {
            ResultSet set = DBConnection.makeQuery("SELECT * FROM INFORMATION");

            while (set.next()) {
                cityDropDown.addItem(set.getString("City"));
                cityAreaMap.put(set.getString("City"), parseAreas(set.getString("Area")));
            }
            locationDropDown.setModel((new JComboBox<>(cityAreaMap.get(cityDropDown.getSelectedItem().toString()))).getModel());
        } catch (Exception ex) {

        }

        cityDropDown.addItemListener((e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                locationDropDown.setModel((new JComboBox<>(cityAreaMap.get(e.getItem().toString()))).getModel());
            }
        });
    }

    String[] parseAreas(String areas) {
        if (areas.charAt(0) == '"') {
            return (areas.replace(String.valueOf('"'), "").split(","));
        } else {
            String[] string = new String[1];
            string[0] = areas;
            return string;
        }
    }

    void setAge(int year) {
        ageLabel.setText("Current Age: " + ((LocalDate.now()).getYear() - year));
    }

    void setDayDropDown(int month) {

        //remove items
        dayDropDown.removeAllItems();

        int i;
        if (month == 2) {
            //february
            i = 28;
        } else if (month % 2 == 0) {
            i = 30;
        } else {
            i = 31;
        }

        for (int j = 1; j <= i; j++) {
            if (j < 10) {
                dayDropDown.addItem("0" + j);
            } else {
                dayDropDown.addItem("" + j);
            }
        }
    }

    public RegisterForm() {
        initComponents();
        getContentPane().requestFocusInWindow();
        init();
        goForward();
    }

    void goForward() {
        if (state < panels.length - 1) {
            state++;
            attachPanel();
        }
    }

    void goBackward() {
        if (state > 0) {
            state--;
            attachPanel();
        }
    }

    void attachPanel() {
        System.out.println("state " + state);
        try {
            container.remove(container.getComponent(0));
        } catch (Exception e) {

        }

        container.add(panels[state]);

        container.revalidate();
        container.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idGroup = new javax.swing.ButtonGroup();
        panelWelcome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        panelCovid = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        panelCure = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        labelCured = new javax.swing.JLabel();
        panelForm = new javax.swing.JPanel();
        labelTypeOfId = new javax.swing.JLabel();
        dayDropDown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        monthDropDown = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        yearDropDown = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phoneNumberTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cityDropDown = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        locationDropDown = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        wardNumberSpinner = new javax.swing.JSpinner();
        idTextField = new javax.swing.JFormattedTextField();
        cureGroup = new javax.swing.ButtonGroup();
        weeksGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        mainMenuButton = new javax.swing.JButton();
        container = new javax.swing.JPanel();

        panelWelcome.setMinimumSize(new java.awt.Dimension(600, 300));
        panelWelcome.setPreferredSize(new java.awt.Dimension(600, 300));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel3.setText("Welcome");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Please choose one of the following to proceed");

        idGroup.add(jRadioButton3);
        jRadioButton3.setText("Register through NID");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        idGroup.add(jRadioButton4);
        jRadioButton4.setText("Register through Birth Certificate");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelWelcomeLayout = new javax.swing.GroupLayout(panelWelcome);
        panelWelcome.setLayout(panelWelcomeLayout);
        panelWelcomeLayout.setHorizontalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWelcomeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        panelWelcomeLayout.setVerticalGroup(
            panelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWelcomeLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        panelCovid.setMinimumSize(new java.awt.Dimension(600, 300));
        panelCovid.setPreferredSize(new java.awt.Dimension(600, 300));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Were you previously sick with Covid-19?");

        cureGroup.add(jRadioButton1);
        jRadioButton1.setText("Yes");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        cureGroup.add(jRadioButton2);
        jRadioButton2.setText("No");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Has it atleast been 2 weeks since you got sick and were cured?");

        weeksGroup.add(jRadioButton5);
        jRadioButton5.setText("No");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        weeksGroup.add(jRadioButton6);
        jRadioButton6.setText("Yes");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCureLayout = new javax.swing.GroupLayout(panelCure);
        panelCure.setLayout(panelCureLayout);
        panelCureLayout.setHorizontalGroup(
            panelCureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCureLayout.createSequentialGroup()
                .addGroup(panelCureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6)
                    .addComponent(jLabel6))
                .addGap(0, 150, Short.MAX_VALUE))
        );
        panelCureLayout.setVerticalGroup(
            panelCureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCureLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        labelCured.setForeground(new java.awt.Color(255, 153, 153));
        labelCured.setText("If you are still sick from Covid-19, you cannot apply for the vaccine yet. Please get cured first.");

        javax.swing.GroupLayout panelCovidLayout = new javax.swing.GroupLayout(panelCovid);
        panelCovid.setLayout(panelCovidLayout);
        panelCovidLayout.setHorizontalGroup(
            panelCovidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCovidLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelCovidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCured)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel12)
                    .addComponent(panelCure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panelCovidLayout.setVerticalGroup(
            panelCovidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCovidLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(panelCure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCured)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelForm.setMinimumSize(new java.awt.Dimension(600, 300));

        labelTypeOfId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTypeOfId.setText("Birth Certificate Number");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Date of Birth");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Day");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Month");

        yearDropDown.setMaximumSize(new java.awt.Dimension(100, 32767));
        yearDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearDropDownActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Year");

        ageLabel.setText("Current Age: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mobile Number");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("City");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Area");

        jLabel11.setText("Ward Number");

        wardNumberSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(ageLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
                                .addComponent(dayDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yearDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addComponent(phoneNumberTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(cityDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(locationDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11)
                            .addComponent(wardNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(labelTypeOfId)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(idTextField))
                .addGap(19, 19, 19))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelTypeOfId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dayDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(monthDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(yearDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cityDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locationDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(ageLabel)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wardNumberSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration");
        setIconImage((new ImageIcon("resources/UI/syringe.png")).getImage());
        setMinimumSize(new java.awt.Dimension(600, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(46, 48, 50));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(2, 156, 216));
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next ⯈");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        mainMenuButton.setText("Go to Main Menu");
        mainMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(mainMenuButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(nextButton)
                    .addComponent(mainMenuButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        container.setMinimumSize(new java.awt.Dimension(400, 337));
        container.setPreferredSize(new java.awt.Dimension(400, 337));
        container.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void yearDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearDropDownActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void mainMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuButtonActionPerformed
        // TODO add your handling code here:
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_mainMenuButtonActionPerformed


    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:

        //NEXT BUTTON
        goForward();
        check();

        if (nextButton.getText().equals("Register") && isNotEmpty(phoneNumberTextField, idTextField)) {
            registerUser(idGroup.getSelection().getActionCommand());
        }

    }//GEN-LAST:event_nextButtonActionPerformed

    private void check() {
        backButton.setEnabled(true);
        nextButton.setEnabled(false);

        if (panels[state] == panelCovid) {
            if (cureGroup.getSelection() != null) {
                if (cureGroup.getSelection().getActionCommand().equals("NO")) {
                    nextButton.setEnabled(true);
                } else {
                    if (weeksGroup.getSelection() != null) {
                        if (weeksGroup.getSelection().getActionCommand().equals("YES")) {
                            nextButton.setEnabled(true);
                        }
                    }
                }
            }
        }

        if (panels[state] == panelForm) {
            nextButton.setText("Register");
            nextButton.setEnabled(true);
        }
    }

    private void registerUser(String str) {
        try {
            int isAffected;

            if (cureGroup.getSelection().getActionCommand().equals("NO")) {
                isAffected = 0;
            } else {
                isAffected = 1;
            }

            String query = "INSERT INTO COVID_AFFECTED(Identifier, IsAffected, Age_Allowed_Vaccine) VALUES ('" + idTextField.getText() + "' ,"
                    + "'" + isAffected + "',"
                    + "'" + ageLabel.getText().split(" ")[2] + "')";

            
            DBConnection.makeQuery(query);

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 0) {

                try {
                    DBConnection.makeQuery("INSERT INTO " + str + " "
                            + "VALUES ('" + idTextField.getText() + "',"
                            + "'" + parseDate(0) + "',"
                            + "'" + phoneNumberTextField.getText() + "',"
                            + "'" + cityDropDown.getSelectedItem().toString() + "',"
                            + "'" + locationDropDown.getSelectedItem().toString() + "',"
                            + "'" + wardNumberSpinner.getValue() + "',"
                            + "'" + ageLabel.getText().split(" ")[2] + "')");

                } catch (SQLException ex1) {
                    if (ex1.getErrorCode() == 0) {
                        JOptionPane.showMessageDialog(this, "Registration Successful!");
                        new MainMenu().setVisible(true);
                        dispose();
                    }
                    else{
                        System.out.println(ex.getMessage());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sorry you are not old enough for the vaccine");
            }
        }
    }

    private String parseDate(int i) {
        return yearDropDown.getSelectedItem().toString() + "-" + monthDropDown.getSelectedItem().toString() + "-" + dayDropDown.getSelectedItem().toString();
    }

    private boolean isNotEmpty(JTextField... textFields) {
        for (int i = 0; i < textFields.length; i++) {
            if (textFields[i].getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        //BACK BUTTON
        goBackward();

        if (panels[state] == panelWelcome) {
            backButton.setEnabled(false);

            if (idGroup.getSelection() != null) {
                nextButton.setEnabled(true);

            }
        }

        nextButton.setText(nextButtonText);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        panelCure.setVisible(true);
        nextButton.setEnabled(false);

        if (weeksGroup.getSelection() != null) {
            if (weeksGroup.getSelection().getActionCommand().equals("NO")) {
                labelCured.setVisible(true);
            } else {
                nextButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        panelCure.setVisible(false);
        nextButton.setEnabled(true);
        labelCured.setVisible(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        labelCured.setVisible(true);
        nextButton.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        labelCured.setVisible(false);
        nextButton.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        labelTypeOfId.setText("National Identifier (NID)");
        nextButton.setEnabled(true);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        labelTypeOfId.setText("Birth Certificate Number");
        nextButton.setEnabled(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkLaf.setup();

        new DBConnection().getConnection();
        new RegisterForm().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> cityDropDown;
    private javax.swing.JPanel container;
    private javax.swing.ButtonGroup cureGroup;
    private javax.swing.JComboBox<String> dayDropDown;
    private javax.swing.ButtonGroup idGroup;
    private javax.swing.JFormattedTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JLabel labelCured;
    private javax.swing.JLabel labelTypeOfId;
    private javax.swing.JComboBox<String> locationDropDown;
    private javax.swing.JButton mainMenuButton;
    private javax.swing.JComboBox<String> monthDropDown;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel panelCovid;
    private javax.swing.JPanel panelCure;
    private javax.swing.JPanel panelForm;
    private javax.swing.JPanel panelWelcome;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JSpinner wardNumberSpinner;
    private javax.swing.ButtonGroup weeksGroup;
    private javax.swing.JComboBox<String> yearDropDown;
    // End of variables declaration//GEN-END:variables

}
