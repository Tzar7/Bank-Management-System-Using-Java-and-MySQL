package atm.simulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author Riyanshu
 */
public class FastCash extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pinnumber;
    
    FastCash(String pinnumber) {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 350, 700, 35);
        image.add(text);

        b1=new JButton("RS 100");
        b1.setFont(new Font("Osward",Font.BOLD,13));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(180,425,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        b2=new JButton("RS 500");
        b2.setFont(new Font("Osward",Font.BOLD,13));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(370,425,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        b3=new JButton("RS 1000");
        b3.setFont(new Font("Osward",Font.BOLD,13));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(180,470,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
        b4=new JButton("RS 2000");
        b4.setFont(new Font("Osward",Font.BOLD,13));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(370,470,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5=new JButton("RS 5000");
        b5.setFont(new Font("Osward",Font.BOLD,13));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(180,510,150,30);
        b5.addActionListener(this);
        image.add(b5);
        
        b6=new JButton("RS 10,000");
        b6.setFont(new Font("Osward",Font.BOLD,13));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(370,510,150,30);
        b6.addActionListener(this);
        image.add(b6);
        
        b7=new JButton("BACK");
        b7.setFont(new Font("Osward",Font.BOLD,13));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(370,550,150,30);
        b7.addActionListener(this);
        image.add(b7);

        setTitle("Application Form");

        setLocation(300, 0);
        setSize(900,900);
        setUndecorated(true);
        getContentPane().setBackground(new Color(249, 241, 240));
        
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b7) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)e.getSource()).getText().substring(3);
            Conn c=new Conn();
            try {
                ResultSet rs=c.s.executeQuery("select * from  bank where pin='"+pinnumber+"'");
                int balance=0;
                while (rs.next()) {                    
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));  
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));                    
                    }
                }
                
                if (e.getSource() !=b7 && balance<Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "INsufficient Balance");
                    return;   
                }
                
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception er1) {
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }

    
    
}
