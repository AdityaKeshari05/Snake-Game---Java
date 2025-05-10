import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Replace these with your real credentials
            String url = "jdbc:mysql://sql307.infinityfree.com:3306/if0_38886167_snakegame";
            String user = "if0_38886167 ";
            String password = "Gradient2006";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to remote database successfully!");
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}