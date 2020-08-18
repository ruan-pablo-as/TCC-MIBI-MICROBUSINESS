/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCC;

import static JDBCC.AdministradorDAO.c;
import Model.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author r_pab
 */
public class EmpDAO {

    public ObservableList<Empresa> getEmps() {
        c = Conectar.getConnection();
        ObservableList<Empresa> emp = FXCollections.observableArrayList();
        String sql = "SELECT * FROM empresa";
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ResultSet rs = ppstt.executeQuery();
            while (rs.next()) {
                Empresa empresas = new Empresa();
                empresas.setPkidempresa(rs.getLong("pkidempresa"));
                empresas.setNomeemp(rs.getString("nomeemp"));
                empresas.setCnpj(rs.getString("cnpj"));
                empresas.setEmailemp(rs.getString("emailemp"));
                empresas.setDddf(rs.getInt("dddf"));
                empresas.setNumerofixoemp(rs.getLong("numerofixoemp"));
                empresas.setDddw(rs.getInt("dddw"));
                empresas.setNumerowhats(rs.getLong("numerowhats"));
                empresas.setEnderecoemp(rs.getString("enderecoemp"));
                empresas.setNumendereco(rs.getString("numendereco"));
                empresas.setComplemento(rs.getString("complemento"));
                empresas.setFkidmunicipio(rs.getLong("fkidmunicipio"));
                empresas.setFkidestado(rs.getLong("fkidestado"));
                empresas.setFkidusuario(rs.getLong("fkidusuario"));
                emp.add(empresas);
            }
            //fecha conexao
            ppstt.executeQuery();
            ppstt.close();
            return emp;
        } catch (SQLException e) {
            e.getStackTrace();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deletaEmpresa(Empresa emp) {
        String sql = "DELETE FROM empresa WHERE pkidempresa = ?";
        c = Conectar.getConnection();
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ppstt.setLong(1, emp.getPkidempresa());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            e.getStackTrace();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deletaUsEmp(Empresa emp) {
        String sql = "DELETE FROM empresa WHERE fkidusuario = ?;";
        String sql1 = "DELETE FROM usuario WHERE pkidusuario = ?;";
        c = Conectar.getConnection();
        try (PreparedStatement ppstt = c.prepareStatement(sql)) {
            ppstt.setLong(1, emp.getFkidusuario());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.println("ERRO NO 1TRY");
            e.getStackTrace();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try (PreparedStatement ppstt = c.prepareStatement(sql1)) {
            ppstt.setLong(1, emp.getFkidusuario());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.println("ERRO NO 2TRY");
            e.getStackTrace();
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
