
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
    
    private static final String[] image = {
        "Icon_01_Soldado.png",
        "Icon_02_Cabo.png",
        "Icon_03_Terceiro-Sargento.png",
        "Icon_04_Segundo-Sargento.png",
        "Icon_05_Primeiro-Sargento.png",
        "Icon_06_Subtenente.png",
        "Icon_07_Aspirante.png",
        "Icon_08_Segundo-Tenente.png",
        "Icon_09_Primeiro-Tenente.png",
        "Icon_10_Capitão.png",       
    };
    
    public String getNome() {
        return nome[this.ordinal()];
    }
    
    public String getImagem() {
        return image[this.ordinal()];
    }
}