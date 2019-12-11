package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This class follows Singleton pattern to create single database connection
public class DatabaseConnection {

    private static DatabaseConnection instance; // declaring object
    private static Connection connection; //declaring connection variable
    private static final String URL = "jdbc:mysql://localhost/mydb"; // URL constant
    private static final String DATABASEDRIVER = "com.mysql.jdbc.Driver"; //jdbc driver
    private static final String USERNAME = "root"; //database username
    private static final String PASSWORD = "root"; //database password

//constructor to create connection using drivermanger with url,username,password and database driver
    private DatabaseConnection() throws SQLException {
        try {
            Class.forName(DATABASEDRIVER);
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    //method to get database connection
    public static Connection getConnection() {
        return connection;
    }

    //static method to create instance of Singleton class
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    //static method to close connection
    public static void closeConnection() throws SQLException {
        try {
            System.out.println("----Connection closed with MYSQL database----");
            connection.close();
        } catch (Exception e) {
            System.out.println("Close connection failed  : " + e.getMessage());
        }
    }

}
