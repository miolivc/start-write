package br.edu.ifpb.bdnc.start.write.dao.neo4j;



import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

public class FabricaSessao {

    private static Driver driver;
    
    public static Session getSession(){
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "void"));
        return driver.session();
    };
    
    public static void closeDriver(){
        driver.close();
    }
}