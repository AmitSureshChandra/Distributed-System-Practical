package org.example.p4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    static Connection con;

    static public Connection getCon() throws ClassNotFoundException, SQLException {
        if(con != null) return con;

        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/student";

        // Database credentials
        String USER = "root";
        String PASS = "rootpassword";

        //Register JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // open connection
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        return con;
    }
}
