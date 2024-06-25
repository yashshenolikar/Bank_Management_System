package bank.management.system;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.sql.*;

public class Con {
    Connection connection;
    Statement statement;

    public Con() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem", "root", "yash12@02JAN20");
   statement=connection.createStatement();

        } catch (Exception e) {

        }
    }
}
