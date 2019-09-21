/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeingrams.measurements;



import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import java.awt.image.VolatileImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.text.*;
import javax.swing.JTable;

/**
 *
 * @author Vihanga
 */
public class TableViewComplexitySize extends javax.swing.JFrame {

    /**
     * Creates new form ExchangeTable
     */
    public TableViewComplexitySize(VolatileImage msg) {
        initComponents();
        whitespacecount();
        punctuationcount();
        Totalcount();
        Wordcount();
        jTable1.createVolatileImage(60,60);
           setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         
    }
    

    private TableViewComplexitySize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel48 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 0, 0));
        jLabel48.setText("  Search Using Line Number");
        jLabel48.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 19)); // NOI18N
        jLabel2.setText("Total White Spaces");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Digital-7 Mono", 0, 80)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\icons\\recycle-full.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\icons\\globe.png")); // NOI18N
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 63, 60));

        jLabel19.setFont(new java.awt.Font("Calibri Light", 1, 19)); // NOI18N
        jLabel19.setText("Total Complexity");
        jLabel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 15, 170, -1));

        jLabel21.setFont(new java.awt.Font("Digital-7 Mono", 0, 70)); // NOI18N
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 170, 80));

        jPanel7.setBackground(new java.awt.Color(102, 51, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 63, -1));

        jLabel23.setFont(new java.awt.Font("Calibri Light", 1, 19)); // NOI18N
        jLabel23.setText("Line Count");
        jLabel23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 15, 170, -1));

        jLabel24.setFont(new java.awt.Font("Digital-7 Mono", 0, 70)); // NOI18N
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\icons\\arrow-retweet.png")); // NOI18N
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 70));

        jButton10.setBackground(new java.awt.Color(51, 0, 153));
        jButton10.setForeground(new java.awt.Color(255, 255, 0));
        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\icons\\Calculator.png")); // NOI18N
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Line No", "Line Content", "CS ", "CI"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jPanel8.setBackground(new java.awt.Color(51, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 63, -1));

        jLabel26.setFont(new java.awt.Font("Calibri Light", 1, 19)); // NOI18N
        jLabel26.setText("Charactor Count");
        jLabel26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 15, 170, -1));

        jLabel27.setFont(new java.awt.Font("Digital-7 Mono", 0, 70)); // NOI18N
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\icons\\addressbook.png")); // NOI18N
        jPanel8.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 70));

        jButton1.setBackground(new java.awt.Color(51, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\icons\\invoice.png")); // NOI18N
        jButton1.setText("Search All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 0, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\icons\\printer_add.png")); // NOI18N
        jButton2.setText("Print Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);

        try {
            ResultSet rs = Database.getData("SELECT distinct * FROM codesize WHERE lineNo like'" + jTextField4.getText() + "%" + "' ");
            while (rs.next()) {

                Vector v = new Vector();
                   v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
             
                dtm.addRow(v);

            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
      try{
            Process p=Runtime.getRuntime().exec("C:\\Windows\\System32\\calc.exe");
            JFrame j=new JFrame();
            p.equals(j);
      }catch(Exception e){
          e.printStackTrace();
      }
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);

        try {
            ResultSet rs = Database.getData("SELECT distinct * FROM codesize b ORDER BY b.lineNo ASC  ");
            while (rs.next()) {

                Vector v = new Vector();
                      v.add(rs.getString(1));
                       v.add(rs.getString(2));
                        v.add(rs.getString(3));
                v.add(rs.getString(4));
               
                 
             
          
                dtm.addRow(v);

            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //    Map par=new HashMap();
      //  par.put(null, null);
      MessageFormat header=new MessageFormat("Report For Complexity due to size");
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        try{
          /*  String url="jdbc:mysql://localhost:3306/CodeInGrams";
            String username="root";
            String password="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection)DriverManager.getConnection(url, username,password);
            String reppath="C:\\Users\\VIHANGA\\Documents\\GitHub\\Complexity-Measuring-Tool\\tool\\CodeInGrams\\src\\reports\\report1.jrxml";
            JasperPrint print=JasperFillManager.fillReport(reppath, par,con);
            JasperViewer.viewReport(print, false);*/
          
          jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
          

        }
        catch(java.awt.print.PrinterException e)
        {
           System.err.format("Cannot Print Report Page %s \n", e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
      private void whitespacecount() {
	        
	        
	        try {
	            ResultSet rs=Database.getData("SELECT * FROM codewhite b ORDER BY b.id DESC LIMIT 1  ");
	            if(rs.next()){
	            
	             
	                jLabel13.setText(rs.getString("whitespace"));
	            
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	      
	      
	    }
	    
      private void punctuationcount() {
	        
	        
	        try {
	            ResultSet rs=Database.getData("SELECT * FROM codewhite b ORDER BY b.id DESC LIMIT 1  ");
	            if(rs.next()){
	            
	             
	                jLabel24.setText(rs.getString("punctuation"));
	            
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	      
	      
	    }
    
     
           
      
       
      
      
     private void Totalcount() {
      
      
      try {
          ResultSet rs=Database.getData("SELECT * FROM codecom b ORDER BY b.id DESC LIMIT 1  ");
          if(rs.next()){
          
           
              jLabel21.setText(rs.getString("total"));
          
          }
          
      } catch (Exception e) {
          e.printStackTrace();
      }
    
    
  }
     
        private void Wordcount() {
      
      
      try {
          ResultSet rs=Database.getData("SELECT * FROM codewhite b ORDER BY b.id DESC LIMIT 1  ");
          if(rs.next()){
          
           
              jLabel27.setText(rs.getString("words"));
          
          }
          
      } catch (Exception e) {
          e.printStackTrace();
      }
    
    
  }
     
     
    /**
     * @param args the command line arguments
     */
    public  void main(String args[]) {
         try {

            
             UIManager.setLookAndFeel(SyntheticaBlackStarLookAndFeel());
            

        } catch (Exception e) {
            e.printStackTrace();

        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableViewComplexitySize().setVisible(true); 
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    private LookAndFeel SyntheticaBlackStarLookAndFeel() {
        try {
            UIManager.setLookAndFeel(SyntheticaBlackStarLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TableViewComplexitySize.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SyntheticaBlackStarLookAndFeel();
    }

}
