package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
/**
 *
 * @author Riyanshu
 */
public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton b1,b2;
    String pinnumber;

    public PinChange(String pinnumber) {
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 350, 700, 35);
        image.add(text);
        
        JLabel pintext=new JLabel("New PIN:");
        pintext.setFont(new Font("Raleway",Font.BOLD,20));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(180,425,150,30);
        image.add(pintext);
        pin=new JPasswordField();
        pin.setFont(new Font("Osward",Font.BOLD,13));
        pin.setBounds(350,425,150,25);
        pin.addActionListener(this);
        image.add(pin);
        
        JLabel repintext=new JLabel("RE-Enter PIN:");
        repintext.setFont(new Font("Raleway",Font.BOLD,20));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(180,470,150,30);
        image.add(repintext);
        repin=new JPasswordField();
        repin.setFont(new Font("Osward",Font.BOLD,13));
        repin.setBounds(350,470,150,25);
        repin.addActionListener(this);
        image.add(repin);
        
        b1=new JButton("CHANGE");
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
            try {
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "The pin entered didn't matched");
                return;
            }
            if (npin.equals("")) {
               JOptionPane.showMessageDialog(null, "PLease enter new pin");
               return;
            }
            if (rpin.equals("")) {
               JOptionPane.showMessageDialog(null, "PLease re-enter pin");
               return;
            }
            Conn c=new Conn();
                    String query1="update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
                    String query2="update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
                    String query3="update signupthree set pinnumber='"+rpin+"' where pinnumber='"+pinnumber+"'";
                    
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);

            
        } catch (Exception er2) {
            System.out.println(er2);
        }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        
        }
        
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    
}
