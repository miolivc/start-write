/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.mongo;

import br.edu.ifpb.bdnc.start.write.dao.interfaces.PaginaVendaDao;
import br.edu.ifpb.bdnc.start.write.factory.MongoConnectionFactory;
import br.edu.ifpb.bdnc.start.write.model.paginavenda.PaginaVenda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
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
    public List<PaginaVenda> get(String dono) {
        List<PaginaVenda> paginas = new  ArrayList<>();
        MongoCursor cursor = database.find(eq("dono", dono)).iterator();
        while(cursor.hasNext()){
            PaginaVenda pagina = new PaginaVenda();
            pagina.fromDocument((Document) cursor.next());
            paginas.add(pagina);
        }
        return paginas;
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