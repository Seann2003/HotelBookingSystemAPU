/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package components;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import utils.DateValidation;
import utils.EmailValidation;
import utils.ICValidation;
import utils.PhoneNumberValidation;
import utils.FileManager;
import utils.NameValidation;
import utils.Receipt;
import utils.RoomValidation;
import utils.Search;

/**
 *
 * @author User
 */
public class ManageRoom extends javax.swing.JFrame {
        boolean isICValid,isPhoneValid, isEmailValid, inputsValid, isDateValid, isNameValid;
        DefaultTableModel table,model;
        int choosenRow, newPrice;
        File textfile = new File("C:/Users/User/Documents/NetBeansProjects/Hotel Room/src/TextFiles/Booking.txt");
    /**
     * Creates new form ManageRoom
     */
    public ManageRoom() {
        initComponents();
        setLocationRelativeTo(null);
        StartingDate.setMinSelectableDate(new Date());
        EndingDate.setMinSelectableDate(new Date());
        DateValidation.checkdate(StartingDate,jLabel11);
        DateValidation.checkdate(EndingDate,jLabel7);
        
         try{
               FileManager rf = new FileManager();
               String[] data = rf.fileToArray(textfile);


               model = new DefaultTableModel(new String[]{"Room Number", "Customer Name", "IC Number","Contact Number","Email","Check in Date", "Check Out Date", "Number of Pax","Nationality","Price"}, 0){
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    }
                    
                };

                for (String line : data) {
                    String[] row = line.split(",");
                    model.addRow(row);
                }
                
                BookingTable.setModel(model);
         }catch(IOException e){
             System.out.println(e);
         }

        BookingTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                private String [] info = new String [10];
                public void valueChanged(ListSelectionEvent event) {
                    if(!event.getValueIsAdjusting() && BookingTable.getSelectedRow() != -1) { /**Normally used in valueChanged() method in the ListSelectionListener, !event.getValueIsAdjusting() checks
                        whether the selection of table is still changing , getSelectedRow() != -1 checks whether a column is selected**/
                        for (int i= 0; i<10;i++){
                                info[i] = (BookingTable.getValueAt(BookingTable.getSelectedRow(), i).toString());
                        }

                        try { 
                                Customertxt.setText(info[1]);
                                ICnum.setText(info[2]);
                                Contactnumtxt.setText(info[3]);
                                Emailtxt.setText(info[4]);
                                Date startingdate = new SimpleDateFormat("dd/MM/yyyy").parse(info[5]);
                                Date endingdate = new SimpleDateFormat("dd/MM/yyyy").parse(info[6]);
                                StartingDate.setDate(startingdate);
                                EndingDate.setDate(endingdate);
                                int paxIndex = Integer.parseInt(info[7]) - 1;
                                Paxnum.setSelectedIndex(paxIndex);
                                if("Malaysian".equals(info[8])){
                                      Malaysianbtn.setSelected(true);
                                }else if ("Non-Malaysian".equals(info[8])){
                                      nonMalaysianbtn.setSelected(true);
                                }   
                        } catch (ParseException ex) {
                            Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            });

        }
         public boolean isInputValid() {
                    Customertxt.setInputVerifier(new NameValidation());
                    ICnum.setInputVerifier(new ICValidation());
                    Emailtxt.setInputVerifier(new EmailValidation());   
                    Contactnumtxt.setInputVerifier(new PhoneNumberValidation());   
                    isNameValid =  Customertxt.getInputVerifier().shouldYieldFocus(Customertxt);
                    isICValid =  ICnum.getInputVerifier().shouldYieldFocus(ICnum);
                    isPhoneValid = Contactnumtxt.getInputVerifier().shouldYieldFocus(Contactnumtxt);
                    isEmailValid =  Emailtxt.getInputVerifier().shouldYieldFocus(Emailtxt);
                    isDateValid = DateValidation.checkdate(StartingDate,EndingDate);
                    return isNameValid && isICValid && isEmailValid && isPhoneValid && isDateValid;
         }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        nationalityGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookingTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        StartingDate = new com.toedter.calendar.JDateChooser();
        Contactnumtxt = new javax.swing.JTextField();
        Malaysianbtn = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        nonMalaysianbtn = new javax.swing.JRadioButton();
        Emailtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Customertxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ICnum = new javax.swing.JTextField();
        EndingDate = new com.toedter.calendar.JDateChooser();
        BackButton = new javax.swing.JButton();
        Updatebtn = new javax.swing.JButton();
        Deletebtn = new javax.swing.JButton();
        Clearbtn = new javax.swing.JButton();
        Paxnum = new javax.swing.JComboBox<>();
        SearchField = new javax.swing.JTextField();
        ClearSearchField = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        Refreshbtn = new javax.swing.JButton();

