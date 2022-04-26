package OOPIIAssignment.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Main extends JFrame {
    public final JPanel ContentPlacement = new JPanel();
    public final JPanel Navbar = new JPanel();
    public final JButton BtnEnterOrder =
            new JButton("Enter Order");
    public final JButton BtnViewList =
            new JButton("View List of Orders");
    public final JButton BtnViewRecord =
            new JButton("View Record From File");
    public final JButton BtnLogout
            = new JButton("Logout/Exit");

    public Main() throws IOException, ClassNotFoundException {
        super("Main");
        Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();
        SetContentPlacement();
        StyleButton(BtnViewList);
        StyleButton(BtnEnterOrder);
        StyleButton(BtnViewRecord);
        StyleButton(BtnLogout);
        SetupNav();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,600);
        this.setContentPane(ContentPlacement);
        this.setLocation(Dim.width/2-this.getSize().width/2,
                Dim.height/2-this.getSize().height/2);
        this.setResizable(false);
        FrameEvents();
    }

    public void SetContentPlacement(){
        ContentPlacement.setLayout(new BorderLayout());
        ContentPlacement.add(Navbar, BorderLayout.NORTH);
    }
    public void SetupNav(){
        Navbar.setBackground(Color.white);
        Navbar.setSize(1000,100);
        Navbar.setLayout(new FlowLayout());
        Navbar.add(BtnEnterOrder);
        Navbar.add(BtnViewList);
        Navbar.add(BtnViewRecord);
        Navbar.add(BtnLogout);
    }

    public void StyleButton(JButton B){
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
                if(B.getText().equals("Logout/Exit")){
                    B.setBackground(Color.RED);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                B.setBackground(Color.white);

            }
        });
    }
    public void FrameEvents(){
        BtnViewList.addActionListener(e -> {
            ContentPlacement.removeAll();
            ContentPlacement.add(Navbar, BorderLayout.NORTH);
            try {
                ContentPlacement.add(new ViewList(),BorderLayout.CENTER);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            SwingUtilities.updateComponentTreeUI(ContentPlacement);
        });



        BtnEnterOrder.addActionListener(e -> {
            ContentPlacement.removeAll();
            ContentPlacement.add(Navbar, BorderLayout.NORTH);
            ContentPlacement.add(new EnterOrder(), BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(ContentPlacement);
        });

        BtnViewRecord.addActionListener(e -> {
            ContentPlacement.removeAll();
            ContentPlacement.add(Navbar, BorderLayout.NORTH);
            ContentPlacement.add(new ViewRecord(), BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(ContentPlacement);
        });

        BtnLogout.addActionListener(e -> {
            System.exit(0);
        });
    }
}
