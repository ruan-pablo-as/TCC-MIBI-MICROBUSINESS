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
public class Estado {
    private long pkidestado;
    private String uf;
    private String nomeestado;

    public Estado(){
    }
    
    public long getPkidestado() {
        return pkidestado;
    }

    public void setPkidestado(long pkidestado) {
        this.pkidestado = pkidestado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomeestado() {
        return nomeestado;
    }

    public void setNomeestado(String nomeestado) {
        this.nomeestado = nomeestado;
    }
}
