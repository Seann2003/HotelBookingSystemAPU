/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static utils.FileManager.fileToArray;


/**
 *
 * @author User
 */





public class FileManager {
        
    public static String[] fileToArray(File textFile) throws IOException {
        ArrayList<String> fileArray = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(textFile))){
            String line;
            while ((line = br.readLine()) != null) {
                fileArray.add(line);
            }   
        } catch (IOException e) {
           System.out.print("Error occured while reading the file" + e);
        }
        return fileArray.toArray(String[]::new);
    }

        public static void appendtoFile(File file, String[] content) throws IOException {

            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                String line = String.join(",", content);
                writer.println(line);
            }catch (Exception e){
            System.out.println("Error occurred while appending to the file: " + e);
             }
        }    
        
        public static boolean updateIndexContent(File textFile, int indexLine, int indexValue, String replaceValue ) throws IOException{
            String[] contentArray = fileToArray(textFile);
            String line = contentArray[indexLine];
            String[] lineArray = line.split(",");
            lineArray[indexValue] = replaceValue;
            String updatedLine = String.join(",", lineArray);
            contentArray[indexLine] = updatedLine;
            try (PrintWriter writer = new PrintWriter(new FileWriter(textFile))) {
                 for (String content : contentArray) {
                     writer.println(content);
                 }
                 return true;
            }catch (IOException e) {
                System.out.println("Error occurred while writing to the file: " + e);
            }
            return true;
        }
        
        public static void convertTableToTextFile(File textfile, JTable table) throws IOException{
            DefaultTableModel model;
            int rowNum, columnNum;
            StringBuilder sb;
            
            model = (DefaultTableModel) table.getModel();
            rowNum = model.getRowCount();
            columnNum = model.getColumnCount();
            
            sb = new StringBuilder();
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < columnNum; j++) {
                    sb.append(model.getValueAt(i, j));  
                    if (j < columnNum - 1) {
                        sb.append(",");
                    }
                }
                sb.append("\n");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(textfile))) {
                    writer.write(sb.toString());
            } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        }
        
        public static String[] getIndexFromEachRow(String textfile, int columnIndex) throws IOException{
            ArrayList <String> contentArray = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(textfile))){
                String line;
                String[] values ;
                while ((line = br.readLine()) != null) {
                    values = line.split(",");
                    String indexContent = values[columnIndex];
                    contentArray.add(indexContent);
                }
            }catch (IOException e){
                 System.out.println("Failed to read index from each row: " + e.getMessage());
            }
            return contentArray.toArray(new String[0]);
        }
   }

