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
            System.out.println(usuario);

            if (usuario.getEmail() != null) {
                if (usuario.getPassword().equals(password)) {
                    request.getSession();
                    request.getSession().setAttribute("usuario", usuario);
                    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/home.jsp");
                    dispatcher.forward(request, response);
                } 
            }
            erroLogin(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException ex) {
        }
    }

    public void erroLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.html");
        dispatcher.forward(request, response);
    }
}
