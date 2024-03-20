package Lab1EclassMaterial;

import java.sql.*;

public class CallableStatementExample {
   
   public static void main(String[] args) {
       Connection conn = null;
       CallableStatement stmt = null;
       try{
           // Load the JDBC driver for MySQL.
           Class.forName("com.mysql.cj.jdbc.Driver");
           // Connecting to the database...
           System.out.println("Connecting to the database...");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?user=root&password=123456");
           // Creating statement...
           System.out.println("Creating statement...");
           String sql = "{call getcity (?, ?)}"; // SQL to call the stored procedure 'getcity'
           stmt = conn.prepareCall(sql);
           int countryID = 4080; // Sample country ID
           stmt.setInt(1, countryID); // Setting input parameter for the stored procedure
           stmt.registerOutParameter(2, java.sql.Types.VARCHAR); // Registering the out parameter for the stored procedure
           // Executing stored procedure...
           System.out.println("Executing stored procedure..." );
           stmt.execute();
           String cityName = stmt.getString(2); // Retrieving the city name from the stored procedure's output
           // Displaying the city name with the given country ID
           System.out.println("The name of the city with ID:" + 
                              countryID + " is " + cityName);
       } catch (SQLException se) {
           // Handling SQL exceptions
           se.printStackTrace();
       } catch (Exception e) {
           // Handling other exceptions
           e.printStackTrace();
       } finally {
           // Closing resources in the finally block to ensure they are always closed
           try {
               if (stmt != null) stmt.close();
           } catch (SQLException se2) {
           } 
           try {
               if (conn != null) conn.close();
           } catch (SQLException se) {
               se.printStackTrace();
           } 
       } 
       // Goodbye message after closing the connection
       System.out.println("Goodbye!");
   } 
}
