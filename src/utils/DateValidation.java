/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class DateValidation{
    
        public static void checkdate(JDateChooser dateinput, JLabel label) {
                 SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");

                    dateinput.setDateFormatString("dd/MM/yyyy");

                    Date value =dateinput.getDate();
                    if(value != null){
                        String formattedDate = dateformat.format(value);
                        label.setText(formattedDate);
                    }

        }
        public static int getTotalDays(Date startdate, Date enddate){
            long totalDays = enddate.getTime() - startdate.getTime();
            return (int) TimeUnit.DAYS.convert(totalDays, TimeUnit.MILLISECONDS);  //takes the total time difference in milliseconds (imeUnit.MILLISECONDS) to the number of days (TimeUnit.DAYS)
        }

        public static boolean checkdate(JDateChooser start, JDateChooser end){
            Date starting = start.getDate();
             Date ending = end.getDate();
            LocalDate localStartDate = starting.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localEndDate = ending.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
           if ( localStartDate.compareTo(localEndDate) >= 0)  {
               JOptionPane.showMessageDialog(null,"Starting date shouldn't be later or same date as ending date. Please re-input again.", "Date Error Message", JOptionPane.INFORMATION_MESSAGE);
               return false;
           }
            return true;
        }       

}
