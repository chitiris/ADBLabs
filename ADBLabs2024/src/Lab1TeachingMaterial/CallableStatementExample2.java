package Lab1TeachingMaterial;

//Import necessary classes from Java SQL package
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


class CallableStatementExample2{  
	public static void main(String args[]){  
		try{  
			// Registers the JDBC driver class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establishes the database connection
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world?world","root","123456");

            // Creates a CallableStatement object
            String query = "{call getcitybycoountry (?)}";
            CallableStatement stmt = con.prepareCall(query);

            // Sets the input parameter value of the stored procedure
            stmt.setString(1, "GRC");

            // Executes the stored procedure and checks if there are any result sets
            boolean hasResults = stmt.execute();
            while (hasResults) {
                // Retrieves the result set and processes it
                ResultSet resultSet = stmt.getResultSet();
                while (resultSet.next()) {
                    // Retrieves the value of the "name" column from the result set
                    String cityName = resultSet.getString("name");
                    // Prints the value of the "name" column to the console
                    System.out.println(cityName);
                }
                // Checks if there are any more result sets
                hasResults = stmt.getMoreResults();
            }

            // Closes the CallableStatement and Connection objects
            stmt.close();
            con.close();
        }
        catch(Exception e){
            // Catches any exception that may occur and prints the error message to the console
            System.out.println(e);
        }
    }
}  