/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.controle;

import br.edu.ifpb.bdnc.start.write.dao.interfaces.PaginaVendaDao;
import br.edu.ifpb.bdnc.start.write.dao.mongo.PaginaVendaDaoMongo;
import br.edu.ifpb.bdnc.start.write.model.Pagina;
import br.edu.ifpb.bdnc.start.write.model.Usuario;
import br.edu.ifpb.bdnc.start.write.model.paginavenda.PaginaVenda;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author miolivc
 */
public class CriarBlog implements Comando {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {

        try {
            String nome = request.getParameter("nome");
            String tipoBlog = request.getParameter("tipoBlog");
            String rodape = request.getParameter("rodape");

            PaginaVenda pagina = null;

            if (tipoBlog.equals("loja")) {
                String pacoteAplicacao = request.getServletContext().getRealPath("");
                pagina = new PaginaVenda();
                pagina.setNome(nome);
                pagina.setRodape(rodape);
                List<Part> lista = (List) request.getParts();
                for (Part p : lista) {
                    if (p.getName().equals("logomarca")) {
                        String caminho = pacoteAplicacao + File.separator + "img-logos" + File.separator + p.getSubmittedFileName();
                        p.write(caminho);
                        pagina.setLogomarca(caminho);
                        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                        pagina.setDono(usuario.getEmail());
                        break;
                    }
                }

                PaginaVendaDao dao = new PaginaVendaDaoMongo();
                dao.add(pagina.toDocument());
                ArrayList<Pagina> listaPaginas = (ArrayList<Pagina>) request.getSession().getAttribute("listaPaginas");
                listaPaginas.add(pagina);
                request.getSession().setAttribute("listaPaginas", listaPaginas);
            }

            request.setAttribute("blog", pagina);

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException | IOException ex) {
            System.err.print(ex);
        }
    }
}
