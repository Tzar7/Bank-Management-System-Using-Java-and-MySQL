package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author Riyanshu
 */
public class MiniStatement extends JFrame implements ActionListener{
    String pinnumber;

    public MiniStatement(String pinnumber) {
        
        this.pinnumber=pinnumber;
        setLayout(null);

        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        
        JLabel bank=new JLabel("MY BANK");
        bank.setFont(new Font("Raleway",Font.BOLD,20));
        bank.setForeground(Color.BLACK);
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setFont(new Font("Raleway",Font.BOLD,15));
        card.setForeground(Color.BLACK);
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            while (rs.next()) {
                card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
                
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            int bal=0;
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
            while (rs.next()) {
                mini.setText(mini.getText()+"<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>" );
                if (rs.getString("type").equals("Deposit")) {
                     bal += Integer.parseInt(rs.getString("amount"));  
                }else{
                     bal -= Integer.parseInt(rs.getString("amount"));                    
                }
            }
            balance.setText("Your current balance is: "+bal);
        
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        setLocation(20, 20);
        setSize(400,600);
//        setUndecorated(true);
        getContentPane().setBackground(new Color(249, 241, 240));
        
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     
    }
    

    public static void main(String[] args) {
        new MiniStatement("");
    }
    
}
