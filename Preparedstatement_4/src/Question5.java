import java.sql.*;

public class Question5 {
    public void PreparedStatementQuestion4(int emp_no, String dept_no, String title) throws SQLException {
        var url = "jdbc:mysql://localhost:3306/employees";
        var username = "root";
        var password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        if(connection == null){
            System.out.println("Connection fail");
        } else{
            System.out.println("Connection success");
        }
        PreparedStatement preparedStatement = connection.prepareStatement("CALL Question_4(emp_no, dept_no,title)");
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
