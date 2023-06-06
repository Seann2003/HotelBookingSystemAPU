/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package components;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import utils.DateValidation;
import utils.FileManager;
import utils.Search;

/**
 *
 * @author User
 */
public class ViewRoom extends javax.swing.JFrame {

     /**
     * Creates new form BookRoom
     */

    public ViewRoom()  {
        initComponents();
         setLocationRelativeTo(null);
         Receipt.setVisible(false);
         PrintReceipt.setEnabled(Receipt.getText().length() > 0); //only allow the button to be pressed when receipt is shown
         try{
                FileManager rf = new FileManager();
                String[] data = rf.fileToArray(new File("C:/Users/User/Documents/NetBeansProjects/Hotel Room/src/TextFiles/Booking.txt"));


                DefaultTableModel model = new DefaultTableModel(new String[]{"Room Number", "Customer Name", "IC Number","Contact Number","Email","Check in Date", "Check out Date", "Number of Pax","Nationality","Price"}, 0){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    }
                    
                };

                for (String line : data) {
                    String[] row = line.split(",");
                    model.addRow(row);
                }
                RoomTable.setModel(model);
         }catch(IOException e){
             System.out.println(e);
         }
         
         
    RoomTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
           int numOfDays;
            double subtotal;
            private final String [] tableArray = new String [10];
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if(!event.getValueIsAdjusting() && RoomTable.getSelectedRow() != -1) { /**Normally used in valueChanged() method in the ListSelectionListener, !event.getValueIsAdjusting() checks whether 
                 the selection of table is still changing , getSelectedRow() != -1 checks whether a column is selected**/
                    for (int i= 0; i<10;i++){
                            tableArray[i] = (RoomTable.getValueAt(RoomTable.getSelectedRow(), i).toString()) ;
                    }
                   Receipt.setVisible(true);
                   Receipt.setText("----------------------------------------------------------------------------------------\n                  The Zephyrus Hotel Booking Receipt        \n\nJalan SS25/2, \nTaman Bukit Emas, \n47829 Petaling Jaya.\n----------------------------------------------------------------------------------------\n");
                   if(null == tableArray[1]){
                       Receipt.setText("Booking not completed, please assign a room number for this booking.");
                   }else{
                       Receipt.setText(Receipt.getText()+ "Room Number: "+tableArray[0]+"\n");
                   }    
                   Receipt.setText(Receipt.getText()+ "Customer Name: " + tableArray[1]+"\n");
                   Receipt.setText(Receipt.getText()+ "Check in Date : " + tableArray[5]+"\n");
                   Receipt.setText(Receipt.getText()+ "Check out Date: " + tableArray[6]+"\n");
                   Receipt.setText(Receipt.getText()+ "----------------------------------------------------------------------------------------\n");
                   SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        numOfDays = DateValidation.getTotalDays(format.parse(tableArray[5]), format.parse(tableArray[6]));
                        subtotal = (double)350*numOfDays;
                        Receipt.setText(Receipt.getText()+ "Sub-Total: RM" + subtotal  + "\n");
                        if ("Malaysian".equals(tableArray[8])){
                            Receipt.setText(Receipt.getText()+ "Total Room Charges (10%) : RM" + subtotal*0.1  + "\n");
                        }else{
                            Receipt.setText(Receipt.getText()+ "Total Room Charges (10%) : RM" + subtotal*0.1  + "\n");
                            Receipt.setText(Receipt.getText()+ "Tourism tax: RM " + numOfDays*10  + "\n");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(ViewRoom.class.getName()).log(Level.SEVERE, null, ex);
                    }

                   Receipt.setText(Receipt.getText()+ "Total Price: RM " + (tableArray[9])+"\n\n\n");
                   Receipt.setText(Receipt.getText()+ "************************************************************************\n                                       Thank You Come Again                   \n************************************************************************");
                   PrintReceipt.setEnabled(true);
                }

            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        createBookingbutton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RoomTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Receipt = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        PrintReceipt = new javax.swing.JButton();
        Clearbtn = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Room List");
        setBackground(new java.awt.Color(255, 204, 153));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Bernard MT Condensed", 0, 18)); // NOI18N
        jLabel1.setText("Receipt");

        createBookingbutton.setBackground(new java.awt.Color(0, 255, 255));
        createBookingbutton.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        createBookingbutton.setForeground(new java.awt.Color(0, 0, 0));
        createBookingbutton.setText("Create Booking");
        createBookingbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBookingbuttonActionPerformed(evt);
            }
        });

        filterButton.setBackground(new java.awt.Color(255, 204, 204));
        filterButton.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        filterButton.setForeground(new java.awt.Color(0, 0, 0));
        filterButton.setText("Search");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        RoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Room ID", "Starting Date", "Ending Date", "Number Of Pax"
            }
        ));
        jScrollPane1.setViewportView(RoomTable);

        BackButton.setBackground(new java.awt.Color(255, 153, 153));
        BackButton.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        BackButton.setForeground(new java.awt.Color(51, 51, 0));
        BackButton.setText("< Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        Receipt.setEditable(false);
        Receipt.setColumns(20);
        Receipt.setRows(5);
        jScrollPane2.setViewportView(Receipt);

        jLabel2.setFont(new java.awt.Font("Bernard MT Condensed", 0, 36)); // NOI18N
        jLabel2.setText("Rooms");

        PrintReceipt.setBackground(new java.awt.Color(153, 153, 255));
        PrintReceipt.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        PrintReceipt.setForeground(new java.awt.Color(51, 51, 0));
        PrintReceipt.setText("Print Receipt");
        PrintReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintReceiptActionPerformed(evt);
            }
        });

        Clearbtn.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        Clearbtn.setText("Clear");
        Clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Clearbtn)
                .addGap(41, 41, 41)
                .addComponent(filterButton)
                .addGap(245, 245, 245)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(createBookingbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PrintReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(132, 132, 132)
                    .addComponent(jLabel2)
                    .addContainerGap(1255, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBookingbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterButton)
                            .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clearbtn))
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(PrintReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(jLabel2)
                    .addContainerGap(540, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createBookingbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBookingbuttonActionPerformed
        CreateBooking listbooking = new CreateBooking();
        listbooking.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createBookingbuttonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
            new Search(SearchField, RoomTable);
    }//GEN-LAST:event_filterButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
                MainPage a = new MainPage();
                a.setVisible(true);
                this.setVisible(false);
       
    }//GEN-LAST:event_BackButtonActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void PrintReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintReceiptActionPerformed
        try {
                Receipt.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ViewRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintReceiptActionPerformed

    private void ClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbtnActionPerformed
        SearchField.setText("");
    }//GEN-LAST:event_ClearbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JButton PrintReceipt;
    private javax.swing.JTextArea Receipt;
    private javax.swing.JTable RoomTable;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton createBookingbutton;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
