import java.sql.*;

// Setting connection with the database .
public class Conn {
    Connection c;
    Statement s;
    // Conn Constructor that will get used in various classes many times .
    public Conn(){
        // Exception handling
        try{
            c = DriverManager.getConnection("jdbc:mysql:///snakegame" , "root" , "Aditya2006");  //  JDBC Connection .
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
