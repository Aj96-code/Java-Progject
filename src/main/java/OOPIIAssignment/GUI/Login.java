package OOPIIAssignment.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Login extends JFrame {
    private final JPanel ViewPanel = new JPanel();
    private final JTextField TbUserName = new JTextField();
    private final JPasswordField TbPassword = new JPasswordField();
    private final JButton BtnLogin = new JButton();
    private final JButton BtnCancel = new JButton();
    private final JLabel LblUserName = new JLabel("Username");
    private final JLabel LblPassword = new JLabel("Password");
    private final JLabel LblError = new JLabel();



    public Login(){
        super("Login");
         BaseSetUp();
         StyleButtons();
         StyleTextBoxes();
         AddContentToViewPanel();
         FrameEvents();
         this.setResizable(false);
    }

    private void FrameEvents() {
        BtnLogin.addActionListener(new ActionListener() {
            int Attempt = 2;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(TbUserName.getText().equals("admin")
                && String.valueOf(TbPassword.getPassword()).
                        equals("peterray123")){
                    JFrame Main = null;
                    try {
                        Main = new Main();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    Main.setVisible(true);
                    setVisible(false);
                }else if(Attempt == 0){
                    LblError.setForeground(Color.red);
                    LblError.setText("Please Exit the program and try again");
                    TbUserName.setEnabled(false);
                    TbPassword.setEnabled(false);
                }else {
                    LblError.setForeground(Color.red);
                    LblError.setText("Your Attemps left are: "+ Attempt);
                    Attempt--;
                }

            }

        });

        BtnLogin.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(MouseEvent e) {
                BtnLogin.setBackground(Color.gray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                BtnLogin.setBackground(Color.white);
            }
        });


        BtnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        BtnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                BtnCancel.setBackground(Color.pink);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                BtnCancel.setBackground(Color.RED);
            }
        });
    }

    public void BaseSetUp(){
        Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600,500);
        this.setResizable(false);
        this.setContentPane(ViewPanel);
        this.setLocation(Dim.width/2-this.getSize().width/2,
                Dim.height/2-this.getSize().height/2);
    }

    public void StyleButtons(){
        BtnLogin.setText("Login");
        BtnLogin.setForeground(Color.BLACK);
        BtnLogin.setBackground(Color.white);
        Border Line = new LineBorder(Color.BLACK);
        Border Margin = new EmptyBorder(5,15,5,15);
        Border Compound = new CompoundBorder(Line, Margin);
        BtnLogin.setBorder(Compound);
        BtnCancel.setText("Cancel");
        BtnCancel.setForeground(Color.white);
        BtnCancel.setBackground(Color.RED);
        Border CLine = new LineBorder(Color.BLACK);
        Border CMargin = new EmptyBorder(5,15,5,15);
        Border CCompound = new CompoundBorder(CLine, CMargin);
        BtnCancel.setBorder(CCompound);
    }

    public void StyleTextBoxes(){
        TbUserName.setPreferredSize(new Dimension(200,25));
        TbPassword.setPreferredSize(new Dimension(200, 25));

    }


    public void AddContentToViewPanel(){
        GridBagConstraints GBC = new GridBagConstraints();
        GBC.insets.left =10;
        GBC.insets.top = 10;
        ViewPanel.setLayout(new GridBagLayout());
        GBC.gridx=0;
        GBC.gridy=0;
        ViewPanel.add(LblUserName,GBC);
        GBC.gridx=1;
        GBC.gridy=0;
        ViewPanel.add(TbUserName,GBC);
        GBC.gridx=0;
        GBC.gridy=1;
        ViewPanel.add(LblPassword,GBC);
        GBC.gridx=1;
        GBC.gridy=1;
        ViewPanel.add(TbPassword, GBC);
        GBC.gridx=1;
        GBC.gridy=2;
        ViewPanel.add(BtnLogin, GBC);
        GBC.insets.left = 200;
        GBC.gridx=1;
        GBC.gridy=2;
        ViewPanel.add(BtnCancel, GBC);
        GBC.insets.left = 0;
        GBC.gridx=0;
        GBC.gridy=3;
        ViewPanel.add(LblError, GBC);
    }




}
