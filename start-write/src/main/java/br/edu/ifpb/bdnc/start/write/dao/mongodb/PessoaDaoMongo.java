/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.mongodb;

import br.edu.ifpb.bdnc.start.write.dao.PessoaDao;
import br.edu.ifpb.bdnc.start.write.factory.MongoConnectionFactory;
import br.edu.ifpb.bdnc.start.write.model.Usuario;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBObject;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class PessoaDaoMongo implements PessoaDao {
    private final MongoClient mongoClient;
    private final DB database;
    private final DBCollection dbCollection;
    private static DBObject dBObject;
    
    public PessoaDaoMongo(){
        mongoClient = MongoConnectionFactory.getConnection();
        database = MongoConnectionFactory.getDatabase(mongoClient);
        dbCollection = database.getCollection("pessoa");
    }

    @Override
    public void add(Usuario pessoa) {
        dBObject = new BasicDBObject("username", pessoa.getUsername())
                .append("birthDate", pessoa.getBirthDate())
                .append("password", pessoa.getPassword())
                .append("email", pessoa.getEmail())
                .append("name", pessoa.getName());
        dbCollection.insert(dBObject);
    }

    @Override
    public void delete(String email) {
        dBObject = new BasicDBObject("email", email);
        
    }

    @Override
    public List<Usuario> list() {
        return null;
    }

    @Override
    public Usuario find(String email) {
        return null;
    }

    @Override
    public void update(Usuario pessoa) {
        
    }

}
