/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
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
import javax.swing.JFrame;
import database.database_functions;
import functions.datearray;

/**
 *
 * @author root
 */
public class entry extends javax.swing.JFrame {

    /**
     * Creates new form entry
     */
    static iofunctions io;
    static int token,imilk,ipaneer,ighee,ichach,iold,itotal;
    static int lmilk,lpaneer,lghee,lchach,lold,ltotal;
    static String name;
    static int old_remain;
    static datearray dateobject;
    static database_functions db;
    public entry() {
        initComponents();
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        name = new String();
        io = new iofunctions();
        old_remain = 0;
        db = new database_functions();
        dateobject = new datearray();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        month = new javax.swing.JComboBox<>();
        year = new javax.swing.JTextField();
        qmilk = new javax.swing.JTextField();
        rmilk = new javax.swing.JTextField();
        qghee = new javax.swing.JTextField();
        rghee = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        etoken = new javax.swing.JLabel();
        ename = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        jLabel1.setText("Month");

        jLabel2.setText("Year");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 15)); // NOI18N
        jLabel3.setText("Milk Qty");

        jLabel4.setText("Milk Price");

        jLabel5.setText("Ghee Qty");

        jLabel6.setText("Ghee Price");

        etoken.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N

        ename.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N

        jButton1.setText("+Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etoken, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ename, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addGap(67, 67, 67)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(qmilk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rmilk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(qghee, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rghee, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(etoken, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(qmilk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rmilk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(qghee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rghee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        int[] arrayofdate = dateobject.returndate();
//        date.setText(arrayofdate[0]+"");
 //       month.setText(arrayofdate[1]+1+"");
  //      year.setText(arrayofdate[2]+"");
            int[] datadate = dateobject.returndate();
            int totalcustomer = db.numberofrecords("customer");
            String[][] result = db.retrieve("select token,name from customer",  2);
            int loopi = 0;
            while(loopi<totalcustomer)
            {
                if (token == Integer.parseInt(result[loopi][0]))
                {
                  name = result[loopi][1];
                  etoken.setText(token+"");
                  ename.setText(name);
                  break;
                }
                loopi++;
            }
        
            qmilk.setText("");
            rmilk.setText("");
            qghee.setText("");
            rghee.setText("");
            year.setText(datadate[2]+"");
            month.setSelectedIndex(datadate[1]);
            result = db.retrieve("select milkmedium,ghee from owner", 2);
            rmilk.setText(result[0][0]);
            rghee.setText(result[0][1]);
    }//GEN-LAST:event_formComponentShown

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Collect and calculate values 
        String smonth = month.getSelectedItem().toString();
        String syear = year.getText();
        String sdate = smonth+"-"+syear;
        int sqmilk = Integer.parseInt(qmilk.getText());
        int srmilk = Integer.parseInt(rmilk.getText());
        int sqghee = Integer.parseInt(qghee.getText());
        int srghee = Integer.parseInt(rghee.getText());
        int stmilk = sqmilk*srmilk;
        int stghee = sqghee*srghee;
        int sold = 0;
        String[][] result = db.retrieve("select remain from record where token = '"+token+"' "
                + "ORDER BY sn DESC LIMIT 1", 1);
        if (result[0][0].equals("noentry"))
        {
            sold = 0;
        }
        else
        {
            sold = Integer.parseInt(result[0][0]);
        }
        int stotal = stmilk+stghee;
        int sgrand = stotal+sold;
        int spay = 0;
        int sremain = sgrand;
        
        // check for pre entry
        result = db.retrieve("select sn from record where token = '"+token+"' AND "
                + "date = '"+sdate+"'", 1);
        if(result[0][0].equals("noentry"))
        {
            db.create("insert into record(token,date,milkq,milkr,milkt,gheeq,gheer,gheet,"
                    + "old,total,grand,pay,remain) values('"+token+"','"+sdate+"','"+sqmilk+"',"
                            + "'"+srmilk+"','"+stmilk+"','"+sqghee+"','"+srghee+"','"+stghee+"',"
                                    + "'"+sold+"','"+stotal+"','"+sgrand+"','"+spay+"','"+sremain+"')");
        }
        else
        {
            db.create("update record set milkq = milkq+'"+sqmilk+"' , "
                    + "milkt = milkq*milkr , gheeq = gheeq+'"+sqghee+"' , "
                            + "gheet = gheeq*gheer , total = milkt+gheet , grand = old+total , "
                            + "remain = grand where token='"+token+"' AND date = '"+sdate+"'");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void show(int intoken) {
        token = intoken;
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
            java.util.logging.Logger.getLogger(entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new entry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ename;
    private javax.swing.JLabel etoken;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JTextField qghee;
    private javax.swing.JTextField qmilk;
    private javax.swing.JTextField rghee;
    private javax.swing.JTextField rmilk;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
