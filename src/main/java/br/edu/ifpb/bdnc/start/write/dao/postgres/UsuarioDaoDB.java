/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.start.write.dao.postgres;

import br.edu.ifpb.bdnc.start.write.factory.PostgresConnectionFactory;
import br.edu.ifpb.bdnc.start.write.dao.interfaces.UsuarioDao;
import br.edu.ifpb.bdnc.start.write.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author alann
 */
public class UsuarioDaoDB implements UsuarioDao {
    private Connection conn = null;

    public UsuarioDaoDB() throws SQLException, ClassNotFoundException {
	conn = PostgresConnectionFactory.getConnection();
    }

    @Override
    public void add(Usuario pessoa) {
        String sql = "INSERT INTO USUARIO(id,name, birthDate, username, email, password)"
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, pessoa.getId());
            stmt.setString(2, pessoa.getName());
            stmt.setDate(3, Date.valueOf(pessoa.getBirthDate()));
            stmt.setString(4, pessoa.getUsername());
            stmt.setString(5, pessoa.getEmail());
            stmt.setString(6, pessoa.getPassword());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public void delete(String pesquisa) {
        String sql = "DELETE FROM USUARIO WHERE EMAIL = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }

    @Override
    public List<Usuario> list() {
        List<Usuario> users = null;
        String sql = "SELECT * FROM USUARIO ";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setBirthDate(rs.getDate("birthDate").toLocalDate());
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return users;
    }

    @Override
    public Usuario find(String pesquisa) {
        Usuario user = new Usuario();
        String sql = "SELECT * FROM USUARIO WHERE EMAIL = ? OR USERNAME = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, pesquisa);
            stmt.setString(2, pesquisa);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setBirthDate(rs.getDate("birthDate").toLocalDate());
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return user;
    }

    @Override
    public void update(Usuario pessoa) {
        try{
            delete(pessoa.getEmail());
            add(pessoa);
        } catch (Exception ex){
            System.err.println(ex.toString());
        }
    }    
}
