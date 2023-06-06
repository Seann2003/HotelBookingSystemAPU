/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class PhoneNumberValidation extends InputVerifier{
int length;
String phoneStr;
boolean phoneStatus;
    @Override
    public boolean verify(JComponent input) {
        phoneStr = ((JTextField) input).getText().trim();
        length = phoneStr.length();
        if(length < 9 || length >11){
            return false;
        }else if (!(RoomValidation.checkInputs(phoneStr))) {
            return false;
        }
        return true;
    }

 
    @Override
    public boolean shouldYieldFocus(JComponent input) {
        phoneStatus = verify(input);
        if (!phoneStatus) {
            JOptionPane.showMessageDialog(null, "Incorrect phone number format. "
                    + "Phone number should consists of 9 to 11 digits ONLY. Please try again","Incorrect Phone "
                            + "number format", JOptionPane.INFORMATION_MESSAGE);
        }
        return phoneStatus;
    }
 
}


  