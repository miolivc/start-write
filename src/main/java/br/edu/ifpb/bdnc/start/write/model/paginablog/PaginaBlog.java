/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model.paginablog;

import br.edu.ifpb.bdnc.start.write.model.Pagina;
import java.io.File;
import org.bson.Document;


/**
 *
 * @author Alann Rodrigues
 */
public class PaginaBlog extends Pagina{
    
    public PaginaBlog(String nome, String logomarca, String rodape) {
        super(nome, logomarca, rodape);
    }

    @Override
    public Document toDocument() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagina fromDocument(Document doc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
