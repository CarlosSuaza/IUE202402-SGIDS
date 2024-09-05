package org.app.dryprinciple.sqlUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconnection {

    private final String databaseURL;
    private final String databaseUser;
    private final String databasePassword;

    public SQLconnection() {
        databaseURL = "jdbc:mysql://localhost:3306/drydb";
        databaseUser = "root";
        databasePassword = "root";
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(databaseURL,databaseUser,databasePassword);
    }


}
