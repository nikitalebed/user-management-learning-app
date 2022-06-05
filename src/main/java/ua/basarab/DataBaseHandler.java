package ua.basarab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler {
    static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    static final String USER = "postgres";
    static final String PASS = "200604";
    private Connection connection;

    public Connection getDbConnection() {
        try {
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
