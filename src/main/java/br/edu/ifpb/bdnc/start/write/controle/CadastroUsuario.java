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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alann Rodrigues
 */
public class CadastroUsuario implements Comando {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {

        try {
            String username = request.getParameter("username");
            String birthDate = request.getParameter("birthDate");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String name = request.getParameter("name");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(birthDate, formatter);

            Usuario usuario = new Usuario();
            usuario.setBirthDate(date);
            usuario.setEmail(email);
            usuario.setName(name);
            usuario.setPassword(password);
            usuario.setUsername(username);

            UsuarioDao dao = new UsuarioDaoDB();
            dao.add(usuario);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.html");
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException | SQLException | ServletException | IOException ex) {}
    }
}
