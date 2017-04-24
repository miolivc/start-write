/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Alann Rodrigues
 */
public class PaginaVenda extends Pagina{
    
    private ArrayList<PostagemVenda> postagems;

    public PaginaVenda(ArrayList<PostagemVenda> postagems, String nome, byte[] logomarca, String rodape) {
        super(nome, logomarca, rodape);
        this.postagems = postagems;
    }

    public ArrayList<PostagemVenda> getPostagems() {
        return postagems;
    }

    public void setPostagems(ArrayList<PostagemVenda> postagems) {
        this.postagems = postagems;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.postagems);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PaginaVenda other = (PaginaVenda) obj;
        if (!Objects.equals(this.postagems, other.postagems)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaginaVenda{" + "postagems=" + postagems + '}';
    }    
}
