package OOPIIAssignment.GUI;

import OOPIIAssignment.Class.FileManager;
import OOPIIAssignment.Class.Order;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ViewList extends JPanel {
    FileManager Fm = new FileManager();
    String [] ColNames = { "Id", "CustomerName", "Product Id",
            "Product Brand", "Product Model", "Product Price",
            "Quantity"};

    public ViewList() throws IOException, ClassNotFoundException {
        ArrayList<Order> Orders = new ArrayList<>();


        Orders = Fm.ReadArrayListOrderFromFile();
        String [][] TestData = new String [Orders.size()][7];

        int i = 0;
        for(Order O : Orders){
            TestData[i][0] = String.valueOf(O.getId());
            TestData[i][1] = O.getCustomerName();
            TestData[i][2] = String.valueOf(O.getProductId());
            TestData[i][3] = O.getProductBrand();
            TestData[i][4] = O.getProductModel();
            TestData[i][5] = String.valueOf(O.getProductPrice());
            TestData[i][6] = String.valueOf(O.getQuantity());
            i++;
        }

        JTable TOrderList = new JTable(TestData, ColNames);
        TOrderList.setEnabled(false);
        TOrderList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(TOrderList));
    }
}
