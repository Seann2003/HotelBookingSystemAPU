/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package components;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import utils.FileManager;

/**
 *
 * @author User
 */
public class MainPage extends javax.swing.JFrame {
    String file  = "C:/Users/User/Documents/NetBeansProjects/Hotel Room/src/TextFiles/Booking.txt";
    int n;
    /**
     * Creates new form MainPage
     */
    public MainPage() {
        initComponents();
        setLocationRelativeTo(null);
        Earnings();
        TotalCustomers();
    }

    private void Earnings(){
            String[] lastIndexes;                
            try {
                int earnings = 0;       
                lastIndexes = FileManager.getIndexFromEachRow(file, 9);
                for(String price : lastIndexes ){
                    int num =  Integer.parseInt(price);
                    earnings += num;
                }
                Earningstxt.setText("RM" +String.valueOf(earnings));
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void TotalCustomers(){
            String[] lastIndexes;                
            try {
                int total = 0;       
                lastIndexes = FileManager.getIndexFromEachRow(file, 1);
                for(String customers : lastIndexes ){
                    total += 1;
                }
                TotalCustomerstxt.setText(String.valueOf(total));
            } catch (IOException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Earnings1 = new javax.swing.JLabel();
        PageTitle = new javax.swing.JLabel();
        AllRoomsButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        ManageRoombtn = new javax.swing.JButton();
        TotalEarnings = new javax.swing.JLabel();
        Earningstxt = new javax.swing.JLabel();
        TotalCustomerstxt = new javax.swing.JLabel();
        TotalCustomers = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        Earnings1.setText("Earnings");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Staff Interface");
        setForeground(java.awt.Color.red);
        setResizable(false);

        PageTitle.setFont(new java.awt.Font("Bernard MT Condensed", 1, 36)); // NOI18N
        PageTitle.setText("Zephyrus Hotel Staff Interface");
        PageTitle.setMaximumSize(new java.awt.Dimension(172, 16));

        AllRoomsButton.setBackground(new java.awt.Color(255, 153, 153));
        AllRoomsButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        AllRoomsButton.setForeground(new java.awt.Color(0, 0, 0));
        AllRoomsButton.setText("All Rooms");
        AllRoomsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllRoomsButtonActionPerformed(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(255, 153, 153));
        ExitButton.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(0, 0, 0));
        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        ManageRoombtn.setBackground(new java.awt.Color(255, 153, 153));
        ManageRoombtn.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        ManageRoombtn.setForeground(new java.awt.Color(0, 0, 0));
        ManageRoombtn.setText("Manage Room");
        ManageRoombtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageRoombtnActionPerformed(evt);
            }
        });

        TotalEarnings.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        TotalEarnings.setText("Total Earnings:");

        Earningstxt.setFont(new java.awt.Font("Cooper Black", 1, 25)); // NOI18N
        Earningstxt.setText("Earnings txt");

        TotalCustomerstxt.setFont(new java.awt.Font("Cooper Black", 1, 25)); // NOI18N
        TotalCustomerstxt.setText("Total Customers");

        TotalCustomers.setFont(new java.awt.Font("Cooper Black", 0, 36)); // NOI18N
        TotalCustomers.setText("Total Customers:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(AllRoomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(ManageRoombtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TotalCustomers)
                            .addComponent(TotalEarnings))
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Earningstxt)
                            .addComponent(TotalCustomerstxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(PageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(PageTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ManageRoombtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllRoomsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalEarnings)
                    .addComponent(Earningstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalCustomers)
                    .addComponent(TotalCustomerstxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void AllRoomsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllRoomsButtonActionPerformed
        ViewRoom roompage = new ViewRoom();
        roompage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AllRoomsButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
       n = JOptionPane.showConfirmDialog(null, "Would you like to terminate?","Terminate System",JOptionPane.YES_NO_CANCEL_OPTION);
       if(n==JOptionPane.YES_OPTION)
           System.exit(0);
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ManageRoombtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageRoombtnActionPerformed
                ManageRoom a = new ManageRoom();
                a.setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_ManageRoombtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    public ImageIcon loadIcon(String iconName) throws IOException {
    ClassLoader loader = this.getClass().getClassLoader();
    BufferedImage icon = ImageIO.read(loader.getResourceAsStream(iconName));
    return new ImageIcon(icon);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllRoomsButton;
    private javax.swing.JLabel Earnings1;
    private javax.swing.JLabel Earningstxt;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton ManageRoombtn;
    private javax.swing.JLabel PageTitle;
    private javax.swing.JLabel TotalCustomers;
    private javax.swing.JLabel TotalCustomerstxt;
    private javax.swing.JLabel TotalEarnings;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
