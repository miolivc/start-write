package br.edu.ifpb.bdnc.start.write.factory;



import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

public class Neo4JConnectionFactory {

    private static Driver driver;
    
    public static Session getSession(){
        driver = GraphDatabase.driver("bolt://localhost:7687", 
                AuthTokens.none());
        return driver.session();
    };
    
    public static void closeDriver(){
        driver.close();
    }
}