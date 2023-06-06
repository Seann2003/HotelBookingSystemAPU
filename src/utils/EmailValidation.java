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
public class EmailValidation extends InputVerifier {
    
    @Override
    public boolean verify(JComponent input) {
        String email = ((JTextField) input).getText();
        String regexPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        return (email.matches(regexPattern));
     }


    public boolean shouldYieldFocus(JComponent input){
            boolean emailStatus = verify(input);
            if(!emailStatus){
                JOptionPane.showMessageDialog(null,"Incorrect Email format. Please try again","Email format error message", JOptionPane.INFORMATION_MESSAGE);
            }
            return emailStatus;
    }
    
   
}



