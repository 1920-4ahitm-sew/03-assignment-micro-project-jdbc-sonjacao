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

    @GET
    @Path("{id}")
    public PublishingHouse findPublishingHouse(@PathParam("id") long id) {

        initJdbc();

        int publisherno = toIntExact(id);
        PublishingHouse publishingHouse = new PublishingHouse();
        try {
            PreparedStatement pstmt = connection.prepareStatement("" +
                    "select PUBLISHER_NO, PUBLISHER_NAME, STREET, POSTAL_CODE, CITY, COUNTRY from PUBLISHING_HOUSE where PUBLISHER_NO=?");
            pstmt.setInt(1, publisherno);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                publishingHouse.setPublisherNo(rs.getLong(1));
                publishingHouse.setPublisherName(rs.getString(2));
                publishingHouse.setStreet(rs.getString(3));
                publishingHouse.setPostalCode(rs.getLong(4));
                publishingHouse.setCity(rs.getString(5));
                publishingHouse.setCountry(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        teardownJdbc();
        return publishingHouse;
    }
}