        jButton5.setText("View");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manage Room");
        setResizable(false);

        BookingTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(BookingTable);

        jLabel5.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel5.setText("Email:");

        Contactnumtxt.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        Contactnumtxt.setSelectionColor(new java.awt.Color(51, 51, 255));
        Contactnumtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactnumtxtActionPerformed(evt);
            }
        });

        nationalityGroup.add(Malaysianbtn);
        Malaysianbtn.setText("Malaysian");

        jLabel7.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel7.setText("Ending Date Of Stay:");

        nationalityGroup.add(nonMalaysianbtn);
        nonMalaysianbtn.setText("Non-Malaysian");

        Emailtxt.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        Emailtxt.setSelectionColor(new java.awt.Color(51, 51, 255));
        Emailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailtxtActionPerformed(evt);
            }
        });

        jLabel6.setText("Nationality: ");

        jLabel8.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel8.setText("Number of Pax:");

        jLabel3.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel3.setText("IC/Passport: ");

        jLabel2.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel2.setText("Customer Name:");

        jLabel4.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel4.setText("Contact Number:");

        Customertxt.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        Customertxt.setSelectionColor(new java.awt.Color(51, 51, 255));
        Customertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomertxtActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        jLabel11.setText("Starting Date Of Stay:");

        ICnum.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        ICnum.setSelectionColor(new java.awt.Color(51, 51, 255));
        ICnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ICnumActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(255, 153, 153));
        BackButton.setFont(new java.awt.Font("Eras Medium ITC", 0, 14)); // NOI18N
        BackButton.setForeground(new java.awt.Color(51, 51, 0));
        BackButton.setText("< Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        Updatebtn.setBackground(new java.awt.Color(102, 255, 102));
        Updatebtn.setForeground(new java.awt.Color(0, 0, 0));
        Updatebtn.setText("Update");
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });

        Deletebtn.setBackground(new java.awt.Color(204, 0, 0));
        Deletebtn.setText("Delete");
        Deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletebtnActionPerformed(evt);
            }
        });

        Clearbtn.setText("Clear");
        Clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearbtnActionPerformed(evt);
            }
        });

        Paxnum.setEditable(true);
        Paxnum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", " " }));

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        ClearSearchField.setText("Clear");
        ClearSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearSearchFieldActionPerformed(evt);
            }
        });

        SearchButton.setBackground(new java.awt.Color(255, 153, 153));
        SearchButton.setForeground(new java.awt.Color(0, 0, 0));
        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        Refreshbtn.setText("Refresh");
        Refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Paxnum, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Malaysianbtn)
                            .addGap(41, 41, 41)
                            .addComponent(nonMalaysianbtn))
                        .addComponent(Customertxt)
                        .addComponent(ICnum)
                        .addComponent(Contactnumtxt)
                        .addComponent(Emailtxt)
                        .addComponent(EndingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StartingDate, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(Refreshbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(ClearSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(Updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(452, 452, 452))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Customertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClearSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Refreshbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ICnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Contactnumtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(StartingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(EndingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Paxnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Malaysianbtn)
                                .addComponent(jLabel6))
                            .addComponent(nonMalaysianbtn)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clearbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailtxtActionPerformed
            Emailtxt.setInputVerifier(new EmailValidation());   
    }//GEN-LAST:event_EmailtxtActionPerformed

    private void CustomertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomertxtActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_CustomertxtActionPerformed

    private void ICnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ICnumActionPerformed
        ICnum.setInputVerifier(new ICValidation());
    }//GEN-LAST:event_ICnumActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        MainPage a = new MainPage();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
         String name,ic, email,contactnum,pax,nationality = null;
         String [] values;
        choosenRow = BookingTable.getSelectedRow();
        if (choosenRow != -1){
                    Date  startdate,enddate;
                    name = Customertxt.getText();
                    ic = ICnum.getText();
                    contactnum =Contactnumtxt.getText();
                    email = Emailtxt.getText();        
                    startdate = StartingDate.getDate();
                    enddate = EndingDate.getDate();
                    pax =String.valueOf(Paxnum.getSelectedItem());
                    if (Malaysianbtn.isSelected()){
                         nationality = Malaysianbtn.getText();
                    }else if(nonMalaysianbtn.isSelected()){
                        nationality = nonMalaysianbtn.getText();
                    }
                    inputsValid = RoomValidation.checkInputs(name, ic, contactnum, email, startdate, enddate, pax,nationality);
                    int numOfDays =  DateValidation.getTotalDays(startdate,enddate);
                    Receipt receipt = new Receipt();
                    newPrice = receipt.calculateTax(nationality,numOfDays);
                    if (inputsValid && isInputValid()){
                          SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                              try {
                                       values = new String[] {name, ic, contactnum, email, dateformat.format(startdate), dateformat.format(enddate), pax, nationality, String.valueOf(newPrice)};
                                       for (int i = 0; i<values.length ;i++){
                                           FileManager.updateIndexContent(textfile, choosenRow, i + 1, values[i]);
                                       }
                                       SelectRoom a = new SelectRoom(choosenRow);
                                       a.setVisible(true);
                                       this.setVisible(false);
                                       if (true){
                                               JOptionPane.showMessageDialog(null, "Changes have been made.","Changes successful message", JOptionPane.INFORMATION_MESSAGE);
                                       }
                              } catch (IOException ex) {
                                  Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
                              }
                   }
        }
    
    }//GEN-LAST:event_UpdatebtnActionPerformed

    private void ClearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearbtnActionPerformed
                    Customertxt.setText("");
                    ICnum.setText("");
                    Contactnumtxt.setText("");
                    Emailtxt.setText("");        
                    StartingDate.setDate(null);
                   EndingDate.setDate(null);
                   Paxnum.setSelectedIndex(0);
                   nationalityGroup.clearSelection();
    }//GEN-LAST:event_ClearbtnActionPerformed

    private void ContactnumtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactnumtxtActionPerformed
        Contactnumtxt.setInputVerifier(new PhoneNumberValidation());   
    }//GEN-LAST:event_ContactnumtxtActionPerformed

    private void DeletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletebtnActionPerformed
             choosenRow = BookingTable.getSelectedRow();
             if(choosenRow != -1){
                 int confirmation = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this booking?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
                 if(confirmation == JOptionPane.YES_OPTION){
                     table = (DefaultTableModel) BookingTable.getModel();
                     table.removeRow(choosenRow);
                     BookingTable.repaint();
                     try {
                         FileManager.convertTableToTextFile(textfile, BookingTable);
                     } catch (IOException ex) {
                         Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                    
             }
    }//GEN-LAST:event_DeletebtnActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
            
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
            new Search(SearchField, BookingTable);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void ClearSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearSearchFieldActionPerformed
                SearchField.setText("");
    }//GEN-LAST:event_ClearSearchFieldActionPerformed

    private void RefreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshbtnActionPerformed
        BookingTable.revalidate();
        BookingTable.repaint();
    }//GEN-LAST:event_RefreshbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTable BookingTable;
    private javax.swing.JButton ClearSearchField;
    private javax.swing.JButton Clearbtn;
    private javax.swing.JTextField Contactnumtxt;
    private javax.swing.JTextField Customertxt;
    private javax.swing.JButton Deletebtn;
    private javax.swing.JTextField Emailtxt;
    private com.toedter.calendar.JDateChooser EndingDate;
    private javax.swing.JTextField ICnum;
    private javax.swing.JRadioButton Malaysianbtn;
    private javax.swing.JComboBox<String> Paxnum;
    private javax.swing.JButton Refreshbtn;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchField;
    private com.toedter.calendar.JDateChooser StartingDate;
    private javax.swing.JButton Updatebtn;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup nationalityGroup;
    private javax.swing.JRadioButton nonMalaysianbtn;
    // End of variables declaration//GEN-END:variables
}
