/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.controle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alann
 */
public class Redirecionar implements Comando {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {

        try {
            String nomePagina = request.getParameter("nomePagina");
            request.getSession().setAttribute("nomePagina", nomePagina);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/template-loja/PaginaPostagens.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(Redirecionar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
