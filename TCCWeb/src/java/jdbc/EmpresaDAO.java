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
import model.Empresa;

/**
 *
 * @author r_pab
 */
public class EmpresaDAO {

    static Connection c;

    public static void insereEmpresa(Empresa emp, long id) {
        c = Conectar.getConnection();
        String sql = "INSERT INTO empresa(nomeemp, cnpj, emailemp, dddf, "
                + "numerofixoemp, dddw, numerowhats, enderecoemp, "
                + "numendereco, complemento, fkidmunicipio, fkidestado, fkidusuario)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ppstt.setString(1, emp.getNomeemp());
            ppstt.setString(2, emp.getCnpj());
            ppstt.setString(3, emp.getEmailemp());
            ppstt.setInt(4, emp.getDddf());
            ppstt.setLong(5, emp.getNumerofixoemp());
            ppstt.setInt(6, emp.getDddw());
            ppstt.setLong(7, emp.getNumerowhats());
            ppstt.setString(8, emp.getEnderecoemp());
            ppstt.setString(9, emp.getNumendereco());
            ppstt.setString(10, emp.getComplemento());
            ppstt.setLong(11, emp.getFkidmunicipio());
            ppstt.setLong(12, emp.getFkidestado());
            ppstt.setLong(13, id);
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public static Empresa selectEmpUser(long idUsuario) {
        Empresa emp = new Empresa();
        c = Conectar.getConnection();
        String sql = "SELECT * FROM empresa WHERE fkidusuario = " + idUsuario;
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                emp.setPkidempresa(rs.getLong("pkidempresa"));
                emp.setNomeemp(rs.getString("nomeemp"));
                emp.setCnpj(rs.getString("cnpj"));
                emp.setEmailemp(rs.getString("emailemp"));
                emp.setDddf(rs.getInt("dddf"));
                emp.setNumerofixoemp(rs.getLong("numerofixoemp"));
                emp.setDddw(rs.getInt("dddw"));
                emp.setNumerowhats(rs.getLong("numerowhats"));
                emp.setEnderecoemp(rs.getString("enderecoemp"));
                emp.setNumendereco(rs.getString("numendereco"));
                emp.setComplemento(rs.getString("complemento"));
                emp.setFkidmunicipio(rs.getLong("fkidmunicipio"));
                emp.setFkidestado(rs.getLong("fkidestado"));
                emp.setFkidusuario(rs.getLong("fkidusuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return emp;
    }

    public static void  alteraEmpresa(Empresa emp, long id) {
        c = Conectar.getConnection();
        String sql = "UPDATE empresa SET nomeemp = ?, cnpj = ?, emailemp = ?, dddf = ?, "
                + "numerofixoemp = ?, dddw = ?, numerowhats = ?, enderecoemp = ?, "
                + "numendereco = ?, complemento = ?, fkidmunicipio = ?, fkidestado = ? "
                + "WHERE fkidusuario = ?";
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ppstt.setString(1, emp.getNomeemp());
            ppstt.setString(2, emp.getCnpj());
            ppstt.setString(3, emp.getEmailemp());
            ppstt.setInt(4, emp.getDddf());
            ppstt.setLong(5, emp.getNumerofixoemp());
            ppstt.setInt(6, emp.getDddw());
            ppstt.setLong(7, emp.getNumerowhats());
            ppstt.setString(8, emp.getEnderecoemp());
            ppstt.setString(9, emp.getNumendereco());
            ppstt.setString(10, emp.getComplemento());
            ppstt.setLong(11, emp.getFkidmunicipio());
            ppstt.setLong(12, emp.getFkidestado());
            ppstt.setLong(13, id);
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    public static void delEmp(long id) {
        c = Conectar.getConnection();
        String sql = "DELETE FROM empresa WHERE pkidempresa = ?";
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
