/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class Search {
    public Search(JTextField searchField, JTable table){
            String input = searchField.getText();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            //("?i) means case-insensitive matching. The regex filter in this case will search for the input regardless of the cases.
            RowFilter<DefaultTableModel,Object> filterByRow = RowFilter.regexFilter("(?i)"+input);
            //TableRowSorter will apply the filter on the table when called upon.
            TableRowSorter<DefaultTableModel> sortTableRow = new TableRowSorter<>(model);
            sortTableRow.setRowFilter(filterByRow);
            table.setRowSorter(sortTableRow);
    }
               
}
