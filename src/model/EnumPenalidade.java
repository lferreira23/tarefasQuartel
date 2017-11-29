
package model;

/**
 * @author Luiz Ferreira
 * @since 28/11/2017
 * Enum para penalidades
 */
public enum EnumPenalidade {
    ADVERTENCIA,
    IMPEDIMENTO_DICISPLINAR,
    REPREENSAO,
    DETENCAO_DISCIPLINAR,
    PRISAO_DISCIPLINAR,
    LICENCIAMENTO_EXCLUSAO;
    
    private static final String[] nome = {
        "Advertência",
        "Impedimento disciplinar",
        "Repreensão",
        "Detenção disciplinar",
        "Prisão disciplinar",
        "Licenc. e exclusão a bem da disciplina"
    };

    public static int getCount() {
        return values().length;
    }
    
    public String getNome() {
        return nome[this.ordinal()];
    }
    

}
