package at.htl.library;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LibraryTest {

    public final static String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection connection;

    @BeforeAll
    public static void initJdbc() {
        try {
            Class.forName(DRIVER_STRING);
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to database not possible:\n" +
                    e.getMessage() + "\n");
            System.exit(1);
        }
    }

    @AfterAll
    public static void tearDownJdbc() {
        try {
            if (connection != null || !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01Create() {
        try {
            Statement stmt = connection.createStatement();

            String sql = "CREATE TABLE test_table(" +
                    " id INT CONSTRAINT PK_id PRIMARY KEY," +
                    " type varchar(255) NOT NULL)";
            stmt.execute(sql);
            stmt.execute("drop table test_table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02Insert() {
        try {
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO PUBLISHING_HOUSE(PUBLISHER_NO, PUBLISHER_NAME, STREET, POSTAL_CODE, CITY, COUNTRY) " +
                    " VALUES(100000, 'Springer-Verlag GmbH', 'Tiergartenstrasse 17', 69121, 'Heidelberg', 'Germany')";
            assertThat(stmt.executeUpdate(sql), is(1));
            stmt.execute("delete from PUBLISHING_HOUSE where PUBLISHER_NO=100000");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test03Update() {
        try {
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO PUBLISHING_HOUSE(PUBLISHER_NO, PUBLISHER_NAME, STREET, POSTAL_CODE, CITY, COUNTRY) " +
                    " VALUES(100000, 'Springer-Verlag GmbH', 'Tiergartenstrasse 17', 69121, 'Heidelberg', 'Germany')";
            stmt.execute(sql);

            sql = "UPDATE PUBLISHING_HOUSE SET CITY='Berlin' WHERE PUBLISHER_NO=100000";
            assertThat(stmt.executeUpdate(sql), is(1));
            stmt.execute("delete from PUBLISHING_HOUSE where PUBLISHER_NO=100000");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04Select() {
        try {
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO PUBLISHING_HOUSE(PUBLISHER_NO, PUBLISHER_NAME, STREET, POSTAL_CODE, CITY, COUNTRY) " +
                    " VALUES(100000, 'Springer-Verlag GmbH', 'Tiergartenstrasse 17', 69121, 'Heidelberg', 'Germany')";
            stmt.execute(sql);

            sql = "SELECT PUBLISHER_NO FROM PUBLISHING_HOUSE WHERE PUBLISHER_NO=100000";
            ResultSet rs = stmt.executeQuery(sql);

            assertThat(rs.next(), is(true));
            stmt.execute("delete from PUBLISHING_HOUSE where PUBLISHER_NO=100000");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05Delete() {
        try {
            Statement stmt = connection.createStatement();

            String sql = "INSERT INTO PUBLISHING_HOUSE(PUBLISHER_NO, PUBLISHER_NAME, STREET, POSTAL_CODE, CITY, COUNTRY) " +
                    " VALUES(100000, 'Springer-Verlag GmbH', 'Tiergartenstrasse 17', 69121, 'Heidelberg', 'Germany')";
            stmt.execute(sql);

            sql = "DELETE FROM PUBLISHING_HOUSE WHERE PUBLISHER_NO=100000";
            assertThat(stmt.executeUpdate(sql), is(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
