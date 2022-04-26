package OOPIIAssignment.GUI;

import OOPIIAssignment.Class.FileManager;
import OOPIIAssignment.Class.Order;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ViewOrder extends JPanel {

    FileManager Fm = new FileManager();
    ArrayList<Order> Orders = new ArrayList<>();
    public final JLabel LblCustomerName = new JLabel("Customer Name");
    public final JTextField TbCustomerName = new JTextField();
    public final JLabel LblProductId = new JLabel("Product Id");
    public final JTextField TbProductId = new JTextField();
    public final JLabel LblProductModel = new JLabel("Product Model");
    public final JTextField TbProductModel = new JTextField();
    public final JLabel LblQuantity = new JLabel("Quantity");
    public final JTextField TbQuantity = new JTextField();
    public final JLabel LblPrice = new JLabel("Price");
    public final JTextField TbPrice = new JTextField();
    public final JLabel LblProductBrand = new JLabel("Product Brand");
    public final JTextField TbProductBrand = new JTextField();

    private void init(){
        ArrayList<Order> Orders = null;
        try {
            Orders = Fm.ReadArrayListOrderFromFile();
            this.Orders = Orders;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        StyleTextBoxes();
        AddComp();
    }

    public ViewOrder(){
        init();
        TbCustomerName.setText(Orders.get(Orders.size() - 1)
                .getCustomerName());
        TbProductBrand.setText(Orders.get(Orders.size() - 1)
                .getProductBrand());
        TbQuantity.setText(String.valueOf(Orders.get(Orders.size() - 1)
                .getQuantity()));
        TbProductModel.setText(Orders.get(Orders.size() - 1)
                .getProductBrand());
        TbPrice.setText(String.valueOf(Orders.get(Orders.size() - 1)
                .getProductPrice()));
        TbProductId.setText(String.valueOf(Orders.get(Orders.size() - 1)
                .getProductId()));


    }

    public void StyleTextBoxes(){
        TbCustomerName.setPreferredSize(new Dimension(200,25));
        TbCustomerName.setEnabled(false);
        TbProductId.setPreferredSize(new Dimension(200, 25));
        TbProductId.setEnabled(false);
        TbPrice.setPreferredSize(new Dimension(200,25));
        TbPrice.setEnabled(false);
        TbProductModel.setPreferredSize(new Dimension(200, 25));
        TbProductModel.setEnabled(false);
        TbQuantity.setPreferredSize(new Dimension(200,25));
        TbQuantity.setEnabled(false);
        TbProductBrand.setPreferredSize(new Dimension(200, 25));
        TbProductBrand.setEnabled(false);
    }

    public void AddComp(){
        GridBagConstraints GBC = new GridBagConstraints();
        GBC.insets.left =10;
        GBC.insets.top = 11;
        this.setLayout(new GridBagLayout());
        GBC.gridy = 1; GBC.gridx = 0;
        this.add(LblCustomerName, GBC);
        GBC.gridy = 1; GBC.gridx = 1;
        this.add(TbCustomerName,GBC);
        GBC.gridy = 2; GBC.gridx = 0;
        this.add(LblProductId, GBC);
        GBC.gridy = 2; GBC.gridx = 1;
        this.add(TbProductId, GBC);
        GBC.gridy = 3; GBC.gridx = 0;
        this.add(LblProductModel, GBC);
        GBC.gridy = 3; GBC.gridx = 1;
        this.add(TbProductModel, GBC);
        GBC.gridy = 4; GBC.gridx = 0;
        this.add(LblProductBrand, GBC);
        GBC.gridy = 4; GBC.gridx = 1;
        this.add(TbProductBrand, GBC);
        GBC.gridy = 5; GBC.gridx = 0;
        this.add(LblQuantity, GBC);
        GBC.gridy = 5; GBC.gridx = 1;
        this.add(TbQuantity, GBC);
        GBC.gridy = 6; GBC.gridx = 0;
        this.add(LblPrice, GBC);
        GBC.gridy = 6; GBC.gridx = 1;
        this.add(TbPrice, GBC);
    }
}
