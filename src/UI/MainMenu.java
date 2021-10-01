/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.formdev.flatlaf.FlatDarkLaf;

import com.qoppa.pdfWriter.PDFPrinterJob;
import dbConnection.DBConnection;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lassassin
 */
public class MainMenu extends javax.swing.JFrame {

    /**
         * Creates new form Registration
     */
    JLabel[] labels;

    public MainMenu() {
        initComponents();
        JLabel[] labels = {label2, label3, label4, label5, label6, label7, label8, label9, label10};
        this.labels = labels;
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

        panelCertificate = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label10 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        labelBg = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();
        rights = new javax.swing.JLabel();

        panelCertificate.setMaximumSize(new java.awt.Dimension(590, 850));
        panelCertificate.setMinimumSize(new java.awt.Dimension(590, 850));
        panelCertificate.setLayout(null);

        label1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(51, 51, 51));
        label1.setText("jLabel2");
        panelCertificate.add(label1);
        label1.setBounds(150, 330, 130, 30);

        label5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label5.setForeground(new java.awt.Color(51, 51, 51));
        label5.setText("jLabel2");
        panelCertificate.add(label5);
        label5.setBounds(150, 580, 130, 30);

        label3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label3.setForeground(new java.awt.Color(51, 51, 51));
        label3.setText("jLabel2");
        panelCertificate.add(label3);
        label3.setBounds(150, 500, 130, 30);

        label10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label10.setForeground(new java.awt.Color(51, 51, 51));
        label10.setText("jLabel2");
        panelCertificate.add(label10);
        label10.setBounds(460, 500, 130, 70);

