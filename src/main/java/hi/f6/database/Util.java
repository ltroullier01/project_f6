package hi.f6.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/team6f";
    private static final String C_USER = "clement";
    private static final String C_PASSWORD = "clement";
    private static final String L_USER = "lael";
    private static final String L_PASSWORD = "lael";

    public Connection getConnectionClement() {
        try {
            return DriverManager.getConnection(URL, C_USER, C_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Connection getConnectionLael() {
        try {
            return DriverManager.getConnection(URL, L_USER, L_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
