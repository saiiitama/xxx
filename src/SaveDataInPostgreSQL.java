import java.sql.*;

public class SaveDataInPostgreSQL {
    public void saveData(String name, String surname, String password) {
      Connection conn = null;
      try {
        // Connect to the database
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
  
        // Create a statement
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO clt (cltname, cltsurname, cltpassword) VALUES (?, ?, ?)");
  
        // Set the values for the prepared statement
        stmt.setString(1, name);
        stmt.setString(2, surname);
        stmt.setString(3, password);
  
        // Execute the insert statement
        stmt.executeUpdate();
  
        // Confirm that the data was saved
        System.out.println("Data saved successfully");
      } catch (SQLException e) {
        System.out.println("Error saving data: " + e.getMessage());
      } finally {
        // Close the connection
        if (conn != null) {
          try {
            conn.close();
          } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
      }
    }
  }
}
