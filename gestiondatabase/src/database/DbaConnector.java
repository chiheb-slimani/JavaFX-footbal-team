package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbaConnector {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/";
    private final String dbName = "equipe";
    private final String user = "root";
    private final String password = "";
    private Connection connection;

    // Constructor to initialize the connection
    public DbaConnector() {
        try {
            // Connect to MySQL server
            connection = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("Connected to MySQL server!");

            // Create the database if it doesn't exist
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
                System.out.println("Database created or already exists!");
                statement.executeUpdate("USE " + dbName);
                System.out.println("Using database: " + dbName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null; // Ensure connection is null if an error occurs
        }
    }

    // Method to get the current connection
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(jdbcURL + dbName, user, password);
                System.out.println("Reconnected to database: " + dbName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to create a table
    public void createTable(String tableSQL) {
        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(tableSQL);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the connection when the application ends
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
