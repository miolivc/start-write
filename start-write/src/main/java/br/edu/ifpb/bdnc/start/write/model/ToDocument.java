/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model;

import javax.swing.text.Document;

/**
 *
 * @author Alann Rodrigues
 * @param <T>
 */
public interface ToDocument<T> {
    
    public Document toDocument();
    public T fromDocument();
    
}
