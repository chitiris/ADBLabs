package ConnectionExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnectionWithDB {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Open a connection
            System.out.println("Connecting to database...");
            String url = "jdbc:mysql://localhost:3306/world?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);

            // Do something with the connection
            // ...

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block to close resources
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

