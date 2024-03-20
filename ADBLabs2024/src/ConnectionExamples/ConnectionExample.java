package ConnectionExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class ConnectionExample{
    public static void main(String args[]){
        try{
            // Load MySQL JDBC driver to establish a connection to the database.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL database named "world" on localhost, port 3306.
            // Use your own username and password instead of "root" and "123456".
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "123456");

            // Create a Statement object to send SQL statements to the database.
            Statement stmt = con.createStatement();

            // Execute a query to select all records from the "city" table in the database.
            ResultSet rs = stmt.executeQuery("select * from city");

            // Iterate through the ResultSet, each time printing out the city's ID, name, and country code.
            while(rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

            // Close the database connection to free up resources.
            con.close();
        }
        catch(Exception e){
            // Print any errors that occur during the execution of the try block.
            System.out.println(e);
        }
    }
}
