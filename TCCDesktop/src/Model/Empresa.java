/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author r_pab
 */
public class Empresa {
    private long pkidempresa;
    private String nomeemp;
    
    private String cnpj;
    
    private String emailemp;
    
    private int dddf;
    private long numerofixoemp;
    
    private int dddw;
    private long numerowhats;
    
    private String enderecoemp;
    private String numendereco;
    private String complemento;
    
    private long fkidmunicipio;
    private long fkidestado;
    private long fkidusuario;

    public long getPkidempresa() {
        return pkidempresa;
    }

    public void setPkidempresa(long pkidempresa) {
        this.pkidempresa = pkidempresa;
    }

    public String getNomeemp() {
        return nomeemp;
    }

    public void setNomeemp(String nomeemp) {
        this.nomeemp = nomeemp;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailemp() {
        return emailemp;
    }

    public void setEmailemp(String emailemp) {
        this.emailemp = emailemp;
    }

    public int getDddf() {
        return dddf;
    }

    public void setDddf(int dddf) {
        this.dddf = dddf;
    }

    public long getNumerofixoemp() {
        return numerofixoemp;
    }

    public void setNumerofixoemp(long numerofixoemp) {
        this.numerofixoemp = numerofixoemp;
    }

    public int getDddw() {
        return dddw;
    }

    public void setDddw(int dddw) {
        this.dddw = dddw;
    }

    public long getNumerowhats() {
        return numerowhats;
    }

    public void setNumerowhats(long numerowhats) {
        this.numerowhats = numerowhats;
    }

    public String getEnderecoemp() {
        return enderecoemp;
    }

    public void setEnderecoemp(String enderecoemp) {
        this.enderecoemp = enderecoemp;
    }

    public String getNumendereco() {
        return numendereco;
    }

    public void setNumendereco(String numendereco) {
        this.numendereco = numendereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getFkidmunicipio() {
        return fkidmunicipio;
    }

    public void setFkidmunicipio(long fkidmunicipio) {
        this.fkidmunicipio = fkidmunicipio;
    }

    public long getFkidestado() {
        return fkidestado;
    }

    public void setFkidestado(long fkidestado) {
        this.fkidestado = fkidestado;
    }

    public long getFkidusuario() {
        return fkidusuario;
    }

    public void setFkidusuario(long fkidusuario) {
        this.fkidusuario = fkidusuario;
    }
}
