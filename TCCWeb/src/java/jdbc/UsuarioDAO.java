/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author r_pab
 */
public class UsuarioDAO {

    static Connection c;

    public static void insereUsuario(Usuario cliente) {
        c = Conectar.getConnection();
        String sql = "INSERT INTO usuario(nome, sobrenome, email, senha, fkidmunicipio, fkidestado)"
                + "VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ppstt.setString(1, cliente.getNome());
            ppstt.setString(2, cliente.getSobrenome());
            ppstt.setString(3, cliente.getEmail());
            ppstt.setString(4, cliente.getSenha());
            ppstt.setLong(5, cliente.getFkidmunicipio());
            ppstt.setLong(6, cliente.getFkidestado());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Long> pegaUsuario() {
        c = Conectar.getConnection();
        ArrayList<Long> usuarios = new ArrayList<>();
        String sql = "SELECT pkidusuario FROM usuario";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                usuarios.add(rs.getLong("pkidusuario"));
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return usuarios;
    }
public static List<Usuario> getUsuario(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM usuario;";
        c = Conectar.getConnection();
        try{
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while(rs.next()){
                Usuario user = new Usuario();
                user.setPkidusuario(rs.getLong("pkidusuario"));
                user.setNome(rs.getString("nome"));
                user.setSobrenome(rs.getString("sobrenome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setFkidmunicipio(rs.getLong("fkidmunicipio"));
                user.setFkidestado(rs.getLong("fkidestado"));
                usuarios.add(user);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return usuarios;
    }
    public Usuario getLogin(String email, String senha) {
        String sql = "SELECT * FROM usuario "
                + "WHERE email = '"+email+"' AND senha = '"+senha+"';";
        c = Conectar.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                Usuario user = new Usuario();
                user.setPkidusuario(rs.getLong("pkidusuario"));
                user.setNome(rs.getString("nome"));
                user.setSobrenome(rs.getString("sobrenome"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setFkidmunicipio(rs.getLong("fkidmunicipio"));
                user.setFkidestado(rs.getLong("fkidestado"));
                return user;
            }
        } catch (SQLException e) {
            System.out.print("DAO login ");
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static void alterarUsuario(Usuario user, long id) {
        c = Conectar.getConnection();
        String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, email = ?, "
                + "senha = ?, fkidmunicipio = ?, fkidestado = ? "
                + " WHERE pkidusuario = ?;";
        try (PreparedStatement ppstt = c.prepareStatement(sql);) {
            ppstt.setString(1, user.getNome());
            ppstt.setString(2, user.getSobrenome());
            ppstt.setString(3, user.getEmail());
            ppstt.setString(4, user.getSenha());
            ppstt.setLong(5, user.getFkidmunicipio());
            ppstt.setLong(6, user.getFkidestado());
            ppstt.setLong(7, id);
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    
    public static void delUsuario(long id) {
        c = Conectar.getConnection();
        String sql = "DELETE FROM usuario WHERE pkidusuario = ?";
        try (PreparedStatement ppstt = c.prepareStatement(sql);) {
            ppstt.setLong(1, id);
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    private static void fecharConexao() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
