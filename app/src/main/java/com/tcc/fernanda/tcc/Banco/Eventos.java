package com.tcc.fernanda.tcc.Banco;

/**
 * Created by fernanda on 01/03/18.
 */

public class Eventos {

    private String nomeEvento;
    private int dataEvento;
    private String localEvento;
    private Boolean eventoAtivo;
    private String descricaoEvento;
    private int usuario;

    public Eventos(){

    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(int dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }


    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public Boolean getEventoAtivo() {
        return eventoAtivo;
    }

    public void setEventoAtivo(Boolean eventoAtivo) {
        this.eventoAtivo = eventoAtivo;
    }


    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
