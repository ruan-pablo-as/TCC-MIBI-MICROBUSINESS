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
public class Administrador {
    private long pkidadm;
    private String users;
    private String senha;
    private String nome;

    public long getPkidadm() {
        return pkidadm;
    }

    public void setPkidadm(long pkidadm) {
        this.pkidadm = pkidadm;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