        label2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(51, 51, 51));
        label2.setText("jLabel2");
        panelCertificate.add(label2);
        label2.setBounds(150, 370, 130, 30);

        label4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label4.setForeground(new java.awt.Color(51, 51, 51));
        label4.setText("jLabel2");
        panelCertificate.add(label4);
        label4.setBounds(150, 540, 130, 30);

        label6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label6.setForeground(new java.awt.Color(51, 51, 51));
        label6.setText("jLabel2");
        panelCertificate.add(label6);
        label6.setBounds(460, 330, 130, 30);

        label7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label7.setForeground(new java.awt.Color(51, 51, 51));
        label7.setText("jLabel2");
        panelCertificate.add(label7);
        label7.setBounds(460, 370, 130, 40);

        label8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label8.setForeground(new java.awt.Color(51, 51, 51));
        label8.setText("jLabel2");
        panelCertificate.add(label8);
        label8.setBounds(460, 410, 130, 40);

        label9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        label9.setForeground(new java.awt.Color(51, 51, 51));
        label9.setText("jLabel2");
        panelCertificate.add(label9);
        label9.setBounds(460, 450, 130, 40);

        labelBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/cbg.png"))); // NOI18N
        panelCertificate.add(labelBg);
        labelBg.setBounds(0, 0, 600, 820);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vaccine Distribution System");
        setIconImage((new ImageIcon("resources/UI/syringe.png")).getImage());
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(552, 386));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 65)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 156, 216));
        jLabel1.setText("Vaccine");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(226, 226, 226));
        jLabel3.setText("Distribution System");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 54, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(2, 156, 216));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Register for Vaccination");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Check Position");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Get Certificate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 90, 0);
        jPanel1.add(jPanel3, gridBagConstraints);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 400);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/bg.png"))); // NOI18N
        getContentPane().add(bg);
        bg.setBounds(30, 10, 440, 340);

        rights.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rights.setText("Developed by Augmentors Ⓒ 2021. All rights reserved");
        rights.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rights.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightsMouseClicked(evt);
            }
        });
        getContentPane().add(rights);
        rights.setBounds(110, 340, 290, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    int i = 0;
    private void rightsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightsMouseClicked
        // TODO add your handling code here:
        i++;

        if (i == 4) {
            rights.setText("You are about to be an admin");
        }

        if (i == 7) {
            i = 0;

            new Login().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_rightsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new RegisterForm().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog(this, "NID/Birth Registration Number");

        String query = "SELECT u.NID, id.FullName, u.Birth_Date, id.Gender, v.First_Dose_Date, v.Vaccine_Brand, v.Second_Dose_Date, v.Vaccine_Brand, vc.Institute_Name  FROM VACCINE v INNER JOIN "
                + "(SELECT * FROM PERSON_NID UNION SELECT * FROM PERSON_BIRTH_C) u ON u.NID = v.identifier INNER JOIN "
                + "IDENTIFIER_INFORMATION id ON id.Identifier = v.Identifier INNER JOIN "
                + "VACCINATION_CENTER vc ON vc.Center_ID = v.Center_Id WHERE v.Identifier = ";

        query += input + " AND v.Second_Dose_Date IS NOT NULL ";

        try {
            int i = 0;
            ResultSet set = DBConnection.makeQuery(query);

            while (set.next()) {
                for (; i < set.getMetaData().getColumnCount(); i++) {
                    System.out.println(set.getMetaData().getColumnName(i + 1));
                    labels[i].setText(set.getString(set.getMetaData().getColumnName(i + 1)));
                }
            }

            if (i != 0) {
                //show certificate
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("Select a directory to save certificate PDF");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            
                //
                // disable the "All files" option.
                //
                chooser.setAcceptAllFileFilterUsed(false);
                //    
                if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    new PrintPanelToPDF().makePdf(chooser.getSelectedFile().toString().replace("\\","/"));

                    System.out.println("getCurrentDirectory(): "
                            + chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : "
                            + chooser.getSelectedFile());
                } else {
                    new PrintPanelToPDF().makeFrame();
                    
                    System.out.println("No Selection ");
                }

                label1.setText(String.format("%.0f", Math.random() * 1000000000));

            } else {
                JOptionPane.showMessageDialog(this, "Sorry, your are not eligible for a certificate at the moment");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        System.out.println(query);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            String input = JOptionPane.showInputDialog(this, "NID/Birth Registration Number");
            String query = "SELECT Serial FROM COVID_AFFECTED WHERE Identifier = '";
            query += input + "'";
            ResultSet set = DBConnection.makeQuery(query);
            if (set.next()) {
                String serialNo = set.getString("Serial");
                JOptionPane.showMessageDialog(this, "Your serial is: " + serialNo);
            }else {
                JOptionPane.showMessageDialog(this, "Register first or check if you entered NID/Birth Registration number correctly");
            }
        } catch (SQLException ex) {
            System.out.println("Error in showing serial no in main menu");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public class PrintPanelToPDF implements Printable {

        public void makePdf(String directoryString) {
            try {
                // create a PDF Printer Job
                PDFPrinterJob printer = (PDFPrinterJob) PDFPrinterJob.getPrinterJob();
                // set the printable object 
                printer.setPrintable(new PrintPanelToPDF());
                // set number of copies to 1 
                printer.setCopies(1);
                // print and save the document
                printer.print(directoryString + "/certificate.pdf");
                // output done message 
                System.out.println("Done!");
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }

        public void makeFrame() {
            JFrame frame = new JFrame();
            frame.setMinimumSize(new Dimension(617, 850));
            frame.setLocationRelativeTo(null);
            frame.add(panelCertificate);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.pack();

            panelCertificate.revalidate();
            panelCertificate.repaint();
        }

        public int print(Graphics g, PageFormat pf, int pageIndex) {
            if (pageIndex == 0) {

                g.translate(0, 0);

                makeFrame();
                // print the panel to the graphics on page 0
                panelCertificate.print(g);
                return Printable.PAGE_EXISTS;
            } else {
                return Printable.NO_SUCH_PAGE;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel labelBg;
    private javax.swing.JPanel panelCertificate;
    private javax.swing.JLabel rights;
    // End of variables declaration//GEN-END:variables
}
