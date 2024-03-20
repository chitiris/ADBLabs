package Lab1TeachingMaterial;
//Import necessary classes from Java SQL package
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;


class CallableStatementExample1{  
	public static void main(String args[]) {
        try {
            // Load the MySQL JDBC driver using Class.forName
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL database
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world?world","root","123456");

            // Define the SQL query string as a stored procedure call with two parameters
            String query = "{call getcountry (?, ?)}";

            // Create a CallableStatement object for the stored procedure
            CallableStatement stmt = con.prepareCall(query);

            // Set the first parameter to the country code "GRC"
            stmt.setString(1, "GRC");

            // Register the second parameter as a VARCHAR output parameter
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

            // Execute the stored procedure
            stmt.execute();

            // Retrieve the output parameter value as a String
            String countryName = stmt.getString(2);

            // Print the output parameter value to the console
            System.out.println("Country Name = "+countryName);

            // Close the CallableStatement and Connection objects
            stmt.close();
            con.close();
        } catch(Exception e) {
            // Print any exceptions thrown during execution to the console
            System.out.println(e);
        }
    }
}  