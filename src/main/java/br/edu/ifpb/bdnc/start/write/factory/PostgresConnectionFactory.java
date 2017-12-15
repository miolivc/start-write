package br.edu.ifpb.bdnc.start.write.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionFactory {
    private static final String URL = "jdbc:postgresql://postgreshost:5432/start-write";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
