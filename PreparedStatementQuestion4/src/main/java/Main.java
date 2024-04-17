import java.sql.*;
public class Main {
    public static void main(String[] args) throws SQLException{
        PreparedStatementQuestion4(10071, "d005","Senior Staff");
    }
    public static void PreparedStatementQuestion4(int emp_no, String dept_no, String title) throws SQLException {
        var url = "jdbc:mysql://localhost:3306/employees";
        var username = "root";
        var password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        if(connection == null){
            System.out.println("Connection fail");
        } else{
            System.out.println("Connection success");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("CALL Question_4(?,?,?)");
        preparedStatement.setInt(1,emp_no);
        preparedStatement.setString(2,dept_no);
        preparedStatement.setString(3,title);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
    }

}