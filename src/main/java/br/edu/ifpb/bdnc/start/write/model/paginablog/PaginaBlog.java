/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.model.paginablog;

import br.edu.ifpb.bdnc.start.write.model.Pagina;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author Alann Rodrigues
 */
public class PaginaBlog extends Pagina {

    private ArrayList<PostagemBlog> postagens;
    
    public PaginaBlog(){}

    public PaginaBlog(String nome, String logomarca, String rodape, String dono) {
        super(nome, logomarca, rodape, dono);
    }

    public ArrayList<PostagemBlog> getPostagens() {
        return postagens;
    }

    public void setPostagens(ArrayList<PostagemBlog> postagens) {
        this.postagens = postagens;
    }
    
    

    @Override
    public Document toDocument() {
        Document doc = new Document();
        doc.append("nome", getNome());
        doc.append("logomarca", getLogomarca());
        doc.append("rodape", getRodape());
        doc.append("postagens", getPostagens());
        doc.append("dono", getDono());
        return doc;
    }

    @Override
    public Pagina fromDocument(Document doc) {
        PaginaBlog pagina = new PaginaBlog();
        pagina.setNome(doc.getString("nome"));
        pagina.setRodape(doc.getString("rodape"));
        pagina.setLogomarca(doc.getString("logomarca"));
        pagina.setPostagens((ArrayList<PostagemBlog>) doc.get("postagens"));
        pagina.setDono(doc.getString("dono"));
        System.out.println(pagina.toString());
        return pagina;
    }

}
