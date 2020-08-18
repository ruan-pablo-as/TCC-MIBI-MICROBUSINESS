/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCC;

import Model.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author r_pab
 */
public class AdministradorDAO {

    static Connection c;

    public static void insereAdm(Administrador adm) {
        c = Conectar.getConnection();
        String sql = "INSERT INTO administrador (nome, users, senha) VALUES(?, ?, MD5(?))";
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ppstt.setString(1, adm.getNome());
            ppstt.setString(2, adm.getUsers());
            ppstt.setString(3, adm.getSenha());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            e.getStackTrace();
            e.printStackTrace();
            System.out.println("Erro insereDAO: " + e.getMessage());
        }
    }

    public static Administrador pegaAdm(String user, String senh) {
        c = Conectar.getConnection();
        Administrador adm = new Administrador();
        String sql = "SELECT * FROM administrador WHERE users = ?"
                + " AND senha = MD5(?)";
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ppstt.setString(1, user);
            ppstt.setString(2, senh);
            ppstt.execute();
            ResultSet rs = ppstt.executeQuery();
            if (rs.next()) {
                adm.setPkidadm(rs.getLong("pkidadm"));
                adm.setNome(rs.getString("nome"));
                adm.setUsers(rs.getString("users"));
                adm.setSenha(rs.getString("senha"));
                ppstt.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
            e.printStackTrace();
            System.out.println("Erro pegaAdm: " + e.getMessage());
        }
        return adm;
    }

    private static void fecharConexao() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
