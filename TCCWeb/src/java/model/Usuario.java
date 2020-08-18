/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author r_pab
 */
    public class Usuario {

        private long pkidusuario;
        private String nome;
        private String sobrenome;
        private String email;
        private String senha;
        private long fkidmunicipio;
        private long fkidestado;

    public Usuario() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getPkidusuario() {
        return pkidusuario;
    }

    public void setPkidusuario(long pkidusuario) {
        this.pkidusuario = pkidusuario;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
}
