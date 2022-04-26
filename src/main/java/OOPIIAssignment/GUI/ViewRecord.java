package OOPIIAssignment.GUI;

import OOPIIAssignment.Class.FileManager;
import OOPIIAssignment.Class.Order;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ViewRecord extends JPanel {
    public final JLabel LblEnterId = new JLabel("Enter Order Id:");
    public final JTextField TbEnterId = new JTextField();
    public final JButton BtnSearch = new JButton("Search");
    FileManager Fm = new FileManager();
    String [] ColNames = { "Id", "CustomerName", "Product Id",
            "Product Brand", "Product Model", "Product Price",
            "Quantity"};
    ArrayList<Order> Orders = new ArrayList<>();
    public ViewRecord (){
        BtnSearch.setForeground(Color.BLACK);
        BtnSearch.setBackground(Color.white);
        Border Line = new LineBorder(Color.BLACK);
        Border Margin = new EmptyBorder(5,15,5,15);
        Border Compound = new CompoundBorder(Line, Margin);
        BtnSearch.setBorder(Compound);
        TbEnterId.setPreferredSize(new Dimension(900,25));
        this.setLayout(new FlowLayout());
        this.add(LblEnterId);
        this.add(TbEnterId,1,1);
        this.add(BtnSearch);

        BtnSearch.addActionListener(e -> {
            try {
                Orders = Fm.ReadArrayListOrderFromFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }



            Boolean IsFound = false;
            int FoundIndex = 0;

            for (Order O : Orders) {
                if(TbEnterId.getText().isBlank()) {
                    break;
                }
                try {
                    if (O.getId() == Integer.parseInt(TbEnterId.getText())) {
                        IsFound = true;
                        break;
                    }
                    FoundIndex++;
                }catch (Exception Ex){}

            }

            if(IsFound) {
                String[][] TestData = new String[1][7];
                TestData[0][0] = String.valueOf(Orders.get(FoundIndex).getId());
                TestData[0][1] = Orders.get(FoundIndex).getCustomerName();
                TestData[0][2] = String.valueOf(Orders.get(FoundIndex).getProductId());
                TestData[0][3] = Orders.get(FoundIndex).getProductBrand();
                TestData[0][4] = Orders.get(FoundIndex).getProductModel();
                TestData[0][5] = String.valueOf(Orders.get(FoundIndex).getProductPrice());
                TestData[0][6] = String.valueOf(Orders.get(FoundIndex).getQuantity());


                JTable TOrderList = new JTable(TestData, ColNames);
                TOrderList.setEnabled(false);
                TOrderList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                FlowLayout FL = new FlowLayout();
                this.removeAll();
                this.setLayout(new FlowLayout());
                this.add(LblEnterId);
                this.add(TbEnterId);
                this.add(BtnSearch);
                this.setLayout(new BorderLayout());
                this.add(new JPanel().add(new JScrollPane(TOrderList)),
                        BorderLayout.SOUTH);
                SwingUtilities.updateComponentTreeUI(this);
            } else {
                TbEnterId.setText("Order Not Found");
            }
        });
    }


}
