/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.controle;

import br.edu.ifpb.bdnc.start.write.dao.interfaces.UsuarioDao;
import br.edu.ifpb.bdnc.start.write.dao.postgres.UsuarioDaoDB;
import br.edu.ifpb.bdnc.start.write.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alann Rodrigues
 */
public class Login implements Comando {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            UsuarioDao dao = new UsuarioDaoDB();
            Usuario usuario = dao.find(login);
            
            String caminho = " ";

            if (usuario.getEmail() != null) {
                if (usuario.getPassword().equals(password)) {
                    request.getSession();
                    request.getSession().setAttribute("usuario", usuario);
                    caminho = "/home.jsp";
                    dispachar(request, response,caminho);
                } 
            }
            caminho = "/index.html";
            dispachar(request, response,caminho);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException ex) {}
    }

    public void dispachar(HttpServletRequest request, HttpServletResponse response, String caminho) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(caminho);
        dispatcher.forward(request, response);
    }
}
