/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.factory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 *
 * @author miolivc
 */
public class MongoConnectionFactory {  
    
    private static MongoClient client = null;
    
    public static MongoClient getConnection(){
        MongoConnectionFactory.client = new MongoClient(
            new MongoClientURI("mongodb://mongohost:27017")
        );
        return MongoConnectionFactory.client;
    }
}
