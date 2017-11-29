package model;

import java.util.Date;

/**
 * Classe que define todas as informaçoes do militar
 * @author Luiz Ferreira
 * @since 28/11/2017
 */
public class LogAtividade {
    private Militar militar;
    private Date data;
    private boolean atividadesRealizadas;
    private int grauPenalidadeAplicada;
    
    public LogAtividade(Militar militar) {
        this.militar = militar;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public Date getData() {
        return data;
    }

    public void setGrauPenalidadeAplicada(int grauPenalidadeAplicada) {
        this.grauPenalidadeAplicada = grauPenalidadeAplicada;
    }

    public int getGrauPenalidade() {
        return grauPenalidadeAplicada;
    }
    
    public void setAtividadesRealizadas(boolean atividadesRealizadas) {
        this.atividadesRealizadas = atividadesRealizadas;
    }
    
    public boolean realizouAtividades() {
        return atividadesRealizadas;
    }

}
