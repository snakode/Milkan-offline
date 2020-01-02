/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import functions.iofunctions;
import functions.common;
import static gui.updatecustomer.io;
import gui.entry;
import gui.records;
import gui.pay;
import gui.showpayments;
import javax.swing.JFrame;
import database.database_functions;
import gui.printbill;
/**
/**
 *
 * @author root
 */
public class selector extends javax.swing.JFrame {

    /**
     * Creates new form selector
     */
    DefaultListModel<String> defaultmodel;
    int check;
    static iofunctions io;
    static entry goentry;
    static records gorecords;
    static pay gopay;
    static showpayments goshowpayments;
    static database_functions db;
    static String choice;
    static printbill goprintbill;
    public selector() {
        initComponents();
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        check = 0;
        defaultmodel = new DefaultListModel();
        io = new iofunctions();
        goentry = new entry();
        gorecords = new records();
        gopay = new pay();
        goshowpayments = new showpayments();
        db = new database_functions();
        goprintbill = new printbill();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        token = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Token");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(token, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(token, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String stoken = token.getText();
       if(stoken.equals(""))
       {
           io.alert("Please Enter Valid Token Value");
       }
       else
       {
              String[][] result = db.retrieve("select token from customer where token = '"+stoken+"'", 1);
              if(result[0][0].equals("noentry"))
              {
                  io.alert("Please Enter Valid Token Value");
              }
              else
              {
                  if(choice.equals("entry"))
                  {
                    goentry.show(Integer.parseInt(stoken));
                  }
                  else if(choice.equals("records"))
                  {
                    gorecords.show(Integer.parseInt(stoken));  
                  }
                  else if(choice.equals("pay"))
                  {
                      gopay.show(Integer.parseInt(stoken));
                  }
                  else if(choice.equals("payments"))
                  {
                      goshowpayments.show(Integer.parseInt(stoken));
                  }
                  else if(choice.equals("bills"))
                  {
                      goprintbill.show(Integer.parseInt(stoken));
                  }
              }
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
            String[][] result = db.retrieve("select token,name from customer", 2);
            for(String[] x : result)
            {
                try
                {
                String stoken = x[0];
                String sname = x[1];
                defaultmodel.addElement(stoken+"   "+sname);
                }
                catch(Exception e)
                {
                    
                }
            }
        jList1.setModel(defaultmodel);
    }//GEN-LAST:event_formComponentShown

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        String string = jList1.getSelectedValue();
        int i = 0,token=0,ten=1;
        while(string.charAt(i) != ' ')
        {
            token = token*ten + (Character.getNumericValue(string.charAt(i)));
            ten = ten * 10;
            i++;
        }
              if(choice.equals("entry"))
                  {
                    goentry.show(token);
                  }
                  else if(choice.equals("records"))
                  {
                    gorecords.show(token);  
                  }
                  else if(choice.equals("pay"))
                  {
                      gopay.show(token);
                  }
                  else if(choice.equals("payments"))
                  {
                      goshowpayments.show(token);
                  }
                  else if(choice.equals("bills"))
                  {
                      goprintbill.show(token);
                  }
    }//GEN-LAST:event_jList1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        defaultmodel.clear();
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void show(String parachoice) {
        choice = parachoice;
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
            java.util.logging.Logger.getLogger(selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new selector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField token;
    // End of variables declaration//GEN-END:variables
}
