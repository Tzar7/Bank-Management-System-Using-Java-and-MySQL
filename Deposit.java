package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Riyanshu
 */
public class Deposit extends  JFrame implements ActionListener{
    
    JTextField amount;
    JButton b1,b2;
    String pinnumber;

    public Deposit(String pinnumber) {
        
        this.pinnumber=pinnumber;
        setLayout(null);
      
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount you want to deposit. ");
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 350, 700, 35);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Osward",Font.BOLD,13));
        amount.setBounds(190,400,320,25);
        image.add(amount);
       
        b1=new JButton("DEPOSIT");
        b1.setFont(new Font("Osward",Font.BOLD,13));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(370,510,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2=new JButton("BACK");
        b2.setFont(new Font("Osward",Font.BOLD,13));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(370,550,150,30);
        b2.addActionListener(this);
        image.add(b2); 
         
        setLocation(300, 0);
        setSize(900,900);
        setUndecorated(true);
        getContentPane().setBackground(new Color(249, 241, 240));
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            String number=amount.getText();
            Date date=new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "please eneter the amount you want to deposit");
            }else{
                try {
                    Conn c=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS "+number+"Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception er) {
                    System.out.println(e);
                }
            
            }
            
        }else if (e.getSource()==b2) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        
    }
       
    public static void main(String[] args) {
         new Deposit("");
    }

    
}
