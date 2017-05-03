/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model;

import java.util.Arrays;
import java.util.Objects;
import org.bson.Document;

/**
 *
 * @author Alann Rodrigues
 */
public abstract class Pagina implements ToDocument<Pagina> {

    private String nome;
    private byte[] logomarca;
    private String rodape;
    
    public Pagina(){}

    public Pagina(String nome, byte[] logomarca, String rodape) {
        this.nome = nome;
        this.logomarca = logomarca;
        this.rodape = rodape;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getLogomarca() {
        return logomarca;
    }

    public void setLogomarca(byte[] logomarca) {
        this.logomarca = logomarca;
    }

    public String getRodape() {
        return rodape;
    }

    public void setRodape(String rodape) {
        this.rodape = rodape;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Arrays.hashCode(this.logomarca);
        hash = 29 * hash + Objects.hashCode(this.rodape);
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
        final Pagina other = (Pagina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rodape, other.rodape)) {
            return false;
        }
        if (!Arrays.equals(this.logomarca, other.logomarca)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Pagina{" + "nome=" + nome + ", logomarca=" + logomarca + ", rodape=" + rodape + '}';
    }
    
    @Override
    public abstract Document toDocument();

    @Override
    public abstract Pagina fromDocument(Document doc);

}