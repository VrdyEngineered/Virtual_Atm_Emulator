package Bank_management_system;
//There are five connecting sql with java
// 1. Register the Driver
// 2.Create Connection
// 3.Create statement
// 4.Execute Query
// 5. Close Connection
import java.sql.*;

public class Connectn {
        Connection c;
        Statement s;
        public Connectn(){
            try{
                // crating connection with sql
               //Class.forName(com.mysql.cj.jdbc.Driver);
                c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","!@#$%^&*777v");
                s=c.createStatement();
               // System.out.println("Query: " + query);

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }



}
