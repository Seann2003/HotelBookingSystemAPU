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
public class NameValidation extends InputVerifier {
    
    @Override
    public boolean verify(JComponent input) {
        String name = ((JTextField) input).getText().trim();
        String regexPattern = "^[A-Z][a-zA-Z ]{1,20}$";//shortest name is "E"
        return (name.matches(regexPattern));
     }


    public boolean shouldYieldFocus(JComponent input){
            boolean nameStatus = verify(input);
            if(!nameStatus){
                JOptionPane.showMessageDialog(null,"Incorrect Name format. Numbers and special characters are not allowed. Please try again","Name format error message", JOptionPane.INFORMATION_MESSAGE);
            }
            return nameStatus;
    }
    
   
}
