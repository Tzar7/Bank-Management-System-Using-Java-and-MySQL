package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
/**
 *
 * @author Riyanshu
 */

public class SignupTwo extends  JFrame implements ActionListener {
    
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno ;
    JComboBox religion,category,income,occupation,education;
    String formno;
    
    
    
     SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        
         setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,24));
        additionaldetails.setBounds(250, 80, 600, 40);
        add(additionaldetails);
        
                
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100, 140, 600, 40);
        add(name);
        
        String valueligion[]={"Hindu","Sikh","Christian","Muslim"};
        religion=new JComboBox(valueligion);
        religion.setBackground(new Color(249, 241, 240));
        religion.setBounds(300, 150, 400, 30);
        add(religion);
        
                
        JLabel fathersname=new JLabel("Category:");
        fathersname.setFont(new Font("Raleway",Font.BOLD,20));
        fathersname.setBounds(100, 180, 600, 40);
        add(fathersname);
        
        String valuecategory[]={"General","OBC","SC","ST","Other"};       
        category=new JComboBox(valuecategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(new Color(249, 241, 240));
        add(category);
        
                                
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100, 220, 600, 40);
        add(dob);
        
        String incomecategory[]={"null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};       
        income=new JComboBox(incomecategory);
        income.setBounds(300, 230, 400, 30);
        income.setBackground(new Color(249, 241, 240));
        add(income);
       
                                
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100, 280, 600, 40);
        add(gender);
        
        
                                
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100, 300, 600, 40);
        add(email);
        
        String educationvalues[]={"Non-Graduate","Graduate","Post-Graduate","Docarate","Others"};       
        education=new JComboBox(educationvalues);
        education.setBounds(300, 310, 400, 30);
        add(education);
       
                             
        JLabel married=new JLabel("Occupation:");
        married.setFont(new Font("Raleway",Font.BOLD,20));
        married.setBounds(100, 340, 600, 40);
        add(married);
        
        String occupationvalues[]={"Slaried","Self Employed","Buisness","Student","Retired","Others"};       
        occupation=new JComboBox(occupationvalues);
        occupation.setBounds(300, 350, 400, 30);
        add(occupation);

        JLabel add=new JLabel("Pan No:");
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.setBounds(100, 380, 600, 40);
        add(add);
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        pan.setBounds(300, 390, 400, 30);
        add(pan);
        
                                        
        JLabel city=new JLabel("Adhaar No:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100, 420, 600, 40);
        add(city);
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,18));
        aadhar.setBounds(300, 430, 400, 30);
        add(aadhar);
        
                                        
        JLabel pin=new JLabel("Senior Citizen:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100, 460, 600, 40);
        add(pin);
        syes=new JRadioButton("Yes");
        sno=new JRadioButton("No");
        syes.setBounds(300, 470, 80, 30);
        sno.setBounds(400, 470, 100, 30);
        syes.setBackground(Color.white);
        sno.setBackground(Color.white);
        add(syes);
        add(sno);
        
        ButtonGroup yesButtonGroup=new ButtonGroup();
        yesButtonGroup.add(syes);
        yesButtonGroup.add(sno);
                           
        JLabel state=new JLabel("Existing Account:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100, 500, 600, 40);
        add(state);
        eyes=new JRadioButton("Yes");
        eno=new JRadioButton("No");
        eyes.setBounds(300, 510, 80, 30);
        eno.setBounds(400, 510, 100, 30);
        eyes.setBackground(Color.white);
        eno.setBackground(Color.white);
        add(eyes);
        add(eno);
        
        ButtonGroup eyesButtonGroup=new ButtonGroup();
        eyesButtonGroup.add(eyes);
        eyesButtonGroup.add(eno);     

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
        String srelegion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        String existingaccount=null;
        if (eyes.isSelected()) {
            existingaccount="yes";
        }else if (eno.isSelected()) {
            existingaccount="No";
        }
        String  span=pan.getText();
        String saadhar=aadhar.getText();    
        try {
            
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+srelegion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
      
            } catch (Exception err) {
            System.out.println(err);
        }
    }
    
    public static void main(String[] args) {
       new SignupTwo("");
    }

}
