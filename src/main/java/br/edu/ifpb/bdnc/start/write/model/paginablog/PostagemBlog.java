/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model.paginablog;

import java.util.Objects;

/**
 *
 * @author alann
 */
public class PostagemBlog {
    
    private String assunto;
    private String conteudo;

    public PostagemBlog() {
    }

    public PostagemBlog(String assunto, String conteudo) {
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.assunto);
        hash = 19 * hash + Objects.hashCode(this.conteudo);
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
        final PostagemBlog other = (PostagemBlog) obj;
        if (!Objects.equals(this.assunto, other.assunto)) {
            return false;
        }
        if (!Objects.equals(this.conteudo, other.conteudo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PostagemBlog{" + "assunto=" + assunto + ", conteudo=" + conteudo + '}';
    }
    
    
}
