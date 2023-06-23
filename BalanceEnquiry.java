package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author Riyanshu
 */
public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton b1;
    String pinnumber;

    public BalanceEnquiry(String pinnumber) {
        
        this.pinnumber=pinnumber;
        setLayout(null);
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        
        b1=new JButton("BACK");
        b1.setFont(new Font("Osward",Font.BOLD,13));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(370,550,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
        Conn c=new Conn();
        int balance=0;
            try {
                ResultSet rs=c.s.executeQuery("select * from  bank where pin='"+pinnumber+"'");
                while (rs.next()) {                    
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));  
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));                    
                    }
                }
            }catch(Exception er3){
                System.out.println(er3);
            }
            
        JLabel text=new JLabel("Your current Account Balance:"+balance);
        text.setFont(new Font("Raleway",Font.BOLD,18));
        text.setForeground(Color.WHITE);
        text.setBounds(180, 350, 700, 35);
        image.add(text);    
 
        setLocation(300, 0);
        setSize(900,900);
        setUndecorated(true);
        getContentPane().setBackground(new Color(249, 241, 240));
        
        setVisible(true);
 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
     
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

   
    
}
