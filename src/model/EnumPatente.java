
package model;

/**
 * @author Luiz Ferreira
 * @since 24/11/2017
 * Enum para patentes
 */
public enum EnumPatente {
    SOLDADO,
    CABO,
    TERCEIRO_SARGENTO,
    SEGUNDO_SARGENTO,
    PRIMEIRO_SARGENTO,
    SUBTENENTE,
    ASPIRANTE,
    SEGUNDO_TENENTE,
    PRIMEIRO_TENENTE,
    CAPITAO;
    
    private static final String[] nome = {
        "Soldado",
        "Cabo",
        "Primeiro Sargento",
        "Segundo Sargento",
        "Terceiro Sargento",
        "Subtenente",
        "Aspirante",
        "Segundo Tenente",
        "Primeiro Tenente",
        "Capitão"
    };
    
    public String getNome() {
        return EnumPatente.nome[this.ordinal()];
    }
}