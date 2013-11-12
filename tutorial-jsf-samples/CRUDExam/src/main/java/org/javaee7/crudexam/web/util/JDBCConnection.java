package org.javaee7.crudexam.web.util;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;

/**
 *
 * @author Masudul Haque
 */
public class JDBCConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/sample", "root", "");
        } catch (ClassNotFoundException | SQLException cnfe) {

        }
        return con;
    }
}
