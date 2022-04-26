package OOPIIAssignment.GUI;

import OOPIIAssignment.Class.FileManager;
import OOPIIAssignment.Class.Order;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class EnterOrder extends JPanel {
    FileManager Fm = new FileManager();
    public final JLabel Title = new JLabel("Order Form");
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
    public final JButton BtnSave = new JButton("Save");
    public final JButton BtnViewOrder  = new JButton("View Order");
    public EnterOrder(){
        StyleTextBoxes();
        FormEvents();
        AddComp();
    }

    public void FormEvents(){
        BtnSave.addActionListener(e -> {
            ArrayList<Order> Orders = null;
            try {
                Orders = Fm.ReadArrayListOrderFromFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            Order O = new Order(
                    Orders.size() + 1,
                    TbCustomerName.getText(),
                    Integer.parseInt(TbProductId.getText()),
                    TbProductBrand.getText(),
                    TbProductModel.getText(),
                    Float.parseFloat(TbPrice.getText()),
                    Integer.parseInt(TbQuantity.getText())
            );

            Orders.add(O);
            try {
                Fm.SaveArrayListOrderToFile(Orders);
                JOptionPane.showMessageDialog(this, "Order Saved");
                TbCustomerName.setText("");
                TbPrice.setText("");
                TbProductBrand.setText("");
                TbProductModel.setText("");
                TbProductId.setText("");
                TbQuantity.setText("");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        BtnViewOrder.addActionListener(e ->{
            this.removeAll();
            this.add(new ViewOrder());
            SwingUtilities.updateComponentTreeUI(this);
        });
    }
    public void StyleTextBoxes(){
        TbCustomerName.setPreferredSize(new Dimension(200,25));
        TbProductId.setPreferredSize(new Dimension(200, 25));
        TbPrice.setPreferredSize(new Dimension(200,25));
        TbProductModel.setPreferredSize(new Dimension(200, 25));
        TbQuantity.setPreferredSize(new Dimension(200,25));
        TbProductBrand.setPreferredSize(new Dimension(200, 25));
    }
    public void StyleButton (JButton B ){
        B.setForeground(Color.BLACK);
        B.setBackground(Color.white);
        Border Line = new LineBorder(Color.BLACK);
        Border Margin = new EmptyBorder(5,15,5,15);
        Border Compound = new CompoundBorder(Line, Margin);
        B.setBorder(Compound);
        B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                B.setBackground(Color.gray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                B.setBackground(Color.white);
            }
        });
    }
    public void AddComp(){
        StyleButton(BtnSave);
        StyleButton(BtnViewOrder);
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
        GBC.insets.left = 1;
        GBC.gridy = 7; GBC.gridx = 1;
        this.add(BtnViewOrder, GBC);
        GBC.insets.left = 200;
        GBC.gridy = 7; GBC.gridx = 1;
        this.add(BtnSave, GBC);

    }
}
