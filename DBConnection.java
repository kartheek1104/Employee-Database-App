import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "your-jdbc-localhost-link"; // change this
    private static final String USER = "your-username"; // change this
    private static final String PASSWORD = "your-password"; // change this

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
