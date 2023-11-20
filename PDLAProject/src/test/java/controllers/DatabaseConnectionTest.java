package controllers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseConnectionTest {
    private static Connection connection;

    @BeforeClass
    public static void getConnection() {
        connection = DatabaseConnection.getConnection();
    }

    @AfterClass
    public static void closeConnection() {
        DatabaseConnection.closeConnection();
    }

    @Test
    public void testConnectionNotNull() {
        assertNotNull("Connection should not be null", connection);
    }

    @Test
    public void testConnectionIsOpen() {
        try {
            assertFalse("Connection should be open", connection.isClosed());
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }

    @Test
    public void testCloseConnection() {
        DatabaseConnection.closeConnection();
        try {
            assertTrue("Connection should be closed", connection.isClosed());
        } catch (SQLException e) {
            fail("SQLException: " + e.getMessage());
        }
    }
}
