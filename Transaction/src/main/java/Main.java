import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Transaction(10002,"Production",10173, "d010","Bigdata & ML");
    }
    public static void Transaction(int emp_no_1,String dept_name_1, int emp_no_2, String dept_no_2, String dept_name_2) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/app.properties"));
            var url = (String) properties.get("url");
            var username = (String) properties.get("username");
            var password = (String) properties.get("password");
            Connection connection = DriverManager.getConnection(url, username, password);
            if(connection == null){
                System.out.println("Connect failed");
            } else {
                System.out.println("Success");
            }
            try {
                connection.setAutoCommit(false);
                System.out.println("SavePointSetting");
                PreparedStatement preparedStatement = connection.prepareStatement("CALL update_title(?)");
                preparedStatement.setInt(1,emp_no_1);
                ResultSet resultSet = preparedStatement.executeQuery();
                preparedStatement = connection.prepareStatement("CALL delete_department(?)");
                preparedStatement.setString(1,dept_name_1);
                resultSet = preparedStatement.executeQuery();
                preparedStatement = connection.prepareStatement("CALL create_department_and_manager(?,?, ?)");
                preparedStatement.setString(1,dept_no_2);
                preparedStatement.setString(2,dept_name_2);
                preparedStatement.setInt(3,emp_no_2);
                resultSet = preparedStatement.executeQuery();
                System.out.println("Commit");
                connection.commit();
            } catch (Exception e){
                connection.rollback();
            }
        } catch (FileNotFoundException fileNotFoundException){
            System.out.println("FileNotFoundException");
        } catch(SQLException sqlException){
            System.out.println("SQLException");
        } catch (IOException ioException){
            System.out.println("IOException");
        }

    }
}