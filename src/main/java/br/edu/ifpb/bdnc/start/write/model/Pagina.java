/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model;

import java.util.Objects;
import org.bson.Document;

/**
 *
 * @author Alann Rodrigues
 */
public abstract class Pagina implements ToDocument<Pagina> {

    private String dono;
    private String nome;
    private String logomarca;
    private String rodape;

    public Pagina() {
    }

    public Pagina(String nome, String logomarca, String rodape, String dono) {
        this.nome = nome;
        this.logomarca = logomarca;
        this.rodape = rodape;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogomarca() {
        return logomarca;
    }

    public void setLogomarca(String logomarca) {
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
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.dono);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.logomarca);
        hash = 89 * hash + Objects.hashCode(this.rodape);
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
        if (!Objects.equals(this.dono, other.dono)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.logomarca, other.logomarca)) {
            return false;
        }
        if (!Objects.equals(this.rodape, other.rodape)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dono=" + dono + ", nome=" + nome + ", logomarca=" 
                + logomarca + ", rodape=" + rodape;
    }

    @Override
    public abstract Document toDocument();

    @Override
    public abstract Pagina fromDocument(Document doc);

}
