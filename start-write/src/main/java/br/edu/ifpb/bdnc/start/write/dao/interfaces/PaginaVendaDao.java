/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.interfaces;

import org.bson.Document;

/**
 *
 * @author miolivc
 */
public interface PaginaVendaDao {
    
    void add(Document document);
    void delete(int id);
    Document get(int id);
    
}
