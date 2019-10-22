package at.htl.library.database;

import at.htl.library.model.PublishingHouse;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.toIntExact;

public class Database {


    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection connection;

    public Database() {
    }

    // open connection to database
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

    // close connection to database
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

    // select one row from table
    public PublishingHouse selectPublishingHouse(long id) {
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

    // select all rows from table
    public List<PublishingHouse> selectAllPublishingHouses() {
        List<PublishingHouse> publishingHouseList = new LinkedList<>();

        initJdbc();
        try {
            PreparedStatement pstmt = connection.prepareStatement("" +
                    "select PUBLISHER_NO, PUBLISHER_NAME, STREET, POSTAL_CODE, CITY, COUNTRY from PUBLISHING_HOUSE");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PublishingHouse publishingHouse = new PublishingHouse();
                publishingHouse.setPublisherNo(rs.getLong(1));
                publishingHouse.setPublisherName(rs.getString(2));
                publishingHouse.setStreet(rs.getString(3));
                publishingHouse.setPostalCode(rs.getLong(4));
                publishingHouse.setCity(rs.getString(5));
                publishingHouse.setCountry(rs.getString(6));
                // add to list
                publishingHouseList.add(publishingHouse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        teardownJdbc();
        return publishingHouseList;
    }

    // delete row from table
    public void deletePublishingHouse(long id) {
        initJdbc();
        try {
            PreparedStatement pstmt = connection.prepareStatement("" +
                    "delete from PUBLISHING_HOUSE where PUBLISHER_NO=?");
            pstmt.setInt(1, toIntExact(id));
            pstmt.execute();
            System.out.println("Deleted publishing house with publisher number: " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        teardownJdbc();

    }

    // insert new row into table
    public void insertPublishingHouse(PublishingHouse publishingHouse) {
        initJdbc();
        try {
            PreparedStatement pstmt = connection.prepareStatement("" +
                    "insert into PUBLISHING_HOUSE(PUBLISHER_NO, PUBLISHER_NAME, STREET, POSTAL_CODE, CITY, COUNTRY) " +
                    "values (?,?,?,?,?,?)");
            pstmt.setInt(1, toIntExact(publishingHouse.getPublisherNo()));
            pstmt.setString(2, publishingHouse.getPublisherName());
            pstmt.setString(3, publishingHouse.getStreet());
            pstmt.setInt(4, toIntExact(publishingHouse.getPostalCode()));
            pstmt.setString(5, publishingHouse.getCity());
            pstmt.setString(6, publishingHouse.getCountry());

            pstmt.execute();
            System.out.println("Inserted " + publishingHouse);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        teardownJdbc();
    }

    // update existing row in the table
    public void updatePublishingHouse(PublishingHouse publishingHouse) {
        initJdbc();
        try {
            PreparedStatement pstmt = connection.prepareStatement("" +
                    "update PUBLISHING_HOUSE set PUBLISHER_NAME=?, STREET=?, POSTAL_CODE=?, CITY=?, COUNTRY=? " +
                    "where PUBLISHER_NO=?");
            pstmt.setString(1, publishingHouse.getPublisherName());
            pstmt.setString(2,publishingHouse.getStreet());
            pstmt.setInt(3, toIntExact(publishingHouse.getPostalCode()));
            pstmt.setString(4, publishingHouse.getCity());
            pstmt.setString(5, publishingHouse.getCountry());
            pstmt.setInt(6, toIntExact(publishingHouse.getPublisherNo()));
            pstmt.execute();

            System.out.println("Updated " + publishingHouse);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        teardownJdbc();
    }

}
