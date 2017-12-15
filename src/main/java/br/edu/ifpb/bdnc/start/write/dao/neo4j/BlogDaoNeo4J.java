/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.neo4j;

import br.edu.ifpb.bdnc.start.write.factory.Neo4JConnectionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import static org.neo4j.driver.v1.Values.parameters;

/**
 *
 * @author alann
 */
public class BlogDaoNeo4J {

    private final Session session;

    public BlogDaoNeo4J() {
        this.session = Neo4JConnectionFactory.getSession();
    }

    public void addNode(String titulo, String template) throws IOException {
        session.run("create (:Blog{titulo: {titulo}, template: {template}})", 
                    parameters("titulo", titulo, "template", template));
        session.close();
    }

    public void deleteNode(String titulo) throws IOException {
        session.run("match (b:Blog{titulo:{titulo}}) delete s", 
                    parameters("titulo", titulo));
        session.close();
    }

    public List<String> getNodes(String template) throws IOException {
        List<String> lista = new ArrayList<>();

        StatementResult stat = session
                .run("match (b:Blog{template: '" + template + "'}) return s");

        while (stat.hasNext()) {
            Record record = stat.next();
            lista.add(record.get(0).get("titulo").asString());
        }
        session.close();
        return lista;
    }

}
