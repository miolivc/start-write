/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.postgres;

import br.edu.ifpb.bdnc.start.write.dao.UsuarioDaoIf;
import br.edu.ifpb.bdnc.start.write.model.Usuario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alann
 */
public class UsuarioDao implements UsuarioDaoIf {

    @Override
    public void add(Usuario pessoa) {
        
    }

    @Override
    public void delete(String email) {
        
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
