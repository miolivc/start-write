/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.mongo;

import br.edu.ifpb.bdnc.start.write.dao.interfaces.PaginaVendaDao;
import br.edu.ifpb.bdnc.start.write.factory.MongoConnectionFactory;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

/**
 *
 * @author miolivc
 */
public class PaginaVendaDaoMongo implements PaginaVendaDao {
    MongoCollection database = null;

    public PaginaVendaDaoMongo() {
        database = MongoConnectionFactory.getConnection()
                .getDatabase("start-write").
                getCollection("paginaVenda");
    }

    @Override
    public Document get(int id) {
        Document document = null;
        MongoCursor cursor = database.find(eq("_id", id)).iterator();
        while(cursor.hasNext()){
            document = (Document) cursor.next();
        }
        return document;
    }

    @Override
    public void add(Document document) {
        database.insertOne(document);
    }

    @Override
    public void delete(int id) {
        database.findOneAndDelete(eq("_id", id));
    }    
}