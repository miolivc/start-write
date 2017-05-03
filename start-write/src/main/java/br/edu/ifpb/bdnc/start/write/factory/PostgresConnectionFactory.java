package br.edu.ifpb.bdnc.start.write.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionFactory {
    private static final String url = "jdbc:postgresql://localhost:5432/start-write";
    private static final String user = "postgres";
    private static final String password = "postgres";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }

}
