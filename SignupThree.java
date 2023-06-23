package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.util.Random;

/**
 *
 * @author Riyanshu
 */
public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton saving ,fixed,current,recurring;
    JCheckBox atm,internet,mobile,email,cheque,stmt,check;
    JButton submit,cancel;
    String formno;
    
    public SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel accountdetails=new JLabel("Page 3: Account Details");
        accountdetails.setFont(new Font("Raleway",Font.BOLD,24));
        accountdetails.setBounds(250, 80, 600, 40);
        add(accountdetails);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100, 140, 600, 40);
        add(type);
        saving=new JRadioButton("Saving Account");
        fixed=new JRadioButton("Fixed Account");
        current=new JRadioButton("Current Account");
        recurring=new JRadioButton("Recurring Account");
        saving.setBounds(100, 190, 130, 30);
        fixed.setBounds(280, 190, 140, 30);
        current.setBounds(100, 230, 130, 30);
        recurring.setBounds(280, 230, 140, 30);
        saving.setBackground(Color.white);
        fixed.setBackground(Color.white);
        current.setBackground(Color.white);
        recurring.setBackground(Color.white);
        add(saving);
        add(fixed);
        add(current);
        add(recurring);
        ButtonGroup eyesButtonGroup=new ButtonGroup();
        eyesButtonGroup.add(saving);
        eyesButtonGroup.add(fixed);    
        eyesButtonGroup.add(current);   
        eyesButtonGroup.add(recurring);   
        
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100, 270, 600, 40);
        add(card);
        JLabel carddetail=new JLabel("(Your 16-Digit Card Number)");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100, 295, 600, 40);
        add(carddetail);
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,18));
        number.setBounds(330, 270, 600, 40);
        add(number);
        
        JLabel pin=new JLabel("Pin Number:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100, 370, 600, 40);
        add(pin );
        JLabel pindetail=new JLabel("(4-Digit Password)");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100, 395, 600, 40);
        add(pindetail);
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,18));
        pnumber.setBounds(330, 370, 600, 40);
        add(pnumber);
        
        
        JLabel service=new JLabel("Service Required:");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(100, 450, 600, 40);
        add(service );
        atm=new JCheckBox("ATM CARD");
        internet=new JCheckBox("Internet Banking");
        mobile=new JCheckBox("Mobile Banking");
        email=new JCheckBox("Email Alerts");
        cheque=new JCheckBox("Cheque Book");
        stmt=new JCheckBox("E-Statement");
        check=new JCheckBox("I Hearby to Accept all Terms and Conditions.");
        
        atm.setBounds(100, 490, 130, 30);
        internet.setBounds(280, 490, 140, 30);
        mobile.setBounds(100, 530, 130, 30);
        email.setBounds(280, 530, 140, 30);
        cheque.setBounds(100, 570, 140, 30);
        stmt.setBounds(280, 570, 140, 30);
        check.setBounds(100, 630, 300, 30);
        atm.setBackground(Color.white);
        internet.setBackground(Color.white);
        mobile.setBackground(Color.white);
        email.setBackground(Color.white);
        cheque.setBackground(Color.white);
        stmt.setBackground(Color.white);
        check.setBackground(Color.white);
        add(atm);
        add(internet);
        add(mobile);
        add(email);
        add(cheque);
        add(stmt);
        add(check);
        
        submit=new JButton("SUMBIT");
        submit.setFont(new Font("Osward",Font.BOLD,18));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,690,150,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.setFont(new Font("Osward",Font.BOLD,18));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450,690,150,30);
        cancel.addActionListener(this);
        add(cancel);
       
        
        setTitle("Application Form");

        setLocation(400, 60);
        setSize(800,800);
        getContentPane().setBackground(new Color(249, 241, 240));
        
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit) {
            String accounttype=null;
            if(saving.isSelected()){
                accounttype="Saving ACCount";
            }else if(fixed.isSelected()){
                accounttype="Fixed ACCount";         
            }else if(current.isSelected()){
                accounttype="Current ACCount";
            }else if(recurring.isSelected()){
                accounttype="Recurring ACCount";          
            }
            
            Random random=new Random();
            String cardnumber=""+Math.abs((random.nextLong()&90000000L)+ 5040965000000000L);
            String pinnumber=""+Math.abs((random.nextLong()&9000L)+ 1000L);
            
            String facility="";
            if(atm.isSelected()){
                facility=facility +"ATM CARD";
            }else if(internet.isSelected()){
                facility=facility +"Internet Banking";
            }else if(mobile.isSelected()){
                facility=facility +"Mobile Banking";
            }else if(email.isSelected()){
                facility=facility +"Email Service";
            }else if(cheque.isSelected()){
                facility=facility +"Cheque Book";
            }else if(stmt.isSelected()){
                facility=facility +"E-Statement";
            }  
            
            try {
                if (accounttype.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn c=new Conn();
                    String query1="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                     c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number:"+cardnumber +"\n pin:"+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            
            } catch (Exception err) {
                System.out.println(err);
            }
       
        }else if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        
        }
        
    }
 
    public static void main(String[] args) {
        new SignupThree("");
    }

    
}
