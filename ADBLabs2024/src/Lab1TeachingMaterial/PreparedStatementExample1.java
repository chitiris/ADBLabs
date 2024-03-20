package Lab1TeachingMaterial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


class PreparedStatementExample1 {  
    public static void main(String args[]) {  
        try {  			
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?world", "root", "123456");

            // Prepare the SQL statement
            PreparedStatement stmt = con.prepareStatement("insert into city values(?,?,?,?,?)");  
            stmt.setInt(1, 4085);  // Add the first available position of the ID field
            stmt.setString(2, "Kozani");  // Set the second parameter to "Volos"
            stmt.setString(3, "GRC");  // Set the third parameter to "GRC"
            stmt.setString(4, "Dutiki Makedonia");  // Set the fourth parameter to "Thessalia"
            stmt.setString(5, "954520");  // Set the fifth parameter to "95452"
            
            // Execute the SQL statement
            int i = stmt.executeUpdate();  
            System.out.println(i + " records inserted");  
            
            // Close the database connection
            con.close();  
        } catch (Exception e) {
            // Handle any errors that occur
            System.out.println(e);
        }  
    }  
} 