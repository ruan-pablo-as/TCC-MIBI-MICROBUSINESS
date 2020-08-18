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
public class Cidade{
    private long pkidmunicipio;
    private String nomemunicipio;
    private long fkidestado;

    public long getPkidmunicipio() {
        return pkidmunicipio;
    }

    public void setPkidmunicipio(long pkidmunicipio) {
        this.pkidmunicipio = pkidmunicipio;
    }

    public String getNomemunicipio() {
        return nomemunicipio;
    }

    public void setNomemunicipio(String nomemunicipio) {
        this.nomemunicipio = nomemunicipio;
    }


    public long getFkidestado() {
        return fkidestado;
    }

    public void setFkidestado(long fkidestado) {
        this.fkidestado = fkidestado;
    }
}
