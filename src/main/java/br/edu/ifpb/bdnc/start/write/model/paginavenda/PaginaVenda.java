/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model.paginavenda;

import br.edu.ifpb.bdnc.start.write.model.Pagina;
import java.util.ArrayList;
import java.util.Objects;
import org.bson.Document;

/**
 *
 * @author Alann Rodrigues
 */
public class PaginaVenda extends Pagina{
    
    private ArrayList<PostagemVenda> postagens;
    
    public PaginaVenda(){}

    public PaginaVenda(ArrayList<PostagemVenda> postagens, String nome, String logomarca, String rodape, String dono) {
        super(nome, logomarca, rodape, dono);
        this.postagens = postagens;
    }

    public ArrayList<PostagemVenda> getPostagens() {
        return postagens;
    }

    public void setPostagens(ArrayList<PostagemVenda> postagens) {
        this.postagens = postagens;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.postagens);
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
        if (!Objects.equals(this.postagens, other.postagens)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PaginaVenda{" + super.toString() + "postagens=" + postagens + '}';
    }   
    
    @Override
    public Document toDocument(){
        Document doc = new Document();
        doc.append("nome", getNome());
        doc.append("logomarca", getLogomarca());
        doc.append("rodape", getRodape());
        doc.append("postagens", getPostagens());
        doc.append("dono", getDono());
        return doc;
    }
    
    @Override
    public PaginaVenda fromDocument(Document doc) {
        PaginaVenda pagina = new PaginaVenda();
        pagina.setNome(doc.getString("nome"));
        pagina.setRodape(doc.getString("rodape"));
        pagina.setLogomarca(doc.getString("logomarca"));
        pagina.setPostagens((ArrayList<PostagemVenda>) doc.get("postagens"));
        pagina.setDono(doc.getString("dono"));
        System.out.println(pagina.toString());
        return pagina;
    }
}
