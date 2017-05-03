/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.interfaces;

import br.edu.ifpb.bdnc.start.write.model.Usuario;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface UsuarioDao {
    
    void add(Usuario pessoa);
    void delete(String pesquisa);
    List<Usuario> list();
    Usuario find(String pesquisa);
    void update(Usuario pessoa);
    
}
