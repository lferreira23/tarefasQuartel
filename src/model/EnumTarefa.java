
package model;

/**
 * @author Luiz Ferreira
 * @since 24/11/2017
 * Enum para patentes
 */
public enum EnumTarefa {
    DESCASCAR_BATATAS,
    LIMPAR_BANHEIRO,
    LIMPAR_COZINHA,
    COZINHAR_ALMOCO,
    COZINHAR_JANTA,
    ALIMENTAR_CAVALOS,
    LIMPAR_ESTABULOS,
    RECARREGAR_ARMAMENTO,
    TROCAR_ENCANAMENTO,
    LEVANTAR_BANDEIRA;
    
    private static final String[] nome = {
        "Descascar batatas",
        "Limpar banheiro",
        "Limpar cozinha",
        "Cozinhar almoço",
        "Cozinhar janta",
        "Alimentar cavalos",
        "Limpar estábulos",
        "Recarregar armamento",
        "Trocar encanamento",
        "Levantar bandeira"
    };
    
    public String getNome() {
        return nome[this.ordinal()];
    }
}
