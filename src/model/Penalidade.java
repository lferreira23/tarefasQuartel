package model;

import java.util.Date;

/**
 * Classe que define todas as informaçoes do militar
 * @author Luiz Ferreira
 * @since 28/11/2017
 */
public class Penalidade {
    private Militar militar;
    private Date data;
    private int grauPenalidade;
    
    public Penalidade(Militar militar) {
        this.militar = militar;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    
    public Date getData() {
        return data;
    }

    public void setGrauPenalidade(int grauPenalidade) {
        this.grauPenalidade = grauPenalidade;
    }

    public int getGrauPenalidade() {
        return grauPenalidade;
    }

}
