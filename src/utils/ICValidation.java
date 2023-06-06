/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ICValidation extends InputVerifier {
    
    @Override
    public boolean verify(JComponent input) {
        String icStr = ((JTextField) input).getText().trim();
        int length = icStr.length();
        if(length != 12){
            return false;
        }else if (!(RoomValidation.checkInputs(icStr))) {
            return false;
        }
        return true;
    }

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        boolean icStatus = verify(input);
        if (!icStatus) {
            JOptionPane.showMessageDialog(null, "Incorrect IC format. IC should consists of 12 digits ONLY"
                    + ". Please try again","IC Number Format Message", JOptionPane.INFORMATION_MESSAGE);        
        }
        return icStatus;
    }

    
}

