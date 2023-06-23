package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Riyanshu
 */

public class Login  extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField PinTextField;
    
    Login(){
        setLayout(null);
        
        setTitle("ATM SIMULATOR");
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(50, 10, 100, 100);
        add(label);
        
        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250, 40, 400, 40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 400, 40);
        add(cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300, 160, 250, 30);
        cardTextField.setFont(new Font("Osward",Font.BOLD,18));
        add(cardTextField);
        
        PinTextField=new JPasswordField();
        PinTextField.setBounds(300, 210, 250, 30);
        cardTextField.setFont(new Font("Osward",Font.BOLD,18));
        add(PinTextField);
        
        login=new JButton("SIGN IN");
        login.setFont(new Font("Osward",Font.BOLD,18));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("Clear");
        clear.setFont(new Font("Osward",Font.BOLD,18));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(450,300,100,30);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setFont(new Font("Osward",Font.BOLD,18));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,250,30);
        signup.addActionListener(this);
        add(signup);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 200, 400, 40);
        add(pin);

        setLocation(400, 60);
        setSize(800,480);
        getContentPane().setBackground(new Color(249, 241, 240));

        setVisible(true);
 
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==clear){
            cardTextField.setText("");
            PinTextField.setText("");
        
        }else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=PinTextField.getText();
            String query="select * from login where cardnumber='"+cardnumber+"'and pin='"+pinnumber+"'";
            try {
                ResultSet rs= conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);                   
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card bumber or pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
   
    public static void main(String[] args){
        new Login();
        
        
    }

}
