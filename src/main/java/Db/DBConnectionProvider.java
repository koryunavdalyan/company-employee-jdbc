package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private static DBConnectionProvider instance = new DBConnectionProvider();

    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/company_employee?useUnicode";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private DBConnectionProvider() {
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DBConnectionProvider getInstance() {
        return instance;
    }
}