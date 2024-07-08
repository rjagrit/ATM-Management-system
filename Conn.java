/*
JDBC Connectivity has 5 steps
1) Register the Driver
2) Create Connection
3) Create Statement
4) Execute Query
5) Close the Connection
 */
import java.sql.*;
public class Conn
{
    Connection c;
    Statement s;
    Conn()
    {
        try
        {
            //Register the Driver, error is continuously shown cuz now we dont have to register the Driver manually, Java will take Driver Automatically
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","tiger2k1706@");//connection
            s= c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
