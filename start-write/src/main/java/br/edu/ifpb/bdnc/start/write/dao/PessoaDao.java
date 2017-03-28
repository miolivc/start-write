/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao;

import br.edu.ifpb.bdnc.start.write.model.Usuario;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface PessoaDao {
    
    public void add(Usuario pessoa);
    public void delete(String email);
    public List<Usuario> list();
    public Usuario find(String email);
    public void update(Usuario pessoa);
    
}
