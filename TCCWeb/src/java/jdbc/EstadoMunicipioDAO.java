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
import model.Cidade;
import model.Estado;

/**
 *
 * @author r_pab
 */
public class EstadoMunicipioDAO {

    static Connection c;

    public static List<Estado> getEstado() {
        List<Estado> estados = new ArrayList<Estado>();
        String sql = "SELECT pkidestado, nomeestado FROM estado ORDER BY nomeestado ASC;";
        c = Conectar.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setPkidestado(rs.getLong("pkidestado"));
                estado.setNomeestado(rs.getString("nomeestado"));
                estados.add(estado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return estados;
    }

    public static List<Cidade> getCidade(long estado) {
        List<Cidade> cidades = new ArrayList<Cidade>();
        String sql = "SELECT municipio.pkidmunicipio, municipio.nomemunicipio, municipio.fkidestado FROM municipio, estado "
                + "WHERE municipio.fkidestado = estado.pkidestado AND"
                + " estado.pkidestado = " + estado + " ORDER BY municipio.nomemunicipio ASC;";
        c = Conectar.getConnection();
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setPkidmunicipio(rs.getLong("pkidmunicipio"));
                cidade.setNomemunicipio(rs.getString("nomemunicipio"));
                cidade.setFkidestado(rs.getLong("fkidestado"));
                cidades.add(cidade);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cidades;
    }

    private static void fecharConexao() {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
