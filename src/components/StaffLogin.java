/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import utils.FileManager;


public class StaffLogin implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JTextField usernameText;
    private final JPasswordField passwrdText;
    private final JLabel passwrdLabel;
    private final JLabel usernameLabel;
    private final JButton loginButton;
    private final JLabel success;

    public StaffLogin() {
        frame = new JFrame("The Zephyrus Hotel");
        panel = new JPanel();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null) ; 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
       panel.setLayout(new BorderLayout());
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);
        
        usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        panel.add(usernameText);
        
        passwrdLabel = new JLabel("Password");
        passwrdLabel.setBounds(10, 60, 80, 25);
        panel.add(passwrdLabel);

        passwrdText = new JPasswordField(20);
        passwrdText.setBounds(100, 60, 165, 25);
        panel.add(passwrdText);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        panel.add(loginButton);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameText.getText();
            String password = new String(passwrdText.getPassword());
            boolean login_details = false;
            String textfile = "C:/Users/User/Documents/NetBeansProjects/Hotel Room/src/TextFiles/Staff.txt";
            try {
                FileManager rf = new FileManager();
                String[] lines = rf.fileToArray(new File(textfile));
                for (String line : lines) {
                    String[] values = line.split(",");
                    if (username.equals(values[0]) && password.equals(values [1])){
                        login_details = true;
                        MainPage a = new MainPage();
                        a.setVisible(true);
                        frame.setVisible(false);
                        break;
                    }
                }
                if (!login_details){
                    showMessageDialog(null, "Incorrect staff credentials. Please try again.","Login Credentials Error Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException err) {
                System.out.println(err);
            }
        }



    public static void main(String[] args) {
        new StaffLogin();
    }



}
