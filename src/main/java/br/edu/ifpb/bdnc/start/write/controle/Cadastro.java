/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.controle;

import br.edu.ifpb.bdnc.start.write.model.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alann Rodrigues
 */
public class Cadastro implements Comando {

    @Override
    public void executar(HttpServletRequest request, HttpServletResponse response) {

        try {
            String username = request.getParameter("username");
            String birthDate = request.getParameter("birthDate");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            
            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            Date date = (Date) formatter.parse(birthDate);

            Usuario usuario = new Usuario();
            usuario.setBirthDate(date);
            usuario.setEmail(email);
            usuario.setName(name);
            usuario.setPassword(password);
            usuario.setUsername(username);

        } catch (ParseException ex) {

        }

    }
}
