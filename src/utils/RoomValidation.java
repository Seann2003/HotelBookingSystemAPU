package utils;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;



public class RoomValidation {
    public static boolean checkInputs(String n, String ic, String ctnum, String email, Date sdate, Date edate, String pax, String nationality){
        if(n.isEmpty() || ic.isEmpty() || ctnum.isEmpty() || email.isEmpty() || sdate == null || edate == null || pax.isEmpty() || nationality == null){
            JOptionPane.showMessageDialog(null, "Your input cannot be empty. Please check your input again.","Missing Input Message", JOptionPane.INFORMATION_MESSAGE);
             return false;
        }
       return true;
    }
    
    
    
    public static boolean checkInputs(String value){
         return value.matches("\\d+");
    }
    
    
    public static List<String> checkRoom(int lineIndex) throws IOException{
         String [] contents;
         List <String> unavailableRooms = new ArrayList<>();
         File textfile = new File ("C:/Users/User/Documents/NetBeansProjects/Hotel Room/src/TextFiles/Booking.txt");
        try{
                if(textfile.length() != 0){  // this is to make sure even if the booking is empty, the values can still be printed out
                    contents =  FileManager.fileToArray(textfile);
                    String previousBooking = contents[lineIndex];
                    String[] lastLine = previousBooking.split(",");
                    String newStartDate = lastLine[5];
                    String newEndDate = lastLine[6];
                    for (String line : contents) {
                        String[] values = line.split(",");
                        String startDate = values[5];
                        String endDate = values[6];
                        if(((newStartDate.compareTo(startDate) >= 0 && newStartDate.compareTo(endDate) < 0) ||
                                newStartDate.equals(startDate) ||
                                (newEndDate.compareTo(startDate) > 0 && newEndDate.compareTo(endDate) <= 0)  ||
                                newEndDate.equals(endDate)) && values[0] != null){
                            unavailableRooms.add(values[0]);
                        }
                    }
                }       
        }catch(IOException e){
             e.printStackTrace();
        }
         return unavailableRooms;
    }
}
