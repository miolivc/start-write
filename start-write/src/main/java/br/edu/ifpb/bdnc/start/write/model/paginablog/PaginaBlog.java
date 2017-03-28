/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model.paginablog;

import br.edu.ifpb.bdnc.start.write.model.Pagina;
import br.edu.ifpb.bdnc.start.write.model.Usuario;

/**
 *
 * @author Alann Rodrigues
 */
public class PaginaBlog extends Pagina{
    
    public PaginaBlog(String nome, byte[] logomarca, String rodape, Usuario usuario) {
        super(nome, logomarca, rodape, usuario);
    }
    
}
