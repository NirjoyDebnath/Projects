package librarymanagement;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */

public class IssuBook extends javax.swing.JFrame {

    

    
    

    /**
     * Creates new form IssuBook
     */
    public IssuBook() throws ClassNotFoundException, SQLException {
        initComponents();
       dNamecombo(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BookName = new javax.swing.JLabel();
        SData = new javax.swing.JTextField();
        SName = new javax.swing.JLabel();
        StudentName = new javax.swing.JLabel();
        IdData = new javax.swing.JTextField();
        IssuDate = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        DueDate = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        BookData = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        BookName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BookName.setText("Book Name");
        jPanel1.add(BookName);
        BookName.setBounds(50, 80, 110, 22);

        SData.setBackground(new java.awt.Color(204, 204, 255));
        SData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(SData);
        SData.setBounds(240, 140, 251, 30);

        SName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SName.setText("Student Name");
        jPanel1.add(SName);
        SName.setBounds(50, 140, 140, 22);

        StudentName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        StudentName.setText("Mobile No");
        jPanel1.add(StudentName);
        StudentName.setBounds(50, 200, 100, 22);

        IdData.setBackground(new java.awt.Color(255, 204, 204));
        IdData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(IdData);
        IdData.setBounds(240, 200, 251, 30);

        IssuDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        IssuDate.setText("Issue Date");
        jPanel1.add(IssuDate);
        IssuDate.setBounds(50, 260, 110, 22);

        jTextField1.setBackground(new java.awt.Color(204, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(240, 268, 251, 30);

        DueDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DueDate.setText("Due Date");
        jPanel1.add(DueDate);
        DueDate.setBounds(50, 320, 100, 22);

        jTextField2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(240, 330, 250, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Issue");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(230, 410, 83, 31);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(420, 410, 77, 31);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(240, 20, 250, 20);

        BookData.setBackground(new java.awt.Color(204, 204, 255));
        BookData.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(BookData);
        BookData.setBounds(240, 80, 251, 30);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap(269, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
           public void dNamecombo() throws ClassNotFoundException, SQLException
    {
        DBConnector dbc = new DBConnector("root", "", "librarydata", "localhost:3306");
        
        try {
            dbc.connect();
            Statement query = dbc.dbcon.createStatement();
            ResultSet answer = query.executeQuery("select Book_Name from library_manegment_book_information");
            
            while(answer.next())
            {
                jComboBox1.addItem(answer.getString("Book_Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssuBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                        
    public void infoMsg(String message, String title)
    {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       mainpage mp= new mainpage();
        mp.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        

        
        
        
            String BookName=BookData.getText();
            String SName=SData.getText();
            String StudentId=IdData.getText();
            String IssuDate=jTextField1.getText();
            String DueDate=jTextField2.getText();
            
            //Class.forName("com.mysql.jdbc.driver");
             DBConnector dbc = new DBConnector("root", "", "issu", "localhost:3306");
        
        try {
            dbc.connect();
            Statement insert = dbc.dbcon.createStatement();
            /*ResultSet answer = insert.executeQuery("select * from issuebook where BookName=\""+SName+"\"");
            insert.executeUpdate("insert into issuebook (BookName,StudentName,StudentId,IssuDate,DueDate) values(\""+BookData+"\",\""+SData+"\",\""+IdData+"\",\""+jTextField1+"\",\""+jTextField2+"\")");
         */
            String sql="INSERT INTO `issubook`(`BookName`, `StudentName`, `StudentId`, `IssuDate`, `DueDate`) VALUES('"+BookName+"','"+SName+"','"+StudentId+"','"+IssuDate+"','"+DueDate+"')";
               insert.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Inserted Sucessfully");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            // TODO add your handling code here:
            DBConnector dbc = new DBConnector("root", "", "librarydata", "localhost:3306");
            
            
            dbc.connect();
            Statement query = dbc.dbcon.createStatement();
            ResultSet answer = query.executeQuery("select * from library_manegment_book_information where Book_Name=\""+jComboBox1.getSelectedItem()+"\"");
            
            while(answer.next())
            {
            BookData.setText(answer.getString("Book_Name"));
            } 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IssuBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IssuBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(IssuBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IssuBook().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(IssuBook.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(IssuBook.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookData;
    private javax.swing.JLabel BookName;
    private javax.swing.JLabel DueDate;
    private javax.swing.JTextField IdData;
    private javax.swing.JLabel IssuDate;
    private javax.swing.JTextField SData;
    private javax.swing.JLabel SName;
    private javax.swing.JLabel StudentName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void Referesh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
