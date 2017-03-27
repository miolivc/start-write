/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao;

import br.edu.ifpb.bdnc.start.write.model.Pessoa;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface PessoaDao {
    
    public void add(Pessoa pessoa);
    public void delete(String email);
    public List<Pessoa> list();
    public Pessoa find(String email);
    public void update(Pessoa pessoa);
    
}
