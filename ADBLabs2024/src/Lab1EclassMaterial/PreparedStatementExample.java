package Lab1EclassMaterial;

//Import required Java classes for JDBC connectivity
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Define a public class named PreparedStatementExample
public class PreparedStatementExample {

 // Define the main method for the program
 public static void main(String[] args) {

     // Declare PreparedStatement and ResultSet objects and initialize them to null
     PreparedStatement pstmt = null;
     ResultSet rst = null;

     // Define the SQL query to execute
     String myQuery = "select Name, CountryCode, Population from city";

     try {

         // Load the MySQL JDBC driver using the Class.forName() method
         Class.forName("com.mysql.cj.jdbc.Driver");

         // Establish a connection to the MySQL database using the DriverManager.getConnection() method
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?world", "root", "123456");

         // Create a PreparedStatement object using the SQL query and the connection object
         pstmt = con.prepareStatement(myQuery);

         // Execute the PreparedStatement using the executeQuery() method and store the results in a ResultSet object
         rst = pstmt.executeQuery();

         // Print column headers for the output
         System.out.println("Name \t\t Country \t\t Population\n");

         // Loop through each row in the ResultSet and print the values for the three columns
         while (rst.next()) {
             System.out.print(rst.getString(1));
             System.out.print("\t\t" + rst.getString(2));
             System.out.print("\t\t" + rst.getInt(3));
             System.out.println();
         }
     } catch (Exception exec) {

         // If an exception occurs during the program execution, print the stack trace to the console
         exec.printStackTrace();
     }
 }
}
