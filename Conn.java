package atm.simulator;

import java.sql.*;

/**
 *
 * @author Riyanshu
 */
public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1234");
           s=c.createStatement();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
