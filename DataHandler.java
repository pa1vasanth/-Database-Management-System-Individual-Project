package jsp_azure_test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataHandler {

    private Connection conn;

    // Azure SQL connection credentials
    private String server = "komm0004-sql-server.database.windows.net";
    private String database = "cs-dsa-4513-sql-db";
    private String username = "komm0004";
    private String password = "xacwej-fohto7-cysFyf";

    // Resulting connection string
    final private String url =
            String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
                    server, database, username, password);

    // Initialize and save the database connection
    private void getDBConnection() throws SQLException {
        if (conn != null) {
            return;
        }

        this.conn = DriverManager.getConnection(url);
    }

    // Return the result of selecting everything from the movie_night table 
    public ResultSet getAllEmployees() throws SQLException {
        getDBConnection();
        
        final String sqlQuery = "select * from employee;";
        final PreparedStatement stmt = conn.prepareStatement(sqlQuery);
        return stmt.executeQuery();
    }
    

    // Inserts a record into the movie_night table with the given attribute values
    public boolean addEmployee(
            String e_name, String e_address, float salary, String type, int produce_per_day, String type_of_product, String position, String degree1, String degree2, String degree3) throws SQLException {

        getDBConnection(); // Prepare the database connection

        // Prepare the SQL statement
        final String sqlQuery =
                "EXEC query1 @e_name = ?, @e_address = ?, @salary = ?, @type=?, @produce_per_day=?, @type_of_product=?,@position=?,@degree1=?,@degree2=?,@degree3=?;";
        final PreparedStatement stmt = conn.prepareStatement(sqlQuery);

        // Replace the '?' in the above statement with the given attribute values
        stmt.setString(1, e_name);
        stmt.setString(2, e_address);
        stmt.setFloat(3, salary);
        stmt.setString(4, type);
        stmt.setInt(5, produce_per_day);
        stmt.setString(6, type_of_product);
        stmt.setString(7, position);
        stmt.setString(8, degree1);
        stmt.setString(9, degree2);
        stmt.setString(10, degree3);
        
        // Execute the query, if only one record is updated, then we indicate success by returning true
        return stmt.executeUpdate() == 1;
    }
        
        public ResultSet addEmployeeSalary(
                float salary) throws SQLException {

        getDBConnection(); // Prepare the database connection

        // Prepare the SQL statement
        final String sqlQuery = "EXEC query12 @salary=?;";
        final PreparedStatement stmt = conn.prepareStatement(sqlQuery);

        // Replace the '?' in the above statement with the given attribute values
        stmt.setFloat(1, salary);

        // Execute the query, if only one record is updated, then we indicate success by returning true
        return stmt.executeQuery();
    }
}
