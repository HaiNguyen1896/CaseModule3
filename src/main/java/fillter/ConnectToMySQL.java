package fillter;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/shopg3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            return null;
        }
    }
}
