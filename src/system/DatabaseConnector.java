package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/task_manager";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";
    private Connection connection;

    public DatabaseConnector() {
        try {
            // Establish the database connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement methods for CRUD operations on tasks and users
    // Example methods: createTask, updateTask, deleteTask, createUser, updateUser, etc.

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
