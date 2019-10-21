package at.htl.library.rest;

import at.htl.library.model.PublishingHouse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.sql.*;

import static java.lang.Math.toIntExact;

@Path("library")
public class LibraryEndpoint {

    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection connection;

    public static void initJdbc() {
        try {
            Class.forName(DRIVER_STRING);
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to database not possible:\n" +
                    e.getMessage() + "\n");
        }
    }

    public static void teardownJdbc() {
        try {
            if (connection != null || !connection.isClosed()) {
                connection.close();
                System.out.println("Connection to database closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
