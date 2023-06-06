/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import components.BookingDetails;

/**
 *
 * @author User
 */
public class Receipt {

    private final int price = 350;
   
    public int calculateTax(String nationality, int days) {
            int newPrice,initialPrice, tax, tourismTax;
            initialPrice = price * days;
            tax = (int) (initialPrice * 0.1);
            tourismTax = 10* days;
            if (nationality.equals("Malaysian")) {
                newPrice = initialPrice + tax;
            } else if (nationality.equals("Non-Malaysian")) {
                newPrice = initialPrice +tax +tourismTax;
            }else {
                newPrice = price;
            }
                return newPrice;
            }      
}
