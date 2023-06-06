/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import utils.DateValidation;
import utils.FileManager;
import utils.Receipt;

/**
 *
 * @author User
 */
class CustomerBooking {
     private String name, ic, contactnum,email,nationality;
     
     public CustomerBooking(String name,String ic, String contactnum, String email, String nationality){
        this.name = name;
        this.ic = ic;
        this.contactnum = contactnum;
        this.email = email;
        this.nationality = nationality;
    }
     public String getName(){
         return this.name;
     }
     
     public String getIC(){
         return this.ic;
     }
     
     public String getContactNum(){
         return this.contactnum;
     }
     
     public String getEmail(){
         return this.email;
     }     
     
     public String getNationality(){
         return this.nationality;
     }  
     public String getBookingDetails(){
         String message = "Name: " + getName() + "\n"+ "IC: " + getIC() + "\n"+ "Contact Number: " + getContactNum() + "\n"+ "Email: " + getEmail() + "\n"+ "Nationality: " + getNationality() + "\n";
        return message;
     }
}

public class BookingDetails extends CustomerBooking{
    private String pax, customerDetails, message;
    private Date  start, end;
    public BookingDetails(String name,String ic, String contactnum, String email,  Date start, Date end, String pax, String nationality){
        super(name,ic,contactnum,email,nationality);
        this.start = start;// start date
        this.end = end;// end date
        this.pax = pax;
    }
    
    public Date getStart(){
        return this.start;
    }
        
    public Date getEnd(){
        return this.end;
    }    
    
    public String getPax(){
        return this.pax;
    }
    @Override
    public  String getBookingDetails(){
        customerDetails = super.getBookingDetails();
       message = customerDetails +"Start Date: " + getStart() + "\n"+ "End Date: " + getEnd() + "\n"+ "Pax: " + getPax();
       return message;
     }
            
    public void displayBooking(){
       String message = getBookingDetails();
       JOptionPane.showMessageDialog(null, message,"Customer Booking", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String RecordBooking() {
        try{        
            SimpleDateFormat defaultdate = new SimpleDateFormat("dd/MM/yyyy");
            Receipt receipt = new Receipt();
            BookingDetails booking = new BookingDetails(getName(), getIC(), getContactNum(), getEmail(), getStart(), getEnd(), getPax(), getNationality());
            booking.displayBooking();
            int days = DateValidation.getTotalDays(getStart(), getEnd());
            int totalPrice = receipt.calculateTax(getNationality(), days );
            String[] content = {null,getName(), getIC(), getContactNum(), getEmail(), defaultdate.format(getStart()), defaultdate.format(getEnd()), getPax(), getNationality(),String.valueOf(totalPrice)};
             String path= "C:/Users/User/Documents/NetBeansProjects/Hotel Room/src/TextFiles/Booking.txt";
            FileManager rf = new FileManager();
            rf.appendtoFile(new File(path),content);
            return "Success";
                
            }
            catch (IOException ex)
            {
                return ex.toString();
            }
    }

}

   
  
 
