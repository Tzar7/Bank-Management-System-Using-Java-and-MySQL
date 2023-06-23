package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
/**
 *
 * @author Riyanshu
 */

public class SignupOne extends  JFrame implements ActionListener {
    
    long random;
    JTextField nameJTextField,fathernameJTextField ,emailJTextField,addJTextField,cityJTextField,pinJTextField,stateJTextField;
    JButton next;
    JRadioButton male,female,Married,unmarried ;
    JDateChooser dateChooser;
    
    
    
     SignupOne() {
        
        setLayout(null);
        
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000l)+100l);
        
        JLabel formno=new JLabel("Application Number."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personaldetails=new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,24));
        personaldetails.setBounds(250, 80, 600, 40);
        add(personaldetails);
        
                
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 600, 40);
        add(name);
        nameJTextField=new JTextField();
        nameJTextField.setFont(new Font("Raleway",Font.BOLD,18));
        nameJTextField.setBounds(300, 150, 400, 30);
        add(nameJTextField);
        
                        
        JLabel fathersname=new JLabel("Father's Name:");
        fathersname.setFont(new Font("Raleway",Font.BOLD,20));
        fathersname.setBounds(100, 180, 600, 40);
        add(fathersname);
        fathernameJTextField=new JTextField();
        fathernameJTextField.setFont(new Font("Raleway",Font.BOLD,18));
        fathernameJTextField.setBounds(300, 190, 400, 30);
        add(fathernameJTextField);
        
                                
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 220, 600, 40);
        add(dob);
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300, 230, 400, 30);
        add(dateChooser);
       
                                
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 260, 600, 40);
        add(gender);
        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        male.setBounds(300, 270, 60, 30);
        female.setBounds(380, 270, 80, 30);
        female.setBackground(Color.white);
        male.setBackground(Color.white);
        add(male);
        add(female);
        
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        
                                
        JLabel email=new JLabel("Email ID:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 300, 600, 40);
        add(email);
        emailJTextField=new JTextField();
        emailJTextField.setFont(new Font("Raleway",Font.BOLD,18));
        emailJTextField.setBounds(300, 310, 400, 30);
        add(emailJTextField);
        
                                        
        JLabel married=new JLabel("Marital Status:");
        married.setFont(new Font("Raleway",Font.BOLD,20));
        married.setBounds(100, 340, 600, 40);
        add(married);
        Married=new JRadioButton("Married");
        unmarried=new JRadioButton("Unmarried");
        Married.setBounds(300, 350, 80, 30);
        unmarried.setBounds(400, 350, 100, 30);
        Married.setBackground(Color.white);
        unmarried.setBackground(Color.white);
        add(Married);
        add(unmarried);
        
        ButtonGroup yesButtonGroup=new ButtonGroup();
        yesButtonGroup.add(Married);
        yesButtonGroup.add(unmarried);
       
        
        
        JLabel add=new JLabel("Address:");
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.setBounds(100, 380, 600, 40);
        add(add);
        addJTextField=new JTextField();
        addJTextField.setFont(new Font("Raleway",Font.BOLD,18));
        addJTextField.setBounds(300, 390, 400, 30);
        add(addJTextField);
        
                                        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 420, 600, 40);
        add(city);
        cityJTextField=new JTextField();
        cityJTextField.setFont(new Font("Raleway",Font.BOLD,18));
        cityJTextField.setBounds(300, 430, 400, 30);
        add(cityJTextField);
        
                                        
        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100, 460, 600, 40);
        add(pin);
        pinJTextField=new JTextField();
        pinJTextField.setFont(new Font("Raleway",Font.BOLD,18));
        pinJTextField.setBounds(300, 470, 400, 30);
        add(pinJTextField);
        
                                        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 500, 600, 40);
        add(state);
        stateJTextField=new JTextField();
        stateJTextField.setFont(new Font("Raleway",Font.BOLD,18));
        stateJTextField.setBounds(300, 510, 400, 30);
        add(stateJTextField);
        
        
        next=new JButton("NEXT");
        next.setFont(new Font("Osward",Font.BOLD,18));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(500,600,200,30);
        next.addActionListener(this);
        add(next);

        
        
        
        setTitle("Application Form");
        
        setLocation(400, 60);
        setSize(800,800);
        getContentPane().setBackground(new Color(249, 241, 240));
        
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String formno=""+random;
        String name=nameJTextField.getText();
        String fname=fathernameJTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emailJTextField.getText();
        String married=null;
        if (Married.isSelected()) {
            married="Married";
        }else if (unmarried.isSelected()) {
            married="unmarried";
        }
        String  address=addJTextField.getText();
        String city=cityJTextField.getText();
        String state=stateJTextField.getText();
        String pin=pinJTextField.getText();
        
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+married+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            
            }
        } catch (Exception err) {
            System.out.println(err);
        }
    }
    
    public static void main(String[] args) {
       new SignupOne();
    }

}
