//import java.awt.BorderLayout;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//public class RoomList extends JPanel {
//    
//    public RoomList() throws FileNotFoundException {
//        initComponents();
//    }
//
//    private void initComponents() throws FileNotFoundException {
//        // Read data from file and create table model
//        File file = new File("C:/Users/User/Documents/NetBeansProjects/Hotel Room/src/TextFiles/Room.txt");
//        Scanner scanner = new Scanner(file);
//        ArrayList<String[]> data = new ArrayList<String[]>();
//        while (scanner.hasNextLine()) {
//            String[] line = scanner.nextLine().split(",");
//            data.add(line);
//        }
//        scanner.close();
//
//        String[][] dataArray = new String[data.size()][];
//        for (int i = 0; i < data.size(); i++) {
//            String[] row = data.get(i);
//            dataArray[i] = row;
//        }
//
//        String[] columnNames = {"ID", "Floor", "Status", "Num. of Rooms", "Start Date", "End Date"};
//        DefaultTableModel model = new DefaultTableModel(dataArray, columnNames);
//
//        // Create JTable and JScrollPane
//        JTable table = new JTable(model);
//        JScrollPane scrollPane = new JScrollPane(table);
//
//        // Add scroll pane to panel
//        this.setLayout(new BorderLayout());
//        this.add(scrollPane, BorderLayout.CENTER);
//    }
//    public static void main(String[] args) throws FileNotFoundException {
//        new RoomList();
//    }
//}

