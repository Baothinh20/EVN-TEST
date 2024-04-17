package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static Properties properties;
    private static Connection connection;
    public JdbcUtils() throws FileNotFoundException, IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/app.properties"));
    }
    public static void connectionTesting() throws SQLException {
        var url = (String) properties.get("url");
        var username = (String) properties.get("username");
        var password = (String) properties.get("password");
        connection = DriverManager.getConnection(url, username, password);
        if(connection == null){
            System.out.println("Connect failed");
        } else {
            System.out.println("Success");
        }
    }
    public static Connection getConnection() throws SQLException {
        var url = (String) properties.get("url");
        var username = (String) properties.get("username");
        var password = (String) properties.get("password");
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void disConnection() throws SQLException {
        connection.close();
    }
    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection connnection = getConnection();
        Statement statement = connnection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;
    }
    public static PreparedStatement createPrepareStatement(String sql) throws SQLException {
        Connection connnection = getConnection();
        PreparedStatement preStatement = connnection.prepareStatement(sql);
        return preStatement;
    }
}