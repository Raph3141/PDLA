import java.sql.Connection;
public class MainClass {
        public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();

        // Use the connection for database operations

        // Don't forget to close the connection when done
        DatabaseConnection.closeConnection();
    }
}
